package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.base.MyAccountUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyUser;

public class MyAccountUserDao
    extends MyAccountUserDaoBase
{
    public KmList<MyAccountUser> findAccountUsersFor(MyUser u)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUserIs(u);
        return c.findAll();
    }

    public KmList<MyAccountUser> findAccountUsersFor(MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereAccountIs(a);
        return c.findAll();
    }

    public MyAccountUser findAccountUserFor(MyUser u, MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUserIs(u);
        c.whereAccountIs(a);
        return c.findFirst();
    }

    /**
     * (valerie)
     * these two convenience methods
     * 
     * review_valerie (wyatt) discuss 
     */
    public MyAccountUser findCurrentOwner(MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereAccountIs(a);
        c.whereRoleIsOwner();
        return c.findUnique();
    }

    public void transferOwnership(MyAccountUser oldOwner, MyAccountUser newOwner)
    {
        oldOwner.setRole(MyAccountUserRole.User);
        newOwner.setRole(MyAccountUserRole.Owner);
    }

    public void createNewAccountUser(MyUser u, MyAccount a, MyAccountUserRole role)
    {
        MyAccountUser au;
        au = new MyAccountUser();
        au.setAccount(a);
        au.setUser(u);
        au.setRole(role);
        au.saveDao();
    }

    public MyAccountUser getNewAccountUser(MyUser u, MyAccount a)
    {
        MyAccountUser au;
        au = new MyAccountUser();
        au.setAccount(a);
        au.setUser(u);
        au.setRole(MyAccountUserRole.User);
        au.saveDao();
        return au;
    }

    public void createNewAccountUser(MyUser u, MyAccount a)
    {
        createNewAccountUser(u, a, MyAccountUserRole.User);
    }
}
