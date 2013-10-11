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

public class MySystemLogFinder
    implements KmKeyFinderIF<MySystemLog,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MySystemLog staticFind(Integer key)
    {
        return new MySystemLogFinder().find(key);
    }

    public static MySystemLog staticFindDao(Integer key)
    {
        return new MySystemLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySystemLog find(Integer key)
    {
        return new MySystemLogDao().findId(key);
    }

    public MySystemLog findDao(Integer key)
    {
        MyDaoKeyFinder<MySystemLog,Integer> e;
        e = new MyDaoKeyFinder<MySystemLog,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
