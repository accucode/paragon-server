//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MyEmailRecipientCriteria;
import com.app.model.MyEmailRecipient;
import com.app.model.meta.MyMetaEmailRecipient;

import com.kodemore.dao.KmAbstractDao;

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
        return new MyEmailRecipientCriteria(createGenericCriteria());
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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
