package com.app.ui.control;

import com.kodemore.servlet.control.ScControl;

import com.app.ui.core.MyServletData;

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
