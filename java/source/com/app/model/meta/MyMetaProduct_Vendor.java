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

public class MyMetaProduct_Vendor
    extends KmMetaDaoAssociation<MyProduct,MyVendor>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "vendor";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyVendor getValueFor(MyProduct model)
    {
        return model.getVendor();
    }
    
    @Override
    public void setValueFor(MyProduct model, MyVendor value)
    {
        model.setVendor(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, MyVendor value)
    {
        return model.hasVendor(value);
    }
}
