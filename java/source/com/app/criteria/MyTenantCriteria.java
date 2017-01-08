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

public class MyTenantCriteria
    extends MyAbstractCriteria<MyTenant>
    implements MyTenantDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereHostname()
    {
        return new KmhStringCondition(context(), fullName(HOSTNAME));
    }

    public KmhStringCondition whereThemeCode()
    {
        return new KmhStringCondition(context(), fullName(THEME_CODE));
    }

    public KmhStringCondition whereIntacctCompanyId()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_COMPANY_ID));
    }

    public KmhStringCondition whereIntacctUserId()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_USER_ID));
    }

    public KmhStringCondition whereIntacctUserPassword()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_USER_PASSWORD));
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

    public void sortOnHostname()
    {
        parent().sortAscending(HOSTNAME);
    }

    public void sortOnHostnameDescending()
    {
        parent().sortDescending(HOSTNAME);
    }

    public void sortOnHostname(boolean asc)
    {
        if ( asc )
            sortOnHostname();
        else
            sortOnHostnameDescending();
    }

    public void sortOnThemeCode()
    {
        parent().sortAscending(THEME_CODE);
    }

    public void sortOnThemeCodeDescending()
    {
        parent().sortDescending(THEME_CODE);
    }

    public void sortOnThemeCode(boolean asc)
    {
        if ( asc )
            sortOnThemeCode();
        else
            sortOnThemeCodeDescending();
    }

    public void sortOnIntacctCompanyId()
    {
        parent().sortAscending(INTACCT_COMPANY_ID);
    }

    public void sortOnIntacctCompanyIdDescending()
    {
        parent().sortDescending(INTACCT_COMPANY_ID);
    }

    public void sortOnIntacctCompanyId(boolean asc)
    {
        if ( asc )
            sortOnIntacctCompanyId();
        else
            sortOnIntacctCompanyIdDescending();
    }

    public void sortOnIntacctUserId()
    {
        parent().sortAscending(INTACCT_USER_ID);
    }

    public void sortOnIntacctUserIdDescending()
    {
        parent().sortDescending(INTACCT_USER_ID);
    }

    public void sortOnIntacctUserId(boolean asc)
    {
        if ( asc )
            sortOnIntacctUserId();
        else
            sortOnIntacctUserIdDescending();
    }

    public void sortOnIntacctUserPassword()
    {
        parent().sortAscending(INTACCT_USER_PASSWORD);
    }

    public void sortOnIntacctUserPasswordDescending()
    {
        parent().sortDescending(INTACCT_USER_PASSWORD);
    }

    public void sortOnIntacctUserPassword(boolean asc)
    {
        if ( asc )
            sortOnIntacctUserPassword();
        else
            sortOnIntacctUserPasswordDescending();
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
    //# projections (hostname)
    //##################################################

    public void selectHostname()
    {
        select(HOSTNAME);
    }

    public void selectDistinctHostname()
    {
        selectDistinct(HOSTNAME);
    }

    public void selectCountDistinctHostname()
    {
        selectCountDistinct(HOSTNAME);
    }

    public void selectMinimumHostname()
    {
        selectMinimum(HOSTNAME);
    }

    public void selectMaximumHostname()
    {
        selectMaximum(HOSTNAME);
    }

    public void selectAverageHostname()
    {
        selectAverage(HOSTNAME);
    }

    public void selectSumHostname()
    {
        selectSum(HOSTNAME);
    }

    public void groupByHostname()
    {
        groupBy(HOSTNAME);
    }

    //##################################################
    //# projections (themeCode)
    //##################################################

    public void selectThemeCode()
    {
        select(THEME_CODE);
    }

    public void selectDistinctThemeCode()
    {
        selectDistinct(THEME_CODE);
    }

    public void selectCountDistinctThemeCode()
    {
        selectCountDistinct(THEME_CODE);
    }

    public void selectMinimumThemeCode()
    {
        selectMinimum(THEME_CODE);
    }

    public void selectMaximumThemeCode()
    {
        selectMaximum(THEME_CODE);
    }

    public void selectAverageThemeCode()
    {
        selectAverage(THEME_CODE);
    }

    public void selectSumThemeCode()
    {
        selectSum(THEME_CODE);
    }

    public void groupByThemeCode()
    {
        groupBy(THEME_CODE);
    }

    //##################################################
    //# projections (intacctCompanyId)
    //##################################################

    public void selectIntacctCompanyId()
    {
        select(INTACCT_COMPANY_ID);
    }

    public void selectDistinctIntacctCompanyId()
    {
        selectDistinct(INTACCT_COMPANY_ID);
    }

    public void selectCountDistinctIntacctCompanyId()
    {
        selectCountDistinct(INTACCT_COMPANY_ID);
    }

    public void selectMinimumIntacctCompanyId()
    {
        selectMinimum(INTACCT_COMPANY_ID);
    }

    public void selectMaximumIntacctCompanyId()
    {
        selectMaximum(INTACCT_COMPANY_ID);
    }

    public void selectAverageIntacctCompanyId()
    {
        selectAverage(INTACCT_COMPANY_ID);
    }

    public void selectSumIntacctCompanyId()
    {
        selectSum(INTACCT_COMPANY_ID);
    }

    public void groupByIntacctCompanyId()
    {
        groupBy(INTACCT_COMPANY_ID);
    }

    //##################################################
    //# projections (intacctUserId)
    //##################################################

    public void selectIntacctUserId()
    {
        select(INTACCT_USER_ID);
    }

    public void selectDistinctIntacctUserId()
    {
        selectDistinct(INTACCT_USER_ID);
    }

    public void selectCountDistinctIntacctUserId()
    {
        selectCountDistinct(INTACCT_USER_ID);
    }

    public void selectMinimumIntacctUserId()
    {
        selectMinimum(INTACCT_USER_ID);
    }

    public void selectMaximumIntacctUserId()
    {
        selectMaximum(INTACCT_USER_ID);
    }

    public void selectAverageIntacctUserId()
    {
        selectAverage(INTACCT_USER_ID);
    }

    public void selectSumIntacctUserId()
    {
        selectSum(INTACCT_USER_ID);
    }

    public void groupByIntacctUserId()
    {
        groupBy(INTACCT_USER_ID);
    }

    //##################################################
    //# projections (intacctUserPassword)
    //##################################################

    public void selectIntacctUserPassword()
    {
        select(INTACCT_USER_PASSWORD);
    }

    public void selectDistinctIntacctUserPassword()
    {
        selectDistinct(INTACCT_USER_PASSWORD);
    }

    public void selectCountDistinctIntacctUserPassword()
    {
        selectCountDistinct(INTACCT_USER_PASSWORD);
    }

    public void selectMinimumIntacctUserPassword()
    {
        selectMinimum(INTACCT_USER_PASSWORD);
    }

    public void selectMaximumIntacctUserPassword()
    {
        selectMaximum(INTACCT_USER_PASSWORD);
    }

    public void selectAverageIntacctUserPassword()
    {
        selectAverage(INTACCT_USER_PASSWORD);
    }

    public void selectSumIntacctUserPassword()
    {
        selectSum(INTACCT_USER_PASSWORD);
    }

    public void groupByIntacctUserPassword()
    {
        groupBy(INTACCT_USER_PASSWORD);
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
    //# collection (Projects)
    //##################################################

    public MyProjectCriteria joinToProjects()
    {
        return new MyProjectCriteria(joinTo(PROJECTS));
    }

    public MyProjectCriteria leftJoinToProjects()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECTS));
    }

    //##################################################
    //# collection (Users)
    //##################################################

    public MyUserCriteria joinToUsers()
    {
        return new MyUserCriteria(joinTo(USERS));
    }

    public MyUserCriteria leftJoinToUsers()
    {
        return new MyUserCriteria(leftJoinTo(USERS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyTenantJunction all()
    {
        return addAnd();
    }

    public MyTenantJunction any()
    {
        return addOr();
    }

    public MyTenantJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyTenantJunction addNotAnd()
    {
        return new MyTenantJunction(parent().addNotAnd());
    }

    public MyTenantJunction addNotOr()
    {
        return new MyTenantJunction(parent().addNotOr());
    }

    public MyTenantJunction addAnd()
    {
        return new MyTenantJunction(parent().addAnd());
    }

    public MyTenantJunction addOr()
    {
        return new MyTenantJunction(parent().addOr());
    }
}
