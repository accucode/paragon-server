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
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaServerSession_LastTouchedLocalTsMessage
    extends KmMetaStringProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Lasttouched";
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
    public String getValueFor(MyServerSession model)
    {
        return model.getLastTouchedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, String value)
    {
        return model.hasLastTouchedLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
