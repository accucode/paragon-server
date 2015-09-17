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

public class MyAttentionGroupFinder
    implements KmKeyFinderIF<MyAttentionGroup,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAttentionGroup staticFind(String key)
    {
        return new MyAttentionGroupFinder().find(key);
    }

    public static MyAttentionGroup staticFindDao(String key)
    {
        return new MyAttentionGroupFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAttentionGroup find(String key)
    {
        return new MyAttentionGroupDao().findUid(key);
    }

    public MyAttentionGroup findDao(String key)
    {
        MyDaoKeyFinder<MyAttentionGroup,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
