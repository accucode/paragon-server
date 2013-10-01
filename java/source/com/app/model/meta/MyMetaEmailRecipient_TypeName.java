//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyEmailRecipient;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaEmailRecipient_TypeName
    extends KmMetaStringProperty<MyEmailRecipient>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "typeName";
    }

    @Override
    public String getLabel()
    {
        return "Type";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
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
    public String getValueFor(MyEmailRecipient model)
    {
        return model.getTypeName();
    }
    
    @Override
    public boolean hasValueFor(MyEmailRecipient model, String value)
    {
        return model.hasTypeName(value);
    }
    
    @Override
    public int compareValues(MyEmailRecipient o1, MyEmailRecipient o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
