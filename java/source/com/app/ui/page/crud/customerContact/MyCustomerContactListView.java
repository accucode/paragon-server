package com.app.ui.page.crud.customerContact;

import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyCustomerContactListView
    extends MyCrudListView<MyCustomer,MyCustomerContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactListView()
    {
        this(new MyCustomerContactBuilder());
    }

    public MyCustomerContactListView(MyCustomerContactBuilder e)
    {
        super(e);
    }
}
