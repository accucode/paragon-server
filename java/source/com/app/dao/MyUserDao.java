package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEmailParser;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

/**
 * (valerie)
 * hope I didn't get too carried away with the refactoring, still working
 * on the right balance
 * 
 * (wyatt) discuss
 * 
 * (valerie) Eh?
 * 
 * review_valerie (wyatt) discuss
 */

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
        a.setName("Root");
        a.setTypePersonal();
        a.saveDao();

        MyAccountUser au;
        au = a.addAccountUser();
        au.setUser(u);
        au.setRoleOwner();

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
        u.saveDao();
        return u;
    }

    public MyUser createNewUser(String email, String password)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setName(name);
        u.setEmail(email);
        u.addPersonalAccount();
        u.setPassword(password);
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    public MyUser createNewUser(String email, String password, MyAccount account)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setName(name);
        u.setEmail(email);
        u.addPersonalAccount();
        u.setPassword(password);
        u.joinAccount(account);
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    public MyUser createNewUser(String email, String password, MyAccount account, String roleCode)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setRoleUser();
        u.setName(name);
        u.setEmail(email);
        u.addPersonalAccount();
        u.setPassword(password);
        u.joinAccount(account, roleCode);
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    //##################################################
    //# convenience
    //##################################################

    public MyUser findRoot()
    {
        return findUid(MyUser.ROOT_UID);
    }
}
