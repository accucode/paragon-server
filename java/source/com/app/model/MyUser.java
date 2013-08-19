package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.model.meta.MyMetaAccount;
import com.app.model.meta.MyMetaAccountUser;
import com.app.utility.MyUtility;

public class MyUser
    extends MyUserBase
{
    //##################################################
    //# constants
    //##################################################

    public static final String     ROOT_UID          = "root";

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

    public boolean allowsAdmin()
    {
        return isRoleAdmin() || isRoleDeveloper();
    }

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

    public MyAccount addBusinessAccount(String name, String roleCode)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypeBusiness();
        a.saveDao();

        return _addAccount(a, roleCode);
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

    public MyAccount addPersonalAccount(String name, String roleCode)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setTypeBusiness();
        a.saveDao();

        return _addAccount(a, roleCode);
    }

    public MyAccountUser joinAccount(MyAccount a)
    {
        MyAccountUser au;
        au = a.addAccountUser();
        au.setRoleUser();
        return au;
    }

    public MyAccountUser joinAccount(MyAccount a, String roleCode)
    {
        MyAccountUser au;
        au = a.addAccountUser();
        au.setRoleCode(roleCode);
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

    private MyAccount _addAccount(MyAccount a, String roleCode)
    {
        MyAccountUser au;
        au = joinAccount(a);
        au.setRoleCode(roleCode);
        return a;
    }
}
