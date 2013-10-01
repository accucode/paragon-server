//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyEmailRecipientDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmailRecipient;
import com.app.model.MyEmailRecipientValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaEmailRecipient_Address
    extends KmMetaStringProperty<MyEmailRecipient>
    implements KmMetaDaoPropertyIF<MyEmailRecipient,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "address";
    }

    @Override
    public String getLabel()
    {
        return "Address";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyEmailRecipientValidator.instance.getAddressValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "address";
    }

    @Override
    public MyEmailRecipientDao getDao()
    {
        return getAccess().getEmailRecipientDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmailRecipient model)
    {
        return model.getAddress();
    }
    
    @Override
    public void setValueFor(MyEmailRecipient model, String value)
    {
        model.setAddress(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailRecipient model, String value)
    {
        return model.hasAddress(value);
    }
    
    @Override
    public int compareValues(MyEmailRecipient o1, MyEmailRecipient o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
