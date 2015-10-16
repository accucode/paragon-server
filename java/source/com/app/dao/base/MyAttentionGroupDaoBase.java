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

public abstract class MyAttentionGroupDaoBase
    extends KmAbstractDao<MyAttentionGroup,String>
    implements MyAttentionGroupDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttentionGroupDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAttentionGroup> getPersistentClass()
    {
        return MyAttentionGroup.class;
    }

    @Override
    protected String getTableName()
    {
        return "attentionGroup";
    }

    @Override
    public MyAttentionGroupCriteria createCriteria()
    {
        return new MyAttentionGroupCriteria(_createCriteria());
    }

    @Override
    public MyAttentionGroupCriteria createDetachedCriteria(String alias)
    {
        return new MyAttentionGroupCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAttentionGroup getMeta()
    {
        return MyAttentionGroup.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAttentionGroup findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAttentionGroup m = findUid(e);

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
