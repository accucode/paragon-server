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

    public KmhStringCondition whereFirstName()
    {
        return new KmhStringCondition(context(), fullName(FIRST_NAME));
    }

    public KmhStringCondition whereLastName()
    {
        return new KmhStringCondition(context(), fullName(LAST_NAME));
    }

    public KmhStringCondition whereNickname()
    {
        return new KmhStringCondition(context(), fullName(NICKNAME));
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhStringCondition wherePasswordSalt()
    {
        return new KmhStringCondition(context(), fullName(PASSWORD_SALT));
    }

    public KmhStringCondition wherePasswordHash()
    {
        return new KmhStringCondition(context(), fullName(PASSWORD_HASH));
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), fullName(PHONE));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
    }

    public KmhStringCondition whereTimeZoneCode()
    {
        return new KmhStringCondition(context(), fullName(TIME_ZONE_CODE));
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), fullName(ROLE_CODE));
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

    public void whereRoleIsAdmin()
    {
        whereRoleIs(MyUserRole.Admin);
    }

    public void whereRoleIsNotAdmin()
    {
        whereRoleIsNot(MyUserRole.Admin);
    }

    public void whereRoleIsAdmin(boolean e)
    {
        if ( e )
            whereRoleIsAdmin();
        else
            whereRoleIsNotAdmin();
    }

    public void whereRoleIsOther()
    {
        whereRoleIs(MyUserRole.Other);
    }

    public void whereRoleIsNotOther()
    {
        whereRoleIsNot(MyUserRole.Other);
    }

    public void whereRoleIsOther(boolean e)
    {
        if ( e )
            whereRoleIsOther();
        else
            whereRoleIsNotOther();
    }

    public KmhStringCondition whereDashboardOrientationTypeCode()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_ORIENTATION_TYPE_CODE));
    }

    public KmhIntegerCondition whereDashboardLineCount1()
    {
        return new KmhIntegerCondition(context(), fullName(DASHBOARD_LINE_COUNT_1));
    }

    public KmhIntegerCondition whereDashboardLineCount2()
    {
        return new KmhIntegerCondition(context(), fullName(DASHBOARD_LINE_COUNT_2));
    }

    public KmhStringCondition whereDashboardPanelCodeA()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_A));
    }

    public KmhStringCondition whereDashboardPanelCodeB()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_B));
    }

    public KmhStringCondition whereDashboardPanelCodeC()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_C));
    }

    public KmhStringCondition whereDashboardPanelCodeD()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_D));
    }

    public KmhStringCondition whereDashboardPanelCodeE()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_E));
    }

    public KmhStringCondition whereDashboardPanelCodeF()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_F));
    }

    public KmhStringCondition whereDashboardPanelCodeG()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_G));
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

    public void sortOnDashboardOrientationTypeCode()
    {
        parent().sortAscending(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void sortOnDashboardOrientationTypeCodeDescending()
    {
        parent().sortDescending(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void sortOnDashboardOrientationTypeCode(boolean asc)
    {
        if ( asc )
            sortOnDashboardOrientationTypeCode();
        else
            sortOnDashboardOrientationTypeCodeDescending();
    }

    public void sortOnDashboardLineCount1()
    {
        parent().sortAscending(DASHBOARD_LINE_COUNT_1);
    }

    public void sortOnDashboardLineCount1Descending()
    {
        parent().sortDescending(DASHBOARD_LINE_COUNT_1);
    }

    public void sortOnDashboardLineCount1(boolean asc)
    {
        if ( asc )
            sortOnDashboardLineCount1();
        else
            sortOnDashboardLineCount1Descending();
    }

    public void sortOnDashboardLineCount2()
    {
        parent().sortAscending(DASHBOARD_LINE_COUNT_2);
    }

    public void sortOnDashboardLineCount2Descending()
    {
        parent().sortDescending(DASHBOARD_LINE_COUNT_2);
    }

    public void sortOnDashboardLineCount2(boolean asc)
    {
        if ( asc )
            sortOnDashboardLineCount2();
        else
            sortOnDashboardLineCount2Descending();
    }

    public void sortOnDashboardPanelCodeA()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_A);
    }

    public void sortOnDashboardPanelCodeADescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_A);
    }

    public void sortOnDashboardPanelCodeA(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeA();
        else
            sortOnDashboardPanelCodeADescending();
    }

    public void sortOnDashboardPanelCodeB()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_B);
    }

    public void sortOnDashboardPanelCodeBDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_B);
    }

    public void sortOnDashboardPanelCodeB(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeB();
        else
            sortOnDashboardPanelCodeBDescending();
    }

    public void sortOnDashboardPanelCodeC()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_C);
    }

    public void sortOnDashboardPanelCodeCDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_C);
    }

    public void sortOnDashboardPanelCodeC(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeC();
        else
            sortOnDashboardPanelCodeCDescending();
    }

    public void sortOnDashboardPanelCodeD()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_D);
    }

    public void sortOnDashboardPanelCodeDDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_D);
    }

    public void sortOnDashboardPanelCodeD(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeD();
        else
            sortOnDashboardPanelCodeDDescending();
    }

    public void sortOnDashboardPanelCodeE()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_E);
    }

    public void sortOnDashboardPanelCodeEDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_E);
    }

    public void sortOnDashboardPanelCodeE(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeE();
        else
            sortOnDashboardPanelCodeEDescending();
    }

    public void sortOnDashboardPanelCodeF()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_F);
    }

    public void sortOnDashboardPanelCodeFDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_F);
    }

    public void sortOnDashboardPanelCodeF(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeF();
        else
            sortOnDashboardPanelCodeFDescending();
    }

    public void sortOnDashboardPanelCodeG()
    {
        parent().sortAscending(DASHBOARD_PANEL_CODE_G);
    }

    public void sortOnDashboardPanelCodeGDescending()
    {
        parent().sortDescending(DASHBOARD_PANEL_CODE_G);
    }

    public void sortOnDashboardPanelCodeG(boolean asc)
    {
        if ( asc )
            sortOnDashboardPanelCodeG();
        else
            sortOnDashboardPanelCodeGDescending();
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
    //# projections (dashboardOrientationTypeCode)
    //##################################################

    public void selectDashboardOrientationTypeCode()
    {
        select(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectDistinctDashboardOrientationTypeCode()
    {
        selectDistinct(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectCountDistinctDashboardOrientationTypeCode()
    {
        selectCountDistinct(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectMinimumDashboardOrientationTypeCode()
    {
        selectMinimum(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectMaximumDashboardOrientationTypeCode()
    {
        selectMaximum(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectAverageDashboardOrientationTypeCode()
    {
        selectAverage(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void selectSumDashboardOrientationTypeCode()
    {
        selectSum(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public void groupByDashboardOrientationTypeCode()
    {
        groupBy(DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    //##################################################
    //# projections (dashboardLineCount1)
    //##################################################

    public void selectDashboardLineCount1()
    {
        select(DASHBOARD_LINE_COUNT_1);
    }

    public void selectDistinctDashboardLineCount1()
    {
        selectDistinct(DASHBOARD_LINE_COUNT_1);
    }

    public void selectCountDistinctDashboardLineCount1()
    {
        selectCountDistinct(DASHBOARD_LINE_COUNT_1);
    }

    public void selectMinimumDashboardLineCount1()
    {
        selectMinimum(DASHBOARD_LINE_COUNT_1);
    }

    public void selectMaximumDashboardLineCount1()
    {
        selectMaximum(DASHBOARD_LINE_COUNT_1);
    }

    public void selectAverageDashboardLineCount1()
    {
        selectAverage(DASHBOARD_LINE_COUNT_1);
    }

    public void selectSumDashboardLineCount1()
    {
        selectSum(DASHBOARD_LINE_COUNT_1);
    }

    public void groupByDashboardLineCount1()
    {
        groupBy(DASHBOARD_LINE_COUNT_1);
    }

    //##################################################
    //# projections (dashboardLineCount2)
    //##################################################

    public void selectDashboardLineCount2()
    {
        select(DASHBOARD_LINE_COUNT_2);
    }

    public void selectDistinctDashboardLineCount2()
    {
        selectDistinct(DASHBOARD_LINE_COUNT_2);
    }

    public void selectCountDistinctDashboardLineCount2()
    {
        selectCountDistinct(DASHBOARD_LINE_COUNT_2);
    }

    public void selectMinimumDashboardLineCount2()
    {
        selectMinimum(DASHBOARD_LINE_COUNT_2);
    }

    public void selectMaximumDashboardLineCount2()
    {
        selectMaximum(DASHBOARD_LINE_COUNT_2);
    }

    public void selectAverageDashboardLineCount2()
    {
        selectAverage(DASHBOARD_LINE_COUNT_2);
    }

    public void selectSumDashboardLineCount2()
    {
        selectSum(DASHBOARD_LINE_COUNT_2);
    }

    public void groupByDashboardLineCount2()
    {
        groupBy(DASHBOARD_LINE_COUNT_2);
    }

    //##################################################
    //# projections (dashboardPanelCodeA)
    //##################################################

    public void selectDashboardPanelCodeA()
    {
        select(DASHBOARD_PANEL_CODE_A);
    }

    public void selectDistinctDashboardPanelCodeA()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_A);
    }

    public void selectCountDistinctDashboardPanelCodeA()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_A);
    }

    public void selectMinimumDashboardPanelCodeA()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_A);
    }

    public void selectMaximumDashboardPanelCodeA()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_A);
    }

    public void selectAverageDashboardPanelCodeA()
    {
        selectAverage(DASHBOARD_PANEL_CODE_A);
    }

    public void selectSumDashboardPanelCodeA()
    {
        selectSum(DASHBOARD_PANEL_CODE_A);
    }

    public void groupByDashboardPanelCodeA()
    {
        groupBy(DASHBOARD_PANEL_CODE_A);
    }

    //##################################################
    //# projections (dashboardPanelCodeB)
    //##################################################

    public void selectDashboardPanelCodeB()
    {
        select(DASHBOARD_PANEL_CODE_B);
    }

    public void selectDistinctDashboardPanelCodeB()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_B);
    }

    public void selectCountDistinctDashboardPanelCodeB()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_B);
    }

    public void selectMinimumDashboardPanelCodeB()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_B);
    }

    public void selectMaximumDashboardPanelCodeB()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_B);
    }

    public void selectAverageDashboardPanelCodeB()
    {
        selectAverage(DASHBOARD_PANEL_CODE_B);
    }

    public void selectSumDashboardPanelCodeB()
    {
        selectSum(DASHBOARD_PANEL_CODE_B);
    }

    public void groupByDashboardPanelCodeB()
    {
        groupBy(DASHBOARD_PANEL_CODE_B);
    }

    //##################################################
    //# projections (dashboardPanelCodeC)
    //##################################################

    public void selectDashboardPanelCodeC()
    {
        select(DASHBOARD_PANEL_CODE_C);
    }

    public void selectDistinctDashboardPanelCodeC()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_C);
    }

    public void selectCountDistinctDashboardPanelCodeC()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_C);
    }

    public void selectMinimumDashboardPanelCodeC()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_C);
    }

    public void selectMaximumDashboardPanelCodeC()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_C);
    }

    public void selectAverageDashboardPanelCodeC()
    {
        selectAverage(DASHBOARD_PANEL_CODE_C);
    }

    public void selectSumDashboardPanelCodeC()
    {
        selectSum(DASHBOARD_PANEL_CODE_C);
    }

    public void groupByDashboardPanelCodeC()
    {
        groupBy(DASHBOARD_PANEL_CODE_C);
    }

    //##################################################
    //# projections (dashboardPanelCodeD)
    //##################################################

    public void selectDashboardPanelCodeD()
    {
        select(DASHBOARD_PANEL_CODE_D);
    }

    public void selectDistinctDashboardPanelCodeD()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_D);
    }

    public void selectCountDistinctDashboardPanelCodeD()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_D);
    }

    public void selectMinimumDashboardPanelCodeD()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_D);
    }

    public void selectMaximumDashboardPanelCodeD()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_D);
    }

    public void selectAverageDashboardPanelCodeD()
    {
        selectAverage(DASHBOARD_PANEL_CODE_D);
    }

    public void selectSumDashboardPanelCodeD()
    {
        selectSum(DASHBOARD_PANEL_CODE_D);
    }

    public void groupByDashboardPanelCodeD()
    {
        groupBy(DASHBOARD_PANEL_CODE_D);
    }

    //##################################################
    //# projections (dashboardPanelCodeE)
    //##################################################

    public void selectDashboardPanelCodeE()
    {
        select(DASHBOARD_PANEL_CODE_E);
    }

    public void selectDistinctDashboardPanelCodeE()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_E);
    }

    public void selectCountDistinctDashboardPanelCodeE()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_E);
    }

    public void selectMinimumDashboardPanelCodeE()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_E);
    }

    public void selectMaximumDashboardPanelCodeE()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_E);
    }

    public void selectAverageDashboardPanelCodeE()
    {
        selectAverage(DASHBOARD_PANEL_CODE_E);
    }

    public void selectSumDashboardPanelCodeE()
    {
        selectSum(DASHBOARD_PANEL_CODE_E);
    }

    public void groupByDashboardPanelCodeE()
    {
        groupBy(DASHBOARD_PANEL_CODE_E);
    }

    //##################################################
    //# projections (dashboardPanelCodeF)
    //##################################################

    public void selectDashboardPanelCodeF()
    {
        select(DASHBOARD_PANEL_CODE_F);
    }

    public void selectDistinctDashboardPanelCodeF()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_F);
    }

    public void selectCountDistinctDashboardPanelCodeF()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_F);
    }

    public void selectMinimumDashboardPanelCodeF()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_F);
    }

    public void selectMaximumDashboardPanelCodeF()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_F);
    }

    public void selectAverageDashboardPanelCodeF()
    {
        selectAverage(DASHBOARD_PANEL_CODE_F);
    }

    public void selectSumDashboardPanelCodeF()
    {
        selectSum(DASHBOARD_PANEL_CODE_F);
    }

    public void groupByDashboardPanelCodeF()
    {
        groupBy(DASHBOARD_PANEL_CODE_F);
    }

    //##################################################
    //# projections (dashboardPanelCodeG)
    //##################################################

    public void selectDashboardPanelCodeG()
    {
        select(DASHBOARD_PANEL_CODE_G);
    }

    public void selectDistinctDashboardPanelCodeG()
    {
        selectDistinct(DASHBOARD_PANEL_CODE_G);
    }

    public void selectCountDistinctDashboardPanelCodeG()
    {
        selectCountDistinct(DASHBOARD_PANEL_CODE_G);
    }

    public void selectMinimumDashboardPanelCodeG()
    {
        selectMinimum(DASHBOARD_PANEL_CODE_G);
    }

    public void selectMaximumDashboardPanelCodeG()
    {
        selectMaximum(DASHBOARD_PANEL_CODE_G);
    }

    public void selectAverageDashboardPanelCodeG()
    {
        selectAverage(DASHBOARD_PANEL_CODE_G);
    }

    public void selectSumDashboardPanelCodeG()
    {
        selectSum(DASHBOARD_PANEL_CODE_G);
    }

    public void groupByDashboardPanelCodeG()
    {
        groupBy(DASHBOARD_PANEL_CODE_G);
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
    //# association (LastProject)
    //##################################################

    public void selectLastProjectUid()
    {
        select(LAST_PROJECT_UID);
    }

    public void selectMinimumLastProjectUid()
    {
        selectMinimum(LAST_PROJECT_UID);
    }

    public void selectMaximumLastProjectUid()
    {
        selectMaximum(LAST_PROJECT_UID);
    }

    public void groupByLastProjectUid()
    {
        groupBy(LAST_PROJECT_UID);
    }

    public MyProjectCriteria joinToLastProject()
    {
        return new MyProjectCriteria(joinTo(LAST_PROJECT));
    }

    public MyProjectCriteria leftJoinToLastProject()
    {
        return new MyProjectCriteria(leftJoinTo(LAST_PROJECT));
    }

    public KmhStringCondition whereLastProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(LAST_PROJECT_UID));
    }

    public void whereLastProjectIs(MyProject e)
    {
        if ( e == null )
            whereLastProjectUid().isNull();
        else
            whereLastProjectUid().is(e.getUid());
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
