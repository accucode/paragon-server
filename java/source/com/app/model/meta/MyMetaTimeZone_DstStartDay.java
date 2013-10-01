//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyTimeZone;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaIntegerProperty;

public class MyMetaTimeZone_DstStartDay
    extends KmMetaIntegerProperty<MyTimeZone>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dstStartDay";
    }

    @Override
    public String getLabel()
    {
        return "Dst Start Day";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyTimeZone model)
    {
        return model.getDstStartDay();
    }
    
    @Override
    public boolean hasValueFor(MyTimeZone model, Integer value)
    {
        return model.hasDstStartDay(value);
    }
    
    @Override
    public int compareValues(MyTimeZone o1, MyTimeZone o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
