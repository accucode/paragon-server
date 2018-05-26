package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.model.support.MyPageDomainIF;
import com.app.model.support.MyPersonNameIF;
import com.app.model.support.MyPersonNameUtility;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferUserDetail;
import com.app.ui.page.crud.user.MyUserListPage;
import com.app.utility.MyUtility;

public class MyUser
    extends MyUserBase
    implements MyTenantDomainIF, MyPersonNameIF, MyPageDomainIF, MyTransferrableIF<MyUser>
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The number of minutes a user needs to be inactive to be condsidered stale.
     */
    private static final int TIMEOUT_MINUTES = 10;

    public static final KmTimeZone DEFAULT_TIME_ZONE = KmTimeZone.Mountain;

    /**
     * Root is a special user.
     * We use this to bootstrap the system, and sometimes for testing.
     */
    public static final String ROOT_EMAIL = "root";

    /**
     * The user name that we use a placeholder to represent actions
     * performed directly by the system.
     */
    public static final String SYSTEM_NAME = "System";

    //##################################################
    //# constructor
    //##################################################

    public MyUser()
    {
        super();

        setTimeZone(DEFAULT_TIME_ZONE);
        setRandomPassword();
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# convenience
    //##################################################

    public void setPassword(String e)
    {
        setPasswordHash(hashPassword(e));
    }

    public void setRandomPassword()
    {
        setPassword(Kmu.newUid());
    }

    public void clearPassword()
    {
        setPassword(null);
    }

    public boolean hasPassword()
    {
        return hasPasswordHash();
    }

    public boolean hasPassword(String e)
    {
        if ( hasPassword() )
            return hasPasswordHash(hashPassword(e));

        return Kmu.isEmpty(e);
    }

    //##################################################
    //# time zone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        return KmTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(KmTimeZone e)
    {
        if ( e == null )
            clearTimeZoneCode();
        else
            setTimeZoneCode(e.getCode());
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    //##################################################
    //# roles
    //##################################################

    public boolean allowsLogin()
    {
        return isEnabled();
    }

    public boolean allowsDeveloper()
    {
        return isRoleDeveloper();
    }

    public boolean allowsTenantAdmin()
    {
        return isRoleTenantAdmin() || allowsDeveloper();
    }

    /**
     * Return true if the this user is allowed to manange
     * (e.g.: add/edit) developers.
     */
    public boolean allowsManageDevelopers()
    {
        return allowsDeveloper();
    }

    public boolean allowsClearPassword()
    {
        return allowsDeveloper();
    }

    public boolean allowsSetPassword()
    {
        return allowsDeveloper();
    }

    public boolean allowsProxy()
    {
        return allowsDeveloper();
    }

    /**
     * Return true if this user is allowed to copy projects across
     * different tenants.
     */
    public boolean allowsCrossTenantAccess()
    {
        return allowsDeveloper();
    }

    //##################################################
    //# projects
    //##################################################

    public KmList<MyMember> getMemberships()
    {
        return getAccess().getMemberDao().findUser(this);
    }

    public KmList<MyMember> getManagerMemberships()
    {
        KmList<MyMember> v;
        v = getMemberships();
        v.retainIf(e -> e.isRoleManager());
        return v;
    }

    public KmList<MyProject> getManagedProjects()
    {
        return getManagerMemberships().collect(e -> e.getProject());
    }

    public KmList<MyProject> getProjects()
    {
        return getMemberships().collect(e -> e.getProject());
    }

    public KmList<MyProject> getProjectsByName()
    {
        KmList<MyProject> v;
        v = getProjects();
        v.sortOn(MyProject::getName);
        return v;
    }

    public KmList<String> getProjectNames()
    {
        return getProjectsByName().collect(e -> e.getName());
    }

    public boolean isMemberOf(MyProject e)
    {
        return getMembershipFor(e) != null;
    }

    public MyMember getMembershipFor(MyProject p)
    {
        for ( MyMember m : getMemberships() )
            if ( m.hasProject(p) )
                return m;

        return null;
    }

    //==================================================
    //= projects :: recent
    //==================================================

    @Override
    public MyProject getLastProject()
    {
        return getRecentProjects().getFirstSafe();
    }

    public KmList<MyProject> getRecentProjects()
    {
        return getAccess().getUserRecentProjectDao().findProjectsFor(this);
    }

    public void selectProject(MyProject e)
    {
        lazyCreateRecentProjectFor(e);
        cleanUpRecentProjects();

        lazyCreateMemberFor(e);
    }

    /**
     * This is primarily used for tenant administrators or other
     * users that are allowed to access a project without prior
     * approval through the member table. We create member record
     * so that we have a place to track information like the currently
     * selected depot, but "disable" member record to avoid possible
     * secondary effects such as sending messasges to active members.
     */
    private MyMember lazyCreateMemberFor(MyProject p)
    {
        MyMember m = p.getMemberFor(this);
        if ( m != null )
            return m;

        m = p.addMember();
        m.setUser(this);
        m.setEnabled(false);
        m.setRoleWorker();
        return m;
    }

    private void lazyCreateRecentProjectFor(MyProject project)
    {

        KmList<MyUserRecentProject> v;
        v = getAccess().getUserRecentProjectDao().findAllFor(this);

        MyUserRecentProject recent;

        recent = v.selectFirst(e -> e.hasUser(this) && e.hasProject(project));

        if ( recent != null )
        {
            recent.setUpdatedUtcTs(nowUtc());
            return;
        }

        recent = new MyUserRecentProject(this, project);
        recent.daoAttach();
        getAccess().flush();
    }

    private void cleanUpRecentProjects()
    {
        checkRecentProjectMemberships();

        KmList<MyUserRecentProject> v;
        v = getAccess().getUserRecentProjectDao().findAllFor(this);

        int limit = 5;
        if ( v.size() <= limit )
            return;

        v.removeRange(0, 5);
        v.forEach(e -> e.daoDelete());
    }

    private void checkRecentProjectMemberships()
    {
        KmList<MyUserRecentProject> v;
        v = getAccess().getUserRecentProjectDao().findAllFor(this);

        for ( MyUserRecentProject recentProject : v )
        {
            MyProject project = recentProject.getProject();
            if ( !project.allowsMember(this) )
                recentProject.daoDelete();
        }

        getAccess().flush();
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public void updateFullName()
    {
        String s = MyPersonNameUtility.getFullName(this);
        setFullName(s);
        truncateFullName();
    }

    @Override
    public String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    @Override
    public String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    @Override
    public String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }

    //##################################################
    //# inactive
    //##################################################

    public boolean isStale()
    {
        KmTimestamp lastTouched = getSessionLastTouchedTs();

        if ( lastTouched == null )
            return true;

        KmTimestamp inactiveTime = KmClock.getUtcTimestamp().subtractMinutes(TIMEOUT_MINUTES);

        if ( lastTouched.isBefore(inactiveTime) )
            return true;

        return false;
    }

    private KmTimestamp getSessionLastTouchedTs()
    {
        MyServerSession ss = getAccess().getServerSessionDao().findLastTouchedFor(this);

        return ss == null
            ? null
            : ss.getLastTouchedUtcTs();
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferUserDetail newTransferDetail()
    {
        return new MyTransferUserDetail(this);
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyUserListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyUserListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getEmail();
    }

    //##################################################
    //# support
    //##################################################

    private String hashPassword(String e)
    {
        return MyUtility.getPasswordHash(getPasswordSalt(), e);
    }
}
