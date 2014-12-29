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
