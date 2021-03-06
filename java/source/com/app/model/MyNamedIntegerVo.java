package com.app.model;

import com.app.model.base.MyNamedIntegerVoBase;

public class MyNamedIntegerVo
    extends MyNamedIntegerVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyNamedIntegerVo()
    {
        super();
    }

    public MyNamedIntegerVo(String name, Integer count)
    {
        setName(name);
        setValue(count);
    }

    //##################################################
    //# convenience
    //##################################################

    public void addValue(MyNamedIntegerVo e)
    {
        if ( e != null )
            addValue(e.getValue());
    }

    public void addValue(Integer e)
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
        return getName() + " " + getValue();
    }

}
