//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyFile;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaFile_StatusName
    extends KmMetaStringProperty<MyFile>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "statusName";
    }

    @Override
    public String getLabel()
    {
        return "Status";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
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
    public String getValueFor(MyFile model)
    {
        return model.getStatusName();
    }
    
    @Override
    public boolean hasValueFor(MyFile model, String value)
    {
        return model.hasStatusName(value);
    }
    
    @Override
    public int compareValues(MyFile o1, MyFile o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
