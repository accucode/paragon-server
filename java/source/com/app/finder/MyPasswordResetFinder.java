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

public final class MyPasswordResetFinder
    implements KmKeyFinderIF<MyPasswordReset,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyPasswordResetFinder instance = new MyPasswordResetFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyPasswordResetFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPasswordReset find(String key)
    {
        return new MyPasswordResetDao().findUid(key);
    }

    public MyPasswordReset findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
