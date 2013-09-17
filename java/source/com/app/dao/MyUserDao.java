package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyUser;

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
        u.getAccounts().getFirst().setName("Root-Inc");
        return u;
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
        u.addPersonalAccount();
        u.setRandomPassword();
        u.setVerified(true);
        u.saveDao();
        return u;
    }
   
}
