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

public class MyMetaProject
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProject instance = new MyMetaProject();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProject()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "project";
    }

    public MyProjectValidator getValidator()
    {
        return MyProjectValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Almost everything is managed within the context of a project. For example: the depots, product catalogs, and orders are all managed by project.  Although two projects may define depots with the same name, each project will actually have their own separate depot.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaProject_Uid Uid = new MyMetaProject_Uid();
    public static final MyMetaProject_CreatedUtcTs CreatedUtcTs = new MyMetaProject_CreatedUtcTs();
    public static final MyMetaProject_UpdatedUtcTs UpdatedUtcTs = new MyMetaProject_UpdatedUtcTs();
    public static final MyMetaProject_Name Name = new MyMetaProject_Name();
    public static final MyMetaProject_Code Code = new MyMetaProject_Code();
    public static final MyMetaProject_CompanyName CompanyName = new MyMetaProject_CompanyName();
    public static final MyMetaProject_SendEmailFrom SendEmailFrom = new MyMetaProject_SendEmailFrom();
    public static final MyMetaProject_Active Active = new MyMetaProject_Active();
    public static final MyMetaProject_CatalogVersion CatalogVersion = new MyMetaProject_CatalogVersion();
    public static final MyMetaProject_BusinessDays BusinessDays = new MyMetaProject_BusinessDays();
    public static final MyMetaProject_BusinessStartTime BusinessStartTime = new MyMetaProject_BusinessStartTime();
    public static final MyMetaProject_BusinessEndTime BusinessEndTime = new MyMetaProject_BusinessEndTime();
    public static final MyMetaProject_LockVersion LockVersion = new MyMetaProject_LockVersion();
    public static final MyMetaProject_DisplayString DisplayString = new MyMetaProject_DisplayString();
    public static final MyMetaProject_CreatedLocalTs CreatedLocalTs = new MyMetaProject_CreatedLocalTs();
    public static final MyMetaProject_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaProject_CreatedLocalTsMessage();
    public static final MyMetaProject_CreatedLocalDate CreatedLocalDate = new MyMetaProject_CreatedLocalDate();
    public static final MyMetaProject_CreatedLocalTime CreatedLocalTime = new MyMetaProject_CreatedLocalTime();
    public static final MyMetaProject_UpdatedLocalTs UpdatedLocalTs = new MyMetaProject_UpdatedLocalTs();
    public static final MyMetaProject_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaProject_UpdatedLocalTsMessage();
    public static final MyMetaProject_UpdatedLocalDate UpdatedLocalDate = new MyMetaProject_UpdatedLocalDate();
    public static final MyMetaProject_UpdatedLocalTime UpdatedLocalTime = new MyMetaProject_UpdatedLocalTime();
    public static final MyMetaProject_CreatedByFullName CreatedByFullName = new MyMetaProject_CreatedByFullName();
    public static final MyMetaProject_UpdatedByFullName UpdatedByFullName = new MyMetaProject_UpdatedByFullName();
    public static final MyMetaProject_TenantName TenantName = new MyMetaProject_TenantName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaProject_CreatedBy CreatedBy = new MyMetaProject_CreatedBy();
    public static final MyMetaProject_UpdatedBy UpdatedBy = new MyMetaProject_UpdatedBy();
    public static final MyMetaProject_Tenant Tenant = new MyMetaProject_Tenant();
}
