//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyUserValidator;

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

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaUser_Uid Uid = new MyMetaUser_Uid();
    public static final MyMetaUser_Name Name = new MyMetaUser_Name();
    public static final MyMetaUser_Email Email = new MyMetaUser_Email();
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

}
