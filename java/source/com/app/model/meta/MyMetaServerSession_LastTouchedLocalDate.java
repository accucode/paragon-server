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

public class MyMetaServerSession_LastTouchedLocalDate
    extends KmMetaDateProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Lasttouched";
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
        return model.getLastTouchedLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmDate value)
    {
        return model.hasLastTouchedLocalDate(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
