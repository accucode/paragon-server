//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
