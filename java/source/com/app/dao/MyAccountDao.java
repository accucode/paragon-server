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
        MyAccount account = createNewAccount(name, type);

        getAccess().getAccountUserDao().createNewAccountUser(user, account, MyAccountUserRole.Owner);

        return account;
    }

    public MyAccount createNewAccount(String name, MyAccountType type)
    {
        MyAccount account;
        account = new MyAccount();
        account.setName(name);
        account.setType(type);
        account.saveDao();
        return account;
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
