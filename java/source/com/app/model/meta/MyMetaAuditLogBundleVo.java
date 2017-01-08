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

public class MyMetaAuditLogBundleVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAuditLogBundleVo instance = new MyMetaAuditLogBundleVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAuditLogBundleVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "auditLogBundleVo";
    }

    public MyAuditLogBundleVoValidator getValidator()
    {
        return MyAuditLogBundleVoValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A summary of a bundle of changes made to a single domain model.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAuditLogBundleVo_TransactionUid TransactionUid = new MyMetaAuditLogBundleVo_TransactionUid();
    public static final MyMetaAuditLogBundleVo_UserName UserName = new MyMetaAuditLogBundleVo_UserName();
    public static final MyMetaAuditLogBundleVo_TypeCode TypeCode = new MyMetaAuditLogBundleVo_TypeCode();
    public static final MyMetaAuditLogBundleVo_LogUtcTs LogUtcTs = new MyMetaAuditLogBundleVo_LogUtcTs();
    public static final MyMetaAuditLogBundleVo_DomainType DomainType = new MyMetaAuditLogBundleVo_DomainType();
    public static final MyMetaAuditLogBundleVo_DomainName DomainName = new MyMetaAuditLogBundleVo_DomainName();
    public static final MyMetaAuditLogBundleVo_DomainUid DomainUid = new MyMetaAuditLogBundleVo_DomainUid();
    public static final MyMetaAuditLogBundleVo_DomainBundleUid DomainBundleUid = new MyMetaAuditLogBundleVo_DomainBundleUid();
    public static final MyMetaAuditLogBundleVo_DomainTypeLabel DomainTypeLabel = new MyMetaAuditLogBundleVo_DomainTypeLabel();
    public static final MyMetaAuditLogBundleVo_DisplayUserName DisplayUserName = new MyMetaAuditLogBundleVo_DisplayUserName();
    public static final MyMetaAuditLogBundleVo_DisplaySummary DisplaySummary = new MyMetaAuditLogBundleVo_DisplaySummary();
    public static final MyMetaAuditLogBundleVo_DisplayString DisplayString = new MyMetaAuditLogBundleVo_DisplayString();
    public static final MyMetaAuditLogBundleVo_TypeName TypeName = new MyMetaAuditLogBundleVo_TypeName();
    public static final MyMetaAuditLogBundleVo_LogLocalTs LogLocalTs = new MyMetaAuditLogBundleVo_LogLocalTs();
    public static final MyMetaAuditLogBundleVo_LogLocalTsMessage LogLocalTsMessage = new MyMetaAuditLogBundleVo_LogLocalTsMessage();
    public static final MyMetaAuditLogBundleVo_LogLocalDate LogLocalDate = new MyMetaAuditLogBundleVo_LogLocalDate();
    public static final MyMetaAuditLogBundleVo_LogLocalTime LogLocalTime = new MyMetaAuditLogBundleVo_LogLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAuditLogBundleVo_User User = new MyMetaAuditLogBundleVo_User();
}
