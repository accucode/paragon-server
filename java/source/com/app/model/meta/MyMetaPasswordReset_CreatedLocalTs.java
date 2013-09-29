//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyPasswordReset;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;

public class MyMetaPasswordReset_CreatedLocalTs
    extends KmMetaTimestampProperty<MyPasswordReset>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Created";
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
    public KmTimestamp getValueFor(MyPasswordReset model)
    {
        return model.getCreatedLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
    {
        return model.hasCreatedLocalTs(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
