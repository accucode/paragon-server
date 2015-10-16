package com.app.model;

import com.app.model.base.MyEmailRecipientBase;

public class MyEmailRecipient
    extends MyEmailRecipientBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipient()
    {
        super();

        setTypeTo();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getTypeName() + " " + getAddress();
    }

}
