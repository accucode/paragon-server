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

public class MyMetaMemberSkill_Member
    extends KmMetaDaoAssociation<MyMemberSkill,MyMember>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "member";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyMember getValueFor(MyMemberSkill model)
    {
        return model.getMember();
    }
    
    @Override
    public void setValueFor(MyMemberSkill model, MyMember value)
    {
        model.setMember(value);
    }
    
    @Override
    public boolean hasValueFor(MyMemberSkill model, MyMember value)
    {
        return model.hasMember(value);
    }
}
