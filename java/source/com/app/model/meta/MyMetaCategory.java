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

public class MyMetaCategory
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCategory instance = new MyMetaCategory();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCategory()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "category";
    }

    public static MyCategoryValidator getValidator()
    {
        return MyCategoryValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Products are organized into categories.  Categories are currently used\nfor filtering and consolidated reporting.  Typical examples include: gateways,\naccess points, switches, installations, and surveys.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaCategory_Uid Uid = new MyMetaCategory_Uid();
    public static final MyMetaCategory_Name Name = new MyMetaCategory_Name();
    public static final MyMetaCategory_LockVersion LockVersion = new MyMetaCategory_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaCategory_Project Project = new MyMetaCategory_Project();
}
