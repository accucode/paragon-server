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
        return new MyUserCriteria(_createCriteria());
    }

    @Override
    public MyUserCriteria createDetachedCriteria(String alias)
    {
        return new MyUserCriteria(_createDetachedCriteria(alias));
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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
