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

public class MyMetaNamedDoubleVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedDoubleVo instance = new MyMetaNamedDoubleVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedDoubleVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedDoubleVo";
    }

    public MyNamedDoubleVoValidator getValidator()
    {
        return MyNamedDoubleVoValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "This is a non-persistent domain model; it is NOT stored in the database.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaNamedDoubleVo_Name Name = new MyMetaNamedDoubleVo_Name();
    public static final MyMetaNamedDoubleVo_Value Value = new MyMetaNamedDoubleVo_Value();
    public static final MyMetaNamedDoubleVo_DisplayString DisplayString = new MyMetaNamedDoubleVo_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
