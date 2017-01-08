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
import com.kodemore.exception.*;
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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAuditLog_BooleanValue
    extends KmMetaBooleanProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "booleanValue";
    }

    @Override
    public String getLabel()
    {
        return "Boolean Value";
    }

    @Override
    public String getHelp()
    {
        return "The boolean value, if applicable.";
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
    public KmBooleanValidator getValidator()
    {
        return MyAuditLogValidator.instance.getBooleanValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "booleanValue";
    }

    @Override
    public MyAuditLogDao getDao()
    {
        return getAccess().getAuditLogDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyAuditLog model)
    {
        return model.getBooleanValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, Boolean value)
    {
        model.setBooleanValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, Boolean value)
    {
        return model.hasBooleanValue(value);
    }

}
