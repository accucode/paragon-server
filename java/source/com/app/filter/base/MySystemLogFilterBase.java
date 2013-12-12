//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MySystemLogCriteria;
import com.app.dao.MySystemLogDao;
import com.app.dao.base.MySystemLogDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MySystemLog;
import com.app.model.meta.MyMetaSystemLog;

public abstract class MySystemLogFilterBase
    extends MyBasicFilter<MySystemLog>
    implements MySystemLogDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySystemLog> c)
    {
        applyConditionsTo((MySystemLogCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySystemLog> c)
    {
        applySortsTo((MySystemLogCriteria)c);
    }

    protected abstract void applyConditionsTo(MySystemLogCriteria c);

    protected abstract void applySortsTo(MySystemLogCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSystemLog getMeta()
    {
        return MySystemLog.Meta;
    }

    @Override
    protected MySystemLogDao getDao()
    {
        return getAccess().getSystemLogDao();
    }

    @Override
    protected MySystemLogCriteria createCriteria()
    {
        return new MySystemLogCriteria(createGenericCriteria());
    }
}
