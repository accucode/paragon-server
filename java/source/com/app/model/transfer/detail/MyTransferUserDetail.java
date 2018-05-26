package com.app.model.transfer.detail;

import com.app.model.MyUser;

public class MyTransferUserDetail
    extends MyTransferAbstractDetail<MyUser>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferUserDetail(MyUser from)
    {
        super(from);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUser findTargetFor(MyUser from)
    {
        return findUserFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyUser transferAdd(MyUser from)
    {
        MyUser to;
        to = new MyUser();
        to.setTenant(getTargetTenant());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyUser from, MyUser to)
    {
        apply(from, to);
    }

    private void apply(MyUser from, MyUser to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }
}
