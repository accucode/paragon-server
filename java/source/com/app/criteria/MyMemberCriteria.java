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

public class MyMemberCriteria
    extends MyAbstractCriteria<MyMember>
    implements MyMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyMember e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyMember e)
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

    public KmhIntegerCondition whereDashboardLineCount1()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_LINE_COUNT_1);
    }

    public KmhIntegerCondition whereDashboardLineCount2()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_LINE_COUNT_2);
    }

    public KmhStringCondition whereDashboardOrientationTypeCode()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public KmhStringCondition whereDashboardPanelCodeA()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_A);
    }

    public KmhStringCondition whereDashboardPanelCodeB()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_B);
    }

    public KmhStringCondition whereDashboardPanelCodeC()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_C);
    }

    public KmhStringCondition whereDashboardPanelCodeD()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_D);
    }

    public KmhStringCondition whereDashboardPanelCodeE()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_E);
    }

    public KmhStringCondition whereDashboardPanelCodeF()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_F);
    }

    public KmhStringCondition whereDashboardPanelCodeG()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_G);
    }

    public KmhIntegerCondition whereDashboardRefreshMinutes()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_REFRESH_MINUTES);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), alias(), ROLE_CODE);
    }

    public void whereRoleIs(MyMemberRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().is(e.getCode());
    }

    public void whereRoleIsNot(MyMemberRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().isNot(e.getCode());
    }

    public void whereRoleIsManager()
    {
        whereRoleIs(MyMemberRole.Manager);
    }

    public void whereRoleIsNotManager()
    {
        whereRoleIsNot(MyMemberRole.Manager);
    }

    public void whereRoleIsManager(boolean e)
    {
        if ( e )
            whereRoleIsManager();
        else
            whereRoleIsNotManager();
    }

    public void whereRoleIsWorker()
    {
        whereRoleIs(MyMemberRole.Worker);
    }

    public void whereRoleIsNotWorker()
    {
        whereRoleIsNot(MyMemberRole.Worker);
    }

    public void whereRoleIsWorker(boolean e)
    {
        if ( e )
            whereRoleIsWorker();
        else
            whereRoleIsNotWorker();
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

    public void sortOnDashboardRefreshMinutes()
    {
        parent().sortAscending(DASHBOARD_REFRESH_MINUTES);
    }

    public void sortOnDashboardRefreshMinutesDescending()
    {
        parent().sortDescending(DASHBOARD_REFRESH_MINUTES);
    }

    public void sortOnDashboardRefreshMinutes(boolean asc)
    {
        if ( asc )
            sortOnDashboardRefreshMinutes();
        else
            sortOnDashboardRefreshMinutesDescending();
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
    //# projections (dashboardRefreshMinutes)
    //##################################################

    public void selectDashboardRefreshMinutes()
    {
        select(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectDistinctDashboardRefreshMinutes()
    {
        selectDistinct(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectCountDistinctDashboardRefreshMinutes()
    {
        selectCountDistinct(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectMinimumDashboardRefreshMinutes()
    {
        selectMinimum(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectMaximumDashboardRefreshMinutes()
    {
        selectMaximum(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectAverageDashboardRefreshMinutes()
    {
        selectAverage(DASHBOARD_REFRESH_MINUTES);
    }

    public void selectSumDashboardRefreshMinutes()
    {
        selectSum(DASHBOARD_REFRESH_MINUTES);
    }

    public void groupByDashboardRefreshMinutes()
    {
        groupBy(DASHBOARD_REFRESH_MINUTES);
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
    //# association (User)
    //##################################################

    public void selectUserUid()
    {
        select(USER_UID);
    }

    public void selectCountDistinctUserUid()
    {
        selectCountDistinct(USER_UID);
    }
    
    public void selectDistinctUserUid()
    {
        selectDistinct(USER_UID);
    }

    public void selectMinimumUserUid()
    {
        selectMinimum(USER_UID);
    }

    public void selectMaximumUserUid()
    {
        selectMaximum(USER_UID);
    }

    public void groupByUserUid()
    {
        groupBy(USER_UID);
    }

    public MyUserCriteria joinToUser()
    {
        return new MyUserCriteria(joinTo(USER));
    }

    public MyUserCriteria leftJoinToUser()
    {
        return new MyUserCriteria(leftJoinTo(USER));
    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(parent(), alias(), USER_UID);
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    public void whereUserIsNot(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNotNull();
        else
            whereUserUid().isNot(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyMemberJunction all()
    {
        return addAnd();
    }

    public MyMemberJunction any()
    {
        return addOr();
    }

    public MyMemberJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyMemberJunction addNotAnd()
    {
        return new MyMemberJunction(parent().addNotAnd());
    }

    public MyMemberJunction addNotOr()
    {
        return new MyMemberJunction(parent().addNotOr());
    }

    public MyMemberJunction addAnd()
    {
        return new MyMemberJunction(parent().addAnd());
    }

    public MyMemberJunction addOr()
    {
        return new MyMemberJunction(parent().addOr());
    }
}
