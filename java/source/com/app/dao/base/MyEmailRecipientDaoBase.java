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

public abstract class MyEmailRecipientDaoBase
    extends KmAbstractDao<MyEmailRecipient,String>
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipientDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmailRecipient> getPersistentClass()
    {
        return MyEmailRecipient.class;
    }

    @Override
    protected String getTableName()
    {
        return "emailRecipient";
    }

    @Override
    public MyEmailRecipientCriteria createCriteria()
    {
        return new MyEmailRecipientCriteria(_createCriteria());
    }

    @Override
    public MyEmailRecipientCriteria createDetachedCriteria(String alias)
    {
        return new MyEmailRecipientCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaEmailRecipient getMeta()
    {
        return MyEmailRecipient.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmailRecipient findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmailRecipient m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
