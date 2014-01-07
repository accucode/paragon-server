package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyUserAccountCriteria;
import com.app.dao.base.MyUserAccountDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyUserAccount;

public class MyUserAccountDao
    extends MyUserAccountDaoBase
{
    public KmList<MyUserAccount> findAccount(MyAccount e)
    {
        MyUserAccountCriteria c;
        c = createCriteria();
        c.whereAccountIs(e);
        return c.findAll();
    }
}
