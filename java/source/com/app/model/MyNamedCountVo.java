package com.app.model;

import com.app.model.base.MyNamedCountVoBase;

public class MyNamedCountVo
    extends MyNamedCountVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyNamedCountVo()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName() + " " + getCount();
    }

}
