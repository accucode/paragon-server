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

public class MyMetaRegion
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaRegion instance = new MyMetaRegion();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaRegion()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "region";
    }

    public static MyRegionValidator getValidator()
    {
        return MyRegionValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Regions are typically used to define broad geographic areas; such as\nDomestic and Internation.  Once regions have been defined, they can be used\nto customize pricing, shipping, and other factors.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaRegion_Uid Uid = new MyMetaRegion_Uid();
    public static final MyMetaRegion_Name Name = new MyMetaRegion_Name();
    public static final MyMetaRegion_LockVersion LockVersion = new MyMetaRegion_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaRegion_Project Project = new MyMetaRegion_Project();
}
