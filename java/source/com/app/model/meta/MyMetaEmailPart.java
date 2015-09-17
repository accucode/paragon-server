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

    public static MyEmailPartValidator getValidator()
    {
        return MyEmailPartValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Each email is composed of at least one part, the body.  In some cases the body may\nbe composed of multiple parts.  For example, to supply both plaintext and html versions\nof the body; or to provide attachments.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmailPart_Uid Uid = new MyMetaEmailPart_Uid();
    public static final MyMetaEmailPart_Sequence Sequence = new MyMetaEmailPart_Sequence();
    public static final MyMetaEmailPart_TypeCode TypeCode = new MyMetaEmailPart_TypeCode();
    public static final MyMetaEmailPart_AttachmentName AttachmentName = new MyMetaEmailPart_AttachmentName();
    public static final MyMetaEmailPart_Data Data = new MyMetaEmailPart_Data();
    public static final MyMetaEmailPart_LockVersion LockVersion = new MyMetaEmailPart_LockVersion();
    public static final MyMetaEmailPart_TypeName TypeName = new MyMetaEmailPart_TypeName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaEmailPart_Email Email = new MyMetaEmailPart_Email();
}
