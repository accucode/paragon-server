package com.app.model.transfer.detail;

import com.app.model.MyVendor;

public class MyTransferVendorDetail
    extends MyTransferAbstractDetail<MyVendor>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferVendorDetail(MyVendor from)
    {
        super(from);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyVendor findTargetFor(MyVendor from)
    {
        return findVisitFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyVendor transferAdd(MyVendor from)
    {
        MyVendor to;
        to = new MyVendor();
        to.setProject(getTargetProject());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyVendor from, MyVendor to)
    {
        apply(from, to);
    }

    private void apply(MyVendor from, MyVendor to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }
}
