package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyApplicationLogBase;
import com.app.model.core.MySystemDomainIF;

public class MyApplicationLog
    extends MyApplicationLogBase
    implements MySystemDomainIF
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
    public String getDisplayString()
    {
        return getMessage();
    }

    @Override
    public String getLevelCodeName()
    {
        return Kmu.format("%s (%s)", getLevelName(), getLevelCode());
    }
}
