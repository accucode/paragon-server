package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAccountCriteria;
import com.app.dao.base.MyAccountDaoBase;
import com.app.model.MyAccount;

public class MyAccountDao
    extends MyAccountDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyAccount> findName(String name)
    {
        MyAccountCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        return c.findAll();
    }

    public MyAccount findRoot()
    {
        return findUid(MyAccount.ROOT_UID);
    }
}
