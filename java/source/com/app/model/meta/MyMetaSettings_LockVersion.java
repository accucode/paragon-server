//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MySettingsDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySettings;
import com.app.model.MySettingsValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

public class MyMetaSettings_LockVersion
    extends KmMetaIntegerProperty<MySettings>
    implements KmMetaDaoPropertyIF<MySettings,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lockVersion";
    }

    @Override
    public String getLabel()
    {
        return "Lock Version";
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
        return MySettingsValidator.instance.getLockVersionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lockVersion";
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
        return model.getLockVersion();
    }
    
    @Override
    public void setValueFor(MySettings model, Integer value)
    {
        model.setLockVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MySettings model, Integer value)
    {
        return model.hasLockVersion(value);
    }
    
    @Override
    public int compareValues(MySettings o1, MySettings o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
