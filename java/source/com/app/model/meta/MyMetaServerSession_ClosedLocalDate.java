//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDateProperty;
import com.kodemore.time.KmDate;

import com.app.model.MyServerSession;

public class MyMetaServerSession_ClosedLocalDate
    extends KmMetaDateProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Closed";
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
        return model.getClosedLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmDate value)
    {
        return model.hasClosedLocalDate(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
