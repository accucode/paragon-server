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

public class MyUserCriteria
    extends MyAbstractCriteria<MyUser>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyUser e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyUser e)
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

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
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

    public KmhStringCondition whereMemo()
    {
        return new KmhStringCondition(context(), alias(), MEMO);
    }

    public KmhStringCondition whereNickname()
    {
        return new KmhStringCondition(context(), alias(), NICKNAME);
    }

    public KmhStringCondition wherePasswordHash()
    {
        return new KmhStringCondition(context(), alias(), PASSWORD_HASH);
    }

    public KmhStringCondition wherePasswordSalt()
    {
        return new KmhStringCondition(context(), alias(), PASSWORD_SALT);
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), alias(), PHONE);
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), alias(), ROLE_CODE);
    }

    public void whereRoleIs(MyUserRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().is(e.getCode());
    }

    public void whereRoleIsNot(MyUserRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().isNot(e.getCode());
    }

    public void whereRoleIsDeveloper()
    {
        whereRoleIs(MyUserRole.Developer);
    }

    public void whereRoleIsNotDeveloper()
    {
        whereRoleIsNot(MyUserRole.Developer);
    }

    public void whereRoleIsDeveloper(boolean e)
    {
        if ( e )
            whereRoleIsDeveloper();
        else
            whereRoleIsNotDeveloper();
    }

    public void whereRoleIsTenantAdmin()
    {
        whereRoleIs(MyUserRole.TenantAdmin);
    }

    public void whereRoleIsNotTenantAdmin()
    {
        whereRoleIsNot(MyUserRole.TenantAdmin);
    }

    public void whereRoleIsTenantAdmin(boolean e)
    {
        if ( e )
            whereRoleIsTenantAdmin();
        else
            whereRoleIsNotTenantAdmin();
    }

    public void whereRoleIsProjectMember()
    {
        whereRoleIs(MyUserRole.ProjectMember);
    }

    public void whereRoleIsNotProjectMember()
    {
        whereRoleIsNot(MyUserRole.ProjectMember);
    }

    public void whereRoleIsProjectMember(boolean e)
    {
        if ( e )
            whereRoleIsProjectMember();
        else
            whereRoleIsNotProjectMember();
    }

    public KmhStringCondition whereTimeZoneCode()
    {
        return new KmhStringCondition(context(), alias(), TIME_ZONE_CODE);
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

    public void sortOnEnabled()
    {
        parent().sortAscending(ENABLED);
    }

    public void sortOnEnabledDescending()
    {
        parent().sortDescending(ENABLED);
    }

    public void sortOnEnabled(boolean asc)
    {
        if ( asc )
            sortOnEnabled();
        else
            sortOnEnabledDescending();
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

    public void sortOnMemo()
    {
        parent().sortAscending(MEMO);
    }

    public void sortOnMemoDescending()
    {
        parent().sortDescending(MEMO);
    }

    public void sortOnMemo(boolean asc)
    {
        if ( asc )
            sortOnMemo();
        else
            sortOnMemoDescending();
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

    public void sortOnPasswordHash()
    {
        parent().sortAscending(PASSWORD_HASH);
    }

    public void sortOnPasswordHashDescending()
    {
        parent().sortDescending(PASSWORD_HASH);
    }

    public void sortOnPasswordHash(boolean asc)
    {
        if ( asc )
            sortOnPasswordHash();
        else
            sortOnPasswordHashDescending();
    }

    public void sortOnPasswordSalt()
    {
        parent().sortAscending(PASSWORD_SALT);
    }

    public void sortOnPasswordSaltDescending()
    {
        parent().sortDescending(PASSWORD_SALT);
    }

    public void sortOnPasswordSalt(boolean asc)
    {
        if ( asc )
            sortOnPasswordSalt();
        else
            sortOnPasswordSaltDescending();
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

    public void sortOnRoleCode()
    {
        parent().sortAscending(ROLE_CODE);
    }

    public void sortOnRoleCodeDescending()
    {
        parent().sortDescending(ROLE_CODE);
    }

    public void sortOnRoleCode(boolean asc)
    {
        if ( asc )
            sortOnRoleCode();
        else
            sortOnRoleCodeDescending();
    }

    public void sortOnTimeZoneCode()
    {
        parent().sortAscending(TIME_ZONE_CODE);
    }

    public void sortOnTimeZoneCodeDescending()
    {
        parent().sortDescending(TIME_ZONE_CODE);
    }

    public void sortOnTimeZoneCode(boolean asc)
    {
        if ( asc )
            sortOnTimeZoneCode();
        else
            sortOnTimeZoneCodeDescending();
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
    //# projections (enabled)
    //##################################################

    public void selectEnabled()
    {
        select(ENABLED);
    }

    public void selectDistinctEnabled()
    {
        selectDistinct(ENABLED);
    }

    public void selectCountDistinctEnabled()
    {
        selectCountDistinct(ENABLED);
    }

    public void selectMinimumEnabled()
    {
        selectMinimum(ENABLED);
    }

    public void selectMaximumEnabled()
    {
        selectMaximum(ENABLED);
    }

    public void selectAverageEnabled()
    {
        selectAverage(ENABLED);
    }

    public void selectSumEnabled()
    {
        selectSum(ENABLED);
    }

    public void groupByEnabled()
    {
        groupBy(ENABLED);
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
    //# projections (memo)
    //##################################################

    public void selectMemo()
    {
        select(MEMO);
    }

    public void selectDistinctMemo()
    {
        selectDistinct(MEMO);
    }

    public void selectCountDistinctMemo()
    {
        selectCountDistinct(MEMO);
    }

    public void selectMinimumMemo()
    {
        selectMinimum(MEMO);
    }

    public void selectMaximumMemo()
    {
        selectMaximum(MEMO);
    }

    public void selectAverageMemo()
    {
        selectAverage(MEMO);
    }

    public void selectSumMemo()
    {
        selectSum(MEMO);
    }

    public void groupByMemo()
    {
        groupBy(MEMO);
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
    //# projections (passwordHash)
    //##################################################

    public void selectPasswordHash()
    {
        select(PASSWORD_HASH);
    }

    public void selectDistinctPasswordHash()
    {
        selectDistinct(PASSWORD_HASH);
    }

    public void selectCountDistinctPasswordHash()
    {
        selectCountDistinct(PASSWORD_HASH);
    }

    public void selectMinimumPasswordHash()
    {
        selectMinimum(PASSWORD_HASH);
    }

    public void selectMaximumPasswordHash()
    {
        selectMaximum(PASSWORD_HASH);
    }

    public void selectAveragePasswordHash()
    {
        selectAverage(PASSWORD_HASH);
    }

    public void selectSumPasswordHash()
    {
        selectSum(PASSWORD_HASH);
    }

    public void groupByPasswordHash()
    {
        groupBy(PASSWORD_HASH);
    }

    //##################################################
    //# projections (passwordSalt)
    //##################################################

    public void selectPasswordSalt()
    {
        select(PASSWORD_SALT);
    }

    public void selectDistinctPasswordSalt()
    {
        selectDistinct(PASSWORD_SALT);
    }

    public void selectCountDistinctPasswordSalt()
    {
        selectCountDistinct(PASSWORD_SALT);
    }

    public void selectMinimumPasswordSalt()
    {
        selectMinimum(PASSWORD_SALT);
    }

    public void selectMaximumPasswordSalt()
    {
        selectMaximum(PASSWORD_SALT);
    }

    public void selectAveragePasswordSalt()
    {
        selectAverage(PASSWORD_SALT);
    }

    public void selectSumPasswordSalt()
    {
        selectSum(PASSWORD_SALT);
    }

    public void groupByPasswordSalt()
    {
        groupBy(PASSWORD_SALT);
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
    //# projections (roleCode)
    //##################################################

    public void selectRoleCode()
    {
        select(ROLE_CODE);
    }

    public void selectDistinctRoleCode()
    {
        selectDistinct(ROLE_CODE);
    }

    public void selectCountDistinctRoleCode()
    {
        selectCountDistinct(ROLE_CODE);
    }

    public void selectMinimumRoleCode()
    {
        selectMinimum(ROLE_CODE);
    }

    public void selectMaximumRoleCode()
    {
        selectMaximum(ROLE_CODE);
    }

    public void selectAverageRoleCode()
    {
        selectAverage(ROLE_CODE);
    }

    public void selectSumRoleCode()
    {
        selectSum(ROLE_CODE);
    }

    public void groupByRoleCode()
    {
        groupBy(ROLE_CODE);
    }

    //##################################################
    //# projections (timeZoneCode)
    //##################################################

    public void selectTimeZoneCode()
    {
        select(TIME_ZONE_CODE);
    }

    public void selectDistinctTimeZoneCode()
    {
        selectDistinct(TIME_ZONE_CODE);
    }

    public void selectCountDistinctTimeZoneCode()
    {
        selectCountDistinct(TIME_ZONE_CODE);
    }

    public void selectMinimumTimeZoneCode()
    {
        selectMinimum(TIME_ZONE_CODE);
    }

    public void selectMaximumTimeZoneCode()
    {
        selectMaximum(TIME_ZONE_CODE);
    }

    public void selectAverageTimeZoneCode()
    {
        selectAverage(TIME_ZONE_CODE);
    }

    public void selectSumTimeZoneCode()
    {
        selectSum(TIME_ZONE_CODE);
    }

    public void groupByTimeZoneCode()
    {
        groupBy(TIME_ZONE_CODE);
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
    //# association (Tenant)
    //##################################################

    public void selectTenantUid()
    {
        select(TENANT_UID);
    }

    public void selectCountDistinctTenantUid()
    {
        selectCountDistinct(TENANT_UID);
    }
    
    public void selectDistinctTenantUid()
    {
        selectDistinct(TENANT_UID);
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
        return new KmhStringCondition(parent(), alias(), TENANT_UID);
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    public void whereTenantIsNot(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNotNull();
        else
            whereTenantUid().isNot(e.getUid());
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

    public MyUserJunction all()
    {
        return addAnd();
    }

    public MyUserJunction any()
    {
        return addOr();
    }

    public MyUserJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyUserJunction addNotAnd()
    {
        return new MyUserJunction(parent().addNotAnd());
    }

    public MyUserJunction addNotOr()
    {
        return new MyUserJunction(parent().addNotOr());
    }

    public MyUserJunction addAnd()
    {
        return new MyUserJunction(parent().addAnd());
    }

    public MyUserJunction addOr()
    {
        return new MyUserJunction(parent().addOr());
    }
}
