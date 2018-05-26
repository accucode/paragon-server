package com.app.dao;

import com.app.criteria.MyVendorCriteria;
import com.app.dao.base.MyVendorDaoBase;
import com.app.model.MyProject;
import com.app.model.MyVendor;

public class MyVendorDao
    extends MyVendorDaoBase
{
    //##################################################
    //# duplicate name
    //##################################################

    public MyVendor findName(MyProject project, String name)
    {
        MyVendorCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.findUnique();
    }

    public boolean isDuplicateName(MyProject project, String name)
    {
        MyVendorCriteria c;
        c = createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);
        return c.exists();
    }

    public boolean isDuplicateName(MyVendor vendor, String name)
    {
        MyVendorCriteria c;
        c = createCriteria();
        c.whereProjectIs(vendor.getProject());
        c.whereName().is(name);
        c.whereUidIsNot(vendor);
        return c.exists();
    }

}
