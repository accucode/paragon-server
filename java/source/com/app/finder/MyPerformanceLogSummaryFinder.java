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

public class MyPerformanceLogSummaryFinder
    implements KmKeyFinderIF<MyPerformanceLogSummary,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyPerformanceLogSummary staticFind(String key)
    {
        return new MyPerformanceLogSummaryFinder().find(key);
    }

    public static MyPerformanceLogSummary staticFindDao(String key)
    {
        return new MyPerformanceLogSummaryFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPerformanceLogSummary find(String key)
    {
        return new MyPerformanceLogSummaryDao().findUid(key);
    }

    public MyPerformanceLogSummary findDao(String key)
    {
        MyDaoKeyFinder<MyPerformanceLogSummary,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
