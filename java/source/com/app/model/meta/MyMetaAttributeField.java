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

public class MyMetaAttributeField
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAttributeField instance = new MyMetaAttributeField();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAttributeField()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attributeField";
    }

    public static MyAttributeFieldValidator getValidator()
    {
        return MyAttributeFieldValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The list of custom attribute definition for this project.  This includes definitions for multiple models.  This allows project managers to track additional attributes that were not explicitly supported in the original software.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAttributeField_Uid Uid = new MyMetaAttributeField_Uid();
    public static final MyMetaAttributeField_CategoryCode CategoryCode = new MyMetaAttributeField_CategoryCode();
    public static final MyMetaAttributeField_Name Name = new MyMetaAttributeField_Name();
    public static final MyMetaAttributeField_Active Active = new MyMetaAttributeField_Active();
    public static final MyMetaAttributeField_LockVersion LockVersion = new MyMetaAttributeField_LockVersion();
    public static final MyMetaAttributeField_CategoryName CategoryName = new MyMetaAttributeField_CategoryName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAttributeField_Project Project = new MyMetaAttributeField_Project();
}
