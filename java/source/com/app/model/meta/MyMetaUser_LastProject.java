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

public class MyMetaUser_LastProject
    extends KmMetaDaoAssociation<MyUser,MyProject>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastProject";
    }

    @Override
    public String getLabel()
    {
        return "Last Project";
    }

    @Override
    public String getHelp()
    {
        return "The last project this user was working on.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProject getValueFor(MyUser model)
    {
        return model.getLastProject();
    }

    @Override
    public void setValueFor(MyUser model, MyProject value)
    {
        model.setLastProject(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, MyProject value)
    {
        return model.hasLastProject(value);
    }
}
