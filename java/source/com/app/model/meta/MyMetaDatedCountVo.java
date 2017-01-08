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

public class MyMetaDatedCountVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDatedCountVo instance = new MyMetaDatedCountVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDatedCountVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "datedCountVo";
    }

    public MyDatedCountVoValidator getValidator()
    {
        return MyDatedCountVoValidator.instance;
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

    public static final MyMetaDatedCountVo_Date Date = new MyMetaDatedCountVo_Date();
    public static final MyMetaDatedCountVo_Count Count = new MyMetaDatedCountVo_Count();
    public static final MyMetaDatedCountVo_DisplayString DisplayString = new MyMetaDatedCountVo_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
