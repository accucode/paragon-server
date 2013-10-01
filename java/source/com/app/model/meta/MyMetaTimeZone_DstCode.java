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
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaTimeZone_DstCode
    extends KmMetaStringProperty<MyTimeZone>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dstCode";
    }

    @Override
    public String getLabel()
    {
        return "Dst Code";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
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
    public String getValueFor(MyTimeZone model)
    {
        return model.getDstCode();
    }
    
    @Override
    public boolean hasValueFor(MyTimeZone model, String value)
    {
        return model.hasDstCode(value);
    }
    
    @Override
    public int compareValues(MyTimeZone o1, MyTimeZone o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
