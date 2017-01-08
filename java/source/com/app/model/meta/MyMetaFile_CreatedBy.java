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

public class MyMetaFile_CreatedBy
    extends KmMetaDaoAssociation<MyFile,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdBy";
    }

    @Override
    public String getLabel()
    {
        return "Created By";
    }

    @Override
    public String getHelp()
    {
        return "The user that originally created this record, if known.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyFile model)
    {
        return model.getCreatedBy();
    }

    @Override
    public void setValueFor(MyFile model, MyUser value)
    {
        model.setCreatedBy(value);
    }

    @Override
    public boolean hasValueFor(MyFile model, MyUser value)
    {
        return model.hasCreatedBy(value);
    }
}
