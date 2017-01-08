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

public class MyMetaEmailPart
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailPart instance = new MyMetaEmailPart();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailPart()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailPart";
    }

    public MyEmailPartValidator getValidator()
    {
        return MyEmailPartValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Each email is composed of at least one part, the body.  In some cases the body may be composed of multiple parts.  For example, to supply both plaintext and html versions of the body; or to provide attachments.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailPart_Uid Uid = new MyMetaEmailPart_Uid();
    public static final MyMetaEmailPart_CreatedUtcTs CreatedUtcTs = new MyMetaEmailPart_CreatedUtcTs();
    public static final MyMetaEmailPart_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmailPart_UpdatedUtcTs();
    public static final MyMetaEmailPart_Sequence Sequence = new MyMetaEmailPart_Sequence();
    public static final MyMetaEmailPart_TypeCode TypeCode = new MyMetaEmailPart_TypeCode();
    public static final MyMetaEmailPart_AttachmentName AttachmentName = new MyMetaEmailPart_AttachmentName();
    public static final MyMetaEmailPart_Data Data = new MyMetaEmailPart_Data();
    public static final MyMetaEmailPart_LockVersion LockVersion = new MyMetaEmailPart_LockVersion();
    public static final MyMetaEmailPart_DisplayString DisplayString = new MyMetaEmailPart_DisplayString();
    public static final MyMetaEmailPart_TypeName TypeName = new MyMetaEmailPart_TypeName();
    public static final MyMetaEmailPart_CreatedLocalTs CreatedLocalTs = new MyMetaEmailPart_CreatedLocalTs();
    public static final MyMetaEmailPart_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmailPart_CreatedLocalTsMessage();
    public static final MyMetaEmailPart_CreatedLocalDate CreatedLocalDate = new MyMetaEmailPart_CreatedLocalDate();
    public static final MyMetaEmailPart_CreatedLocalTime CreatedLocalTime = new MyMetaEmailPart_CreatedLocalTime();
    public static final MyMetaEmailPart_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmailPart_UpdatedLocalTs();
    public static final MyMetaEmailPart_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmailPart_UpdatedLocalTsMessage();
    public static final MyMetaEmailPart_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmailPart_UpdatedLocalDate();
    public static final MyMetaEmailPart_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmailPart_UpdatedLocalTime();
    public static final MyMetaEmailPart_CreatedByFullName CreatedByFullName = new MyMetaEmailPart_CreatedByFullName();
    public static final MyMetaEmailPart_UpdatedByFullName UpdatedByFullName = new MyMetaEmailPart_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailPart_CreatedBy CreatedBy = new MyMetaEmailPart_CreatedBy();
    public static final MyMetaEmailPart_UpdatedBy UpdatedBy = new MyMetaEmailPart_UpdatedBy();
    public static final MyMetaEmailPart_Email Email = new MyMetaEmailPart_Email();
}
