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

public class MyMetaPasswordReset
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPasswordReset instance = new MyMetaPasswordReset();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPasswordReset()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "passwordReset";
    }

    public static MyPasswordResetValidator getValidator()
    {
        return MyPasswordResetValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPasswordReset_Uid Uid = new MyMetaPasswordReset_Uid();
    public static final MyMetaPasswordReset_StatusCode StatusCode = new MyMetaPasswordReset_StatusCode();
    public static final MyMetaPasswordReset_AccessKey AccessKey = new MyMetaPasswordReset_AccessKey();
    public static final MyMetaPasswordReset_CreatedUtcTs CreatedUtcTs = new MyMetaPasswordReset_CreatedUtcTs();
    public static final MyMetaPasswordReset_ClosedUtcTs ClosedUtcTs = new MyMetaPasswordReset_ClosedUtcTs();
    public static final MyMetaPasswordReset_LockVersion LockVersion = new MyMetaPasswordReset_LockVersion();
    public static final MyMetaPasswordReset_StatusName StatusName = new MyMetaPasswordReset_StatusName();
    public static final MyMetaPasswordReset_CreatedLocalTs CreatedLocalTs = new MyMetaPasswordReset_CreatedLocalTs();
    public static final MyMetaPasswordReset_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPasswordReset_CreatedLocalTsMessage();
    public static final MyMetaPasswordReset_CreatedLocalDate CreatedLocalDate = new MyMetaPasswordReset_CreatedLocalDate();
    public static final MyMetaPasswordReset_CreatedLocalTime CreatedLocalTime = new MyMetaPasswordReset_CreatedLocalTime();
    public static final MyMetaPasswordReset_ClosedLocalTs ClosedLocalTs = new MyMetaPasswordReset_ClosedLocalTs();
    public static final MyMetaPasswordReset_ClosedLocalTsMessage ClosedLocalTsMessage = new MyMetaPasswordReset_ClosedLocalTsMessage();
    public static final MyMetaPasswordReset_ClosedLocalDate ClosedLocalDate = new MyMetaPasswordReset_ClosedLocalDate();
    public static final MyMetaPasswordReset_ClosedLocalTime ClosedLocalTime = new MyMetaPasswordReset_ClosedLocalTime();
    public static final MyMetaPasswordReset_UserName UserName = new MyMetaPasswordReset_UserName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaPasswordReset_User User = new MyMetaPasswordReset_User();
}
