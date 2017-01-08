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

public class MyMetaAuditLog_DoubleValue
    extends KmMetaDoubleProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,Double>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "doubleValue";
    }

    @Override
    public String getLabel()
    {
        return "Double Value";
    }

    @Override
    public String getHelp()
    {
        return "The double value, if applicable.";
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
    public KmDoubleValidator getValidator()
    {
        return MyAuditLogValidator.instance.getDoubleValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "doubleValue";
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
    public Double getValueFor(MyAuditLog model)
    {
        return model.getDoubleValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, Double value)
    {
        model.setDoubleValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, Double value)
    {
        return model.hasDoubleValue(value);
    }

}
