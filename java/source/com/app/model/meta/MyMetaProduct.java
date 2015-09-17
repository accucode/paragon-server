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

public class MyMetaProduct
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProduct instance = new MyMetaProduct();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProduct()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "product";
    }

    public static MyProductValidator getValidator()
    {
        return MyProductValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The the project's product catalog.  Products are primarily used to define the things\nthat we sell, but are also used to coordinate inventory and technician stock (checkouts).\nProducts are managed within a project, and even if multiple projects use products with the\nsame name, the products are tracked and managed separately.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaProduct_Uid Uid = new MyMetaProduct_Uid();
    public static final MyMetaProduct_Name Name = new MyMetaProduct_Name();
    public static final MyMetaProduct_LockVersion LockVersion = new MyMetaProduct_LockVersion();
    public static final MyMetaProduct_CategoryName CategoryName = new MyMetaProduct_CategoryName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaProduct_Project Project = new MyMetaProduct_Project();
    public static final MyMetaProduct_Category Category = new MyMetaProduct_Category();
}
