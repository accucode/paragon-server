//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MySystemLogTraceCriteria;
import com.app.dao.MySystemLogTraceDao;
import com.app.dao.base.MySystemLogTraceDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MySystemLogTrace;
import com.app.model.meta.MyMetaSystemLogTrace;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MySystemLogTraceFilterBase
    extends MyBasicFilter<MySystemLogTrace>
    implements MySystemLogTraceDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySystemLogTrace> c)
    {
        applyConditionsTo((MySystemLogTraceCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySystemLogTrace> c)
    {
        applySortsTo((MySystemLogTraceCriteria)c);
    }

    protected abstract void applyConditionsTo(MySystemLogTraceCriteria c);

    protected abstract void applySortsTo(MySystemLogTraceCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSystemLogTrace getMeta()
    {
        return MySystemLogTrace.Meta;
    }

    @Override
    protected MySystemLogTraceDao getDao()
    {
        return getAccess().getSystemLogTraceDao();
    }

    @Override
    protected MySystemLogTraceCriteria createCriteria()
    {
        return new MySystemLogTraceCriteria(createGenericCriteria());
    }
}
