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

import com.app.criteria.MyServerSessionCriteria;
import com.app.model.MyServerSession;
import com.app.model.meta.MyMetaServerSession;

public abstract class MyServerSessionDaoBase
    extends KmAbstractDao<MyServerSession,String>
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyServerSession> getPersistentClass()
    {
        return MyServerSession.class;
    }

    @Override
    protected String getTableName()
    {
        return "serverSession";
    }

    @Override
    public MyServerSessionCriteria createCriteria()
    {
        return new MyServerSessionCriteria(createGenericCriteria());
    }

    protected MyMetaServerSession getMeta()
    {
        return MyServerSession.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyServerSession findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyServerSession m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
