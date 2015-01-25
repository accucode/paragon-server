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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.match.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaShipMethod_Carrier
    extends KmMetaDaoAssociation<MyShipMethod,MyShipCarrier>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "carrier";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyShipCarrier getValueFor(MyShipMethod model)
    {
        return model.getCarrier();
    }
    
    @Override
    public void setValueFor(MyShipMethod model, MyShipCarrier value)
    {
        model.setCarrier(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipMethod model, MyShipCarrier value)
    {
        return model.hasCarrier(value);
    }
}
