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

public class MyMetaAttentionGroup
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAttentionGroup instance = new MyMetaAttentionGroup();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAttentionGroup()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attentionGroup";
    }

    public static MyAttentionGroupValidator getValidator()
    {
        return MyAttentionGroupValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Attention groups are used to coordinate requests for assistance.  When someone needs help with a particular task, they can flag the task attention. However, rather than requesting assistance from a specific person, the app is designed to direct assistance to potentially multiple people.  This provides for greater flexibility and helps avoid bottlenecks as the system scales. Typical examples of attention groups include: Manager, Engineer, and Accounting.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAttentionGroup_Uid Uid = new MyMetaAttentionGroup_Uid();
    public static final MyMetaAttentionGroup_Name Name = new MyMetaAttentionGroup_Name();
    public static final MyMetaAttentionGroup_LockVersion LockVersion = new MyMetaAttentionGroup_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAttentionGroup_Project Project = new MyMetaAttentionGroup_Project();
}
