//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MyPatchCriteria;
import com.app.model.MyPatch;
import com.app.model.meta.MyMetaPatch;

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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
