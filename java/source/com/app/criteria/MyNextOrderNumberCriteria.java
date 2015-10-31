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
import com.app.model.meta.*;

public class MyNextOrderNumberCriteria
    extends MyAbstractCriteria<MyNextOrderNumber>
    implements MyNextOrderNumberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyNextOrderNumberCriteria(KmhCriteria parent)
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

    public KmhDateCondition whereDate()
    {
        return new KmhDateCondition(context(), fullName(DATE));
    }

    public KmhIntegerCondition whereNextNumber()
    {
        return new KmhIntegerCondition(context(), fullName(NEXT_NUMBER));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
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

    public void sortOnDate()
    {
        parent().sortAscending(DATE);
    }

    public void sortOnDateDescending()
    {
        parent().sortDescending(DATE);
    }

    public void sortOnDate(boolean asc)
    {
        if ( asc )
            sortOnDate();
        else
            sortOnDateDescending();
    }

    public void sortOnNextNumber()
    {
        parent().sortAscending(NEXT_NUMBER);
    }

    public void sortOnNextNumberDescending()
    {
        parent().sortDescending(NEXT_NUMBER);
    }

    public void sortOnNextNumber(boolean asc)
    {
        if ( asc )
            sortOnNextNumber();
        else
            sortOnNextNumberDescending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
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
    //# projections (date)
    //##################################################

    public void selectDate()
    {
        select(DATE);
    }

    public void selectDistinctDate()
    {
        selectDistinct(DATE);
    }

    public void selectCountDistinctDate()
    {
        selectCountDistinct(DATE);
    }

    public void selectMinimumDate()
    {
        selectMinimum(DATE);
    }

    public void selectMaximumDate()
    {
        selectMaximum(DATE);
    }

    public void selectAverageDate()
    {
        selectAverage(DATE);
    }

    public void selectSumDate()
    {
        selectSum(DATE);
    }

    public void groupByDate()
    {
        groupBy(DATE);
    }

    //##################################################
    //# projections (nextNumber)
    //##################################################

    public void selectNextNumber()
    {
        select(NEXT_NUMBER);
    }

    public void selectDistinctNextNumber()
    {
        selectDistinct(NEXT_NUMBER);
    }

    public void selectCountDistinctNextNumber()
    {
        selectCountDistinct(NEXT_NUMBER);
    }

    public void selectMinimumNextNumber()
    {
        selectMinimum(NEXT_NUMBER);
    }

    public void selectMaximumNextNumber()
    {
        selectMaximum(NEXT_NUMBER);
    }

    public void selectAverageNextNumber()
    {
        selectAverage(NEXT_NUMBER);
    }

    public void selectSumNextNumber()
    {
        selectSum(NEXT_NUMBER);
    }

    public void groupByNextNumber()
    {
        groupBy(NEXT_NUMBER);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectMinimumProjectUid()
    {
        selectMinimum(PROJECT_UID);
    }

    public void selectMaximumProjectUid()
    {
        selectMaximum(PROJECT_UID);
    }

    public void groupByProjectUid()
    {
        groupBy(PROJECT);
    }

    public MyProjectCriteria joinToProject()
    {
        return new MyProjectCriteria(joinTo(PROJECT));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECT));
    }

    public KmhStringCondition whereProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(PROJECT_UID));
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyNextOrderNumberJunction addAnd()
    {
        return new MyNextOrderNumberJunction(parent().addAnd());
    }

    public MyNextOrderNumberJunction addOr()
    {
        return new MyNextOrderNumberJunction(parent().addOr());
    }
}
