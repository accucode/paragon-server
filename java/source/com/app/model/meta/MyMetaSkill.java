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

public class MyMetaSkill
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSkill instance = new MyMetaSkill();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSkill()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "skill";
    }

    public static MySkillValidator getValidator()
    {
        return MySkillValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Skills are used to coordinate which workers are assigned to specific tasks.\nTypical examples include: Manager, Shipper, Picker, Scheduler, etc.\nEach worker is configured with the list of skills they are trained to perform,\nand each task is configured with the list of skills it requires.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSkill_Uid Uid = new MyMetaSkill_Uid();
    public static final MyMetaSkill_Name Name = new MyMetaSkill_Name();
    public static final MyMetaSkill_LockVersion LockVersion = new MyMetaSkill_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaSkill_Project Project = new MyMetaSkill_Project();
}
