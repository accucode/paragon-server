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

public final class MyProjectFinder
    implements KmKeyFinderIF<MyProject,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyProjectFinder instance = new MyProjectFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyProjectFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyProject find(String key)
    {
        return new MyProjectDao().findUid(key);
    }

    public MyProject findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
