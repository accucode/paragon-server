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

public class MyMetaSalesOrder_Region
    extends KmMetaDaoAssociation<MySalesOrder,MyRegion>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "region";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyRegion getValueFor(MySalesOrder model)
    {
        return model.getRegion();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, MyRegion value)
    {
        model.setRegion(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, MyRegion value)
    {
        return model.hasRegion(value);
    }
}
