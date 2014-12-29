package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyUser;

public class MyUserDao
    extends MyUserDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyUser> findAllByName()
    {
        MyUserCriteria c;
        c = createCriteria();
        c.sortOnName();
        return c.findAll();
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
        u.setRoleOther();
        u.setName(name);
        u.setEmail(email);
        u.setRandomPassword();
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    //##################################################
    //# email
    //##################################################

    public MyUser findEmail(String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereEmail().is(email);
        return c.findUnique();
    }

    public boolean emailExists(String email)
    {
        return findEmail(email) != null;
    }

    /**
     * Determine if any user, NOT the one provided, as the same email.
     */
    public boolean hasDuplicateEmail(MyUser e)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereUid().isNot(e.getUid());
        c.whereEmail().is(e.getEmail());
        return c.findUnique() != null;
    }

}
