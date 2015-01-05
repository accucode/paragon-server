//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyProjectCriteria;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;

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
        return new MyProjectCriteria(createGenericCriteria());
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
