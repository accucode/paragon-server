//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

import com.app.dao.MyAccountDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountValidator;
import com.app.utility.MyGlobals;

public class MyMetaAccount_Uid
    extends KmMetaStringProperty<MyAccount>
    implements KmMetaDaoPropertyIF<MyAccount,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "uid";
    }

    @Override
    public String getLabel()
    {
        return "Uid";
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
        return MyAccountValidator.instance.getUidValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "uid";
    }

    @Override
    public MyAccountDao getDao()
    {
        return getAccess().getAccountDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAccount model)
    {
        return model.getUid();
    }
    
    @Override
    public void setValueFor(MyAccount model, String value)
    {
        model.setUid(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccount model, String value)
    {
        return model.hasUid(value);
    }
    
    @Override
    public int compareValues(MyAccount o1, MyAccount o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
