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

public class MyPasswordResetCriteria
    extends MyAbstractCriteria<MyPasswordReset>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhStringCondition whereToken()
    {
        return new KmhStringCondition(context(), fullName(TOKEN));
    }

    public KmhTimestampCondition whereExpirationUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(EXPIRATION_UTC_TS));
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

    public void sortOnToken()
    {
        parent().sortAscending(TOKEN);
    }

    public void sortOnTokenDescending()
    {
        parent().sortDescending(TOKEN);
    }

    public void sortOnToken(boolean asc)
    {
        if ( asc )
            sortOnToken();
        else
            sortOnTokenDescending();
    }

    public void sortOnExpirationUtcTs()
    {
        parent().sortAscending(EXPIRATION_UTC_TS);
    }

    public void sortOnExpirationUtcTsDescending()
    {
        parent().sortDescending(EXPIRATION_UTC_TS);
    }

    public void sortOnExpirationUtcTs(boolean asc)
    {
        if ( asc )
            sortOnExpirationUtcTs();
        else
            sortOnExpirationUtcTsDescending();
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
    //# projections (token)
    //##################################################

    public void selectToken()
    {
        select(TOKEN);
    }

    public void selectDistinctToken()
    {
        selectDistinct(TOKEN);
    }

    public void selectCountDistinctToken()
    {
        selectCountDistinct(TOKEN);
    }

    public void selectMinimumToken()
    {
        selectMinimum(TOKEN);
    }

    public void selectMaximumToken()
    {
        selectMaximum(TOKEN);
    }

    public void selectAverageToken()
    {
        selectAverage(TOKEN);
    }

    public void selectSumToken()
    {
        selectSum(TOKEN);
    }

    public void groupByToken()
    {
        groupBy(TOKEN);
    }

    //##################################################
    //# projections (expirationUtcTs)
    //##################################################

    public void selectExpirationUtcTs()
    {
        select(EXPIRATION_UTC_TS);
    }

    public void selectDistinctExpirationUtcTs()
    {
        selectDistinct(EXPIRATION_UTC_TS);
    }

    public void selectCountDistinctExpirationUtcTs()
    {
        selectCountDistinct(EXPIRATION_UTC_TS);
    }

    public void selectMinimumExpirationUtcTs()
    {
        selectMinimum(EXPIRATION_UTC_TS);
    }

    public void selectMaximumExpirationUtcTs()
    {
        selectMaximum(EXPIRATION_UTC_TS);
    }

    public void selectAverageExpirationUtcTs()
    {
        selectAverage(EXPIRATION_UTC_TS);
    }

    public void selectSumExpirationUtcTs()
    {
        selectSum(EXPIRATION_UTC_TS);
    }

    public void groupByExpirationUtcTs()
    {
        groupBy(EXPIRATION_UTC_TS);
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
    //# association (Tenant)
    //##################################################

    public void selectTenantUid()
    {
        select(TENANT_UID);
    }

    public void selectMinimumTenantUid()
    {
        selectMinimum(TENANT_UID);
    }

    public void selectMaximumTenantUid()
    {
        selectMaximum(TENANT_UID);
    }

    public void groupByTenantUid()
    {
        groupBy(TENANT_UID);
    }

    public MyTenantCriteria joinToTenant()
    {
        return new MyTenantCriteria(joinTo(TENANT));
    }

    public MyTenantCriteria leftJoinToTenant()
    {
        return new MyTenantCriteria(leftJoinTo(TENANT));
    }

    public KmhStringCondition whereTenantUid()
    {
        return new KmhStringCondition(parent(), fullName(TENANT_UID));
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyPasswordResetJunction all()
    {
        return addAnd();
    }

    public MyPasswordResetJunction any()
    {
        return addOr();
    }

    public MyPasswordResetJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyPasswordResetJunction addNotAnd()
    {
        return new MyPasswordResetJunction(parent().addNotAnd());
    }

    public MyPasswordResetJunction addNotOr()
    {
        return new MyPasswordResetJunction(parent().addNotOr());
    }

    public MyPasswordResetJunction addAnd()
    {
        return new MyPasswordResetJunction(parent().addAnd());
    }

    public MyPasswordResetJunction addOr()
    {
        return new MyPasswordResetJunction(parent().addOr());
    }
}
