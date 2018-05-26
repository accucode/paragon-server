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

public final class MyMemberFinder
    implements KmKeyFinderIF<MyMember,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyMemberFinder instance = new MyMemberFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyMemberFinder()
    {
        // private
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyMember find(String key)
    {
        return new MyMemberDao().findUid(key);
    }

    public MyMember findDao(String key)
    {
        return KmDao.fetch(this::find, key);
    }
}
