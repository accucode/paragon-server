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

public abstract class MyAccountDaoBase
    extends KmAbstractDao<MyAccount,String>
    implements MyAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAccount> getPersistentClass()
    {
        return MyAccount.class;
    }

    @Override
    protected String getTableName()
    {
        return "account";
    }

    @Override
    public MyAccountCriteria createCriteria()
    {
        return new MyAccountCriteria(createGenericCriteria());
    }

    protected MyMetaAccount getMeta()
    {
        return MyAccount.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAccount findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAccount m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
