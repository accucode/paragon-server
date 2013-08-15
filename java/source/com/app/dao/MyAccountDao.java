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
    public MyAccount findName(String name)
    {
        MyAccountCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        return c.findFirst();
    }

    public MyAccount createNewAccount(String name, MyAccountType type, MyUser user)
    {
        MyAccount a = createNewAccount(name, type);

        getAccess().getAccountUserDao().createNewAccountUser(user, a, MyAccountUserRole.Owner);

        return a;
    }

    public MyAccount createNewAccount(String name, MyAccountType type)
    {
        MyAccount a;
        a = new MyAccount();
        a.setName(name);
        a.setType(type);
        a.saveDao();
        return a;
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
