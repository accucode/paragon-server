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

public class MyMetaEmail
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmail instance = new MyMetaEmail();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmail()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "email";
    }

    public static MyEmailValidator getValidator()
    {
        return MyEmailValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaEmail_Uid Uid = new MyMetaEmail_Uid();
    public static final MyMetaEmail_CreatedUtcTs CreatedUtcTs = new MyMetaEmail_CreatedUtcTs();
    public static final MyMetaEmail_SentUtcTs SentUtcTs = new MyMetaEmail_SentUtcTs();
    public static final MyMetaEmail_Subject Subject = new MyMetaEmail_Subject();
    public static final MyMetaEmail_FromAddress FromAddress = new MyMetaEmail_FromAddress();
    public static final MyMetaEmail_StatusCode StatusCode = new MyMetaEmail_StatusCode();
    public static final MyMetaEmail_ErrorNotes ErrorNotes = new MyMetaEmail_ErrorNotes();
    public static final MyMetaEmail_RecipientSummary RecipientSummary = new MyMetaEmail_RecipientSummary();
    public static final MyMetaEmail_ToAddressesLabel ToAddressesLabel = new MyMetaEmail_ToAddressesLabel();
    public static final MyMetaEmail_CcAddressesLabel CcAddressesLabel = new MyMetaEmail_CcAddressesLabel();
    public static final MyMetaEmail_LockVersion LockVersion = new MyMetaEmail_LockVersion();
    public static final MyMetaEmail_StatusName StatusName = new MyMetaEmail_StatusName();
    public static final MyMetaEmail_CreatedLocalTs CreatedLocalTs = new MyMetaEmail_CreatedLocalTs();
    public static final MyMetaEmail_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmail_CreatedLocalTsMessage();
    public static final MyMetaEmail_CreatedLocalDate CreatedLocalDate = new MyMetaEmail_CreatedLocalDate();
    public static final MyMetaEmail_CreatedLocalTime CreatedLocalTime = new MyMetaEmail_CreatedLocalTime();
    public static final MyMetaEmail_SentLocalTs SentLocalTs = new MyMetaEmail_SentLocalTs();
    public static final MyMetaEmail_SentLocalTsMessage SentLocalTsMessage = new MyMetaEmail_SentLocalTsMessage();
    public static final MyMetaEmail_SentLocalDate SentLocalDate = new MyMetaEmail_SentLocalDate();
    public static final MyMetaEmail_SentLocalTime SentLocalTime = new MyMetaEmail_SentLocalTime();

    //##################################################
    //# associations
    //##################################################

}
