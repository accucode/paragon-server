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

public class MyMetaEmailRecipient
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailRecipient instance = new MyMetaEmailRecipient();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailRecipient()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailRecipient";
    }

    public static MyEmailRecipientValidator getValidator()
    {
        return MyEmailRecipientValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "I define the recipients for a given email.  The TOs, CCs, and BCCs.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailRecipient_Uid Uid = new MyMetaEmailRecipient_Uid();
    public static final MyMetaEmailRecipient_Address Address = new MyMetaEmailRecipient_Address();
    public static final MyMetaEmailRecipient_TypeCode TypeCode = new MyMetaEmailRecipient_TypeCode();
    public static final MyMetaEmailRecipient_LockVersion LockVersion = new MyMetaEmailRecipient_LockVersion();
    public static final MyMetaEmailRecipient_TypeName TypeName = new MyMetaEmailRecipient_TypeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailRecipient_Email Email = new MyMetaEmailRecipient_Email();
}
