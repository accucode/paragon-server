package com.app.model;

import com.kodemore.types.KmMoney;
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
    //# accessing
    //##################################################

    public void setListPrice(double e)
    {
        setListPrice(new KmMoney(e));
    }

    public void publish()
    {
        if ( !isStatusDraft() )
            throw Kmu.newError("Cannot publish, not a draft.");

        if ( !hasListPrice() )
            throw Kmu.newError("Cannot publish, list price not set.");

        getMaster().publishDraft();
    }

    //##################################################
    //# attributes
    //##################################################

    public void setAttribute(MyAttributeField field, String text)
    {
        getAccess().getAttributeValueDao().setText(this, field, text);
    }

    //##################################################
    //# on change
    //##################################################

    @Override
    protected void updateProject()
    {
        if ( hasMaster() )
            setProject(getMaster().getProject());
        else
            clearProject();
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
