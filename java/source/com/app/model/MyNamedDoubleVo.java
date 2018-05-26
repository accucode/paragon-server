package com.app.model;

import com.app.model.base.MyNamedDoubleVoBase;

public class MyNamedDoubleVo
    extends MyNamedDoubleVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyNamedDoubleVo()
    {
        super();
    }

    public MyNamedDoubleVo(String name, Double value)
    {
        setName(name);
        setValue(value);
    }

    //##################################################
    //# convenience
    //##################################################

    public void addValue(MyNamedDoubleVo e)
    {
        if ( e != null )
            addValue(e.getValue());
    }

    public void addValue(Double e)
    {
        if ( e == null )
            return;

        if ( hasValue() )
            setValue(getValue() + e);
        else
            setValue(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return formatNamedValue();
    }

    @Override
    public String getAuditLogTitle()
    {
        return formatNamedValue();
    }

    @Override
    public String getDomainTitle()
    {
        return formatNamedValue();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

    //==================================================
    //= private
    //==================================================

    private String formatNamedValue()
    {
        return getName() + " => " + getValue();
    }

}
