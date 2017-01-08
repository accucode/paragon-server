package com.app.model;

import com.app.model.base.MyEmailRecipientBase;
import com.app.model.core.MySystemDomainIF;

public class MyEmailRecipient
    extends MyEmailRecipientBase
    implements MySystemDomainIF
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
