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

public class MyMetaCustomer_Tier
    extends KmMetaDaoAssociation<MyCustomer,MyCustomerTier>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tier";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyCustomerTier getValueFor(MyCustomer model)
    {
        return model.getTier();
    }
    
    @Override
    public void setValueFor(MyCustomer model, MyCustomerTier value)
    {
        model.setTier(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomer model, MyCustomerTier value)
    {
        return model.hasTier(value);
    }
}
