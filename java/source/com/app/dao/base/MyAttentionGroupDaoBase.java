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
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
        return new MyAttentionGroupCriteria(createGenericCriteria());
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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
