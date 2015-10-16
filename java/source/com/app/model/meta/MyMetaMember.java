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

public class MyMetaMember
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaMember instance = new MyMetaMember();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaMember()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "member";
    }

    public static MyMemberValidator getValidator()
    {
        return MyMemberValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The list of members determines which users have access to a specific project. Although users are global, their roles, skills, and access may vary by project.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaMember_Uid Uid = new MyMetaMember_Uid();
    public static final MyMetaMember_RoleCode RoleCode = new MyMetaMember_RoleCode();
    public static final MyMetaMember_Subtitle Subtitle = new MyMetaMember_Subtitle();
    public static final MyMetaMember_SkillNames SkillNames = new MyMetaMember_SkillNames();
    public static final MyMetaMember_LockVersion LockVersion = new MyMetaMember_LockVersion();
    public static final MyMetaMember_RoleName RoleName = new MyMetaMember_RoleName();
    public static final MyMetaMember_ProjectName ProjectName = new MyMetaMember_ProjectName();
    public static final MyMetaMember_UserName UserName = new MyMetaMember_UserName();
    public static final MyMetaMember_UserEmail UserEmail = new MyMetaMember_UserEmail();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaMember_Project Project = new MyMetaMember_Project();
    public static final MyMetaMember_User User = new MyMetaMember_User();
}
