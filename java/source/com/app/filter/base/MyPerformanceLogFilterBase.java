//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MyPerformanceLogCriteria;
import com.app.dao.MyPerformanceLogDao;
import com.app.dao.base.MyPerformanceLogDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyPerformanceLog;
import com.app.model.meta.MyMetaPerformanceLog;

public abstract class MyPerformanceLogFilterBase
    extends MyBasicFilter<MyPerformanceLog>
    implements MyPerformanceLogDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyPerformanceLog> c)
    {
        applyConditionsTo((MyPerformanceLogCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyPerformanceLog> c)
    {
        applySortsTo((MyPerformanceLogCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPerformanceLogCriteria c);

    protected abstract void applySortsTo(MyPerformanceLogCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPerformanceLog getMeta()
    {
        return MyPerformanceLog.Meta;
    }

    @Override
    protected MyPerformanceLogDao getDao()
    {
        return getAccess().getPerformanceLogDao();
    }

    @Override
    protected MyPerformanceLogCriteria createCriteria()
    {
        return new MyPerformanceLogCriteria(createGenericCriteria());
    }
}
