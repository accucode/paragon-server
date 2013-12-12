//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyInvitationDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyInvitation;

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
