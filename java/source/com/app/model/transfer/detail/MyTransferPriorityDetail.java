package com.app.model.transfer.detail;

import com.app.model.MyPriority;

public class MyTransferPriorityDetail
    extends MyTransferAbstractDetail<MyPriority>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferPriorityDetail(MyPriority from)
    {
        super(from);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPriority findTargetFor(MyPriority from)
    {
        return findPriorityFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyPriority transferAdd(MyPriority from)
    {
        MyPriority to;
        to = new MyPriority();
        to.setProject(getTargetProject());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyPriority from, MyPriority to)
    {
        apply(from, to);
    }

    private void apply(MyPriority from, MyPriority to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }

}
