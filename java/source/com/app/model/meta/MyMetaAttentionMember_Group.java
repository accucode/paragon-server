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

public class MyMetaAttentionMember_Group
    extends KmMetaDaoAssociation<MyAttentionMember,MyAttentionGroup>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "group";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAttentionGroup getValueFor(MyAttentionMember model)
    {
        return model.getGroup();
    }
    
    @Override
    public void setValueFor(MyAttentionMember model, MyAttentionGroup value)
    {
        model.setGroup(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttentionMember model, MyAttentionGroup value)
    {
        return model.hasGroup(value);
    }
}
