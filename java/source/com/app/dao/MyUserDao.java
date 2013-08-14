package com.app.dao;

import com.kodemore.utility.KmEmailParser;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyDaoRegistry;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyUser;
import com.app.model.MyUserRole;
import com.app.utility.MyGlobals;

/**
 * review_wyatt (valerie)
 * hope I didn't get too carried away with the refactoring, still working
 * on the right balance
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

    public void createRootUser()
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
        MyUser u = createNewUser(MyUserRole.User, email, password, name);
        MyAccount a = getAccess().getAccountDao().createNewAccount(
            "Personal",
            MyAccountType.Personal);
        getAccess().getAccountUserDao().createNewAccountUser(u, a, MyAccountUserRole.Owner);
    }

    public MyUser createNewUserWithAccount(String email, String password, MyAccount account)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u = createNewUser(MyUserRole.User, email, password, name);

        MyAccount a = account;
        a.saveDao();

        getAccess().getAccountUserDao().createNewAccountUser(u, a);

        return u;
    }

    public MyUser createNewUser(String name, String email, String password, MyAccount account)
    {
        MyUser u = createNewUser(MyUserRole.Admin, email, password, name);

        MyAccount a = account;
        a.saveDao();

        getAccess().getAccountUserDao().createNewAccountUser(u, a);

        return u;
    }

    public MyUser createNewUser(String name, String email, String password, String accountName)
    {
        MyUser u = createNewUser(MyUserRole.Admin, email, password, name);

        MyAccount a = getAccess().getAccountDao().createNewAccount(
            accountName,
            MyAccountType.Personal,
            u);

        getAccess().getAccountUserDao().createNewAccountUser(u, a);

        return u;
    }

    private MyUser createNewUser(MyUserRole userRole, String email, String password, String userName)
    {
        MyUser u;
        u = new MyUser();
        u.setRole(userRole);
        u.setEmail(email);
        u.setPassword(password);
        u.setName(userName);
        u.setVerified(true);
        u.saveDao();
        return u;
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
