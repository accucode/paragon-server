//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyInvitationFinder
    implements KmKeyFinderIF<MyInvitation,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyInvitation staticFind(String key)
    {
        return new MyInvitationFinder().find(key);
    }

    public static MyInvitation staticFindDao(String key)
    {
        return new MyInvitationFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyInvitation find(String key)
    {
        return new MyInvitationDao().findUid(key);
    }

    public MyInvitation findDao(String key)
    {
        MyDaoKeyFinder<MyInvitation,String> e;
        e = new MyDaoKeyFinder<MyInvitation,String>(this, key);
        e.run();
        return e.getValue();
    }
}
