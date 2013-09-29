//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyEmail;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDateProperty;
import com.kodemore.time.KmDate;

public class MyMetaEmail_CreatedLocalDate
    extends KmMetaDateProperty<MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Created";
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
    public KmDate getValueFor(MyEmail model)
    {
        return model.getCreatedLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, KmDate value)
    {
        return model.hasCreatedLocalDate(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
