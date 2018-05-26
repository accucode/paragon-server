package com.app.model;

import com.kodemore.types.KmMoney;

import com.app.model.base.MyNamedMoneyVoBase;

public class MyNamedMoneyVo
    extends MyNamedMoneyVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyNamedMoneyVo()
    {
        super();
    }

    public MyNamedMoneyVo(String name, KmMoney value)
    {
        setName(name);
        setValue(value);
    }

    //##################################################
    //# convenience
    //##################################################

    public void addValue(MyNamedMoneyVo e)
    {
        if ( e != null )
            addValue(e.getValue());
    }

    public void addValue(KmMoney e)
    {
        if ( e == null )
            return;

        if ( hasValue() )
            setValue(getValue().add(e));
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
