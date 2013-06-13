package com.app.model.core;

import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

public abstract class MyAbstractDomainTools
{
    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }
}
