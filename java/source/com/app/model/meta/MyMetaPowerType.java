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

public class MyMetaPowerType
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPowerType instance = new MyMetaPowerType();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPowerType()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "powerType";
    }

    public static MyPowerTypeValidator getValidator()
    {
        return MyPowerTypeValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Power types are used help coordinate hardware adapters, primarily for international orders. For example, a typical switch may be designed to work with typical U.S. power 120V-60Hz, but when we sell it overseas we may need to include an adapter for 220V-50Hz.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPowerType_Uid Uid = new MyMetaPowerType_Uid();
    public static final MyMetaPowerType_Name Name = new MyMetaPowerType_Name();
    public static final MyMetaPowerType_LockVersion LockVersion = new MyMetaPowerType_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaPowerType_Project Project = new MyMetaPowerType_Project();
}
