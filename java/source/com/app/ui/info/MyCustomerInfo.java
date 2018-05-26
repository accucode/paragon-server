package com.app.ui.info;

import com.app.model.MyCustomer;

public class MyCustomerInfo
    extends MyDomainInfo<MyCustomer>
{
    //##################################################
    //# text
    //##################################################

    @Override
    protected String getLabelFor(MyCustomer e)
    {
        return "Customer";
    }

    @Override
    protected String getNameFor(MyCustomer e)
    {
        return e.getName();
    }

    @Override
    protected String getHelpFor(MyCustomer e)
    {
        return null;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MyCustomer findTargetFor(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

    //##################################################
    //# open
    //##################################################

    @Override
    protected void openLinkFor(MyCustomer e)
    {
        e.ajaxEnterPage();
    }

    @Override
    protected String formatPopoutUrlFor(MyCustomer e)
    {
        return e.formatEntryUrl();
    }

}
