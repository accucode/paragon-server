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

public final class MyPerformanceLogDetailFinder
    implements KmKeyFinderIF<MyPerformanceLogDetail,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyPerformanceLogDetailFinder instance = new MyPerformanceLogDetailFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogDetailFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
