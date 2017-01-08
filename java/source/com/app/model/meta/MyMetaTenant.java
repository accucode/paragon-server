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

public class MyMetaTenant
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaTenant instance = new MyMetaTenant();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaTenant()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tenant";
    }

    public MyTenantValidator getValidator()
    {
        return MyTenantValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Each tenant identifies a segregated unit of business within the application. Each tenant has their own set of projects, customers, depots, etc. No information is shared between separate tenants.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaTenant_Uid Uid = new MyMetaTenant_Uid();
    public static final MyMetaTenant_CreatedUtcTs CreatedUtcTs = new MyMetaTenant_CreatedUtcTs();
    public static final MyMetaTenant_Name Name = new MyMetaTenant_Name();
    public static final MyMetaTenant_Hostname Hostname = new MyMetaTenant_Hostname();
    public static final MyMetaTenant_ThemeCode ThemeCode = new MyMetaTenant_ThemeCode();
    public static final MyMetaTenant_IntacctCompanyId IntacctCompanyId = new MyMetaTenant_IntacctCompanyId();
    public static final MyMetaTenant_IntacctUserId IntacctUserId = new MyMetaTenant_IntacctUserId();
    public static final MyMetaTenant_IntacctUserPassword IntacctUserPassword = new MyMetaTenant_IntacctUserPassword();
    public static final MyMetaTenant_ThemeName ThemeName = new MyMetaTenant_ThemeName();
    public static final MyMetaTenant_LockVersion LockVersion = new MyMetaTenant_LockVersion();
    public static final MyMetaTenant_DisplayString DisplayString = new MyMetaTenant_DisplayString();
    public static final MyMetaTenant_CreatedLocalTs CreatedLocalTs = new MyMetaTenant_CreatedLocalTs();
    public static final MyMetaTenant_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaTenant_CreatedLocalTsMessage();
    public static final MyMetaTenant_CreatedLocalDate CreatedLocalDate = new MyMetaTenant_CreatedLocalDate();
    public static final MyMetaTenant_CreatedLocalTime CreatedLocalTime = new MyMetaTenant_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
