package com.app.ui.activity;

import com.app.dao.base.MyDaoRegistry;
import com.app.file.MyFilePaths;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyCookieSession;
import com.app.ui.core.MyPageSession;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyGlobals;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.ScActivity;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public abstract class MyActivity
    extends ScActivity
{
    //##################################################
    //# settings
    //##################################################

    public void defineRoles()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        String s;
        s = getShortClassName();
        s = Kmu.formatCamelCaseAsCapitalizedWords(s);
        return s;
    }

    @Override
    public String getNavigationHash()
    {
        String s;
        s = getShortClassName();
        s = Kmu.lowercaseFirstLetter(s);
        return s;
    }

    private String getShortClassName()
    {
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removeSuffix(s, "Activity");
        s = Kmu.removeSuffix(s, "Page");
        s = Kmu.removeSuffix(s, "Menu");
        return s;
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    @Override
    protected MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

    protected MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    protected MyCookieSession getCookieSession()
    {
        return MyGlobals.getCookieSession();
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
        MyServerSession ss = getServerSession();
        if ( ss == null )
            return null;

        return ss.getAccount();
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
    //# account user
    //##################################################

    public MyAccountUser getCurrentAccountUser()
    {

        MyUser u = getCurrentUser();
        MyAccount a = getCurrentAccount();

        return a.getAccountUserFor(u);
    }

    public String getCurrentAccountUserUid()
    {
        MyAccount a = getCurrentAccount();
        if ( a == null )
            return null;

        return a.getUid();
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

    protected boolean requiresUser()
    {
        return true;
    }

    protected boolean requiresCsr()
    {
        return false;
    }

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
    //# convenience
    //##################################################

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

    //##################################################
    //# utility
    //##################################################

    protected void writeTempWebFile(String file, ScControl c)
    {
        String path = MyFilePaths.getWebPath(file);
        String html = c.render().formatHtml();

        Kmu.writeFile(path, html);
    }

    protected MyPageLayout getPageLayout()
    {
        return MyPageLayout.getInstance();
    }

}
