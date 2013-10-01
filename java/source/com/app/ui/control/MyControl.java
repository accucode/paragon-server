package com.app.ui.control;

import com.app.ui.core.MyServletData;

import com.kodemore.servlet.control.ScControl;

public abstract class MyControl
    extends ScControl
{
    //##################################################
    //# convenience
    //##################################################

    @Override
    public MyServletData getData()
    {
        return (MyServletData)super.getData();
    }
}
