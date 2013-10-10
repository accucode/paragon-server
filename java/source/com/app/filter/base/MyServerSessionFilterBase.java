//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

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
