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

public class MyMetaSalesOrderLine_Product
    extends KmMetaDaoAssociation<MySalesOrderLine,MyProduct>
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
    public MyProduct getValueFor(MySalesOrderLine model)
    {
        return model.getProduct();
    }
    
    @Override
    public void setValueFor(MySalesOrderLine model, MyProduct value)
    {
        model.setProduct(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderLine model, MyProduct value)
    {
        return model.hasProduct(value);
    }
}
