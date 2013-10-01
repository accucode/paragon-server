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
import com.kodemore.meta.KmMetaDateProperty;
import com.kodemore.time.KmDate;

public class MyMetaPatch_InstalledLocalDate
    extends KmMetaDateProperty<MyPatch>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "installedLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Installed";
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
    public KmDate getValueFor(MyPatch model)
    {
        return model.getInstalledLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, KmDate value)
    {
        return model.hasInstalledLocalDate(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
