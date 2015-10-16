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

public class MyMetaServerSession
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaServerSession instance = new MyMetaServerSession();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaServerSession()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "serverSession";
    }

    public static MyServerSessionValidator getValidator()
    {
        return MyServerSessionValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Server sessions are used in place of the Virtual Http Session. This allow for a user session to be served by multiple web server machines. The session is created as early as possible, even before the user actually logs in.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaServerSession_Uid Uid = new MyMetaServerSession_Uid();
    public static final MyMetaServerSession_Active Active = new MyMetaServerSession_Active();
    public static final MyMetaServerSession_CreatedUtcTs CreatedUtcTs = new MyMetaServerSession_CreatedUtcTs();
    public static final MyMetaServerSession_ClosedUtcTs ClosedUtcTs = new MyMetaServerSession_ClosedUtcTs();
    public static final MyMetaServerSession_LastTouchedUtcTs LastTouchedUtcTs = new MyMetaServerSession_LastTouchedUtcTs();
    public static final MyMetaServerSession_Version Version = new MyMetaServerSession_Version();
    public static final MyMetaServerSession_LockVersion LockVersion = new MyMetaServerSession_LockVersion();
    public static final MyMetaServerSession_CreatedLocalTs CreatedLocalTs = new MyMetaServerSession_CreatedLocalTs();
    public static final MyMetaServerSession_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaServerSession_CreatedLocalTsMessage();
    public static final MyMetaServerSession_CreatedLocalDate CreatedLocalDate = new MyMetaServerSession_CreatedLocalDate();
    public static final MyMetaServerSession_CreatedLocalTime CreatedLocalTime = new MyMetaServerSession_CreatedLocalTime();
    public static final MyMetaServerSession_ClosedLocalTs ClosedLocalTs = new MyMetaServerSession_ClosedLocalTs();
    public static final MyMetaServerSession_ClosedLocalTsMessage ClosedLocalTsMessage = new MyMetaServerSession_ClosedLocalTsMessage();
    public static final MyMetaServerSession_ClosedLocalDate ClosedLocalDate = new MyMetaServerSession_ClosedLocalDate();
    public static final MyMetaServerSession_ClosedLocalTime ClosedLocalTime = new MyMetaServerSession_ClosedLocalTime();
    public static final MyMetaServerSession_LastTouchedLocalTs LastTouchedLocalTs = new MyMetaServerSession_LastTouchedLocalTs();
    public static final MyMetaServerSession_LastTouchedLocalTsMessage LastTouchedLocalTsMessage = new MyMetaServerSession_LastTouchedLocalTsMessage();
    public static final MyMetaServerSession_LastTouchedLocalDate LastTouchedLocalDate = new MyMetaServerSession_LastTouchedLocalDate();
    public static final MyMetaServerSession_LastTouchedLocalTime LastTouchedLocalTime = new MyMetaServerSession_LastTouchedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaServerSession_User User = new MyMetaServerSession_User();
    public static final MyMetaServerSession_AutoSignIn AutoSignIn = new MyMetaServerSession_AutoSignIn();
    public static final MyMetaServerSession_CurrentProject CurrentProject = new MyMetaServerSession_CurrentProject();
}
