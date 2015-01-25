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
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
