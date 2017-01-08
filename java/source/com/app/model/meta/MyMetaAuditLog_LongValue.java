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

public class MyMetaAuditLog_LongValue
    extends KmMetaLongProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,Long>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "longValue";
    }

    @Override
    public String getLabel()
    {
        return "Long Value";
    }

    @Override
    public String getHelp()
    {
        return "The long value, if applicable.";
    }

    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmLongValidator getValidator()
    {
        return MyAuditLogValidator.instance.getLongValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "longValue";
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
    public Long getValueFor(MyAuditLog model)
    {
        return model.getLongValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, Long value)
    {
        model.setLongValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, Long value)
    {
        return model.hasLongValue(value);
    }

}
