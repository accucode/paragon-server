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
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.validator.KmStringValidator;

import com.app.dao.MyAccountDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;
import com.app.model.MyAccountValidator;
import com.app.utility.MyGlobals;

public class MyMetaAccount_TypeCode
    extends KmMetaStringProperty<MyAccount>
    implements KmMetaDaoPropertyIF<MyAccount,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "typeCode";
    }

    @Override
    public String getLabel()
    {
        return "Type";
    }

    @Override
    public int getColumnWidth()
    {
        return 3;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyAccountValidator.instance.getTypeCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "typeCode";
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
    //# enum
    //##################################################

    public ScDropdown newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdown newDropdown(String label)
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel(label);
        e.setValidator(getValidator());
        e.setValue(getAdaptor());
        e.addOptions(MyAccountType.values());
        return e;
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAccount model)
    {
        return model.getTypeCode();
    }
    
    @Override
    public void setValueFor(MyAccount model, String value)
    {
        model.setTypeCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccount model, String value)
    {
        return model.hasTypeCode(value);
    }
    
    @Override
    public int compareValues(MyAccount o1, MyAccount o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
