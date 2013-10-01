//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyPatch;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;

public class MyMetaPatch_InstalledLocalTs
    extends KmMetaTimestampProperty<MyPatch>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "installedLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Installed";
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
    public KmTimestamp getValueFor(MyPatch model)
    {
        return model.getInstalledLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, KmTimestamp value)
    {
        return model.hasInstalledLocalTs(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
