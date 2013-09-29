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

public class MyMetaTimeZone_Code
    extends KmMetaStringProperty<MyTimeZone>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "code";
    }

    @Override
    public String getLabel()
    {
        return "Code";
    }

    @Override
    public int getColumnWidth()
    {
        return 5;
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
        return model.getCode();
    }
    
    @Override
    public boolean hasValueFor(MyTimeZone model, String value)
    {
        return model.hasCode(value);
    }
    
    @Override
    public int compareValues(MyTimeZone o1, MyTimeZone o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
