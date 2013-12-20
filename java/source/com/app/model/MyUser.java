package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
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

    public KmCollection<MyAccount> getOwnedAccounts()
    {
        KmCollection<MyAccount> v = new KmCollection<MyAccount>();

        for ( MyAccountUser e : getAccountUsers() )
            if ( e.isRoleOwner() )
                v.add(e.getAccount());

        return v;
    }

    public KmCollection<MyAccount> getSharedAccounts()
    {
        KmCollection<MyAccount> v = new KmCollection<MyAccount>();

        for ( MyAccountUser e : getAccountUsers() )
            if ( !e.isRoleOwner() )
                v.add(e.getAccount());

        return v;
    }

    public KmList<MyAccount> getOwnedAccountsByName()
    {
        KmList<MyAccount> v;
        v = getOwnedAccounts().toList();
        v.sortOn(MyAccount.Meta.Name);
        return v;
    }

    public KmList<MyAccount> getSharedAccountsByName()
    {
        KmList<MyAccount> v;
        v = getSharedAccounts().toList();
        v.sortOn(MyAccount.Meta.Name);
        return v;
    }

    public MyAccount getDefaultAccount()
    {
        MyMetaAccount x = MyAccount.Meta;

        KmCollection<MyAccount> v;
        v = getOwnedAccounts();
        v.toList().sortOn(x.Name);

        return v.getFirst();
    }

    public KmCollection<String> getAccountNames()
    {
        MyMetaAccount x = MyAccount.Meta;

        return getAccounts().collect(x.Name);
    }

    public MyAccount addBusinessAccount(String name)
    {
        MyAccount e;
        e = new MyAccount();
        e.setName(name);
        e.setTypeBusiness();
        e.saveDao();

        return _addAccount(e);
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

    public boolean hasSingleAccount()
    {
        return getAccountUserCount() == 1;
    }

    public boolean hasMultipleAccounts()
    {
        return getAccountUsers().isMultiple();
    }

    public boolean isMemberOf(MyAccount e)
    {
        return e.hasMember(this);
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

}
