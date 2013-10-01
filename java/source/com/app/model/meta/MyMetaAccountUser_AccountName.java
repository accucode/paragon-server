//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyAccountUser;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;

public class MyMetaAccountUser_AccountName
    extends KmMetaStringProperty<MyAccountUser>
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
    public String getValueFor(MyAccountUser model)
    {
        return model.getAccountName();
    }
    
    @Override
    public void setValueFor(MyAccountUser model, String value)
    {
        model.setAccountName(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccountUser model, String value)
    {
        return model.hasAccountName(value);
    }
    
    @Override
    public int compareValues(MyAccountUser o1, MyAccountUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
