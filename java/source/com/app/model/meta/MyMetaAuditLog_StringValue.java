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
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAuditLog_StringValue
    extends KmMetaStringProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "stringValue";
    }

    @Override
    public String getLabel()
    {
        return "String Value";
    }

    @Override
    public String getHelp()
    {
        return "The truncated string value, if applicable.";
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
        return MyAuditLogValidator.instance.getStringValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "stringValue";
    }

    @Override
    public MyAuditLogDao getDao()
    {
        return getAccess().getAuditLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLog model)
    {
        return model.getStringValue();
    }
    
    @Override
    public void setValueFor(MyAuditLog model, String value)
    {
        model.setStringValue(value);
    }
    
    @Override
    public boolean hasValueFor(MyAuditLog model, String value)
    {
        return model.hasStringValue(value);
    }
    
}
