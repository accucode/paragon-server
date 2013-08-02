package com.app.dao;

import com.app.criteria.MyAccountCriteria;
import com.app.dao.base.MyAccountDaoBase;
import com.app.model.MyAccount;

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
}
