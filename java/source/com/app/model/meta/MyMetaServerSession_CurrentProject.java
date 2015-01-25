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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.match.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaServerSession_CurrentProject
    extends KmMetaDaoAssociation<MyServerSession,MyProject>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "currentProject";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProject getValueFor(MyServerSession model)
    {
        return model.getCurrentProject();
    }
    
    @Override
    public void setValueFor(MyServerSession model, MyProject value)
    {
        model.setCurrentProject(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, MyProject value)
    {
        return model.hasCurrentProject(value);
    }
}
