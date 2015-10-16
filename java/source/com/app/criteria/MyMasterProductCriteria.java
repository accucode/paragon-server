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

public class MyMasterProductCriteria
    extends MyAbstractCriteria<MyMasterProduct>
    implements MyMasterProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMasterProductCriteria(KmhCriteria parent)
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

    public KmhStringCondition wherePartNumber()
    {
        return new KmhStringCondition(context(), fullName(PART_NUMBER));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
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

    public void sortOnPartNumber()
    {
        parent().sortAscending(PART_NUMBER);
    }

    public void sortOnPartNumberDescending()
    {
        parent().sortDescending(PART_NUMBER);
    }

    public void sortOnPartNumber(boolean asc)
    {
        if ( asc )
            sortOnPartNumber();
        else
            sortOnPartNumberDescending();
    }

    public void sortOnActive()
    {
        parent().sortAscending(ACTIVE);
    }

    public void sortOnActiveDescending()
    {
        parent().sortDescending(ACTIVE);
    }

    public void sortOnActive(boolean asc)
    {
        if ( asc )
            sortOnActive();
        else
            sortOnActiveDescending();
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
    //# projections (partNumber)
    //##################################################

    public void selectPartNumber()
    {
        select(PART_NUMBER);
    }

    public void selectDistinctPartNumber()
    {
        selectDistinct(PART_NUMBER);
    }

    public void selectCountDistinctPartNumber()
    {
        selectCountDistinct(PART_NUMBER);
    }

    public void selectMinimumPartNumber()
    {
        selectMinimum(PART_NUMBER);
    }

    public void selectMaximumPartNumber()
    {
        selectMaximum(PART_NUMBER);
    }

    public void selectAveragePartNumber()
    {
        selectAverage(PART_NUMBER);
    }

    public void selectSumPartNumber()
    {
        selectSum(PART_NUMBER);
    }

    public void groupByPartNumber()
    {
        groupBy(PART_NUMBER);
    }

    //##################################################
    //# projections (active)
    //##################################################

    public void selectActive()
    {
        select(ACTIVE);
    }

    public void selectDistinctActive()
    {
        selectDistinct(ACTIVE);
    }

    public void selectCountDistinctActive()
    {
        selectCountDistinct(ACTIVE);
    }

    public void selectMinimumActive()
    {
        selectMinimum(ACTIVE);
    }

    public void selectMaximumActive()
    {
        selectMaximum(ACTIVE);
    }

    public void selectAverageActive()
    {
        selectAverage(ACTIVE);
    }

    public void selectSumActive()
    {
        selectSum(ACTIVE);
    }

    public void groupByActive()
    {
        groupBy(ACTIVE);
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
    //# association (PublishedVersion)
    //##################################################

    public void selectPublishedVersionUid()
    {
        select(PUBLISHED_VERSION_UID);
    }

    public void selectMinimumPublishedVersionUid()
    {
        selectMinimum(PUBLISHED_VERSION_UID);
    }

    public void selectMaximumPublishedVersionUid()
    {
        selectMaximum(PUBLISHED_VERSION_UID);
    }

    public void groupByPublishedVersionUid()
    {
        groupBy(PUBLISHED_VERSION);
    }

    public MyProductCriteria joinToPublishedVersion()
    {
        return new MyProductCriteria(joinTo(PUBLISHED_VERSION));
    }

    public MyProductCriteria leftJoinToPublishedVersion()
    {
        return new MyProductCriteria(leftJoinTo(PUBLISHED_VERSION));
    }

    public KmhStringCondition wherePublishedVersionUid()
    {
        return new KmhStringCondition(parent(), fullName(PUBLISHED_VERSION_UID));
    }

    public void wherePublishedVersionIs(MyProduct e)
    {
        if ( e == null )
            wherePublishedVersionUid().isNull();
        else
            wherePublishedVersionUid().is(e.getUid());
    }

    //##################################################
    //# association (DraftVersion)
    //##################################################

    public void selectDraftVersionUid()
    {
        select(DRAFT_VERSION_UID);
    }

    public void selectMinimumDraftVersionUid()
    {
        selectMinimum(DRAFT_VERSION_UID);
    }

    public void selectMaximumDraftVersionUid()
    {
        selectMaximum(DRAFT_VERSION_UID);
    }

    public void groupByDraftVersionUid()
    {
        groupBy(DRAFT_VERSION);
    }

    public MyProductCriteria joinToDraftVersion()
    {
        return new MyProductCriteria(joinTo(DRAFT_VERSION));
    }

    public MyProductCriteria leftJoinToDraftVersion()
    {
        return new MyProductCriteria(leftJoinTo(DRAFT_VERSION));
    }

    public KmhStringCondition whereDraftVersionUid()
    {
        return new KmhStringCondition(parent(), fullName(DRAFT_VERSION_UID));
    }

    public void whereDraftVersionIs(MyProduct e)
    {
        if ( e == null )
            whereDraftVersionUid().isNull();
        else
            whereDraftVersionUid().is(e.getUid());
    }

    //##################################################
    //# collection (Versions)
    //##################################################

    public MyProductCriteria joinToVersions()
    {
        return new MyProductCriteria(joinTo(VERSIONS));
    }

    public MyProductCriteria leftJoinToVersions()
    {
        return new MyProductCriteria(leftJoinTo(VERSIONS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyMasterProductJunction addAnd()
    {
        return new MyMasterProductJunction(parent().addAnd());
    }

    public MyMasterProductJunction addOr()
    {
        return new MyMasterProductJunction(parent().addOr());
    }
}
