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

public class MyMetaSalesOrderLine_FulfilledQuantity
    extends KmMetaIntegerProperty<MySalesOrderLine>
    implements KmMetaDaoPropertyIF<MySalesOrderLine,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fulfilledQuantity";
    }

    @Override
    public String getLabel()
    {
        return "Fulfilled Quantity";
    }

    @Override
    public String getHelp()
    {
        return "The quantity ordered by the customer.";
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
        return MySalesOrderLineValidator.instance.getFulfilledQuantityValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "fulfilledQuantity";
    }

    @Override
    public MySalesOrderLineDao getDao()
    {
        return getAccess().getSalesOrderLineDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MySalesOrderLine model)
    {
        return model.getFulfilledQuantity();
    }
    
    @Override
    public void setValueFor(MySalesOrderLine model, Integer value)
    {
        model.setFulfilledQuantity(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderLine model, Integer value)
    {
        return model.hasFulfilledQuantity(value);
    }
    
}
