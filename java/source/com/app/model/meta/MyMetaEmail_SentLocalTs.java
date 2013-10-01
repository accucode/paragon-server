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
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;

public class MyMetaEmail_SentLocalTs
    extends KmMetaTimestampProperty<MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sentLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Sent";
    }

    @Override
    public int getColumnWidth()
    {
        return 16;
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
    public KmTimestamp getValueFor(MyEmail model)
    {
        return model.getSentLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, KmTimestamp value)
    {
        return model.hasSentLocalTs(value);
    }
    
    @Override
    public int compareValues(MyEmail o1, MyEmail o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
