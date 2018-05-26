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

public final class MySiteFinder
    implements KmKeyFinderIF<MySite,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MySiteFinder instance = new MySiteFinder();

    //##################################################
    //# constructor
    //##################################################

    private MySiteFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySite find(String key)
    {
        return new MySiteDao().findUid(key);
    }

    public MySite findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
