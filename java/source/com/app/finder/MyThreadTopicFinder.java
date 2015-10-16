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

public class MyThreadTopicFinder
    implements KmKeyFinderIF<MyThreadTopic,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyThreadTopic staticFind(String key)
    {
        return new MyThreadTopicFinder().find(key);
    }

    public static MyThreadTopic staticFindDao(String key)
    {
        return new MyThreadTopicFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyThreadTopic find(String key)
    {
        return new MyThreadTopicDao().findCode(key);
    }

    public MyThreadTopic findDao(String key)
    {
        MyDaoKeyFinder<MyThreadTopic,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
