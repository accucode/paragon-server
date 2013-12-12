//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MyServerSessionCriteria;
import com.app.dao.MyServerSessionDao;
import com.app.dao.base.MyServerSessionDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyServerSession;
import com.app.model.meta.MyMetaServerSession;

public abstract class MyServerSessionFilterBase
    extends MyBasicFilter<MyServerSession>
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyServerSession> c)
    {
        applyConditionsTo((MyServerSessionCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyServerSession> c)
    {
        applySortsTo((MyServerSessionCriteria)c);
    }

    protected abstract void applyConditionsTo(MyServerSessionCriteria c);

    protected abstract void applySortsTo(MyServerSessionCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaServerSession getMeta()
    {
        return MyServerSession.Meta;
    }

    @Override
    protected MyServerSessionDao getDao()
    {
        return getAccess().getServerSessionDao();
    }

    @Override
    protected MyServerSessionCriteria createCriteria()
    {
        return new MyServerSessionCriteria(createGenericCriteria());
    }
}
