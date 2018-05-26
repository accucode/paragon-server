//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.command.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public final class MyThreadTopicFinder
    implements KmKeyFinderIF<MyThreadTopic,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyThreadTopicFinder instance = new MyThreadTopicFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyThreadTopicFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
