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

import com.app.criteria.MyUserActivationCriteria;
import com.app.model.MyUserActivation;
import com.app.model.meta.MyMetaUserActivation;

public abstract class MyUserActivationDaoBase
    extends KmAbstractDao<MyUserActivation,String>
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUserActivation> getPersistentClass()
    {
        return MyUserActivation.class;
    }

    @Override
    protected String getTableName()
    {
        return "userActivation";
    }

    @Override
    public MyUserActivationCriteria createCriteria()
    {
        return new MyUserActivationCriteria(createGenericCriteria());
    }

    protected MyMetaUserActivation getMeta()
    {
        return MyUserActivation.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUserActivation findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUserActivation m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
