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

public class MyEmailCriteria
    extends MyAbstractCriteria<MyEmail>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailCriteria(KmhCriteria parent)
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

    public KmhPropertyCondition<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmhPropertyCondition<KmTimestamp> whereSentUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(SENT_UTC_TS));
    }

    public KmhStringCondition whereSubject()
    {
        return new KmhStringCondition(context(), fullName(SUBJECT));
    }

    public KmhStringCondition whereFromAddress()
    {
        return new KmhStringCondition(context(), fullName(FROM_ADDRESS));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public void whereStatusIs(MyEmailStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MyEmailStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsDraft()
    {
        whereStatusIs(MyEmailStatus.Draft);
    }

    public void whereStatusIsNotDraft()
    {
        whereStatusIsNot(MyEmailStatus.Draft);
    }

    public void whereStatusIsDraft(boolean e)
    {
        if ( e )
            whereStatusIsDraft();
        else
            whereStatusIsNotDraft();
    }

    public void whereStatusIsReady()
    {
        whereStatusIs(MyEmailStatus.Ready);
    }

    public void whereStatusIsNotReady()
    {
        whereStatusIsNot(MyEmailStatus.Ready);
    }

    public void whereStatusIsReady(boolean e)
    {
        if ( e )
            whereStatusIsReady();
        else
            whereStatusIsNotReady();
    }

    public void whereStatusIsPending()
    {
        whereStatusIs(MyEmailStatus.Pending);
    }

    public void whereStatusIsNotPending()
    {
        whereStatusIsNot(MyEmailStatus.Pending);
    }

    public void whereStatusIsPending(boolean e)
    {
        if ( e )
            whereStatusIsPending();
        else
            whereStatusIsNotPending();
    }

    public void whereStatusIsSent()
    {
        whereStatusIs(MyEmailStatus.Sent);
    }

    public void whereStatusIsNotSent()
    {
        whereStatusIsNot(MyEmailStatus.Sent);
    }

    public void whereStatusIsSent(boolean e)
    {
        if ( e )
            whereStatusIsSent();
        else
            whereStatusIsNotSent();
    }

    public void whereStatusIsError()
    {
        whereStatusIs(MyEmailStatus.Error);
    }

    public void whereStatusIsNotError()
    {
        whereStatusIsNot(MyEmailStatus.Error);
    }

    public void whereStatusIsError(boolean e)
    {
        if ( e )
            whereStatusIsError();
        else
            whereStatusIsNotError();
    }

    public void whereStatusIsIgnored()
    {
        whereStatusIs(MyEmailStatus.Ignored);
    }

    public void whereStatusIsNotIgnored()
    {
        whereStatusIsNot(MyEmailStatus.Ignored);
    }

    public void whereStatusIsIgnored(boolean e)
    {
        if ( e )
            whereStatusIsIgnored();
        else
            whereStatusIsNotIgnored();
    }

    public KmhStringCondition whereErrorNotes()
    {
        return new KmhStringCondition(context(), fullName(ERROR_NOTES));
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

    public void sortOnSentUtcTs()
    {
        parent().sortAscending(SENT_UTC_TS);
    }

    public void sortOnSentUtcTsDescending()
    {
        parent().sortDescending(SENT_UTC_TS);
    }

    public void sortOnSentUtcTs(boolean asc)
    {
        if ( asc )
            sortOnSentUtcTs();
        else
            sortOnSentUtcTsDescending();
    }

    public void sortOnSubject()
    {
        parent().sortAscending(SUBJECT);
    }

    public void sortOnSubjectDescending()
    {
        parent().sortDescending(SUBJECT);
    }

    public void sortOnSubject(boolean asc)
    {
        if ( asc )
            sortOnSubject();
        else
            sortOnSubjectDescending();
    }

    public void sortOnFromAddress()
    {
        parent().sortAscending(FROM_ADDRESS);
    }

    public void sortOnFromAddressDescending()
    {
        parent().sortDescending(FROM_ADDRESS);
    }

    public void sortOnFromAddress(boolean asc)
    {
        if ( asc )
            sortOnFromAddress();
        else
            sortOnFromAddressDescending();
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

    public void sortOnErrorNotes()
    {
        parent().sortAscending(ERROR_NOTES);
    }

    public void sortOnErrorNotesDescending()
    {
        parent().sortDescending(ERROR_NOTES);
    }

    public void sortOnErrorNotes(boolean asc)
    {
        if ( asc )
            sortOnErrorNotes();
        else
            sortOnErrorNotesDescending();
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
    //# projections (sentUtcTs)
    //##################################################

    public void selectSentUtcTs()
    {
        select(SENT_UTC_TS);
    }

    public void selectDistinctSentUtcTs()
    {
        selectDistinct(SENT_UTC_TS);
    }

    public void selectCountDistinctSentUtcTs()
    {
        selectCountDistinct(SENT_UTC_TS);
    }

    public void selectMinimumSentUtcTs()
    {
        selectMinimum(SENT_UTC_TS);
    }

    public void selectMaximumSentUtcTs()
    {
        selectMaximum(SENT_UTC_TS);
    }

    public void selectAverageSentUtcTs()
    {
        selectAverage(SENT_UTC_TS);
    }

    public void selectSumSentUtcTs()
    {
        selectSum(SENT_UTC_TS);
    }

    public void groupBySentUtcTs()
    {
        groupBy(SENT_UTC_TS);
    }

    //##################################################
    //# projections (subject)
    //##################################################

    public void selectSubject()
    {
        select(SUBJECT);
    }

    public void selectDistinctSubject()
    {
        selectDistinct(SUBJECT);
    }

    public void selectCountDistinctSubject()
    {
        selectCountDistinct(SUBJECT);
    }

    public void selectMinimumSubject()
    {
        selectMinimum(SUBJECT);
    }

    public void selectMaximumSubject()
    {
        selectMaximum(SUBJECT);
    }

    public void selectAverageSubject()
    {
        selectAverage(SUBJECT);
    }

    public void selectSumSubject()
    {
        selectSum(SUBJECT);
    }

    public void groupBySubject()
    {
        groupBy(SUBJECT);
    }

    //##################################################
    //# projections (fromAddress)
    //##################################################

    public void selectFromAddress()
    {
        select(FROM_ADDRESS);
    }

    public void selectDistinctFromAddress()
    {
        selectDistinct(FROM_ADDRESS);
    }

    public void selectCountDistinctFromAddress()
    {
        selectCountDistinct(FROM_ADDRESS);
    }

    public void selectMinimumFromAddress()
    {
        selectMinimum(FROM_ADDRESS);
    }

    public void selectMaximumFromAddress()
    {
        selectMaximum(FROM_ADDRESS);
    }

    public void selectAverageFromAddress()
    {
        selectAverage(FROM_ADDRESS);
    }

    public void selectSumFromAddress()
    {
        selectSum(FROM_ADDRESS);
    }

    public void groupByFromAddress()
    {
        groupBy(FROM_ADDRESS);
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
    //# projections (errorNotes)
    //##################################################

    public void selectErrorNotes()
    {
        select(ERROR_NOTES);
    }

    public void selectDistinctErrorNotes()
    {
        selectDistinct(ERROR_NOTES);
    }

    public void selectCountDistinctErrorNotes()
    {
        selectCountDistinct(ERROR_NOTES);
    }

    public void selectMinimumErrorNotes()
    {
        selectMinimum(ERROR_NOTES);
    }

    public void selectMaximumErrorNotes()
    {
        selectMaximum(ERROR_NOTES);
    }

    public void selectAverageErrorNotes()
    {
        selectAverage(ERROR_NOTES);
    }

    public void selectSumErrorNotes()
    {
        selectSum(ERROR_NOTES);
    }

    public void groupByErrorNotes()
    {
        groupBy(ERROR_NOTES);
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
    //# collection (Recipients)
    //##################################################

    public MyEmailRecipientCriteria joinToRecipients()
    {
        return new MyEmailRecipientCriteria(joinTo(RECIPIENTS));
    }

    public MyEmailRecipientCriteria leftJoinToRecipients()
    {
        return new MyEmailRecipientCriteria(leftJoinTo(RECIPIENTS));
    }

    //##################################################
    //# collection (Parts)
    //##################################################

    public MyEmailPartCriteria joinToParts()
    {
        return new MyEmailPartCriteria(joinTo(PARTS));
    }

    public MyEmailPartCriteria leftJoinToParts()
    {
        return new MyEmailPartCriteria(leftJoinTo(PARTS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyEmailJunction addAnd()
    {
        return new MyEmailJunction(parent().addAnd());
    }

    public MyEmailJunction addOr()
    {
        return new MyEmailJunction(parent().addOr());
    }
}
