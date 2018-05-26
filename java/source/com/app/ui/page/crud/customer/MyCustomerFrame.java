package com.app.ui.page.crud.customer;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyCustomerFrame
    extends MyCrudFrame<MyProject,MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerFrame()
    {
        this(new MyCustomerBuilder());
    }

    public MyCustomerFrame(MyCustomerBuilder e)
    {
        super(e);
    }

}
