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

public final class MyVendorFinder
    implements KmKeyFinderIF<MyVendor,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyVendorFinder instance = new MyVendorFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyVendorFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyVendor find(String key)
    {
        return new MyVendorDao().findUid(key);
    }

    public MyVendor findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
