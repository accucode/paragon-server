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

public class MyMetaSalesOrder_AttentionTo
    extends KmMetaDaoAssociation<MySalesOrder,MyAttentionGroup>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attentionTo";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAttentionGroup getValueFor(MySalesOrder model)
    {
        return model.getAttentionTo();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, MyAttentionGroup value)
    {
        model.setAttentionTo(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, MyAttentionGroup value)
    {
        return model.hasAttentionTo(value);
    }
}
