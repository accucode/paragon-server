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

public abstract class MyInvitationDaoBase
    extends KmAbstractDao<MyInvitation,String>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitationDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyInvitation> getPersistentClass()
    {
        return MyInvitation.class;
    }

    @Override
    protected String getTableName()
    {
        return "invitation";
    }

    @Override
    public MyInvitationCriteria createCriteria()
    {
        return new MyInvitationCriteria(_createCriteria());
    }

    @Override
    public MyInvitationCriteria createDetachedCriteria(String alias)
    {
        return new MyInvitationCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaInvitation getMeta()
    {
        return MyInvitation.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyInvitation findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyInvitation m = findUid(e);

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
