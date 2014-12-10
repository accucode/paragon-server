package com.app.ui.page;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.ScPage;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyCookieSession;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public abstract class MyPage
    extends ScPage
{
    //##################################################
    //# check layout
    //##################################################

    @Override
    protected void checkLayout()
    {
        super.checkLayout();

        checkPageHeader();
        checkPageFooter();
        checkLeftMenu();
    }

    private void checkPageHeader()
    {
        boolean shows = showsPageHeader();
        boolean visible = getData().isPageHeaderVisible();

        if ( shows != visible )
            getPageLayout().ajaxShowHeader(shows);
    }

    private void checkPageFooter()
    {
        boolean shows = showsPageFooter();
        boolean visible = getData().isPageFooterVisible();

        if ( shows != visible )
            getPageLayout().ajaxShowFooter(shows);
    }

    private void checkLeftMenu()
    {
        boolean shows = showsLeftMenu();
        boolean visible = getData().isLeftMenuVisible();

        if ( shows != visible )
            getPageLayout().ajaxShowLeftMenu(shows);

        if ( shows )
            getPageLayout().getLeftMenu().ajaxRefreshSelection(this);
    }

    protected boolean showsPageHeader()
    {
        return true;
    }

    protected boolean showsPageFooter()
    {
        return true;
    }

    protected boolean showsLeftMenu()
    {
        return true;
    }

    public MyLeftMenuItem getMenuItem()
    {
        return null;
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
    //# account
    //##################################################

    public MyAccount getCurrentAccount()
    {
        return getServerSession().getCurrentAccount();
    }

    public String getCurrentAccountUid()
    {
        MyAccount a = getCurrentAccount();
        if ( a == null )
            return null;

        return a.getUid();
    }

    public boolean hasCurrentAccount()
    {
        return getCurrentAccount() != null;
    }

    //##################################################
    //# security 
    //##################################################

    @Override
    public void checkSecurity()
    {
        super.checkSecurity();

        checkUser();
        checkDeveloper();
        checkAccountMember();
        checkAccountOwner();
    }

    private void checkUser()
    {
        if ( !requiresUser() )
            return;

        if ( hasCurrentUser() )
            return;

        throwSecurityError("User sign in required.");
    }

    private void checkDeveloper()
    {
        if ( !requiresDeveloper() )
            return;

        if ( hasCurrentUser() && getCurrentUser().allowsDeveloper() )
            return;

        throwSecurityError("Developer access required.");
    }

    private void checkAccountMember()
    {
        if ( !requiresAccountMember() )
            return;

        if ( hasCurrentAccount() && getCurrentAccount().hasMember(getCurrentUser()) )
            return;

        throwSecurityError("Account member required.");
    }

    private void checkAccountOwner()
    {
        if ( !requiresAccountOwner() )
            return;

        if ( hasCurrentAccount() && getCurrentAccount().hasOwner(getCurrentUser()) )
            return;

        throwSecurityError("Account owner required.");
    }

    //==================================================
    //= security overrides
    //==================================================

    protected boolean requiresDeveloper()
    {
        return false;
    }

    protected boolean requiresAccountMember()
    {
        return false;
    }

    protected boolean requiresAccountOwner()
    {
        return false;
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

    protected MyCookieSession getCookieSession()
    {
        return MyGlobals.getCookieSession();
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

    protected void flushDao()
    {
        getDaoSession().flush();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyPageLayout getPageLayout()
    {
        return MyPageLayout.getInstance();
    }

    public final String _formatEntryUrl()
    {
        return MyUrls.getEntryUrl(_composeQueryParameters());
    }

}
