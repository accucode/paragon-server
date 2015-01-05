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

import com.app.criteria.MyCategoryCriteria;
import com.app.model.MyCategory;
import com.app.model.meta.MyMetaCategory;

public abstract class MyCategoryDaoBase
    extends KmAbstractDao<MyCategory,String>
    implements MyCategoryDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCategoryDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyCategory> getPersistentClass()
    {
        return MyCategory.class;
    }

    @Override
    protected String getTableName()
    {
        return "category";
    }

    @Override
    public MyCategoryCriteria createCriteria()
    {
        return new MyCategoryCriteria(createGenericCriteria());
    }

    protected MyMetaCategory getMeta()
    {
        return MyCategory.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyCategory findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyCategory m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
