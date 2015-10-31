//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyAttentionMemberFinder
    implements KmKeyFinderIF<MyAttentionMember,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAttentionMember staticFind(String key)
    {
        return new MyAttentionMemberFinder().find(key);
    }

    public static MyAttentionMember staticFindDao(String key)
    {
        return new MyAttentionMemberFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttentionMember find(String key)
    {
        return new MyAttentionMemberDao().findUid(key);
    }

    public MyAttentionMember findDao(String key)
    {
        MyDaoKeyFinder<MyAttentionMember,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
