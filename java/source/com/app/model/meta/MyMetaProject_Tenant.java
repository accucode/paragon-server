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

public class MyMetaProject_Tenant
    extends KmMetaDaoAssociation<MyProject,MyTenant>
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
        return "The tenant that owns this project.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyTenant getValueFor(MyProject model)
    {
        return model.getTenant();
    }

    @Override
    public void setValueFor(MyProject model, MyTenant value)
    {
        model.setTenant(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, MyTenant value)
    {
        return model.hasTenant(value);
    }
}
