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

public class MyMetaCustomerSite_Customer
    extends KmMetaDaoAssociation<MyCustomerSite,MyCustomer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customer";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyCustomer getValueFor(MyCustomerSite model)
    {
        return model.getCustomer();
    }
    
    @Override
    public void setValueFor(MyCustomerSite model, MyCustomer value)
    {
        model.setCustomer(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomerSite model, MyCustomer value)
    {
        return model.hasCustomer(value);
    }
}
