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

public abstract class MyEmailDaoBase
    extends KmAbstractDao<MyEmail,String>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmail> getPersistentClass()
    {
        return MyEmail.class;
    }

    @Override
    protected String getTableName()
    {
        return "email";
    }

    @Override
    public MyEmailCriteria createCriteria()
    {
        return new MyEmailCriteria(createGenericCriteria());
    }

    protected MyMetaEmail getMeta()
    {
        return MyEmail.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmail findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmail m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
