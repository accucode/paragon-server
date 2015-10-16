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

public class MyMetaOrderNumber_NextNumber
    extends KmMetaIntegerProperty<MyOrderNumber>
    implements KmMetaDaoPropertyIF<MyOrderNumber,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "nextNumber";
    }

    @Override
    public String getLabel()
    {
        return "Next Number";
    }

    @Override
    public String getHelp()
    {
        return "The next number to be assigned.  This is a number that has NOT yet been used.  Clients will usually increment this value by one each time an order number is needed.  However, if a client needs a batch of multiple orders numbers this value may be incremented by some larger unit (e.g.: 10).";
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
        return MyOrderNumberValidator.instance.getNextNumberValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "nextNumber";
    }

    @Override
    public MyOrderNumberDao getDao()
    {
        return getAccess().getOrderNumberDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyOrderNumber model)
    {
        return model.getNextNumber();
    }
    
    @Override
    public void setValueFor(MyOrderNumber model, Integer value)
    {
        model.setNextNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MyOrderNumber model, Integer value)
    {
        return model.hasNextNumber(value);
    }
    
}
