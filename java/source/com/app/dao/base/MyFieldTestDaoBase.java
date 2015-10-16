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

public abstract class MyFieldTestDaoBase
    extends KmAbstractDao<MyFieldTest,String>
    implements MyFieldTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFieldTest> getPersistentClass()
    {
        return MyFieldTest.class;
    }

    @Override
    protected String getTableName()
    {
        return "fieldTest";
    }

    @Override
    public MyFieldTestCriteria createCriteria()
    {
        return new MyFieldTestCriteria(_createCriteria());
    }

    @Override
    public MyFieldTestCriteria createDetachedCriteria(String alias)
    {
        return new MyFieldTestCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFieldTest getMeta()
    {
        return MyFieldTest.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFieldTest findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFieldTest m = findUid(e);

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
