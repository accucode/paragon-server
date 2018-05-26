package com.app.model.transfer.detail;

import com.app.model.MyEmailTemplate;

public class MyTransferEmailTemplateDetail
    extends MyTransferAbstractDetail<MyEmailTemplate>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferEmailTemplateDetail(MyEmailTemplate source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailTemplate findTargetFor(MyEmailTemplate from)
    {
        return findEmailTemplateFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyEmailTemplate transferAdd(MyEmailTemplate from)
    {
        MyEmailTemplate to;
        to = new MyEmailTemplate();
        to.setProject(getTargetProject());

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyEmailTemplate from, MyEmailTemplate to)
    {
        apply(from, to);
    }

    private void apply(MyEmailTemplate from, MyEmailTemplate to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }
}
