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
