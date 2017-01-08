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

public class MyMetaInvitation_Project
    extends KmMetaDaoAssociation<MyInvitation,MyProject>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "project";
    }

    @Override
    public String getLabel()
    {
        return "Project";
    }

    @Override
    public String getHelp()
    {
        return "The project to which the invitation referred.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProject getValueFor(MyInvitation model)
    {
        return model.getProject();
    }

    @Override
    public void setValueFor(MyInvitation model, MyProject value)
    {
        model.setProject(value);
    }

    @Override
    public boolean hasValueFor(MyInvitation model, MyProject value)
    {
        return model.hasProject(value);
    }
}
