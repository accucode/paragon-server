//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyOptimisticLockFinder
    implements KmKeyFinderIF<MyOptimisticLock,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyOptimisticLock staticFind(String key)
    {
        return new MyOptimisticLockFinder().find(key);
    }

    public static MyOptimisticLock staticFindDao(String key)
    {
        return new MyOptimisticLockFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyOptimisticLock find(String key)
    {
        return new MyOptimisticLockDao().findName(key);
    }

    public MyOptimisticLock findDao(String key)
    {
        MyDaoKeyFinder<MyOptimisticLock,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
