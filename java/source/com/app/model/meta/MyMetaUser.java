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

public class MyMetaUser
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUser instance = new MyMetaUser();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUser()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "user";
    }

    public MyUserValidator getValidator()
    {
        return MyUserValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Users define the people that can log in to a particular tenant. Most users are configured as Other and then given project specific roles. A few users may be configured as Admin users so that they can create new projects.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaUser_Uid Uid = new MyMetaUser_Uid();
    public static final MyMetaUser_CreatedUtcTs CreatedUtcTs = new MyMetaUser_CreatedUtcTs();
    public static final MyMetaUser_UpdatedUtcTs UpdatedUtcTs = new MyMetaUser_UpdatedUtcTs();
    public static final MyMetaUser_FirstName FirstName = new MyMetaUser_FirstName();
    public static final MyMetaUser_LastName LastName = new MyMetaUser_LastName();
    public static final MyMetaUser_Nickname Nickname = new MyMetaUser_Nickname();
    public static final MyMetaUser_Email Email = new MyMetaUser_Email();
    public static final MyMetaUser_PasswordSalt PasswordSalt = new MyMetaUser_PasswordSalt();
    public static final MyMetaUser_PasswordHash PasswordHash = new MyMetaUser_PasswordHash();
    public static final MyMetaUser_Phone Phone = new MyMetaUser_Phone();
    public static final MyMetaUser_Active Active = new MyMetaUser_Active();
    public static final MyMetaUser_TimeZoneCode TimeZoneCode = new MyMetaUser_TimeZoneCode();
    public static final MyMetaUser_RoleCode RoleCode = new MyMetaUser_RoleCode();
    public static final MyMetaUser_DashboardOrientationTypeCode DashboardOrientationTypeCode = new MyMetaUser_DashboardOrientationTypeCode();
    public static final MyMetaUser_DashboardLineCount1 DashboardLineCount1 = new MyMetaUser_DashboardLineCount1();
    public static final MyMetaUser_DashboardLineCount2 DashboardLineCount2 = new MyMetaUser_DashboardLineCount2();
    public static final MyMetaUser_DashboardPanelCodeA DashboardPanelCodeA = new MyMetaUser_DashboardPanelCodeA();
    public static final MyMetaUser_DashboardPanelCodeB DashboardPanelCodeB = new MyMetaUser_DashboardPanelCodeB();
    public static final MyMetaUser_DashboardPanelCodeC DashboardPanelCodeC = new MyMetaUser_DashboardPanelCodeC();
    public static final MyMetaUser_DashboardPanelCodeD DashboardPanelCodeD = new MyMetaUser_DashboardPanelCodeD();
    public static final MyMetaUser_DashboardPanelCodeE DashboardPanelCodeE = new MyMetaUser_DashboardPanelCodeE();
    public static final MyMetaUser_DashboardPanelCodeF DashboardPanelCodeF = new MyMetaUser_DashboardPanelCodeF();
    public static final MyMetaUser_DashboardPanelCodeG DashboardPanelCodeG = new MyMetaUser_DashboardPanelCodeG();
    public static final MyMetaUser_FullName FullName = new MyMetaUser_FullName();
    public static final MyMetaUser_FormalName FormalName = new MyMetaUser_FormalName();
    public static final MyMetaUser_ShortName ShortName = new MyMetaUser_ShortName();
    public static final MyMetaUser_LongName LongName = new MyMetaUser_LongName();
    public static final MyMetaUser_LockVersion LockVersion = new MyMetaUser_LockVersion();
    public static final MyMetaUser_DisplayString DisplayString = new MyMetaUser_DisplayString();
    public static final MyMetaUser_RoleName RoleName = new MyMetaUser_RoleName();
    public static final MyMetaUser_CreatedLocalTs CreatedLocalTs = new MyMetaUser_CreatedLocalTs();
    public static final MyMetaUser_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaUser_CreatedLocalTsMessage();
    public static final MyMetaUser_CreatedLocalDate CreatedLocalDate = new MyMetaUser_CreatedLocalDate();
    public static final MyMetaUser_CreatedLocalTime CreatedLocalTime = new MyMetaUser_CreatedLocalTime();
    public static final MyMetaUser_UpdatedLocalTs UpdatedLocalTs = new MyMetaUser_UpdatedLocalTs();
    public static final MyMetaUser_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaUser_UpdatedLocalTsMessage();
    public static final MyMetaUser_UpdatedLocalDate UpdatedLocalDate = new MyMetaUser_UpdatedLocalDate();
    public static final MyMetaUser_UpdatedLocalTime UpdatedLocalTime = new MyMetaUser_UpdatedLocalTime();
    public static final MyMetaUser_CreatedByFullName CreatedByFullName = new MyMetaUser_CreatedByFullName();
    public static final MyMetaUser_UpdatedByFullName UpdatedByFullName = new MyMetaUser_UpdatedByFullName();
    public static final MyMetaUser_TenantName TenantName = new MyMetaUser_TenantName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaUser_CreatedBy CreatedBy = new MyMetaUser_CreatedBy();
    public static final MyMetaUser_UpdatedBy UpdatedBy = new MyMetaUser_UpdatedBy();
    public static final MyMetaUser_Tenant Tenant = new MyMetaUser_Tenant();
    public static final MyMetaUser_LastProject LastProject = new MyMetaUser_LastProject();
}
