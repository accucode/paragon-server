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

public class MyMetaServerSession_User
    extends KmMetaDaoAssociation<MyServerSession,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "user";
    }

    @Override
    public String getLabel()
    {
        return "User";
    }

    @Override
    public String getHelp()
    {
        return "The user associated with this session.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyServerSession model)
    {
        return model.getUser();
    }

    @Override
    public void setValueFor(MyServerSession model, MyUser value)
    {
        model.setUser(value);
    }

    @Override
    public boolean hasValueFor(MyServerSession model, MyUser value)
    {
        return model.hasUser(value);
    }
}
