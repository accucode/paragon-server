//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyInvitation;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaInvitation_AccountName
    extends KmMetaStringProperty<MyInvitation>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "accountName";
    }

    @Override
    public String getLabel()
    {
        return "Account Name";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyInvitation model)
    {
        return model.getAccountName();
    }
    
    @Override
    public void setValueFor(MyInvitation model, String value)
    {
        model.setAccountName(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, String value)
    {
        return model.hasAccountName(value);
    }
    
    @Override
    public int compareValues(MyInvitation o1, MyInvitation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
