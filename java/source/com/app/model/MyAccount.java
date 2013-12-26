package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyAccountBase;

public class MyAccount
    extends MyAccountBase
{
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

    public KmList<MyUser> findUsers()
    {
        return getAccess().getUserDao().findAccount(this);
    }

    //##################################################
    //# transfer ownership
    //##################################################

    public boolean validateTransferOwnership(MyUser from, MyUser to)
    {
        if ( from.hasSingleAccount() )
            return false;

        if ( from != getOwner() )
            return false;

        if ( isNotMember(to) )
            return false;

        return !from.equals(to);
    }

    public void transferOwnerTo(MyUser to)
    {
        MyUser from = getOwner();

        validateTransferOwnership(from, to);

        getUserAccountFor(from).setRoleUser();
        getUserAccountFor(to).setRoleOwner();
    }

    //##################################################
    //# delete
    //##################################################

    public boolean validateDeletePermissions(MyUser user)
    {
        if ( user.hasSingleAccount() )
            return false;

        return hasOwner(user);
    }

    //##################################################
    //# support
    //##################################################

    public MyUser getOwner()
    {
        return getAccess().getUserDao().findOwnerFor(this);
    }

    public boolean hasOwner(MyUser u)
    {
        return Kmu.isEqual(getOwner(), u);
    }

    public MyUserAccount getUserAccountFor(MyUser user)
    {
        return user.getUserAccountFor(this);
    }

    private boolean isNotMember(MyUser user)
    {
        return getUserAccountFor(user) == null;
    }

    public boolean hasMember(MyUser u)
    {
        return getUserAccountFor(u) != null;
    }
}
