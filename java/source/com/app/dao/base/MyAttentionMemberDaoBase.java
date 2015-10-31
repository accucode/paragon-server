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
import com.app.utility.*;

public abstract class MyAttentionMemberDaoBase
    extends KmAbstractDao<MyAttentionMember,String>
    implements MyAttentionMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttentionMemberDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAttentionMember> getPersistentClass()
    {
        return MyAttentionMember.class;
    }

    @Override
    protected String getTableName()
    {
        return "attentionMember";
    }

    @Override
    public MyAttentionMemberCriteria createCriteria()
    {
        return new MyAttentionMemberCriteria(_createCriteria());
    }

    @Override
    public MyAttentionMemberCriteria createDetachedCriteria(String alias)
    {
        return new MyAttentionMemberCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAttentionMember getMeta()
    {
        return MyAttentionMember.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAttentionMember findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAttentionMember m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
