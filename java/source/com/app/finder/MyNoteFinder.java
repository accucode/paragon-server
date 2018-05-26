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

public final class MyNoteFinder
    implements KmKeyFinderIF<MyNote,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyNoteFinder instance = new MyNoteFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyNoteFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyNote find(String key)
    {
        return new MyNoteDao().findUid(key);
    }

    public MyNote findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
