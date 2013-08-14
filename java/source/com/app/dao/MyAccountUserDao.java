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
    public MyAccountUser findWithUid(String uid)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUid().is(uid);
        return c.findFirst();
    }

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
        return c.findFirst();
    }

    public void transferOwnership(MyAccountUser oldOwner, MyAccountUser newOwner)
    {
        oldOwner.setRole(MyAccountUserRole.User);
        newOwner.setRole(MyAccountUserRole.Owner);
    }

    public void createNewAccountUser(MyUser user, MyAccount account, MyAccountUserRole role)
    {
        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);
        accountUser.setRole(role);
        accountUser.saveDao();
    }

    public MyAccountUser getNewAccountUser(MyUser user, MyAccount account)
    {
        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);
        accountUser.setRole(MyAccountUserRole.User);
        accountUser.saveDao();
        return accountUser;
    }

    public void createNewAccountUser(MyUser user, MyAccount account)
    {
        createNewAccountUser(user, account, MyAccountUserRole.User);
    }
}
