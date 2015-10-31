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

public class MyMetaAttributeValue_CustomerSite
    extends KmMetaDaoAssociation<MyAttributeValue,MyCustomerSite>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customerSite";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyCustomerSite getValueFor(MyAttributeValue model)
    {
        return model.getCustomerSite();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, MyCustomerSite value)
    {
        model.setCustomerSite(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, MyCustomerSite value)
    {
        return model.hasCustomerSite(value);
    }
}
