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

public abstract class MyAttributeValueDaoBase
    extends KmAbstractDao<MyAttributeValue,String>
    implements MyAttributeValueDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeValueDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAttributeValue> getPersistentClass()
    {
        return MyAttributeValue.class;
    }

    @Override
    protected String getTableName()
    {
        return "attributeValue";
    }

    @Override
    public MyAttributeValueCriteria createCriteria()
    {
        return new MyAttributeValueCriteria(_createCriteria());
    }

    @Override
    public MyAttributeValueCriteria createDetachedCriteria(String alias)
    {
        return new MyAttributeValueCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAttributeValue getMeta()
    {
        return MyAttributeValue.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAttributeValue findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAttributeValue m = findUid(e);

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
