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

import com.app.model.MyAutoSignIn;

public class MyMetaAutoSignIn_CreatedLocalTsMessage
    extends KmMetaStringProperty<MyAutoSignIn>
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
    public String getValueFor(MyAutoSignIn model)
    {
        return model.getCreatedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, String value)
    {
        return model.hasCreatedLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
