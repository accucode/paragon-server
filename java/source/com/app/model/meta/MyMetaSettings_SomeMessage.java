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

import com.app.dao.MySettingsDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySettings;
import com.app.model.MySettingsValidator;
import com.app.utility.MyGlobals;

public class MyMetaSettings_SomeMessage
    extends KmMetaStringProperty<MySettings>
    implements KmMetaDaoPropertyIF<MySettings,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "someMessage";
    }

    @Override
    public String getLabel()
    {
        return "Some Message";
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
        return MySettingsValidator.instance.getSomeMessageValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "someMessage";
    }

    @Override
    public MySettingsDao getDao()
    {
        return getAccess().getSettingsDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MySettings model)
    {
        return model.getSomeMessage();
    }
    
    @Override
    public void setValueFor(MySettings model, String value)
    {
        model.setSomeMessage(value);
    }
    
    @Override
    public boolean hasValueFor(MySettings model, String value)
    {
        return model.hasSomeMessage(value);
    }
    
    @Override
    public int compareValues(MySettings o1, MySettings o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
