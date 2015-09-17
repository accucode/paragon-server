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
        return new MyMemberCriteria(_createCriteria());
    }

    @Override
    public MyMemberCriteria createDetachedCriteria(String alias)
    {
        return new MyMemberCriteria(_createDetachedCriteria(alias));
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
