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

public abstract class MyVisitTypeDaoBase
    extends KmAbstractDao<MyVisitType,String>
    implements MyVisitTypeDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyVisitTypeDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyVisitType> getPersistentClass()
    {
        return MyVisitType.class;
    }

    @Override
    protected String getTableName()
    {
        return "visitType";
    }

    @Override
    public MyVisitTypeCriteria createCriteria()
    {
        return new MyVisitTypeCriteria(_createCriteria());
    }

    @Override
    public MyVisitTypeCriteria createDetachedCriteria(String alias)
    {
        return new MyVisitTypeCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaVisitType getMeta()
    {
        return MyVisitType.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyVisitType findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyVisitType m = findUid(e);

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
