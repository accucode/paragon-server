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

public final class MyEmailRecipientFinder
    implements KmKeyFinderIF<MyEmailRecipient,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyEmailRecipientFinder instance = new MyEmailRecipientFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailRecipientFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailRecipient find(String key)
    {
        return new MyEmailRecipientDao().findUid(key);
    }

    public MyEmailRecipient findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
