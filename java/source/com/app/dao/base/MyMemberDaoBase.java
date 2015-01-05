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

import com.app.criteria.MyMemberCriteria;
import com.app.model.MyMember;
import com.app.model.meta.MyMetaMember;

public abstract class MyMemberDaoBase
    extends KmAbstractDao<MyMember,String>
    implements MyMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyMember> getPersistentClass()
    {
        return MyMember.class;
    }

    @Override
    protected String getTableName()
    {
        return "member";
    }

    @Override
    public MyMemberCriteria createCriteria()
    {
        return new MyMemberCriteria(createGenericCriteria());
    }

    protected MyMetaMember getMeta()
    {
        return MyMember.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyMember findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyMember m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
