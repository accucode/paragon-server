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

public class MyMetaVendor
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaVendor instance = new MyMetaVendor();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaVendor()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "vendor";
    }

    public static MyVendorValidator getValidator()
    {
        return MyVendorValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Vendors are used to help organized products and services.\nTypical examples: Acme Inc, Smith Co";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaVendor_Uid Uid = new MyMetaVendor_Uid();
    public static final MyMetaVendor_Name Name = new MyMetaVendor_Name();
    public static final MyMetaVendor_LockVersion LockVersion = new MyMetaVendor_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaVendor_Project Project = new MyMetaVendor_Project();
}
