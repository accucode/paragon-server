package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyApplicationLogBase;
import com.app.model.meta.MyMetaApplicationLogTrace;

public class MyApplicationLog
    extends MyApplicationLogBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLog()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getLevelCodeName()
    {
        return Kmu.format("%s (%s)", getLevelName(), getLevelCode());
    }

    @Override
    public String getFullTrace()
    {
        MyMetaApplicationLogTrace x = MyApplicationLogTrace.Meta;
        KmList<MyApplicationLogTrace> v = getSortedTraces();
        return v.collect(x.Value).formatLines();
    }

}
