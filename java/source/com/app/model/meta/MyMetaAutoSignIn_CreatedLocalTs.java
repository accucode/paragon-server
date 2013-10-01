//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAutoSignIn;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;

public class MyMetaAutoSignIn_CreatedLocalTs
    extends KmMetaTimestampProperty<MyAutoSignIn>
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
    public KmTimestamp getValueFor(MyAutoSignIn model)
    {
        return model.getCreatedLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        return model.hasCreatedLocalTs(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
