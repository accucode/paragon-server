package com.app.dao;

import com.app.criteria.MyAccountCriteria;
import com.app.dao.base.MyAccountDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

public class MyAccountDao
    extends MyAccountDaoBase
{
    public MyAccount findWithName(String name)
    {
        MyAccountCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        return c.findFirst();
    }

    public MyAccount createNewAccount(String name, String typeCode, MyUser user)
    {
        MyAccount account;
        account = new MyAccount();
        account.setName(name);
        account.setTypeCode(typeCode);
        account.saveDao();

        MyAccountUser accountUser;
        accountUser = new MyAccountUser();
        accountUser.setAccount(account);
        accountUser.setUser(user);
        accountUser.setRoleOwner();
        accountUser.saveDao();

        return account;
    }
}
