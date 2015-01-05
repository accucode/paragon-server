//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyDownloadCriteria;
import com.app.model.MyDownload;
import com.app.model.meta.MyMetaDownload;

public abstract class MyDownloadDaoBase
    extends KmAbstractDao<MyDownload,String>
    implements MyDownloadDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownloadDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyDownload> getPersistentClass()
    {
        return MyDownload.class;
    }

    @Override
    protected String getTableName()
    {
        return "download";
    }

    @Override
    public MyDownloadCriteria createCriteria()
    {
        return new MyDownloadCriteria(createGenericCriteria());
    }

    protected MyMetaDownload getMeta()
    {
        return MyDownload.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyDownload findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyDownload m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
