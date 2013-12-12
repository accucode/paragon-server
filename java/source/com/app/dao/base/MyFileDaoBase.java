//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MyFileCriteria;
import com.app.model.MyFile;
import com.app.model.meta.MyMetaFile;

public abstract class MyFileDaoBase
    extends KmAbstractDao<MyFile,Integer>
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFileDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFile> getPersistentClass()
    {
        return MyFile.class;
    }

    @Override
    protected String getTableName()
    {
        return "file";
    }

    @Override
    public MyFileCriteria createCriteria()
    {
        return new MyFileCriteria(createGenericCriteria());
    }

    protected MyMetaFile getMeta()
    {
        return MyFile.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFile findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MyFile m = findId(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
