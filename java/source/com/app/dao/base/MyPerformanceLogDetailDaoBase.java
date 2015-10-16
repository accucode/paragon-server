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

public abstract class MyPerformanceLogDetailDaoBase
    extends KmAbstractDao<MyPerformanceLogDetail,String>
    implements MyPerformanceLogDetailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetailDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPerformanceLogDetail> getPersistentClass()
    {
        return MyPerformanceLogDetail.class;
    }

    @Override
    protected String getTableName()
    {
        return "performanceLogDetail";
    }

    @Override
    public MyPerformanceLogDetailCriteria createCriteria()
    {
        return new MyPerformanceLogDetailCriteria(_createCriteria());
    }

    @Override
    public MyPerformanceLogDetailCriteria createDetachedCriteria(String alias)
    {
        return new MyPerformanceLogDetailCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaPerformanceLogDetail getMeta()
    {
        return MyPerformanceLogDetail.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPerformanceLogDetail findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPerformanceLogDetail m = findUid(e);

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
