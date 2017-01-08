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
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyFileDaoBase
    extends KmAbstractDao<MyFile,String>
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
        return new MyFileCriteria(_createCriteria());
    }

    @Override
    public MyFileCriteria createDetachedCriteria(String alias)
    {
        return new MyFileCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFile getMeta()
    {
        return MyFile.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFile findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFile m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
