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
import com.kodemore.meta.KmMetaTimeProperty;
import com.kodemore.time.KmTime;

public class MyMetaEmail_SentLocalTime
    extends KmMetaTimeProperty<MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sentLocalTime";
    }

    @Override
    public String getLabel()
    {
        return "Sent";
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
    public KmTime getValueFor(MyEmail model)
    {
        return model.getSentLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, KmTime value)
    {
        return model.hasSentLocalTime(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
