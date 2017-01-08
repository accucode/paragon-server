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

public class MyMetaAuditLog
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAuditLog instance = new MyMetaAuditLog();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAuditLog()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "auditLog";
    }

    public MyAuditLogValidator getValidator()
    {
        return MyAuditLogValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I maintain a log of changes made to the domain.  Each record identify a single attribute that has been modified on a given model.  For example, a single record may record that the user John Doe changed the Widget's price to $13.00 on Jan 1, 2015.\n This is intended to be a historical archive that can be easily exported to a third-party reporting.  All records must be immutable; records can be added, but not modified.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAuditLog_Uid Uid = new MyMetaAuditLog_Uid();
    public static final MyMetaAuditLog_CreatedUtcTs CreatedUtcTs = new MyMetaAuditLog_CreatedUtcTs();
    public static final MyMetaAuditLog_TransactionUid TransactionUid = new MyMetaAuditLog_TransactionUid();
    public static final MyMetaAuditLog_UserName UserName = new MyMetaAuditLog_UserName();
    public static final MyMetaAuditLog_TypeCode TypeCode = new MyMetaAuditLog_TypeCode();
    public static final MyMetaAuditLog_DomainType DomainType = new MyMetaAuditLog_DomainType();
    public static final MyMetaAuditLog_DomainName DomainName = new MyMetaAuditLog_DomainName();
    public static final MyMetaAuditLog_DomainUid DomainUid = new MyMetaAuditLog_DomainUid();
    public static final MyMetaAuditLog_DomainBundleUid DomainBundleUid = new MyMetaAuditLog_DomainBundleUid();
    public static final MyMetaAuditLog_FieldName FieldName = new MyMetaAuditLog_FieldName();
    public static final MyMetaAuditLog_NewValue NewValue = new MyMetaAuditLog_NewValue();
    public static final MyMetaAuditLog_OldValue OldValue = new MyMetaAuditLog_OldValue();
    public static final MyMetaAuditLog_StringValue StringValue = new MyMetaAuditLog_StringValue();
    public static final MyMetaAuditLog_IntegerValue IntegerValue = new MyMetaAuditLog_IntegerValue();
    public static final MyMetaAuditLog_LongValue LongValue = new MyMetaAuditLog_LongValue();
    public static final MyMetaAuditLog_DoubleValue DoubleValue = new MyMetaAuditLog_DoubleValue();
    public static final MyMetaAuditLog_MoneyValue MoneyValue = new MyMetaAuditLog_MoneyValue();
    public static final MyMetaAuditLog_BooleanValue BooleanValue = new MyMetaAuditLog_BooleanValue();
    public static final MyMetaAuditLog_DateValue DateValue = new MyMetaAuditLog_DateValue();
    public static final MyMetaAuditLog_TimestampValue TimestampValue = new MyMetaAuditLog_TimestampValue();
    public static final MyMetaAuditLog_UidValue UidValue = new MyMetaAuditLog_UidValue();
    public static final MyMetaAuditLog_DomainTypeLabel DomainTypeLabel = new MyMetaAuditLog_DomainTypeLabel();
    public static final MyMetaAuditLog_FieldNameLabel FieldNameLabel = new MyMetaAuditLog_FieldNameLabel();
    public static final MyMetaAuditLog_DisplayString DisplayString = new MyMetaAuditLog_DisplayString();
    public static final MyMetaAuditLog_TypeName TypeName = new MyMetaAuditLog_TypeName();
    public static final MyMetaAuditLog_CreatedLocalTs CreatedLocalTs = new MyMetaAuditLog_CreatedLocalTs();
    public static final MyMetaAuditLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAuditLog_CreatedLocalTsMessage();
    public static final MyMetaAuditLog_CreatedLocalDate CreatedLocalDate = new MyMetaAuditLog_CreatedLocalDate();
    public static final MyMetaAuditLog_CreatedLocalTime CreatedLocalTime = new MyMetaAuditLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAuditLog_User User = new MyMetaAuditLog_User();
}
