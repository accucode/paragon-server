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

public abstract class MyShipAccountDaoBase
    extends KmAbstractDao<MyShipAccount,String>
    implements MyShipAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipAccountDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyShipAccount> getPersistentClass()
    {
        return MyShipAccount.class;
    }

    @Override
    protected String getTableName()
    {
        return "shipAccount";
    }

    @Override
    public MyShipAccountCriteria createCriteria()
    {
        return new MyShipAccountCriteria(_createCriteria());
    }

    @Override
    public MyShipAccountCriteria createDetachedCriteria(String alias)
    {
        return new MyShipAccountCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaShipAccount getMeta()
    {
        return MyShipAccount.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyShipAccount findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyShipAccount m = findUid(e);

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
