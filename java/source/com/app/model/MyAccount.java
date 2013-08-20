package com.app.model;

import com.kodemore.collection.KmCollection;

import com.app.model.base.MyAccountBase;
import com.app.model.meta.MyMetaAccountUser;
import com.app.model.meta.MyMetaUser;

public class MyAccount
    extends MyAccountBase
{
    //##################################################
    //# constants
    //##################################################

    public static final String ROOT_UID = "root";

    //##################################################
    //# constructor
    //##################################################

    public MyAccount()
    {
        super();
    }

    //##################################################
    //# users
    //##################################################

    public KmCollection<MyUser> getUsers()
    {
        MyMetaAccountUser x = MyAccountUser.Meta;

        return getAccountUsers().collect(x.User);
    }

    public KmCollection<String> getUserNames()
    {
        MyMetaUser x = MyUser.Meta;

        return getUsers().collect(x.Name);
    }

    //##################################################
    //# transfer ownership
    //##################################################

    public boolean validateTransferOwnership(MyUser from, MyUser to)
    {
        if ( from != getOwner() )
            return false;

        if ( isNotMember(to) )
            return false;

        if ( from.equals(to) )
            return false;

        return true;
    }

    public MyUser getOwner()
    {
        KmCollection<MyAccountUser> v = getAccountUsers();
        for ( MyAccountUser e : v )
            if ( e.isRoleOwner() )
                return e.getUser();

        return null;
    }

    public void transferOwnerTo(MyUser to)
    {
        MyUser from = getOwner();

        validateTransferOwnership(from, to);

        getAccountUserFor(from).setRoleUser();
        getAccountUserFor(to).setRoleOwner();
    }

    public MyAccountUser getAccountUserFor(MyUser user)
    {
        KmCollection<MyAccountUser> v = getAccountUsers();
        for ( MyAccountUser e : v )
            if ( e.hasUser(user) )
                return e;

        return null;
    }

    private boolean isNotMember(MyUser user)
    {
        return getAccountUserFor(user) == null;
    }
}
