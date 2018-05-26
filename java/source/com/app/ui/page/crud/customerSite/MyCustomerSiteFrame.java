package com.app.ui.page.crud.customerSite;

import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyCustomerSiteFrame
    extends MyCrudFrame<MyCustomer,MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteFrame()
    {
        this(new MyCustomerSiteBuilder());
    }

    public MyCustomerSiteFrame(MyCustomerSiteBuilder e)
    {
        super(e);
    }

}
