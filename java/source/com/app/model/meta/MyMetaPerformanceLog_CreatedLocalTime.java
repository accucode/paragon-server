//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyPerformanceLog;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaTimeProperty;
import com.kodemore.time.KmTime;

public class MyMetaPerformanceLog_CreatedLocalTime
    extends KmMetaTimeProperty<MyPerformanceLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalTime";
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
    public KmTime getValueFor(MyPerformanceLog model)
    {
        return model.getCreatedLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, KmTime value)
    {
        return model.hasCreatedLocalTime(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
