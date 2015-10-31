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

public class MyMetaAttributeValue
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAttributeValue instance = new MyMetaAttributeValue();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAttributeValue()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attributeValue";
    }

    public static MyAttributeValueValidator getValidator()
    {
        return MyAttributeValueValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The field data for each custom attribute.  For example, this may store the value ('red') of the custom 'color' attribute used with products.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAttributeValue_Uid Uid = new MyMetaAttributeValue_Uid();
    public static final MyMetaAttributeValue_TextValue TextValue = new MyMetaAttributeValue_TextValue();
    public static final MyMetaAttributeValue_LockVersion LockVersion = new MyMetaAttributeValue_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAttributeValue_Field Field = new MyMetaAttributeValue_Field();
    public static final MyMetaAttributeValue_Product Product = new MyMetaAttributeValue_Product();
    public static final MyMetaAttributeValue_CustomerSite CustomerSite = new MyMetaAttributeValue_CustomerSite();
    public static final MyMetaAttributeValue_SalesOrderLine SalesOrderLine = new MyMetaAttributeValue_SalesOrderLine();
}
