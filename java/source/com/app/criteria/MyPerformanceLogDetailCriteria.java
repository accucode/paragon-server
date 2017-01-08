//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.basic.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.meta.*;

public class MyPerformanceLogDetailCriteria
    extends MyAbstractCriteria<MyPerformanceLogDetail>
    implements MyPerformanceLogDetailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetailCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhIntegerCondition whereDurationMs()
    {
        return new KmhIntegerCondition(context(), fullName(DURATION_MS));
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnCreatedUtcTs()
    {
        parent().sortAscending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTsDescending()
    {
        parent().sortDescending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnCreatedUtcTs();
        else
            sortOnCreatedUtcTsDescending();
    }

    public void sortOnName()
    {
        parent().sortAscending(NAME);
    }

    public void sortOnNameDescending()
    {
        parent().sortDescending(NAME);
    }

    public void sortOnName(boolean asc)
    {
        if ( asc )
            sortOnName();
        else
            sortOnNameDescending();
    }

    public void sortOnDurationMs()
    {
        parent().sortAscending(DURATION_MS);
    }

    public void sortOnDurationMsDescending()
    {
        parent().sortDescending(DURATION_MS);
    }

    public void sortOnDurationMs(boolean asc)
    {
        if ( asc )
            sortOnDurationMs();
        else
            sortOnDurationMsDescending();
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (createdUtcTs)
    //##################################################

    public void selectCreatedUtcTs()
    {
        select(CREATED_UTC_TS);
    }

    public void selectDistinctCreatedUtcTs()
    {
        selectDistinct(CREATED_UTC_TS);
    }

    public void selectCountDistinctCreatedUtcTs()
    {
        selectCountDistinct(CREATED_UTC_TS);
    }

    public void selectMinimumCreatedUtcTs()
    {
        selectMinimum(CREATED_UTC_TS);
    }

    public void selectMaximumCreatedUtcTs()
    {
        selectMaximum(CREATED_UTC_TS);
    }

    public void selectAverageCreatedUtcTs()
    {
        selectAverage(CREATED_UTC_TS);
    }

    public void selectSumCreatedUtcTs()
    {
        selectSum(CREATED_UTC_TS);
    }

    public void groupByCreatedUtcTs()
    {
        groupBy(CREATED_UTC_TS);
    }

    //##################################################
    //# projections (name)
    //##################################################

    public void selectName()
    {
        select(NAME);
    }

    public void selectDistinctName()
    {
        selectDistinct(NAME);
    }

    public void selectCountDistinctName()
    {
        selectCountDistinct(NAME);
    }

    public void selectMinimumName()
    {
        selectMinimum(NAME);
    }

    public void selectMaximumName()
    {
        selectMaximum(NAME);
    }

    public void selectAverageName()
    {
        selectAverage(NAME);
    }

    public void selectSumName()
    {
        selectSum(NAME);
    }

    public void groupByName()
    {
        groupBy(NAME);
    }

    //##################################################
    //# projections (durationMs)
    //##################################################

    public void selectDurationMs()
    {
        select(DURATION_MS);
    }

    public void selectDistinctDurationMs()
    {
        selectDistinct(DURATION_MS);
    }

    public void selectCountDistinctDurationMs()
    {
        selectCountDistinct(DURATION_MS);
    }

    public void selectMinimumDurationMs()
    {
        selectMinimum(DURATION_MS);
    }

    public void selectMaximumDurationMs()
    {
        selectMaximum(DURATION_MS);
    }

    public void selectAverageDurationMs()
    {
        selectAverage(DURATION_MS);
    }

    public void selectSumDurationMs()
    {
        selectSum(DURATION_MS);
    }

    public void groupByDurationMs()
    {
        groupBy(DURATION_MS);
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyPerformanceLogDetailJunction all()
    {
        return addAnd();
    }

    public MyPerformanceLogDetailJunction any()
    {
        return addOr();
    }

    public MyPerformanceLogDetailJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyPerformanceLogDetailJunction addNotAnd()
    {
        return new MyPerformanceLogDetailJunction(parent().addNotAnd());
    }

    public MyPerformanceLogDetailJunction addNotOr()
    {
        return new MyPerformanceLogDetailJunction(parent().addNotOr());
    }

    public MyPerformanceLogDetailJunction addAnd()
    {
        return new MyPerformanceLogDetailJunction(parent().addAnd());
    }

    public MyPerformanceLogDetailJunction addOr()
    {
        return new MyPerformanceLogDetailJunction(parent().addOr());
    }
}
