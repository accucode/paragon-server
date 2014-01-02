package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyUser;
import com.app.utility.MyConstantsIF;

public class MyUserDao
    extends MyUserDaoBase
{
    //##################################################
    //# find
    //##################################################

    public MyUser findEmail(String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereEmail().is(email);
        return c.findUnique();
    }

    public KmList<MyUser> findName(String s)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereName().is(s);
        return c.findAll();
    }

    public MyUser createRootUser()
    {
        MyUser u;
        u = createUser("Root", "root");
        u.setRoleDeveloper();
        u.clearPassword();
        u.getAccounts().getFirst().setName(getRootAccountName());
        return u;
    }

    private String getRootAccountName()
    {
        return MyConstantsIF.APPLICATION_NAME + " Inc.";
    }

    /**
     * Create a new user.  
     * Automatically creates the user's personal account.
     */
    public MyUser createUser(String name, String email)
    {
        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setName(name);
        u.setEmail(email);
        u.addAccount("Personal");
        u.setRandomPassword();
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    public KmList<MyUser> findAccount(MyAccount e)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.joinToUserAccounts().whereAccountIs(e);
        return c.findAll();
    }

    public MyUser findOwnerFor(MyAccount e)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.joinToUserAccounts().whereAccountIs(e);
        c.joinToUserAccounts().whereRoleIsOwner();
        return c.findFirst();
    }
}
