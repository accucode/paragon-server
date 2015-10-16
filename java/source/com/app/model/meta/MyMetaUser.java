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

    public static MyUserValidator getValidator()
    {
        return MyUserValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Users define the global list of people that can log in to the system. Most users are configured as Other and then given project specific roles. A few users may be configured as Admin users so that they can create new projects.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaUser_Uid Uid = new MyMetaUser_Uid();
    public static final MyMetaUser_Name Name = new MyMetaUser_Name();
    public static final MyMetaUser_Email Email = new MyMetaUser_Email();
    public static final MyMetaUser_Phone Phone = new MyMetaUser_Phone();
    public static final MyMetaUser_Verified Verified = new MyMetaUser_Verified();
    public static final MyMetaUser_PasswordSalt PasswordSalt = new MyMetaUser_PasswordSalt();
    public static final MyMetaUser_PasswordHash PasswordHash = new MyMetaUser_PasswordHash();
    public static final MyMetaUser_TimeZoneCode TimeZoneCode = new MyMetaUser_TimeZoneCode();
    public static final MyMetaUser_RoleCode RoleCode = new MyMetaUser_RoleCode();
    public static final MyMetaUser_LockVersion LockVersion = new MyMetaUser_LockVersion();
    public static final MyMetaUser_RoleName RoleName = new MyMetaUser_RoleName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaUser_LastProject LastProject = new MyMetaUser_LastProject();
}
