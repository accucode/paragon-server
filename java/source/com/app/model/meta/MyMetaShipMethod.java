//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.meta;

import java.util.*;

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

public class MyMetaShipMethod
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaShipMethod instance = new MyMetaShipMethod();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaShipMethod()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "shipMethod";
    }

    public static MyShipMethodValidator getValidator()
    {
        return MyShipMethodValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The list of methods for a particular carrier.  E.g.: Red Label, 2-day, ground.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaShipMethod_Uid Uid = new MyMetaShipMethod_Uid();
    public static final MyMetaShipMethod_Name Name = new MyMetaShipMethod_Name();
    public static final MyMetaShipMethod_LockVersion LockVersion = new MyMetaShipMethod_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaShipMethod_Carrier Carrier = new MyMetaShipMethod_Carrier();
}
