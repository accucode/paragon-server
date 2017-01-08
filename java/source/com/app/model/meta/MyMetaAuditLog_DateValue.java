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

public class MyMetaAuditLog_DateValue
    extends KmMetaDateProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,KmDate>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dateValue";
    }

    @Override
    public String getLabel()
    {
        return "Date Value";
    }

    @Override
    public String getHelp()
    {
        return "The date value, if applicable.";
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
    public KmDateValidator getValidator()
    {
        return MyAuditLogValidator.instance.getDateValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "dateValue";
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
    public KmDate getValueFor(MyAuditLog model)
    {
        return model.getDateValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, KmDate value)
    {
        model.setDateValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, KmDate value)
    {
        return model.hasDateValue(value);
    }

}
