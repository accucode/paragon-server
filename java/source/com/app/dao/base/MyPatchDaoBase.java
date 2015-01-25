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

public abstract class MyPatchDaoBase
    extends KmAbstractDao<MyPatch,String>
    implements MyPatchDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPatchDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPatch> getPersistentClass()
    {
        return MyPatch.class;
    }

    @Override
    protected String getTableName()
    {
        return "patch";
    }

    @Override
    public MyPatchCriteria createCriteria()
    {
        return new MyPatchCriteria(createGenericCriteria());
    }

    protected MyMetaPatch getMeta()
    {
        return MyPatch.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPatch findName(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteName(String e)
    {
        MyPatch m = findName(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
