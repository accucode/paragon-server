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

public class MyMetaSalesOrder_Project
    extends KmMetaDaoAssociation<MySalesOrder,MyProject>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "project";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProject getValueFor(MySalesOrder model)
    {
        return model.getProject();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, MyProject value)
    {
        model.setProject(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, MyProject value)
    {
        return model.hasProject(value);
    }
}
