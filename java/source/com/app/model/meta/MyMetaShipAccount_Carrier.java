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

public class MyMetaShipAccount_Carrier
    extends KmMetaDaoAssociation<MyShipAccount,MyShipCarrier>
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
    public MyShipCarrier getValueFor(MyShipAccount model)
    {
        return model.getCarrier();
    }
    
    @Override
    public void setValueFor(MyShipAccount model, MyShipCarrier value)
    {
        model.setCarrier(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, MyShipCarrier value)
    {
        return model.hasCarrier(value);
    }
}
