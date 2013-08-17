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
     * review_wyatt (valerie) to replace transferOwnership in MyAccountUserDao
     */
    public void transferOwnership(MyUser from, MyUser to)
    {
        MyAccountUser fromAU;
        fromAU = getAccess().getAccountUserDao().findCurrentOwner(this);

        if ( from != fromAU.getUser() )
            error("Sorry, you do not have permission to transfer ownership of this account.");

        if ( isNotMember(to) )
            error("%s is not yet a member of %s.", to.getName(), getName());

        if ( from.equals(to) )
            error("You are already the account owner.");

        fromAU.setRoleUser();

        MyAccountUser toAU;
        toAU = findAccountUserUid(to.getUid());
        toAU.setRoleOwner();
    }

    public void setOwnerTo(MyUser to)
    {
        MyAccountUser fromAU;
        fromAU = getAccess().getAccountUserDao().findCurrentOwner(this);
        fromAU.setRoleUser();

        MyAccountUser toAU;
        toAU = findAccountUserUid(to.getUid());
        toAU.setRoleOwner();
    }

    private boolean isNotMember(MyUser to)
    {
        return findAccountUserUid(to.getUid()) == null;
    }
}
