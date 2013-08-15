package com.app.dao;

import com.app.criteria.MyAccountCriteria;
import com.app.dao.base.MyAccountDaoBase;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.MyAccountUserRole;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

public class MyAccountDao
    extends MyAccountDaoBase
{
    //##################################################
    //# find
    //##################################################

    /**
     * review_valerie (wyatt) discuss
     * needs to return a list or use a uid if returning only one
     */
    public MyAccount findName(String name)
    {
        MyAccountCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        return c.findFirst();
    }

    public MyAccount findRoot()
    {
        return findUid(MyAccount.ROOT_UID);
    }

    //##################################################
    //# create
    //##################################################

    public MyAccount createNewAccount(String name, MyAccountType type, MyUser user)
    {
        MyAccount e = createNewAccount(name, type);
        getAccess().getAccountUserDao().createNewAccountUser(user, e, MyAccountUserRole.Owner);
        return e;
    }

    public MyAccount createNewAccount(String name, MyAccountType type)
    {
        MyAccount e;
        e = new MyAccount();
        e.setName(name);
        e.setType(type);
        e.saveDao();
        return e;
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
