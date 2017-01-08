//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
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

public class MyMetaServerSession_AutoLogin
    extends KmMetaDaoAssociation<MyServerSession,MyAutoLogin>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoLogin";
    }

    @Override
    public String getLabel()
    {
        return "Auto Login";
    }

    @Override
    public String getHelp()
    {
        return "The token, if any, that was used to automatically login.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAutoLogin getValueFor(MyServerSession model)
    {
        return model.getAutoLogin();
    }

    @Override
    public void setValueFor(MyServerSession model, MyAutoLogin value)
    {
        model.setAutoLogin(value);
    }

    @Override
    public boolean hasValueFor(MyServerSession model, MyAutoLogin value)
    {
        return model.hasAutoLogin(value);
    }
}
