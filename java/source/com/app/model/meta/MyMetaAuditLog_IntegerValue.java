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

public class MyMetaAuditLog_IntegerValue
    extends KmMetaIntegerProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "integerValue";
    }

    @Override
    public String getLabel()
    {
        return "Integer Value";
    }

    @Override
    public String getHelp()
    {
        return "The integer value, if applicable.";
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
        return MyAuditLogValidator.instance.getIntegerValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "integerValue";
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
    public Integer getValueFor(MyAuditLog model)
    {
        return model.getIntegerValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, Integer value)
    {
        model.setIntegerValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, Integer value)
    {
        return model.hasIntegerValue(value);
    }

}
