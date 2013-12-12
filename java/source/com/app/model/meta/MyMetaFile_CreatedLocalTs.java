//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;

import com.app.model.MyFile;

public class MyMetaFile_CreatedLocalTs
    extends KmMetaTimestampProperty<MyFile>
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
    public KmTimestamp getValueFor(MyFile model)
    {
        return model.getCreatedLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyFile model, KmTimestamp value)
    {
        return model.hasCreatedLocalTs(value);
    }
    
    @Override
    public int compareValues(MyFile o1, MyFile o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
