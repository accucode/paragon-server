//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

import com.app.model.MyPatch;

public class MyMetaPatch_InstalledLocalTsMessage
    extends KmMetaStringProperty<MyPatch>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "installedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Installed";
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
    public String getValueFor(MyPatch model)
    {
        return model.getInstalledLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, String value)
    {
        return model.hasInstalledLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
