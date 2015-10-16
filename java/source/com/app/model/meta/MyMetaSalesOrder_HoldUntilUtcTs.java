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

public class MyMetaSalesOrder_HoldUntilUtcTs
    extends KmMetaTimestampProperty<MySalesOrder>
    implements KmMetaDaoPropertyIF<MySalesOrder,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "holdUntilUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Hold Until Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "Indicates the order is on hold, and that the on-hold status should be automatically removed at a particular date and time.";
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
        return MySalesOrderValidator.instance.getHoldUntilUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "holdUntilUtcTs";
    }

    @Override
    public MySalesOrderDao getDao()
    {
        return getAccess().getSalesOrderDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MySalesOrder model)
    {
        return model.getHoldUntilUtcTs();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, KmTimestamp value)
    {
        model.setHoldUntilUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, KmTimestamp value)
    {
        return model.hasHoldUntilUtcTs(value);
    }
    
}
