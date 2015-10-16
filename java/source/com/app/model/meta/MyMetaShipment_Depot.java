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

public class MyMetaShipment_Depot
    extends KmMetaDaoAssociation<MyShipment,MyDepot>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "depot";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyDepot getValueFor(MyShipment model)
    {
        return model.getDepot();
    }
    
    @Override
    public void setValueFor(MyShipment model, MyDepot value)
    {
        model.setDepot(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, MyDepot value)
    {
        return model.hasDepot(value);
    }
}
