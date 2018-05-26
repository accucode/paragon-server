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

public final class MyEmailPartFinder
    implements KmKeyFinderIF<MyEmailPart,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyEmailPartFinder instance = new MyEmailPartFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailPartFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailPart find(String key)
    {
        return new MyEmailPartDao().findUid(key);
    }

    public MyEmailPart findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
