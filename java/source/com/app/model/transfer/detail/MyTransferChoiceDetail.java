package com.app.model.transfer.detail;

import com.app.model.MyProject;
import com.app.model.MyChoice;

public class MyTransferChoiceDetail
    extends MyTransferAbstractDetail<MyChoice>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferChoiceDetail(MyChoice source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyChoice findTargetFor(MyChoice from)
    {
        return findProjectOptionFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MyChoice transferAdd(MyChoice from)
    {
        MyProject toProject = getTargetProject();

        MyChoice to;
        to = new MyChoice();
        to.setProject(toProject);

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MyChoice from, MyChoice to)
    {
        apply(from, to);
    }

    private void apply(MyChoice from, MyChoice to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }
}
