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

public class MyMetaAuditLog_TypeCode
    extends KmMetaStringProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "typeCode";
    }

    @Override
    public String getLabel()
    {
        return "Type Code";
    }

    @Override
    public String getHelp()
    {
        return "The type of change.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 3;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyAuditLogValidator.instance.getTypeCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "typeCode";
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
    //# enum
    //##################################################

    public ScDropdown newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdown newDropdown(String label)
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(getAdaptor());
        e.addOptions(MyAuditLogType.values());
        return e;
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLog model)
    {
        return model.getTypeCode();
    }
    
    @Override
    public void setValueFor(MyAuditLog model, String value)
    {
        model.setTypeCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyAuditLog model, String value)
    {
        return model.hasTypeCode(value);
    }
    
}
