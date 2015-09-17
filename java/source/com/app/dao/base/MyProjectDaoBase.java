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

public abstract class MyProjectDaoBase
    extends KmAbstractDao<MyProject,String>
    implements MyProjectDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyProject> getPersistentClass()
    {
        return MyProject.class;
    }

    @Override
    protected String getTableName()
    {
        return "project";
    }

    @Override
    public MyProjectCriteria createCriteria()
    {
        return new MyProjectCriteria(_createCriteria());
    }

    @Override
    public MyProjectCriteria createDetachedCriteria(String alias)
    {
        return new MyProjectCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaProject getMeta()
    {
        return MyProject.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyProject findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyProject m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
