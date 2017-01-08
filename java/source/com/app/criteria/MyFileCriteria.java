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

public class MyFileCriteria
    extends MyAbstractCriteria<MyFile>
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFileCriteria(KmhCriteria parent)
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

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UPDATED_UTC_TS));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition wherePath()
    {
        return new KmhStringCondition(context(), fullName(PATH));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public void whereStatusIs(MyFileStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MyFileStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsNew()
    {
        whereStatusIs(MyFileStatus.New);
    }

    public void whereStatusIsNotNew()
    {
        whereStatusIsNot(MyFileStatus.New);
    }

    public void whereStatusIsNew(boolean e)
    {
        if ( e )
            whereStatusIsNew();
        else
            whereStatusIsNotNew();
    }

    public void whereStatusIsReady()
    {
        whereStatusIs(MyFileStatus.Ready);
    }

    public void whereStatusIsNotReady()
    {
        whereStatusIsNot(MyFileStatus.Ready);
    }

    public void whereStatusIsReady(boolean e)
    {
        if ( e )
            whereStatusIsReady();
        else
            whereStatusIsNotReady();
    }

    public void whereStatusIsDeleted()
    {
        whereStatusIs(MyFileStatus.Deleted);
    }

    public void whereStatusIsNotDeleted()
    {
        whereStatusIsNot(MyFileStatus.Deleted);
    }

    public void whereStatusIsDeleted(boolean e)
    {
        if ( e )
            whereStatusIsDeleted();
        else
            whereStatusIsNotDeleted();
    }

    public void whereStatusIsError()
    {
        whereStatusIs(MyFileStatus.Error);
    }

    public void whereStatusIsNotError()
    {
        whereStatusIsNot(MyFileStatus.Error);
    }

    public void whereStatusIsError(boolean e)
    {
        if ( e )
            whereStatusIsError();
        else
            whereStatusIsNotError();
    }

    public KmhIntegerCondition whereSize()
    {
        return new KmhIntegerCondition(context(), fullName(SIZE));
    }

    public KmhIntegerCondition wherePartialSize()
    {
        return new KmhIntegerCondition(context(), fullName(PARTIAL_SIZE));
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

    public void sortOnUpdatedUtcTs()
    {
        parent().sortAscending(UPDATED_UTC_TS);
    }

    public void sortOnUpdatedUtcTsDescending()
    {
        parent().sortDescending(UPDATED_UTC_TS);
    }

    public void sortOnUpdatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnUpdatedUtcTs();
        else
            sortOnUpdatedUtcTsDescending();
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

    public void sortOnPath()
    {
        parent().sortAscending(PATH);
    }

    public void sortOnPathDescending()
    {
        parent().sortDescending(PATH);
    }

    public void sortOnPath(boolean asc)
    {
        if ( asc )
            sortOnPath();
        else
            sortOnPathDescending();
    }

    public void sortOnStatusCode()
    {
        parent().sortAscending(STATUS_CODE);
    }

    public void sortOnStatusCodeDescending()
    {
        parent().sortDescending(STATUS_CODE);
    }

    public void sortOnStatusCode(boolean asc)
    {
        if ( asc )
            sortOnStatusCode();
        else
            sortOnStatusCodeDescending();
    }

    public void sortOnSize()
    {
        parent().sortAscending(SIZE);
    }

    public void sortOnSizeDescending()
    {
        parent().sortDescending(SIZE);
    }

    public void sortOnSize(boolean asc)
    {
        if ( asc )
            sortOnSize();
        else
            sortOnSizeDescending();
    }

    public void sortOnPartialSize()
    {
        parent().sortAscending(PARTIAL_SIZE);
    }

    public void sortOnPartialSizeDescending()
    {
        parent().sortDescending(PARTIAL_SIZE);
    }

    public void sortOnPartialSize(boolean asc)
    {
        if ( asc )
            sortOnPartialSize();
        else
            sortOnPartialSizeDescending();
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
    //# projections (updatedUtcTs)
    //##################################################

    public void selectUpdatedUtcTs()
    {
        select(UPDATED_UTC_TS);
    }

    public void selectDistinctUpdatedUtcTs()
    {
        selectDistinct(UPDATED_UTC_TS);
    }

    public void selectCountDistinctUpdatedUtcTs()
    {
        selectCountDistinct(UPDATED_UTC_TS);
    }

    public void selectMinimumUpdatedUtcTs()
    {
        selectMinimum(UPDATED_UTC_TS);
    }

    public void selectMaximumUpdatedUtcTs()
    {
        selectMaximum(UPDATED_UTC_TS);
    }

    public void selectAverageUpdatedUtcTs()
    {
        selectAverage(UPDATED_UTC_TS);
    }

    public void selectSumUpdatedUtcTs()
    {
        selectSum(UPDATED_UTC_TS);
    }

    public void groupByUpdatedUtcTs()
    {
        groupBy(UPDATED_UTC_TS);
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
    //# projections (path)
    //##################################################

    public void selectPath()
    {
        select(PATH);
    }

    public void selectDistinctPath()
    {
        selectDistinct(PATH);
    }

    public void selectCountDistinctPath()
    {
        selectCountDistinct(PATH);
    }

    public void selectMinimumPath()
    {
        selectMinimum(PATH);
    }

    public void selectMaximumPath()
    {
        selectMaximum(PATH);
    }

    public void selectAveragePath()
    {
        selectAverage(PATH);
    }

    public void selectSumPath()
    {
        selectSum(PATH);
    }

    public void groupByPath()
    {
        groupBy(PATH);
    }

    //##################################################
    //# projections (statusCode)
    //##################################################

    public void selectStatusCode()
    {
        select(STATUS_CODE);
    }

    public void selectDistinctStatusCode()
    {
        selectDistinct(STATUS_CODE);
    }

    public void selectCountDistinctStatusCode()
    {
        selectCountDistinct(STATUS_CODE);
    }

    public void selectMinimumStatusCode()
    {
        selectMinimum(STATUS_CODE);
    }

    public void selectMaximumStatusCode()
    {
        selectMaximum(STATUS_CODE);
    }

    public void selectAverageStatusCode()
    {
        selectAverage(STATUS_CODE);
    }

    public void selectSumStatusCode()
    {
        selectSum(STATUS_CODE);
    }

    public void groupByStatusCode()
    {
        groupBy(STATUS_CODE);
    }

    //##################################################
    //# projections (size)
    //##################################################

    public void selectSize()
    {
        select(SIZE);
    }

    public void selectDistinctSize()
    {
        selectDistinct(SIZE);
    }

    public void selectCountDistinctSize()
    {
        selectCountDistinct(SIZE);
    }

    public void selectMinimumSize()
    {
        selectMinimum(SIZE);
    }

    public void selectMaximumSize()
    {
        selectMaximum(SIZE);
    }

    public void selectAverageSize()
    {
        selectAverage(SIZE);
    }

    public void selectSumSize()
    {
        selectSum(SIZE);
    }

    public void groupBySize()
    {
        groupBy(SIZE);
    }

    //##################################################
    //# projections (partialSize)
    //##################################################

    public void selectPartialSize()
    {
        select(PARTIAL_SIZE);
    }

    public void selectDistinctPartialSize()
    {
        selectDistinct(PARTIAL_SIZE);
    }

    public void selectCountDistinctPartialSize()
    {
        selectCountDistinct(PARTIAL_SIZE);
    }

    public void selectMinimumPartialSize()
    {
        selectMinimum(PARTIAL_SIZE);
    }

    public void selectMaximumPartialSize()
    {
        selectMaximum(PARTIAL_SIZE);
    }

    public void selectAveragePartialSize()
    {
        selectAverage(PARTIAL_SIZE);
    }

    public void selectSumPartialSize()
    {
        selectSum(PARTIAL_SIZE);
    }

    public void groupByPartialSize()
    {
        groupBy(PARTIAL_SIZE);
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
    //# association (CreatedBy)
    //##################################################

    public void selectCreatedByUid()
    {
        select(CREATED_BY_UID);
    }

    public void selectMinimumCreatedByUid()
    {
        selectMinimum(CREATED_BY_UID);
    }

    public void selectMaximumCreatedByUid()
    {
        selectMaximum(CREATED_BY_UID);
    }

    public void groupByCreatedByUid()
    {
        groupBy(CREATED_BY_UID);
    }

    public MyUserCriteria joinToCreatedBy()
    {
        return new MyUserCriteria(joinTo(CREATED_BY));
    }

    public MyUserCriteria leftJoinToCreatedBy()
    {
        return new MyUserCriteria(leftJoinTo(CREATED_BY));
    }

    public KmhStringCondition whereCreatedByUid()
    {
        return new KmhStringCondition(parent(), fullName(CREATED_BY_UID));
    }

    public void whereCreatedByIs(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNull();
        else
            whereCreatedByUid().is(e.getUid());
    }

    //##################################################
    //# association (UpdatedBy)
    //##################################################

    public void selectUpdatedByUid()
    {
        select(UPDATED_BY_UID);
    }

    public void selectMinimumUpdatedByUid()
    {
        selectMinimum(UPDATED_BY_UID);
    }

    public void selectMaximumUpdatedByUid()
    {
        selectMaximum(UPDATED_BY_UID);
    }

    public void groupByUpdatedByUid()
    {
        groupBy(UPDATED_BY_UID);
    }

    public MyUserCriteria joinToUpdatedBy()
    {
        return new MyUserCriteria(joinTo(UPDATED_BY));
    }

    public MyUserCriteria leftJoinToUpdatedBy()
    {
        return new MyUserCriteria(leftJoinTo(UPDATED_BY));
    }

    public KmhStringCondition whereUpdatedByUid()
    {
        return new KmhStringCondition(parent(), fullName(UPDATED_BY_UID));
    }

    public void whereUpdatedByIs(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNull();
        else
            whereUpdatedByUid().is(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyFileJunction all()
    {
        return addAnd();
    }

    public MyFileJunction any()
    {
        return addOr();
    }

    public MyFileJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyFileJunction addNotAnd()
    {
        return new MyFileJunction(parent().addNotAnd());
    }

    public MyFileJunction addNotOr()
    {
        return new MyFileJunction(parent().addNotOr());
    }

    public MyFileJunction addAnd()
    {
        return new MyFileJunction(parent().addAnd());
    }

    public MyFileJunction addOr()
    {
        return new MyFileJunction(parent().addOr());
    }
}
