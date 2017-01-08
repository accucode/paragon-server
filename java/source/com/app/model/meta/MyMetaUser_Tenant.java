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

public class MyMetaUser_Tenant
    extends KmMetaDaoAssociation<MyUser,MyTenant>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tenant";
    }

    @Override
    public String getLabel()
    {
        return "Tenant";
    }

    @Override
    public String getHelp()
    {
        return "The tenant.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyTenant getValueFor(MyUser model)
    {
        return model.getTenant();
    }

    @Override
    public void setValueFor(MyUser model, MyTenant value)
    {
        model.setTenant(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, MyTenant value)
    {
        return model.hasTenant(value);
    }
}
