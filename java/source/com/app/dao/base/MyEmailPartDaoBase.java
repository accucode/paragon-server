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

public abstract class MyEmailPartDaoBase
    extends KmAbstractDao<MyEmailPart,String>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmailPart> getPersistentClass()
    {
        return MyEmailPart.class;
    }

    @Override
    protected String getTableName()
    {
        return "emailPart";
    }

    @Override
    public MyEmailPartCriteria createCriteria()
    {
        return new MyEmailPartCriteria(createGenericCriteria());
    }

    protected MyMetaEmailPart getMeta()
    {
        return MyEmailPart.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmailPart findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmailPart m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
