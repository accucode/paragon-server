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
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
