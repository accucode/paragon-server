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

public abstract class MyAutoSignInDaoBase
    extends KmAbstractDao<MyAutoSignIn,String>
    implements MyAutoSignInDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoSignInDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAutoSignIn> getPersistentClass()
    {
        return MyAutoSignIn.class;
    }

    @Override
    protected String getTableName()
    {
        return "autoSignIn";
    }

    @Override
    public MyAutoSignInCriteria createCriteria()
    {
        return new MyAutoSignInCriteria(_createCriteria());
    }

    @Override
    public MyAutoSignInCriteria createDetachedCriteria(String alias)
    {
        return new MyAutoSignInCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAutoSignIn getMeta()
    {
        return MyAutoSignIn.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAutoSignIn findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAutoSignIn m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
