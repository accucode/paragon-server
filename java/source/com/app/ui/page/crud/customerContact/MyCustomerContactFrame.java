package com.app.ui.page.crud.customerContact;

import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyCustomerContactFrame
    extends MyCrudFrame<MyCustomer,MyCustomerContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactFrame()
    {
        this(new MyCustomerContactBuilder());
    }

    public MyCustomerContactFrame(MyCustomerContactBuilder e)
    {
        super(e);
    }

}
