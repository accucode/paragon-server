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

public abstract class MyUserAccountDaoBase
    extends KmAbstractDao<MyUserAccount,String>
    implements MyUserAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserAccountDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUserAccount> getPersistentClass()
    {
        return MyUserAccount.class;
    }

    @Override
    protected String getTableName()
    {
        return "userAccount";
    }

    @Override
    public MyUserAccountCriteria createCriteria()
    {
        return new MyUserAccountCriteria(createGenericCriteria());
    }

    protected MyMetaUserAccount getMeta()
    {
        return MyUserAccount.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUserAccount findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUserAccount m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
