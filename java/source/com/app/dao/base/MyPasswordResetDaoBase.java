//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MyPasswordResetCriteria;
import com.app.model.MyPasswordReset;
import com.app.model.meta.MyMetaPasswordReset;

import com.kodemore.dao.KmAbstractDao;

public abstract class MyPasswordResetDaoBase
    extends KmAbstractDao<MyPasswordReset,String>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPasswordReset> getPersistentClass()
    {
        return MyPasswordReset.class;
    }

    @Override
    protected String getTableName()
    {
        return "passwordReset";
    }

    @Override
    public MyPasswordResetCriteria createCriteria()
    {
        return new MyPasswordResetCriteria(createGenericCriteria());
    }

    protected MyMetaPasswordReset getMeta()
    {
        return MyPasswordReset.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPasswordReset findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPasswordReset m = findUid(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
