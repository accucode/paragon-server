package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyProductBase;

public class MyProduct
    extends MyProductBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyProduct()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected void updateProject()
    {
        if ( hasMaster() )
            setProject(getMaster().getProject());
        else
            clearProject();
    }

    public void publish()
    {
        if ( !isStatusDraft() )
            throw Kmu.newError("Cannot publish, not a draft.");

        getMaster().publishDraft();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return Kmu.format("%s(%s)", getPartNumber(), getStatus());
    }

}
