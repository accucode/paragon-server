package com.app.dao;

import com.app.criteria.MyCustomerCriteria;
import com.app.dao.base.MyCustomerDaoBase;
import com.app.model.MyCustomer;
import com.app.model.MyProject;

public class MyCustomerDao
    extends MyCustomerDaoBase
{
    //##################################################
    //# duplicate name
    //##################################################

    public MyCustomer findName(MyProject project, String name)
    {
        MyCustomerCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.findUnique();
    }

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyCustomerCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyCustomer customer, String name)
    {
        MyCustomerCriteria c;
        c = createCriteria();
        c.whereProjectIs(customer.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(customer);
        return c.exists();
    }

}
