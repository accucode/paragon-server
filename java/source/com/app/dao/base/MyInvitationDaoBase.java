//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MyInvitationCriteria;
import com.app.model.MyInvitation;
import com.app.model.meta.MyMetaInvitation;

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
        return new MyInvitationCriteria(createGenericCriteria());
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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
