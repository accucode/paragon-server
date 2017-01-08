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

public class MyMetaAuditLog_User
    extends KmMetaDaoAssociation<MyAuditLog,MyUser>
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
        return "The user that made this change.  May be null for automated updates.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyAuditLog model)
    {
        return model.getUser();
    }

    @Override
    public void setValueFor(MyAuditLog model, MyUser value)
    {
        model.setUser(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, MyUser value)
    {
        return model.hasUser(value);
    }
}
