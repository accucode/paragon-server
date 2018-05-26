package com.app.ui.page.crud.customer;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyCustomerListView
    extends MyCrudListView<MyProject,MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerListView()
    {
        this(new MyCustomerBuilder());
    }

    public MyCustomerListView(MyCustomerBuilder e)
    {
        super(e);
    }
}
