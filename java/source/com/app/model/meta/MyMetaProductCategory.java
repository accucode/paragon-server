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

public class MyMetaProductCategory
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProductCategory instance = new MyMetaProductCategory();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProductCategory()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "productCategory";
    }

    public static MyProductCategoryValidator getValidator()
    {
        return MyProductCategoryValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Products are organized into categories.  Categories are currently used for filtering and consolidated reporting.  Typical examples include: gateways, access points, switches, installations, and surveys.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaProductCategory_Uid Uid = new MyMetaProductCategory_Uid();
    public static final MyMetaProductCategory_Name Name = new MyMetaProductCategory_Name();
    public static final MyMetaProductCategory_LockVersion LockVersion = new MyMetaProductCategory_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaProductCategory_Project Project = new MyMetaProductCategory_Project();
}
