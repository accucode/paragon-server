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

public class MyMetaNamedCountVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedCountVo instance = new MyMetaNamedCountVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedCountVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedCountVo";
    }

    public static MyNamedCountVoValidator getValidator()
    {
        return MyNamedCountVoValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaNamedCountVo_Name Name = new MyMetaNamedCountVo_Name();
    public static final MyMetaNamedCountVo_Count Count = new MyMetaNamedCountVo_Count();

    //##################################################
    //# associations
    //##################################################

}
