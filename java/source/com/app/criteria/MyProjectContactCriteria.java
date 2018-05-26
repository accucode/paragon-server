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

public class MyProjectContactCriteria
    extends MyAbstractCriteria<MyProjectContact>
    implements MyProjectContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyProjectContact e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyProjectContact e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), alias(), EMAIL);
    }

    public KmhStringCondition whereFirstName()
    {
        return new KmhStringCondition(context(), alias(), FIRST_NAME);
    }

    public KmhStringCondition whereFullName()
    {
        return new KmhStringCondition(context(), alias(), FULL_NAME);
    }

    public KmhStringCondition whereLastName()
    {
        return new KmhStringCondition(context(), alias(), LAST_NAME);
    }

    public KmhStringCondition whereNickname()
    {
        return new KmhStringCondition(context(), alias(), NICKNAME);
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), alias(), PHONE);
    }

    public KmhStringCondition whereTitle()
    {
        return new KmhStringCondition(context(), alias(), TITLE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

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

    public void sortOnEmail()
    {
        parent().sortAscending(EMAIL);
    }

    public void sortOnEmailDescending()
    {
        parent().sortDescending(EMAIL);
    }

    public void sortOnEmail(boolean asc)
    {
        if ( asc )
            sortOnEmail();
        else
            sortOnEmailDescending();
    }

    public void sortOnFirstName()
    {
        parent().sortAscending(FIRST_NAME);
    }

    public void sortOnFirstNameDescending()
    {
        parent().sortDescending(FIRST_NAME);
    }

    public void sortOnFirstName(boolean asc)
    {
        if ( asc )
            sortOnFirstName();
        else
            sortOnFirstNameDescending();
    }

    public void sortOnFullName()
    {
        parent().sortAscending(FULL_NAME);
    }

    public void sortOnFullNameDescending()
    {
        parent().sortDescending(FULL_NAME);
    }

    public void sortOnFullName(boolean asc)
    {
        if ( asc )
            sortOnFullName();
        else
            sortOnFullNameDescending();
    }

    public void sortOnLastName()
    {
        parent().sortAscending(LAST_NAME);
    }

    public void sortOnLastNameDescending()
    {
        parent().sortDescending(LAST_NAME);
    }

    public void sortOnLastName(boolean asc)
    {
        if ( asc )
            sortOnLastName();
        else
            sortOnLastNameDescending();
    }

    public void sortOnNickname()
    {
        parent().sortAscending(NICKNAME);
    }

    public void sortOnNicknameDescending()
    {
        parent().sortDescending(NICKNAME);
    }

    public void sortOnNickname(boolean asc)
    {
        if ( asc )
            sortOnNickname();
        else
            sortOnNicknameDescending();
    }

    public void sortOnPhone()
    {
        parent().sortAscending(PHONE);
    }

    public void sortOnPhoneDescending()
    {
        parent().sortDescending(PHONE);
    }

    public void sortOnPhone(boolean asc)
    {
        if ( asc )
            sortOnPhone();
        else
            sortOnPhoneDescending();
    }

    public void sortOnTitle()
    {
        parent().sortAscending(TITLE);
    }

    public void sortOnTitleDescending()
    {
        parent().sortDescending(TITLE);
    }

    public void sortOnTitle(boolean asc)
    {
        if ( asc )
            sortOnTitle();
        else
            sortOnTitleDescending();
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
    //# projections (email)
    //##################################################

    public void selectEmail()
    {
        select(EMAIL);
    }

    public void selectDistinctEmail()
    {
        selectDistinct(EMAIL);
    }

    public void selectCountDistinctEmail()
    {
        selectCountDistinct(EMAIL);
    }

    public void selectMinimumEmail()
    {
        selectMinimum(EMAIL);
    }

    public void selectMaximumEmail()
    {
        selectMaximum(EMAIL);
    }

    public void selectAverageEmail()
    {
        selectAverage(EMAIL);
    }

    public void selectSumEmail()
    {
        selectSum(EMAIL);
    }

    public void groupByEmail()
    {
        groupBy(EMAIL);
    }

    //##################################################
    //# projections (firstName)
    //##################################################

    public void selectFirstName()
    {
        select(FIRST_NAME);
    }

    public void selectDistinctFirstName()
    {
        selectDistinct(FIRST_NAME);
    }

    public void selectCountDistinctFirstName()
    {
        selectCountDistinct(FIRST_NAME);
    }

    public void selectMinimumFirstName()
    {
        selectMinimum(FIRST_NAME);
    }

    public void selectMaximumFirstName()
    {
        selectMaximum(FIRST_NAME);
    }

    public void selectAverageFirstName()
    {
        selectAverage(FIRST_NAME);
    }

    public void selectSumFirstName()
    {
        selectSum(FIRST_NAME);
    }

    public void groupByFirstName()
    {
        groupBy(FIRST_NAME);
    }

    //##################################################
    //# projections (fullName)
    //##################################################

    public void selectFullName()
    {
        select(FULL_NAME);
    }

    public void selectDistinctFullName()
    {
        selectDistinct(FULL_NAME);
    }

    public void selectCountDistinctFullName()
    {
        selectCountDistinct(FULL_NAME);
    }

    public void selectMinimumFullName()
    {
        selectMinimum(FULL_NAME);
    }

    public void selectMaximumFullName()
    {
        selectMaximum(FULL_NAME);
    }

    public void selectAverageFullName()
    {
        selectAverage(FULL_NAME);
    }

    public void selectSumFullName()
    {
        selectSum(FULL_NAME);
    }

    public void groupByFullName()
    {
        groupBy(FULL_NAME);
    }

    //##################################################
    //# projections (lastName)
    //##################################################

    public void selectLastName()
    {
        select(LAST_NAME);
    }

    public void selectDistinctLastName()
    {
        selectDistinct(LAST_NAME);
    }

    public void selectCountDistinctLastName()
    {
        selectCountDistinct(LAST_NAME);
    }

    public void selectMinimumLastName()
    {
        selectMinimum(LAST_NAME);
    }

    public void selectMaximumLastName()
    {
        selectMaximum(LAST_NAME);
    }

    public void selectAverageLastName()
    {
        selectAverage(LAST_NAME);
    }

    public void selectSumLastName()
    {
        selectSum(LAST_NAME);
    }

    public void groupByLastName()
    {
        groupBy(LAST_NAME);
    }

    //##################################################
    //# projections (nickname)
    //##################################################

    public void selectNickname()
    {
        select(NICKNAME);
    }

    public void selectDistinctNickname()
    {
        selectDistinct(NICKNAME);
    }

    public void selectCountDistinctNickname()
    {
        selectCountDistinct(NICKNAME);
    }

    public void selectMinimumNickname()
    {
        selectMinimum(NICKNAME);
    }

    public void selectMaximumNickname()
    {
        selectMaximum(NICKNAME);
    }

    public void selectAverageNickname()
    {
        selectAverage(NICKNAME);
    }

    public void selectSumNickname()
    {
        selectSum(NICKNAME);
    }

    public void groupByNickname()
    {
        groupBy(NICKNAME);
    }

    //##################################################
    //# projections (phone)
    //##################################################

    public void selectPhone()
    {
        select(PHONE);
    }

    public void selectDistinctPhone()
    {
        selectDistinct(PHONE);
    }

    public void selectCountDistinctPhone()
    {
        selectCountDistinct(PHONE);
    }

    public void selectMinimumPhone()
    {
        selectMinimum(PHONE);
    }

    public void selectMaximumPhone()
    {
        selectMaximum(PHONE);
    }

    public void selectAveragePhone()
    {
        selectAverage(PHONE);
    }

    public void selectSumPhone()
    {
        selectSum(PHONE);
    }

    public void groupByPhone()
    {
        groupBy(PHONE);
    }

    //##################################################
    //# projections (title)
    //##################################################

    public void selectTitle()
    {
        select(TITLE);
    }

    public void selectDistinctTitle()
    {
        selectDistinct(TITLE);
    }

    public void selectCountDistinctTitle()
    {
        selectCountDistinct(TITLE);
    }

    public void selectMinimumTitle()
    {
        selectMinimum(TITLE);
    }

    public void selectMaximumTitle()
    {
        selectMaximum(TITLE);
    }

    public void selectAverageTitle()
    {
        selectAverage(TITLE);
    }

    public void selectSumTitle()
    {
        selectSum(TITLE);
    }

    public void groupByTitle()
    {
        groupBy(TITLE);
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

    public void selectCountDistinctCreatedByUid()
    {
        selectCountDistinct(CREATED_BY_UID);
    }
    
    public void selectDistinctCreatedByUid()
    {
        selectDistinct(CREATED_BY_UID);
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
        return new KmhStringCondition(parent(), alias(), CREATED_BY_UID);
    }

    public void whereCreatedByIs(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNull();
        else
            whereCreatedByUid().is(e.getUid());
    }

    public void whereCreatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNotNull();
        else
            whereCreatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectCountDistinctProjectUid()
    {
        selectCountDistinct(PROJECT_UID);
    }
    
    public void selectDistinctProjectUid()
    {
        selectDistinct(PROJECT_UID);
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
        groupBy(PROJECT_UID);
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
        return new KmhStringCondition(parent(), alias(), PROJECT_UID);
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
    }

    public void whereProjectIsNot(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNotNull();
        else
            whereProjectUid().isNot(e.getUid());
    }

    //##################################################
    //# association (UpdatedBy)
    //##################################################

    public void selectUpdatedByUid()
    {
        select(UPDATED_BY_UID);
    }

    public void selectCountDistinctUpdatedByUid()
    {
        selectCountDistinct(UPDATED_BY_UID);
    }
    
    public void selectDistinctUpdatedByUid()
    {
        selectDistinct(UPDATED_BY_UID);
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
        return new KmhStringCondition(parent(), alias(), UPDATED_BY_UID);
    }

    public void whereUpdatedByIs(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNull();
        else
            whereUpdatedByUid().is(e.getUid());
    }

    public void whereUpdatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNotNull();
        else
            whereUpdatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyProjectContactJunction all()
    {
        return addAnd();
    }

    public MyProjectContactJunction any()
    {
        return addOr();
    }

    public MyProjectContactJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyProjectContactJunction addNotAnd()
    {
        return new MyProjectContactJunction(parent().addNotAnd());
    }

    public MyProjectContactJunction addNotOr()
    {
        return new MyProjectContactJunction(parent().addNotOr());
    }

    public MyProjectContactJunction addAnd()
    {
        return new MyProjectContactJunction(parent().addAnd());
    }

    public MyProjectContactJunction addOr()
    {
        return new MyProjectContactJunction(parent().addOr());
    }
}
