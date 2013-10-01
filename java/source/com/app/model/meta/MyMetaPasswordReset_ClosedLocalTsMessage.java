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
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaPasswordReset_ClosedLocalTsMessage
    extends KmMetaStringProperty<MyPasswordReset>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Closed";
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
    public String getValueFor(MyPasswordReset model)
    {
        return model.getClosedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, String value)
    {
        return model.hasClosedLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
