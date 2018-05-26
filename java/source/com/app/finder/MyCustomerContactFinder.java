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

public final class MyCustomerContactFinder
    implements KmKeyFinderIF<MyCustomerContact,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyCustomerContactFinder instance = new MyCustomerContactFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyCustomerContactFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomerContact find(String key)
    {
        return new MyCustomerContactDao().findUid(key);
    }

    public MyCustomerContact findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
