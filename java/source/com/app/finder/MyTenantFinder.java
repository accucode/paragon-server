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

public final class MyTenantFinder
    implements KmKeyFinderIF<MyTenant,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyTenantFinder instance = new MyTenantFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyTenantFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyTenant find(String key)
    {
        return new MyTenantDao().findUid(key);
    }

    public MyTenant findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
