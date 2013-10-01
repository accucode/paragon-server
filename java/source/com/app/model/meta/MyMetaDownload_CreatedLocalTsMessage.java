//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyDownload;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaDownload_CreatedLocalTsMessage
    extends KmMetaStringProperty<MyDownload>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Created";
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
    public String getValueFor(MyDownload model)
    {
        return model.getCreatedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyDownload model, String value)
    {
        return model.hasCreatedLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyDownload o1, MyDownload o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
