package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.model.meta.MyMetaAccount;
import com.app.model.meta.MyMetaUserAccount;
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
        MyMetaUserAccount x = MyUserAccount.Meta;

        return getUserAccounts().collect(x.Account);
    }

    public KmCollection<MyAccount> getOwnedAccounts()
    {
        KmCollection<MyAccount> v = new KmCollection<MyAccount>();

        for ( MyUserAccount e : getUserAccounts() )
            if ( e.isRoleOwner() )
                v.add(e.getAccount());

        return v;
    }

    public KmCollection<MyAccount> getSharedAccounts()
    {
        KmCollection<MyAccount> v = new KmCollection<MyAccount>();

        for ( MyUserAccount e : getUserAccounts() )
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

    public MyAccount addAccount(String name)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.saveDao();

        joinAccount(a, MyUserAccountRole.Owner);

        return a;
    }

    public MyUserAccount joinAccount(MyAccount a)
    {
        return joinAccount(a, MyUserAccountRole.User);
    }

    public MyUserAccount joinAccount(MyAccount a, MyUserAccountRole role)
    {
        MyUserAccount ua;
        ua = addUserAccount();
        ua.setAccount(a);
        ua.setRole(role);
        return ua;
    }

    public boolean hasSingleAccount()
    {
        return getUserAccountCount() == 1;
    }

    public boolean hasMultipleAccounts()
    {
        return getUserAccounts().isMultiple();
    }

    public boolean isMemberOf(MyAccount e)
    {
        return getUserAccountFor(e) != null;
    }

    public MyUserAccount getUserAccountFor(MyAccount a)
    {
        KmCollection<MyUserAccount> uas = getUserAccounts();
        for ( MyUserAccount ua : uas )
            if ( ua.hasAccount(a) )
                return ua;

        return null;
    }

}
