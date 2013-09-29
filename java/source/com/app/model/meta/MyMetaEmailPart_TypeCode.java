//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyEmailPartDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmailPart;
import com.app.model.MyEmailPartType;
import com.app.model.MyEmailPartValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.validator.KmStringValidator;

public class MyMetaEmailPart_TypeCode
    extends KmMetaStringProperty<MyEmailPart>
    implements KmMetaDaoPropertyIF<MyEmailPart,String>
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
        return "Type Code";
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
        return MyEmailPartValidator.instance.getTypeCodeValidator();
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
    public MyEmailPartDao getDao()
    {
        return getAccess().getEmailPartDao();
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
        e.addOptions(MyEmailPartType.values());
        return e;
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmailPart model)
    {
        return model.getTypeCode();
    }
    
    @Override
    public void setValueFor(MyEmailPart model, String value)
    {
        model.setTypeCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailPart model, String value)
    {
        return model.hasTypeCode(value);
    }
    
    @Override
    public int compareValues(MyEmailPart o1, MyEmailPart o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
