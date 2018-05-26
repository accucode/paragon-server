package com.app.ui.grid;

import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyCustomer;
import com.app.ui.grid.core.MyPopoutColumn;

public class MyCustomerColumn<P extends KmUidDomainIF>
    extends MyPopoutColumn<P,MyCustomer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerColumn()
    {
        super();
    }

    public MyCustomerColumn(Function<P,MyCustomer> fn)
    {
        super(fn);
    }

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        setHeader("Customer");
        setWidth(200);
    }

    //##################################################
    //# child
    //##################################################

    @Override
    protected String getTitleFor(MyCustomer e)
    {
        return e.getName();
    }

    @Override
    protected MyCustomer findChild(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    protected void ajaxViewChild(MyCustomer e)
    {
        e.ajaxEnterPage();
    }

    @Override
    protected String getPopoutUrlFor(MyCustomer e)
    {
        return e.formatEntryUrl();
    }
}
