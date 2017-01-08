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

    public MyEmailRecipientValidator getValidator()
    {
        return MyEmailRecipientValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I define the recipients for a given email.  The TOs, CCs, and BCCs.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailRecipient_Uid Uid = new MyMetaEmailRecipient_Uid();
    public static final MyMetaEmailRecipient_CreatedUtcTs CreatedUtcTs = new MyMetaEmailRecipient_CreatedUtcTs();
    public static final MyMetaEmailRecipient_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmailRecipient_UpdatedUtcTs();
    public static final MyMetaEmailRecipient_Address Address = new MyMetaEmailRecipient_Address();
    public static final MyMetaEmailRecipient_TypeCode TypeCode = new MyMetaEmailRecipient_TypeCode();
    public static final MyMetaEmailRecipient_LockVersion LockVersion = new MyMetaEmailRecipient_LockVersion();
    public static final MyMetaEmailRecipient_DisplayString DisplayString = new MyMetaEmailRecipient_DisplayString();
    public static final MyMetaEmailRecipient_TypeName TypeName = new MyMetaEmailRecipient_TypeName();
    public static final MyMetaEmailRecipient_CreatedLocalTs CreatedLocalTs = new MyMetaEmailRecipient_CreatedLocalTs();
    public static final MyMetaEmailRecipient_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmailRecipient_CreatedLocalTsMessage();
    public static final MyMetaEmailRecipient_CreatedLocalDate CreatedLocalDate = new MyMetaEmailRecipient_CreatedLocalDate();
    public static final MyMetaEmailRecipient_CreatedLocalTime CreatedLocalTime = new MyMetaEmailRecipient_CreatedLocalTime();
    public static final MyMetaEmailRecipient_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmailRecipient_UpdatedLocalTs();
    public static final MyMetaEmailRecipient_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmailRecipient_UpdatedLocalTsMessage();
    public static final MyMetaEmailRecipient_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmailRecipient_UpdatedLocalDate();
    public static final MyMetaEmailRecipient_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmailRecipient_UpdatedLocalTime();
    public static final MyMetaEmailRecipient_CreatedByFullName CreatedByFullName = new MyMetaEmailRecipient_CreatedByFullName();
    public static final MyMetaEmailRecipient_UpdatedByFullName UpdatedByFullName = new MyMetaEmailRecipient_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailRecipient_CreatedBy CreatedBy = new MyMetaEmailRecipient_CreatedBy();
    public static final MyMetaEmailRecipient_UpdatedBy UpdatedBy = new MyMetaEmailRecipient_UpdatedBy();
    public static final MyMetaEmailRecipient_Email Email = new MyMetaEmailRecipient_Email();
}
