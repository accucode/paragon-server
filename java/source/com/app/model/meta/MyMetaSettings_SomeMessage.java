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
    public String getHelp()
    {
        return "Just a placeholder until more useful settings are defined.";
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
