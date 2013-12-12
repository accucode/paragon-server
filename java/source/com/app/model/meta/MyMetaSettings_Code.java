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
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.dao.MySettingsDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySettings;
import com.app.model.MySettingsValidator;
import com.app.utility.MyGlobals;

public class MyMetaSettings_Code
    extends KmMetaIntegerProperty<MySettings>
    implements KmMetaDaoPropertyIF<MySettings,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "code";
    }

    @Override
    public String getLabel()
    {
        return "Code";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MySettingsValidator.instance.getCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "code";
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
    public Integer getValueFor(MySettings model)
    {
        return model.getCode();
    }
    
    @Override
    public void setValueFor(MySettings model, Integer value)
    {
        model.setCode(value);
    }
    
    @Override
    public boolean hasValueFor(MySettings model, Integer value)
    {
        return model.hasCode(value);
    }
    
    @Override
    public int compareValues(MySettings o1, MySettings o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
