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

    /**
     * (valerie) to replace transferOwnership in MyAccountUserDao
     * 
     * review_valerie (wyatt) discuss
     */
    public void transferOwnershipValidate(MyUser from, MyUser to)
    {
        MyAccountUser fromAU;
        fromAU = getAccess().getAccountUserDao().findCurrentOwner(this);

        if ( from != fromAU.getUser() )
            error("Sorry, you do not have permission to transfer ownership of this account.");

        if ( isNotMember(to) )
            error("%s is not yet a member of %s.", to.getName(), getName());

        if ( from.equals(to) )
            error("You are already the account owner.");
    }

    /**
     * review_valerie (wyatt) discuss
     */
    public void setOwnerTo(MyUser to)
    {
        MyAccountUser fromAU;
        fromAU = getAccess().getAccountUserDao().findCurrentOwner(this);
        fromAU.setRoleUser();

        MyAccountUser toAU;
        toAU = getAccess().getAccountUserDao().findAccountUserFor(to, this);
        toAU.setRoleOwner();
    }

    private boolean isNotMember(MyUser to)
    {
        MyAccountUser toAU;
        toAU = getAccess().getAccountUserDao().findAccountUserFor(to, this);
        return toAU == null;
    }
}
