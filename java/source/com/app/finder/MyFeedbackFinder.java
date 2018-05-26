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

public final class MyFeedbackFinder
    implements KmKeyFinderIF<MyFeedback,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyFeedbackFinder instance = new MyFeedbackFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyFeedbackFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyFeedback find(String key)
    {
        return new MyFeedbackDao().findUid(key);
    }

    public MyFeedback findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
