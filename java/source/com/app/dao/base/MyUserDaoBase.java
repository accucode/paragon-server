//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MyUserCriteria;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

public abstract class MyUserDaoBase
    extends KmAbstractDao<MyUser,String>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUser> getPersistentClass()
    {
        return MyUser.class;
    }

    @Override
    protected String getTableName()
    {
        return "user";
    }

    @Override
    public MyUserCriteria createCriteria()
    {
        return new MyUserCriteria(createGenericCriteria());
    }

    protected MyMetaUser getMeta()
    {
        return MyUser.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUser findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUser m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
