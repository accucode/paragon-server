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
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaSalesOrderContact_SalesOrder
    extends KmMetaDaoAssociation<MySalesOrderContact,MySalesOrder>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "salesOrder";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySalesOrder getValueFor(MySalesOrderContact model)
    {
        return model.getSalesOrder();
    }
    
    @Override
    public void setValueFor(MySalesOrderContact model, MySalesOrder value)
    {
        model.setSalesOrder(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderContact model, MySalesOrder value)
    {
        return model.hasSalesOrder(value);
    }
}
