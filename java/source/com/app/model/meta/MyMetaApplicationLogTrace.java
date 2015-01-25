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

public class MyMetaApplicationLogTrace
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaApplicationLogTrace instance = new MyMetaApplicationLogTrace();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaApplicationLogTrace()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "applicationLogTrace";
    }

    public static MyApplicationLogTraceValidator getValidator()
    {
        return MyApplicationLogTraceValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Used to store the stack trace segments.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaApplicationLogTrace_Id Id = new MyMetaApplicationLogTrace_Id();
    public static final MyMetaApplicationLogTrace_Sequence Sequence = new MyMetaApplicationLogTrace_Sequence();
    public static final MyMetaApplicationLogTrace_Value Value = new MyMetaApplicationLogTrace_Value();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaApplicationLogTrace_Log Log = new MyMetaApplicationLogTrace_Log();
}
