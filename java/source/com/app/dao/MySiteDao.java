package com.app.dao;

import com.app.criteria.MySiteCriteria;
import com.app.dao.base.MySiteDaoBase;
import com.app.model.MyCustomer;
import com.app.model.MySite;

public class MySiteDao
    extends MySiteDaoBase
{
    //##################################################
    //# duplicate number
    //##################################################

    public MySite findNumber(MyCustomer customer, String number)
    {
        MySiteCriteria c;
        c = createCriteria();
        c.whereCustomerIs(customer);
        c.whereNumber().is(number);
        return c.findUnique();
    }

    public boolean isDuplicateNumber(MyCustomer customer, String number)
    {
        MySiteCriteria c;
        c = createCriteria();
        c.whereCustomerIs(customer);
        c.whereNumber().is(number);
        return c.exists();
    }

    public boolean isDuplicateNumber(MySite site, String number)
    {
        MySiteCriteria c;
        c = createCriteria();
        c.whereCustomerIs(site.getCustomer());
        c.whereNumber().is(number);
        c.whereUidIsNot(site);
        return c.exists();
    }

}
