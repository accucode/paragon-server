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

public class MyPerformanceLogDetailFinder
    implements KmKeyFinderIF<MyPerformanceLogDetail,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyPerformanceLogDetail staticFind(String key)
    {
        return new MyPerformanceLogDetailFinder().find(key);
    }

    public static MyPerformanceLogDetail staticFindDao(String key)
    {
        return new MyPerformanceLogDetailFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPerformanceLogDetail find(String key)
    {
        return new MyPerformanceLogDetailDao().findUid(key);
    }

    public MyPerformanceLogDetail findDao(String key)
    {
        MyDaoKeyFinder<MyPerformanceLogDetail,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
