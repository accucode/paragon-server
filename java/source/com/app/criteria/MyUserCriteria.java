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

public class MyUserCriteria
    extends MyAbstractCriteria<MyUser>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyUserCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
    }

    public KmBooleanCriteria whereVerified()
    {
        return new KmBooleanCriteria(context(), fullName(VERIFIED));
    }

    public KmStringCriteria wherePasswordSalt()
    {
        return new KmStringCriteria(context(), fullName(PASSWORD_SALT));
    }

    public KmStringCriteria wherePasswordHash()
    {
        return new KmStringCriteria(context(), fullName(PASSWORD_HASH));
    }

    public KmStringCriteria whereTimeZoneCode()
    {
        return new KmStringCriteria(context(), fullName(TIME_ZONE_CODE));
    }

    public KmStringCriteria whereRoleCode()
    {
        return new KmStringCriteria(context(), fullName(ROLE_CODE));
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

    public void whereRoleIsUser()
    {
        whereRoleIs(MyUserRole.User);
    }

    public void whereRoleIsNotUser()
    {
        whereRoleIsNot(MyUserRole.User);
    }

    public void whereRoleIsUser(boolean e)
    {
        if ( e )
            whereRoleIsUser();
        else
            whereRoleIsNotUser();
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

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
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

    public void sortOnVerified()
    {
        parent().sortAscending(VERIFIED);
    }

    public void sortOnVerifiedDescending()
    {
        parent().sortDescending(VERIFIED);
    }

    public void sortOnVerified(boolean asc)
    {
        if ( asc )
            sortOnVerified();
        else
            sortOnVerifiedDescending();
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
    //# projections (verified)
    //##################################################

    public void selectVerified()
    {
        select(VERIFIED);
    }

    public void selectDistinctVerified()
    {
        selectDistinct(VERIFIED);
    }

    public void selectCountDistinctVerified()
    {
        selectCountDistinct(VERIFIED);
    }

    public void selectMinimumVerified()
    {
        selectMinimum(VERIFIED);
    }

    public void selectMaximumVerified()
    {
        selectMaximum(VERIFIED);
    }

    public void selectAverageVerified()
    {
        selectAverage(VERIFIED);
    }

    public void selectSumVerified()
    {
        selectSum(VERIFIED);
    }

    public void groupByVerified()
    {
        groupBy(VERIFIED);
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
    //# collection (UserAccounts)
    //##################################################

    public MyUserAccountCriteria joinToUserAccounts()
    {
        return new MyUserAccountCriteria(joinTo(USER_ACCOUNTS));
    }

    public MyUserAccountCriteria leftJoinToUserAccounts()
    {
        return new MyUserAccountCriteria(leftJoinTo(USER_ACCOUNTS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyUserJunction addAnd()
    {
        return new MyUserJunction(parent().addAnd());
    }

    public MyUserJunction addOr()
    {
        return new MyUserJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyUserCriteria createOn(KmModelJunction junction)
    {
        return new MyUserCriteria(parent(), junction.context());
    }

}
