package com.app.ui.page.crud.customerSite;

import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyCustomerSiteListView
    extends MyCrudListView<MyCustomer,MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteListView()
    {
        this(new MyCustomerSiteBuilder());
    }

    public MyCustomerSiteListView(MyCustomerSiteBuilder e)
    {
        super(e);
    }
}
