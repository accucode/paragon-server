package com.app.model;

import com.app.model.base.MySystemLogBase;
import com.app.model.meta.MyMetaSystemLogTrace;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class MySystemLog
    extends MySystemLogBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLog()
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
        MyMetaSystemLogTrace x = MySystemLogTrace.Meta;
        KmList<MySystemLogTrace> v = getSortedTraces();
        return v.collect(x.Value).format("\n");
    }
}
