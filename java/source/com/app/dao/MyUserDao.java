package com.app.dao;

import com.kodemore.utility.KmEmailParser;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
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
        return c.findFirst();
    }

    /**
     * review_steve (wyatt)   discuss
     * review_valerie (wyatt) discuss
     */
    public MyUser findName(String s)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereName().is(s);
        return c.findFirst();
    }

    public void createNewUser()
    {
        MyUser u;
        u = new MyUser();
        u.setUid(MyUser.ROOT_UID);
        u.setRoleDeveloper();
        u.setEmail("root");
        u.setPassword(null);
        u.setName("Root");
        u.setVerified(true);
        u.saveDao();

        MyAccount a;
        a = new MyAccount();
        a.setUid(MyAccount.ROOT_UID);
        a.setName("Personal");
        a.setTypePersonal();
        a.saveDao();

        MyAccountUser au;
        au = a.addAccountUser();
        au.setUser(u);
        au.setRoleOwner();
    }

    /**
     * review_valerie (wyatt) name
     *      This method creates a new invitation?
     */
    public void createNewUserInvitation(String name, String email, String password)
    {
        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setEmail(email);
        u.setPassword(password);
        u.setName(name);
        u.setVerified(true);
        u.saveDao();

        MyAccount a;
        a = new MyAccount();
        a.setName("Personal");
        a.setTypePersonal();
        a.saveDao();

        MyAccountUser au;
        au = a.addAccountUser();
        au.setUser(u);
        au.setRoleOwner();
    }

    // fixme_valerie: rename transfer join
    public MyUser createNewUserTransfer(String email, String password, MyAccount account)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setEmail(email);
        u.setPassword(password);
        u.setName(name);
        u.setVerified(true);
        u.saveDao();

        MyAccount a;
        a = account;
        a.saveDao();

        MyAccountUser au;
        au = a.addAccountUser();
        au.setUser(u);

        return u;
    }
}
