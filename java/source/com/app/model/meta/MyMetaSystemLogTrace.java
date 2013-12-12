//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MySystemLogTraceValidator;

public class MyMetaSystemLogTrace
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSystemLogTrace instance = new MyMetaSystemLogTrace();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSystemLogTrace()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "systemLogTrace";
    }

    public static MySystemLogTraceValidator getValidator()
    {
        return MySystemLogTraceValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSystemLogTrace_Id Id = new MyMetaSystemLogTrace_Id();
    public static final MyMetaSystemLogTrace_Sequence Sequence = new MyMetaSystemLogTrace_Sequence();
    public static final MyMetaSystemLogTrace_Value Value = new MyMetaSystemLogTrace_Value();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSystemLogTrace_Log Log = new MyMetaSystemLogTrace_Log();
}
