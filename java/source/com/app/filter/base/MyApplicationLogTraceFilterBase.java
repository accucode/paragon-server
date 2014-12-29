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

public abstract class MyApplicationLogTraceFilterBase
    extends MyBasicFilter<MyApplicationLogTrace>
    implements MyApplicationLogTraceDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyApplicationLogTrace> c)
    {
        applyConditionsTo((MyApplicationLogTraceCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyApplicationLogTrace> c)
    {
        applySortsTo((MyApplicationLogTraceCriteria)c);
    }

    protected abstract void applyConditionsTo(MyApplicationLogTraceCriteria c);

    protected abstract void applySortsTo(MyApplicationLogTraceCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaApplicationLogTrace getMeta()
    {
        return MyApplicationLogTrace.Meta;
    }

    @Override
    protected MyApplicationLogTraceDao getDao()
    {
        return getAccess().getApplicationLogTraceDao();
    }

    @Override
    protected MyApplicationLogTraceCriteria createCriteria()
    {
        return new MyApplicationLogTraceCriteria(createGenericCriteria());
    }
}
