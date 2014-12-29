//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

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
    public String getHelp()
    {
        return "The unique key.  I am generally hardcoded to 1.";
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
