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

public final class MySiteContactFinder
    implements KmKeyFinderIF<MySiteContact,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MySiteContactFinder instance = new MySiteContactFinder();

    //##################################################
    //# constructor
    //##################################################

    private MySiteContactFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySiteContact find(String key)
    {
        return new MySiteContactDao().findUid(key);
    }

    public MySiteContact findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
