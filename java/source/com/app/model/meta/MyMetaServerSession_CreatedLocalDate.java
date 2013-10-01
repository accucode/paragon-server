//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyServerSession;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDateProperty;
import com.kodemore.time.KmDate;

public class MyMetaServerSession_CreatedLocalDate
    extends KmMetaDateProperty<MyServerSession>
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
    public KmDate getValueFor(MyServerSession model)
    {
        return model.getCreatedLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmDate value)
    {
        return model.hasCreatedLocalDate(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
