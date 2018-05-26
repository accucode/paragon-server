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

public final class MyDefaultRecipientFinder
    implements KmKeyFinderIF<MyDefaultRecipient,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyDefaultRecipientFinder instance = new MyDefaultRecipientFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyDefaultRecipientFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyDefaultRecipient find(String key)
    {
        return new MyDefaultRecipientDao().findUid(key);
    }

    public MyDefaultRecipient findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
