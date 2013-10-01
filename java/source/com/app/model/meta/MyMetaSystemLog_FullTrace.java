//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MySystemLog;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaSystemLog_FullTrace
    extends KmMetaStringProperty<MySystemLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fullTrace";
    }

    @Override
    public String getLabel()
    {
        return "Trace";
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
    public String getValueFor(MySystemLog model)
    {
        return model.getFullTrace();
    }
    
    @Override
    public boolean hasValueFor(MySystemLog model, String value)
    {
        return model.hasFullTrace(value);
    }
    
    @Override
    public int compareValues(MySystemLog o1, MySystemLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
