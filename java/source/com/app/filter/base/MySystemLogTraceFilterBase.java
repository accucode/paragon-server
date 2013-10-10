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
