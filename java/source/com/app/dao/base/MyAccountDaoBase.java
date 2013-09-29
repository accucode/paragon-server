//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MyAccountCriteria;
import com.app.model.MyAccount;
import com.app.model.meta.MyMetaAccount;

import com.kodemore.dao.KmAbstractDao;

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
