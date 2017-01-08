package com.app.dao;

import com.kodemore.utility.Kmu;

import com.app.dao.base.MyOptimisticLockDaoBase;
import com.app.model.MyOptimisticLock;

public class MyOptimisticLockDao
    extends MyOptimisticLockDaoBase
{
    public void touch(String topic, String value)
    {
        String name = Kmu.format("%s::%s", topic, value);
        touch(name);
    }

    public void touch(String name)
    {
        MyOptimisticLock e = findName(name);

        if ( e == null )
        {
            e = new MyOptimisticLock();
            e.setName(name);
            e.daoAttach();
        }

        e.touch();
    }
}
