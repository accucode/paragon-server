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

public class MyMetaMasterProduct
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaMasterProduct instance = new MyMetaMasterProduct();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaMasterProduct()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "masterProduct";
    }

    public static MyMasterProductValidator getValidator()
    {
        return MyMasterProductValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "We support explicit versioning of products.  The masterProduct represents all versions of particular product and is identified by a consistent part number.\n All versions of a product share the same part number.  The part number must be unique within a project and cannot be changed once the products first version has been published.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaMasterProduct_Uid Uid = new MyMetaMasterProduct_Uid();
    public static final MyMetaMasterProduct_PartNumber PartNumber = new MyMetaMasterProduct_PartNumber();
    public static final MyMetaMasterProduct_Active Active = new MyMetaMasterProduct_Active();
    public static final MyMetaMasterProduct_LockVersion LockVersion = new MyMetaMasterProduct_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaMasterProduct_Project Project = new MyMetaMasterProduct_Project();
    public static final MyMetaMasterProduct_PublishedVersion PublishedVersion = new MyMetaMasterProduct_PublishedVersion();
    public static final MyMetaMasterProduct_DraftVersion DraftVersion = new MyMetaMasterProduct_DraftVersion();
}
