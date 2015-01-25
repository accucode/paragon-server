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

public class MyMetaShipCarrier
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaShipCarrier instance = new MyMetaShipCarrier();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaShipCarrier()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "shipCarrier";
    }

    public static MyShipCarrierValidator getValidator()
    {
        return MyShipCarrierValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The list of ship carriers for a particular project.  E.g.: FedEx, UPS, DHL, etc.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaShipCarrier_Uid Uid = new MyMetaShipCarrier_Uid();
    public static final MyMetaShipCarrier_Name Name = new MyMetaShipCarrier_Name();
    public static final MyMetaShipCarrier_MethodNames MethodNames = new MyMetaShipCarrier_MethodNames();
    public static final MyMetaShipCarrier_LockVersion LockVersion = new MyMetaShipCarrier_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaShipCarrier_Project Project = new MyMetaShipCarrier_Project();
}
