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

public class MyMetaShipment_Method
    extends KmMetaDaoAssociation<MyShipment,MyShipMethod>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "method";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyShipMethod getValueFor(MyShipment model)
    {
        return model.getMethod();
    }
    
    @Override
    public void setValueFor(MyShipment model, MyShipMethod value)
    {
        model.setMethod(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, MyShipMethod value)
    {
        return model.hasMethod(value);
    }
}
