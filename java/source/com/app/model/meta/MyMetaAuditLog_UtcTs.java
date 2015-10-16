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

public class MyMetaAuditLog_UtcTs
    extends KmMetaTimestampProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "utcTs";
    }

    @Override
    public String getLabel()
    {
        return "Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The time this change was made.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyAuditLogValidator.instance.getUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "utcTs";
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
    public KmTimestamp getValueFor(MyAuditLog model)
    {
        return model.getUtcTs();
    }
    
    @Override
    public void setValueFor(MyAuditLog model, KmTimestamp value)
    {
        model.setUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyAuditLog model, KmTimestamp value)
    {
        return model.hasUtcTs(value);
    }
    
}
