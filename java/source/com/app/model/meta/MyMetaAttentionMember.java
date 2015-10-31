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

public class MyMetaAttentionMember
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAttentionMember instance = new MyMetaAttentionMember();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAttentionMember()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attentionMember";
    }

    public static MyAttentionMemberValidator getValidator()
    {
        return MyAttentionMemberValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The list of members associated with each attention group. A group can include many members, and each project member can belong to multiple groups.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAttentionMember_Uid Uid = new MyMetaAttentionMember_Uid();
    public static final MyMetaAttentionMember_LockVersion LockVersion = new MyMetaAttentionMember_LockVersion();
    public static final MyMetaAttentionMember_GroupName GroupName = new MyMetaAttentionMember_GroupName();
    public static final MyMetaAttentionMember_UserName UserName = new MyMetaAttentionMember_UserName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaAttentionMember_Group Group = new MyMetaAttentionMember_Group();
    public static final MyMetaAttentionMember_Member Member = new MyMetaAttentionMember_Member();
}
