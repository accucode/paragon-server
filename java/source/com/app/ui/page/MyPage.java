package com.app.ui.page;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.MyGlobalSession;
import com.kodemore.servlet.ScPage;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutType;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public abstract class MyPage
    extends ScPage
{
    //##################################################
    //# layout
    //##################################################

    @Override
    protected void checkLayout()
    {
        super.checkLayout();

        getLayout().checkLayoutFor(this);

        checkProject();
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
    //# bookmark
    //##################################################

    /**
     * Return a complete url that navigates to this page.
     * If this page supports bookmarkable context, the current context is
     * encoded into the url.  The url returned is suitable for use in
     * external content (or browser bookmarks) that navigate back to
     * this page via an HTTP GET.
     */
    public final String formatEntryUrl()
    {
        return MyUrls.getEntryUrl(composeBookmark(true));
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
        return getPageSession().getCurrentProject();
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
            user.setLastProject(currentProject);
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public void checkSecurity()
    {
        MyUser u = getCurrentUser();
        MyProject p = getCurrentProject();

        getSecurityLevel().check(u, p);
    }

    public abstract MySecurityLevel getSecurityLevel();

    @Override
    public final boolean requiresUser()
    {
        return getSecurityLevel().requiresUser();
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

    protected MyGlobalSession getPageSession()
    {
        return MyGlobals.getGlobalSession();
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

    protected MySettings getSettings()
    {
        return getAccess().getSettingsDao().getSettings();
    }

    protected KmDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected void daoFlush()
    {
        getDaoSession().flush();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
