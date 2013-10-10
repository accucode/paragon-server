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
