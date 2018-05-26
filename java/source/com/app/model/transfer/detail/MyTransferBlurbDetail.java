package com.app.model.transfer.detail;

import com.app.model.MyBlurb;

public class MyTransferBlurbDetail
    extends MyTransferAbstractDetail<MyBlurb>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferBlurbDetail(MyBlurb source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyBlurb findTargetFor(MyBlurb from)
    {
        return findBlurbFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyBlurb transferAdd(MyBlurb from)
    {
        MyBlurb to;
        to = new MyBlurb();
        to.setProject(getTargetProject());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyBlurb from, MyBlurb to)
    {
        apply(from, to);
    }

    private void apply(MyBlurb from, MyBlurb to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }
}
