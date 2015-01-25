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

public class MyDownloadFinder
    implements KmKeyFinderIF<MyDownload,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyDownload staticFind(String key)
    {
        return new MyDownloadFinder().find(key);
    }

    public static MyDownload staticFindDao(String key)
    {
        return new MyDownloadFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyDownload find(String key)
    {
        return new MyDownloadDao().findUid(key);
    }

    public MyDownload findDao(String key)
    {
        MyDaoKeyFinder<MyDownload,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
