package com.app.ui.page;

import com.kodemore.collection.KmList;
import com.kodemore.dao.KmDaoSession;
import com.kodemore.exception.KmEnumException;
import com.kodemore.servlet.ScPage;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutType;
import com.app.utility.MyGlobals;

public abstract class MyPage
    extends ScPage
{
    //##################################################
    //# bookmark
    //##################################################

    @Override
    public MyBookmark newBookmark()
    {
        return new MyBookmark(this);
    }

    //##################################################
    //# layout
    //##################################################

    @Override
    protected void checkLayout()
    {
        super.checkLayout();

        checkProject();
        getLayout().checkLayoutFor(this);
    }

    //==================================================
    //= layout :: support
    //==================================================

    protected MyPageLayout getLayout()
    {
        return MyPageLayout.getInstance();
    }

    public MyPageLayoutType getLayoutType()
    {
        return MyPageLayoutType.normal;
    }

    //##################################################
    //# tenant
    //##################################################

    public final MyTenant getCurrentTenant()
    {
        return getServerSession().getTenant();
    }

    //##################################################
    //# user
    //##################################################

    public MyMember getCurrentMember()
    {
        MyProject project = getCurrentProject();
        if ( project == null )
            return null;

        MyUser user = getCurrentUser();
        return project.getMemberFor(user);
    }

    public MyUser getCurrentUser()
    {
        MyServerSession ss = getServerSession();
        if ( ss == null )
            return null;

        return ss.getUser();
    }

    public String getCurrentUserUid()
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return null;

        return u.getUid();
    }

    public boolean hasCurrentUser()
    {
        return getCurrentUser() != null;
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getCurrentProject()
    {
        return MyGlobals.getGlobalSession().getCurrentProject();
    }

    public String getCurrentProjectUid()
    {
        MyProject a = getCurrentProject();
        if ( a == null )
            return null;

        return a.getUid();
    }

    public boolean hasCurrentProject()
    {
        return getCurrentProject() != null;
    }

    /**
     * Check to see if the current project from the page session
     * matches the user's last selected project. If not, set it.
     */
    private void checkProject()
    {
        if ( !hasCurrentUser() )
            return;

        if ( !hasCurrentProject() )
            return;

        MyUser user = getCurrentUser();
        MyProject currentProject = getCurrentProject();

        if ( !user.hasLastProject(currentProject) )
            if ( user.isMemberOf(currentProject) )
                user.selectProject(currentProject);
    }

    //##################################################
    //# time zone
    //##################################################

    public KmTimeZone getCurrentTimeZone()
    {
        return MyGlobals.getCurrentTimeZone();
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public void checkSecurity()
    {
        MyUser u = getCurrentUser();
        MyProject p = getCurrentProject();

        checkSecurityFor(u, p);
    }

    public void checkSecurityFor(MyUser u, MyProject p)
    {
        KmList<MySecurityLevel> levels = getSecurityLevels();
        KmList<KmSimpleResult> results = levels.collect(e -> e.allows(u, p));

        boolean ok = results.containsIf(e -> e.isOk());
        if ( ok )
            return;

        KmList<String> errors;
        errors = results.collect(e -> e.getError());
        errors.removeNulls();

        String msg = errors.join(", or ");
        throw Kmu.newSecurityError(msg);
    }

    /**
     * KLUDGE. This is a workaround for special pages that allow
     * any of several security levels. For example a page may allow
     * either the ProjectManager OR a TenantAdmin. Long-term we should
     * refactor this to a more robust and elegant pattern but for now
     * this provides a solution without updating every page in the system.
     */
    protected KmList<MySecurityLevel> getSecurityLevels()
    {
        return KmList.createWith(getSecurityLevel());
    }

    /**
     * Most pages allow only a single security level.
     */
    public abstract MySecurityLevel getSecurityLevel();

    @Override
    public final boolean requiresUser()
    {
        KmList<MySecurityLevel> levels = getSecurityLevels();
        return levels.isEmpty()
            ? true
            : levels.containsOnlyIf(e -> e.requiresUser());
    }

    //##################################################
    //# display
    //##################################################

    public String getModuleName()
    {
        return getModule().getDisplayName();
    }

    public boolean hasModuleName()
    {
        return Kmu.hasValue(getModuleName());
    }

    public String getModuleHelp()
    {
        return getModule().getHelp();
    }

    protected MyPageModule getModule()
    {
        MySecurityLevel level = getSecurityLevel();

        switch ( level )
        {
            case developer:
                return MyPageModule.Developer;

            case tenantAdmin:
                return MyPageModule.Global;

            case none:
            case projectManager:
            case projectMember:
            case projectWorker:
            case user:
                return MyPageModule.None;
        }
        throw new KmEnumException(level);
    }

    //##################################################
    //# utility
    //##################################################

    @Override
    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    protected MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected void daoFlush()
    {
        getDaoSession().flush();
    }

    protected static MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
