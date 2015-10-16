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

public class MyMetaAttributeValue_Product
    extends KmMetaDaoAssociation<MyAttributeValue,MyProduct>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "product";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProduct getValueFor(MyAttributeValue model)
    {
        return model.getProduct();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, MyProduct value)
    {
        model.setProduct(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, MyProduct value)
    {
        return model.hasProduct(value);
    }
}
