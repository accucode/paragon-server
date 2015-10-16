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

public abstract class MyAttributeFieldDaoBase
    extends KmAbstractDao<MyAttributeField,String>
    implements MyAttributeFieldDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeFieldDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAttributeField> getPersistentClass()
    {
        return MyAttributeField.class;
    }

    @Override
    protected String getTableName()
    {
        return "attributeField";
    }

    @Override
    public MyAttributeFieldCriteria createCriteria()
    {
        return new MyAttributeFieldCriteria(_createCriteria());
    }

    @Override
    public MyAttributeFieldCriteria createDetachedCriteria(String alias)
    {
        return new MyAttributeFieldCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAttributeField getMeta()
    {
        return MyAttributeField.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAttributeField findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAttributeField m = findUid(e);

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
