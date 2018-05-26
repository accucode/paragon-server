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

public class MyPerformanceLogSummaryCriteria
    extends MyAbstractCriteria<MyPerformanceLogSummary>
    implements MyPerformanceLogSummaryDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyPerformanceLogSummary e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyPerformanceLogSummary e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhIntegerCondition whereAverageMs()
    {
        return new KmhIntegerCondition(context(), alias(), AVERAGE_MS);
    }

    public KmhIntegerCondition whereCount()
    {
        return new KmhIntegerCondition(context(), alias(), COUNT);
    }

    public KmhIntegerCondition whereMaximumMs()
    {
        return new KmhIntegerCondition(context(), alias(), MAXIMUM_MS);
    }

    public KmhIntegerCondition whereMinimumMs()
    {
        return new KmhIntegerCondition(context(), alias(), MINIMUM_MS);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhIntegerCondition whereTotalMs()
    {
        return new KmhIntegerCondition(context(), alias(), TOTAL_MS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhDateCondition whereUtcDate()
    {
        return new KmhDateCondition(context(), alias(), UTC_DATE);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnAverageMs()
    {
        parent().sortAscending(AVERAGE_MS);
    }

    public void sortOnAverageMsDescending()
    {
        parent().sortDescending(AVERAGE_MS);
    }

    public void sortOnAverageMs(boolean asc)
    {
        if ( asc )
            sortOnAverageMs();
        else
            sortOnAverageMsDescending();
    }

    public void sortOnCount()
    {
        parent().sortAscending(COUNT);
    }

    public void sortOnCountDescending()
    {
        parent().sortDescending(COUNT);
    }

    public void sortOnCount(boolean asc)
    {
        if ( asc )
            sortOnCount();
        else
            sortOnCountDescending();
    }

    public void sortOnMaximumMs()
    {
        parent().sortAscending(MAXIMUM_MS);
    }

    public void sortOnMaximumMsDescending()
    {
        parent().sortDescending(MAXIMUM_MS);
    }

    public void sortOnMaximumMs(boolean asc)
    {
        if ( asc )
            sortOnMaximumMs();
        else
            sortOnMaximumMsDescending();
    }

    public void sortOnMinimumMs()
    {
        parent().sortAscending(MINIMUM_MS);
    }

    public void sortOnMinimumMsDescending()
    {
        parent().sortDescending(MINIMUM_MS);
    }

    public void sortOnMinimumMs(boolean asc)
    {
        if ( asc )
            sortOnMinimumMs();
        else
            sortOnMinimumMsDescending();
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

    public void sortOnTotalMs()
    {
        parent().sortAscending(TOTAL_MS);
    }

    public void sortOnTotalMsDescending()
    {
        parent().sortDescending(TOTAL_MS);
    }

    public void sortOnTotalMs(boolean asc)
    {
        if ( asc )
            sortOnTotalMs();
        else
            sortOnTotalMsDescending();
    }

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

    public void sortOnUtcDate()
    {
        parent().sortAscending(UTC_DATE);
    }

    public void sortOnUtcDateDescending()
    {
        parent().sortDescending(UTC_DATE);
    }

    public void sortOnUtcDate(boolean asc)
    {
        if ( asc )
            sortOnUtcDate();
        else
            sortOnUtcDateDescending();
    }

    //##################################################
    //# projections (averageMs)
    //##################################################

    public void selectAverageMs()
    {
        select(AVERAGE_MS);
    }

    public void selectDistinctAverageMs()
    {
        selectDistinct(AVERAGE_MS);
    }

    public void selectCountDistinctAverageMs()
    {
        selectCountDistinct(AVERAGE_MS);
    }

    public void selectMinimumAverageMs()
    {
        selectMinimum(AVERAGE_MS);
    }

    public void selectMaximumAverageMs()
    {
        selectMaximum(AVERAGE_MS);
    }

    public void selectAverageAverageMs()
    {
        selectAverage(AVERAGE_MS);
    }

    public void selectSumAverageMs()
    {
        selectSum(AVERAGE_MS);
    }

    public void groupByAverageMs()
    {
        groupBy(AVERAGE_MS);
    }

    //##################################################
    //# projections (count)
    //##################################################

    public void selectCount()
    {
        select(COUNT);
    }

    public void selectDistinctCount()
    {
        selectDistinct(COUNT);
    }

    public void selectCountDistinctCount()
    {
        selectCountDistinct(COUNT);
    }

    public void selectMinimumCount()
    {
        selectMinimum(COUNT);
    }

    public void selectMaximumCount()
    {
        selectMaximum(COUNT);
    }

    public void selectAverageCount()
    {
        selectAverage(COUNT);
    }

    public void selectSumCount()
    {
        selectSum(COUNT);
    }

    public void groupByCount()
    {
        groupBy(COUNT);
    }

    //##################################################
    //# projections (maximumMs)
    //##################################################

    public void selectMaximumMs()
    {
        select(MAXIMUM_MS);
    }

    public void selectDistinctMaximumMs()
    {
        selectDistinct(MAXIMUM_MS);
    }

    public void selectCountDistinctMaximumMs()
    {
        selectCountDistinct(MAXIMUM_MS);
    }

    public void selectMinimumMaximumMs()
    {
        selectMinimum(MAXIMUM_MS);
    }

    public void selectMaximumMaximumMs()
    {
        selectMaximum(MAXIMUM_MS);
    }

    public void selectAverageMaximumMs()
    {
        selectAverage(MAXIMUM_MS);
    }

    public void selectSumMaximumMs()
    {
        selectSum(MAXIMUM_MS);
    }

    public void groupByMaximumMs()
    {
        groupBy(MAXIMUM_MS);
    }

    //##################################################
    //# projections (minimumMs)
    //##################################################

    public void selectMinimumMs()
    {
        select(MINIMUM_MS);
    }

    public void selectDistinctMinimumMs()
    {
        selectDistinct(MINIMUM_MS);
    }

    public void selectCountDistinctMinimumMs()
    {
        selectCountDistinct(MINIMUM_MS);
    }

    public void selectMinimumMinimumMs()
    {
        selectMinimum(MINIMUM_MS);
    }

    public void selectMaximumMinimumMs()
    {
        selectMaximum(MINIMUM_MS);
    }

    public void selectAverageMinimumMs()
    {
        selectAverage(MINIMUM_MS);
    }

    public void selectSumMinimumMs()
    {
        selectSum(MINIMUM_MS);
    }

    public void groupByMinimumMs()
    {
        groupBy(MINIMUM_MS);
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
    //# projections (totalMs)
    //##################################################

    public void selectTotalMs()
    {
        select(TOTAL_MS);
    }

    public void selectDistinctTotalMs()
    {
        selectDistinct(TOTAL_MS);
    }

    public void selectCountDistinctTotalMs()
    {
        selectCountDistinct(TOTAL_MS);
    }

    public void selectMinimumTotalMs()
    {
        selectMinimum(TOTAL_MS);
    }

    public void selectMaximumTotalMs()
    {
        selectMaximum(TOTAL_MS);
    }

    public void selectAverageTotalMs()
    {
        selectAverage(TOTAL_MS);
    }

    public void selectSumTotalMs()
    {
        selectSum(TOTAL_MS);
    }

    public void groupByTotalMs()
    {
        groupBy(TOTAL_MS);
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
    //# projections (utcDate)
    //##################################################

    public void selectUtcDate()
    {
        select(UTC_DATE);
    }

    public void selectDistinctUtcDate()
    {
        selectDistinct(UTC_DATE);
    }

    public void selectCountDistinctUtcDate()
    {
        selectCountDistinct(UTC_DATE);
    }

    public void selectMinimumUtcDate()
    {
        selectMinimum(UTC_DATE);
    }

    public void selectMaximumUtcDate()
    {
        selectMaximum(UTC_DATE);
    }

    public void selectAverageUtcDate()
    {
        selectAverage(UTC_DATE);
    }

    public void selectSumUtcDate()
    {
        selectSum(UTC_DATE);
    }

    public void groupByUtcDate()
    {
        groupBy(UTC_DATE);
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyPerformanceLogSummaryJunction all()
    {
        return addAnd();
    }

    public MyPerformanceLogSummaryJunction any()
    {
        return addOr();
    }

    public MyPerformanceLogSummaryJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyPerformanceLogSummaryJunction addNotAnd()
    {
        return new MyPerformanceLogSummaryJunction(parent().addNotAnd());
    }

    public MyPerformanceLogSummaryJunction addNotOr()
    {
        return new MyPerformanceLogSummaryJunction(parent().addNotOr());
    }

    public MyPerformanceLogSummaryJunction addAnd()
    {
        return new MyPerformanceLogSummaryJunction(parent().addAnd());
    }

    public MyPerformanceLogSummaryJunction addOr()
    {
        return new MyPerformanceLogSummaryJunction(parent().addOr());
    }
}
