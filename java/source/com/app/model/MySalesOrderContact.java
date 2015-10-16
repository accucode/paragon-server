package com.app.model;

import com.app.model.base.MySalesOrderContactBase;

public class MySalesOrderContact
    extends MySalesOrderContactBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderContact()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
