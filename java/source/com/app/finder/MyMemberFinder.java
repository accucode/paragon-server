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

public class MyMemberFinder
    implements KmKeyFinderIF<MyMember,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyMember staticFind(String key)
    {
        return new MyMemberFinder().find(key);
    }

    public static MyMember staticFindDao(String key)
    {
        return new MyMemberFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyMember find(String key)
    {
        return new MyMemberDao().findUid(key);
    }

    public MyMember findDao(String key)
    {
        MyDaoKeyFinder<MyMember,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
