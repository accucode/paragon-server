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
import com.kodemore.meta.KmMetaTimeProperty;
import com.kodemore.time.KmTime;

public class MyMetaServerSession_LastTouchedLocalTime
    extends KmMetaTimeProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalTime";
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
    public KmTime getValueFor(MyServerSession model)
    {
        return model.getLastTouchedLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmTime value)
    {
        return model.hasLastTouchedLocalTime(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
