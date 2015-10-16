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

public class MyMetaSalesOrder_PowerType
    extends KmMetaDaoAssociation<MySalesOrder,MyPowerType>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "powerType";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyPowerType getValueFor(MySalesOrder model)
    {
        return model.getPowerType();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, MyPowerType value)
    {
        model.setPowerType(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, MyPowerType value)
    {
        return model.hasPowerType(value);
    }
}
