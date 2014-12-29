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

public class MyMetaMemberSkill_Skill
    extends KmMetaDaoAssociation<MyMemberSkill,MySkill>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "skill";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySkill getValueFor(MyMemberSkill model)
    {
        return model.getSkill();
    }
    
    @Override
    public void setValueFor(MyMemberSkill model, MySkill value)
    {
        model.setSkill(value);
    }
    
    @Override
    public boolean hasValueFor(MyMemberSkill model, MySkill value)
    {
        return model.hasSkill(value);
    }
}
