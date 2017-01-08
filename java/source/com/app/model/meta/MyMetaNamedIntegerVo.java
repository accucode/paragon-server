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

public class MyMetaNamedIntegerVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedIntegerVo instance = new MyMetaNamedIntegerVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedIntegerVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedIntegerVo";
    }

    public MyNamedIntegerVoValidator getValidator()
    {
        return MyNamedIntegerVoValidator.instance;
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

    public static final MyMetaNamedIntegerVo_Name Name = new MyMetaNamedIntegerVo_Name();
    public static final MyMetaNamedIntegerVo_Value Value = new MyMetaNamedIntegerVo_Value();
    public static final MyMetaNamedIntegerVo_DisplayString DisplayString = new MyMetaNamedIntegerVo_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
