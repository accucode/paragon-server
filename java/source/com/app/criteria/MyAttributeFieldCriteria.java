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

public class MyAttributeFieldCriteria
    extends MyAbstractCriteria<MyAttributeField>
    implements MyAttributeFieldDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeFieldCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereCategoryCode()
    {
        return new KmhStringCondition(context(), fullName(CATEGORY_CODE));
    }

    public void whereCategoryIs(MyAttributeFieldCategory e)
    {
        if ( e == null )
            whereCategoryCode().isNull();
        else
            whereCategoryCode().is(e.getCode());
    }

    public void whereCategoryIsNot(MyAttributeFieldCategory e)
    {
        if ( e == null )
            whereCategoryCode().isNull();
        else
            whereCategoryCode().isNot(e.getCode());
    }

    public void whereCategoryIsCustomerSite()
    {
        whereCategoryIs(MyAttributeFieldCategory.CustomerSite);
    }

    public void whereCategoryIsNotCustomerSite()
    {
        whereCategoryIsNot(MyAttributeFieldCategory.CustomerSite);
    }

    public void whereCategoryIsCustomerSite(boolean e)
    {
        if ( e )
            whereCategoryIsCustomerSite();
        else
            whereCategoryIsNotCustomerSite();
    }

    public void whereCategoryIsProduct()
    {
        whereCategoryIs(MyAttributeFieldCategory.Product);
    }

    public void whereCategoryIsNotProduct()
    {
        whereCategoryIsNot(MyAttributeFieldCategory.Product);
    }

    public void whereCategoryIsProduct(boolean e)
    {
        if ( e )
            whereCategoryIsProduct();
        else
            whereCategoryIsNotProduct();
    }

    public void whereCategoryIsSalesOrderLine()
    {
        whereCategoryIs(MyAttributeFieldCategory.SalesOrderLine);
    }

    public void whereCategoryIsNotSalesOrderLine()
    {
        whereCategoryIsNot(MyAttributeFieldCategory.SalesOrderLine);
    }

    public void whereCategoryIsSalesOrderLine(boolean e)
    {
        if ( e )
            whereCategoryIsSalesOrderLine();
        else
            whereCategoryIsNotSalesOrderLine();
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
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

    public void sortOnCategoryCode()
    {
        parent().sortAscending(CATEGORY_CODE);
    }

    public void sortOnCategoryCodeDescending()
    {
        parent().sortDescending(CATEGORY_CODE);
    }

    public void sortOnCategoryCode(boolean asc)
    {
        if ( asc )
            sortOnCategoryCode();
        else
            sortOnCategoryCodeDescending();
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
    //# projections (categoryCode)
    //##################################################

    public void selectCategoryCode()
    {
        select(CATEGORY_CODE);
    }

    public void selectDistinctCategoryCode()
    {
        selectDistinct(CATEGORY_CODE);
    }

    public void selectCountDistinctCategoryCode()
    {
        selectCountDistinct(CATEGORY_CODE);
    }

    public void selectMinimumCategoryCode()
    {
        selectMinimum(CATEGORY_CODE);
    }

    public void selectMaximumCategoryCode()
    {
        selectMaximum(CATEGORY_CODE);
    }

    public void selectAverageCategoryCode()
    {
        selectAverage(CATEGORY_CODE);
    }

    public void selectSumCategoryCode()
    {
        selectSum(CATEGORY_CODE);
    }

    public void groupByCategoryCode()
    {
        groupBy(CATEGORY_CODE);
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
    //# collection (Values)
    //##################################################

    public MyAttributeValueCriteria joinToValues()
    {
        return new MyAttributeValueCriteria(joinTo(VALUES));
    }

    public MyAttributeValueCriteria leftJoinToValues()
    {
        return new MyAttributeValueCriteria(leftJoinTo(VALUES));
    }

    //##################################################
    //# junction
    //##################################################

    public MyAttributeFieldJunction addAnd()
    {
        return new MyAttributeFieldJunction(parent().addAnd());
    }

    public MyAttributeFieldJunction addOr()
    {
        return new MyAttributeFieldJunction(parent().addOr());
    }
}
