package com.app.model;

import com.app.model.base.MyUserBase;
import com.app.model.meta.MyMetaAccount;
import com.app.model.meta.MyMetaAccountUser;
import com.app.utility.MyUtility;

import com.kodemore.collection.KmCollection;
import com.kodemore.utility.Kmu;

public class MyUser
    extends MyUserBase
{
    //##################################################
    //# constants
    //##################################################

    public static final MyTimeZone DEFAULT_TIME_ZONE = MyTimeZone.MSTD;

    //##################################################
    //# constructor
    //##################################################

    public MyUser()
    {
        super();

        setTimeZone(DEFAULT_TIME_ZONE);
    }

    //##################################################
    //# private
    //##################################################

    private String hashPassword(String e)
    {
        return MyUtility.getPasswordHash(getPasswordSalt(), e);
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

    public MyTimeZone getTimeZone()
    {
        return MyTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(MyTimeZone e)
    {
        if ( e == null )
            setTimeZoneCode(null);
        else
            setTimeZoneCode(e.getCode());
    }

    //##################################################
    //# roles
    //##################################################

    public boolean allowsDeveloper()
    {
        return isRoleDeveloper();
    }

    public boolean allowsLogin()
    {
        return isVerified();
    }

    //##################################################
    //# accounts
    //##################################################

    public KmCollection<MyAccount> getAccounts()
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        return getAccountUsers().collect(x.Account);
    }

    public KmCollection<String> getAccountNames()
    {
        MyMetaAccount x = MyAccount.Meta;

        return getAccounts().collect(x.Name);
    }

    public MyAccount addBusinessAccount(String name)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypeBusiness();
        a.saveDao();

        return _addAccount(a);
    }

    public MyAccount addBusinessAccount(String name, MyAccountUserRole role)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypeBusiness();
        a.saveDao();

        return _addAccount(a, role);
    }

    public MyAccount addPersonalAccount()
    {
        MyAccount a;
        a = new MyAccount();
        a.setName("Personal");
        a.setTypePersonal();
        a.saveDao();

        return _addAccount(a);
    }

    public MyAccount addPersonalAccount(String name)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypePersonal();
        a.saveDao();

        return _addAccount(a);
    }

    public MyAccount addPersonalAccount(String name, MyAccountUserRole role)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypeBusiness();
        a.saveDao();

        return _addAccount(a, role);
    }

    public MyAccountUser joinAccount(MyAccount a)
    {
        MyAccountUser au;
        au = a.addAccountUser();
        au.setRoleUser();

        addAccountUser(au);

        return au;
    }

    public MyAccountUser joinAccount(MyAccount a, MyAccountUserRole role)
    {
        MyAccountUser au;
        au = a.addAccountUser();
        au.setRoleCode(role.getCode());

        addAccountUser(au);

        return au;
    }

    //##################################################
    //# support
    //##################################################

    private MyAccount _addAccount(MyAccount a)
    {
        MyAccountUser au;
        au = joinAccount(a);
        au.setRoleOwner();
        return a;
    }

    private MyAccount _addAccount(MyAccount a, MyAccountUserRole role)
    {
        MyAccountUser au;
        au = joinAccount(a);
        au.setRoleCode(role.getCode());
        return a;
    }

    public void _removeAccount(MyAccount a)
    {
        KmCollection<MyAccountUser> v = getAccountUsers();
        for ( MyAccountUser e : v )
            if ( e.hasAccount(a) )
            {
                removeAccountUser(e);
                break;
            }
    }

    public boolean hasSingleAccount()
    {
        return getAccountUserCount() == 1;
    }
}
