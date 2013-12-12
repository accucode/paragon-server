//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyDownloadDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyDownload;

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
        e = new MyDaoKeyFinder<MyDownload,String>(this, key);
        e.run();
        return e.getValue();
    }
}
