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

public final class MyPerformanceLogSummaryFinder
    implements KmKeyFinderIF<MyPerformanceLogSummary,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyPerformanceLogSummaryFinder instance = new MyPerformanceLogSummaryFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogSummaryFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
