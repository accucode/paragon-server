//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.command.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public final class MyOptimisticLockFinder
    implements KmKeyFinderIF<MyOptimisticLock,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyOptimisticLockFinder instance = new MyOptimisticLockFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyOptimisticLockFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
