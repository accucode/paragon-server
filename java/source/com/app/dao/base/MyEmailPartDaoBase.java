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

import com.app.criteria.MyEmailPartCriteria;
import com.app.model.MyEmailPart;
import com.app.model.meta.MyMetaEmailPart;

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
