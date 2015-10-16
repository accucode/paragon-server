//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyPerformanceLogSummaryFilterBase
    extends MyBasicFilter<MyPerformanceLogSummary>
    implements MyPerformanceLogSummaryDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyPerformanceLogSummary> c)
    {
        applyConditionsTo((MyPerformanceLogSummaryCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyPerformanceLogSummary> c)
    {
        applySortsTo((MyPerformanceLogSummaryCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPerformanceLogSummaryCriteria c);

    protected abstract void applySortsTo(MyPerformanceLogSummaryCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPerformanceLogSummary getMeta()
    {
        return MyPerformanceLogSummary.Meta;
    }

    @Override
    protected MyPerformanceLogSummaryDao getDao()
    {
        return getAccess().getPerformanceLogSummaryDao();
    }

    @Override
    protected MyPerformanceLogSummaryCriteria createCriteria()
    {
        return new MyPerformanceLogSummaryCriteria(_createCriteria());
    }
}
