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

public class MyMetaAttributeValue_Field
    extends KmMetaDaoAssociation<MyAttributeValue,MyAttributeField>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "field";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAttributeField getValueFor(MyAttributeValue model)
    {
        return model.getField();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, MyAttributeField value)
    {
        model.setField(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, MyAttributeField value)
    {
        return model.hasField(value);
    }
}
