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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyPerformanceLogCriteria
    extends MyAbstractCriteria<MyPerformanceLog>
    implements MyPerformanceLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyPerformanceLogCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmIntegerCriteria whereId()
    {
        return new KmIntegerCriteria(context(), fullName(ID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmIntegerCriteria whereDurationMs()
    {
        return new KmIntegerCriteria(context(), fullName(DURATION_MS));
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnId()
    {
        parent().sortAscending(ID);
    }

    public void sortOnIdDescending()
    {
        parent().sortDescending(ID);
    }

    public void sortOnId(boolean asc)
    {
        if ( asc )
            sortOnId();
        else
            sortOnIdDescending();
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
    //# projections (id)
    //##################################################

    public void selectId()
    {
        select(ID);
    }

    public void selectDistinctId()
    {
        selectDistinct(ID);
    }

    public void selectCountDistinctId()
    {
        selectCountDistinct(ID);
    }

    public void selectMinimumId()
    {
        selectMinimum(ID);
    }

    public void selectMaximumId()
    {
        selectMaximum(ID);
    }

    public void selectAverageId()
    {
        selectAverage(ID);
    }

    public void selectSumId()
    {
        selectSum(ID);
    }

    public void groupById()
    {
        groupBy(ID);
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
    //# junction
    //##################################################

    public MyPerformanceLogJunction addAnd()
    {
        return new MyPerformanceLogJunction(parent().addAnd());
    }

    public MyPerformanceLogJunction addOr()
    {
        return new MyPerformanceLogJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyPerformanceLogCriteria createOn(KmModelJunction junction)
    {
        return new MyPerformanceLogCriteria(parent(), junction.context());
    }

}
