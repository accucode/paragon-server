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

public abstract class MyPerformanceLogDetailFilterBase
    extends MyBasicFilter<MyPerformanceLogDetail>
    implements MyPerformanceLogDetailDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyPerformanceLogDetail> c)
    {
        applyConditionsTo((MyPerformanceLogDetailCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyPerformanceLogDetail> c)
    {
        applySortsTo((MyPerformanceLogDetailCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPerformanceLogDetailCriteria c);

    protected abstract void applySortsTo(MyPerformanceLogDetailCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPerformanceLogDetail getMeta()
    {
        return MyPerformanceLogDetail.Meta;
    }

    @Override
    protected MyPerformanceLogDetailDao getDao()
    {
        return getAccess().getPerformanceLogDetailDao();
    }

    @Override
    protected MyPerformanceLogDetailCriteria createCriteria()
    {
        return new MyPerformanceLogDetailCriteria(_createCriteria());
    }
}
