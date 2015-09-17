//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

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

public class MyMetaMemberSkill
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaMemberSkill instance = new MyMetaMemberSkill();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaMemberSkill()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "memberSkill";
    }

    public static MyMemberSkillValidator getValidator()
    {
        return MyMemberSkillValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The project specific skills assigned to a particular member.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaMemberSkill_Uid Uid = new MyMetaMemberSkill_Uid();
    public static final MyMetaMemberSkill_Sequence Sequence = new MyMetaMemberSkill_Sequence();
    public static final MyMetaMemberSkill_LockVersion LockVersion = new MyMetaMemberSkill_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaMemberSkill_Member Member = new MyMetaMemberSkill_Member();
    public static final MyMetaMemberSkill_Skill Skill = new MyMetaMemberSkill_Skill();
}
