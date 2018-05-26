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

public final class MyCustomerFinder
    implements KmKeyFinderIF<MyCustomer,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyCustomerFinder instance = new MyCustomerFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyCustomerFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomer find(String key)
    {
        return new MyCustomerDao().findUid(key);
    }

    public MyCustomer findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
