package com.app.ui.page;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.ScPage;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyMenuItem;
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
    }

    //==================================================
    //= layout :: shows
    //==================================================

    public MyMenuItem getTopMenu()
    {
        if ( hasMenu() )
            return getMenu().getTop();

        return null;
    }

    public MyMenuItem getLeftMenuItem()
    {
        if ( hasMenu() )
            return getMenu().getLeftItem();

        return null;
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
        MyMenuItem menu = getMenu();

        if ( menu == null )
            return MyPageLayoutType.bare;

        if ( menu.isTop() )
            return MyPageLayoutType.simple;

        return MyPageLayoutType.nested;
    }

    private MyMenuItem getMenu()
    {
        return getMenuRegistry().findMenuFor(this);
    }

    private boolean hasMenu()
    {
        return getMenu() != null;
    }

    private MyMenuRegistry getMenuRegistry()
    {
        return MyMenuRegistry.getInstance();
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
        return getServerSession().getCurrentProject();
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

    //##################################################
    //# security
    //##################################################

    @Override
    public void checkSecurity()
    {
        MySecurityLevel sec = getSecurityLevel();
        MyUser u = getCurrentUser();
        MyProject p = getCurrentProject();

        sec.check(u, p);
    }

    public abstract MySecurityLevel getSecurityLevel();

    @Override
    public boolean requiresUser()
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

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyPropertyRegistry getProperties()
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

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    public final String _formatEntryUrl()
    {
        return MyUrls.getEntryUrl(_composeQueryParameters());
    }

}
