package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyApplicationLogBase;

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
        return getSortedTraces().joinLines(e -> e.getValue());
    }

}
