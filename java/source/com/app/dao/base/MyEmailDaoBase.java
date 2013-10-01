//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MyEmailCriteria;
import com.app.model.MyEmail;
import com.app.model.meta.MyMetaEmail;

import com.kodemore.dao.KmAbstractDao;

public abstract class MyEmailDaoBase
    extends KmAbstractDao<MyEmail,String>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmail> getPersistentClass()
    {
        return MyEmail.class;
    }

    @Override
    protected String getTableName()
    {
        return "email";
    }

    @Override
    public MyEmailCriteria createCriteria()
    {
        return new MyEmailCriteria(createGenericCriteria());
    }

    protected MyMetaEmail getMeta()
    {
        return MyEmail.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmail findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmail m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
