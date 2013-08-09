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

public class MyMetaInvitation
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaInvitation instance = new MyMetaInvitation();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaInvitation()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "invitation";
    }

    public static MyInvitationValidator getValidator()
    {
        return MyInvitationValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaInvitation_Uid Uid = new MyMetaInvitation_Uid();
    public static final MyMetaInvitation_StatusCode StatusCode = new MyMetaInvitation_StatusCode();
    public static final MyMetaInvitation_TypeCode TypeCode = new MyMetaInvitation_TypeCode();
    public static final MyMetaInvitation_AccessKey AccessKey = new MyMetaInvitation_AccessKey();
    public static final MyMetaInvitation_CreatedUtcTs CreatedUtcTs = new MyMetaInvitation_CreatedUtcTs();
    public static final MyMetaInvitation_ClosedUtcTs ClosedUtcTs = new MyMetaInvitation_ClosedUtcTs();
    public static final MyMetaInvitation_LockVersion LockVersion = new MyMetaInvitation_LockVersion();
    public static final MyMetaInvitation_StatusName StatusName = new MyMetaInvitation_StatusName();
    public static final MyMetaInvitation_TypeName TypeName = new MyMetaInvitation_TypeName();
    public static final MyMetaInvitation_CreatedLocalTs CreatedLocalTs = new MyMetaInvitation_CreatedLocalTs();
    public static final MyMetaInvitation_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaInvitation_CreatedLocalTsMessage();
    public static final MyMetaInvitation_CreatedLocalDate CreatedLocalDate = new MyMetaInvitation_CreatedLocalDate();
    public static final MyMetaInvitation_CreatedLocalTime CreatedLocalTime = new MyMetaInvitation_CreatedLocalTime();
    public static final MyMetaInvitation_ClosedLocalTs ClosedLocalTs = new MyMetaInvitation_ClosedLocalTs();
    public static final MyMetaInvitation_ClosedLocalTsMessage ClosedLocalTsMessage = new MyMetaInvitation_ClosedLocalTsMessage();
    public static final MyMetaInvitation_ClosedLocalDate ClosedLocalDate = new MyMetaInvitation_ClosedLocalDate();
    public static final MyMetaInvitation_ClosedLocalTime ClosedLocalTime = new MyMetaInvitation_ClosedLocalTime();
    public static final MyMetaInvitation_UserName UserName = new MyMetaInvitation_UserName();
    public static final MyMetaInvitation_AccountName AccountName = new MyMetaInvitation_AccountName();
    public static final MyMetaInvitation_AccountUserRoleCode AccountUserRoleCode = new MyMetaInvitation_AccountUserRoleCode();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaInvitation_User User = new MyMetaInvitation_User();
    public static final MyMetaInvitation_Account Account = new MyMetaInvitation_Account();
    public static final MyMetaInvitation_AccountUser AccountUser = new MyMetaInvitation_AccountUser();
}
