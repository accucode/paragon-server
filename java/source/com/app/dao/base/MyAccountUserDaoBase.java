//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MyAccountUserCriteria;
import com.app.model.MyAccountUser;
import com.app.model.meta.MyMetaAccountUser;

public abstract class MyAccountUserDaoBase
    extends KmAbstractDao<MyAccountUser,String>
    implements MyAccountUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountUserDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAccountUser> getPersistentClass()
    {
        return MyAccountUser.class;
    }

    @Override
    protected String getTableName()
    {
        return "accountUser";
    }

    @Override
    public MyAccountUserCriteria createCriteria()
    {
        return new MyAccountUserCriteria(createGenericCriteria());
    }

    protected MyMetaAccountUser getMeta()
    {
        return MyAccountUser.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAccountUser findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAccountUser m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
