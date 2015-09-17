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

public class MyMetaVisitType
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaVisitType instance = new MyMetaVisitType();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaVisitType()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "visitType";
    }

    public static MyVisitTypeValidator getValidator()
    {
        return MyVisitTypeValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Visit types are configured to identify the types of visits we make to\ncustomer sites. Typical examples include: Installation, Survey, and\nTroubleshooting.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaVisitType_Uid Uid = new MyMetaVisitType_Uid();
    public static final MyMetaVisitType_Name Name = new MyMetaVisitType_Name();
    public static final MyMetaVisitType_LockVersion LockVersion = new MyMetaVisitType_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaVisitType_Project Project = new MyMetaVisitType_Project();
}
