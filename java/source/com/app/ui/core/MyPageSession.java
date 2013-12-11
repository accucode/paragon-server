package com.app.ui.core;

import com.kodemore.servlet.ScPageSession;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyAccount;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.servlet.base.MyPageSessionBase;
import com.app.utility.MyGlobals;

public class MyPageSession
    extends MyPageSessionBase
{
    //##################################################
    //# static
    //##################################################

    public static MyPageSession getInstance()
    {
        return (MyPageSession)ScPageSession.getInstance();
    }

    public static void install()
    {
        install(new MyPageSession());
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _currentAccountUid;

    //##################################################
    //# constructor
    //##################################################

    private MyPageSession()
    {
        _currentAccountUid = new ScLocalString();
    }

    //##################################################
    //# current account
    //##################################################

    public String getCurrentAccountUid()
    {
        return _currentAccountUid.getValue();
    }

    public void setCurrentAccountUid(String e)
    {
        _currentAccountUid.setValue(e);
    }

    public MyAccount getCurrentAccount()
    {
        String uid = getCurrentAccountUid();

        if ( Kmu.hasValue(uid) )
            return getDaoRegistry().findAccountUid(uid);

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return null;

        MyUser user = ss.getUser();
        if ( user == null )
            return null;

        MyAccount acct = user.getDefaultAccount();
        setCurrentAccount(acct);
        return acct;
    }

    public void setCurrentAccount(MyAccount e)
    {
        if ( e == null )
            setCurrentAccountUid(null);
        else
            setCurrentAccountUid(e.getUid());
    }

    public void clearCurrentAccount()
    {
        setCurrentAccount(null);
    }

    public boolean hasCurrentAccount()
    {
        return getCurrentAccount() != null;
    }
}
