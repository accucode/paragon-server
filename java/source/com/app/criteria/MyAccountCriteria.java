//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.dao.base.MyAccountDaoConstantsIF;
import com.app.model.MyAccount;
import com.app.model.MyAccountType;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

public class MyAccountCriteria
    extends MyAbstractCriteria<MyAccount>
    implements MyAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyAccountCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public void whereTypeIs(MyAccountType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyAccountType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsPersonal()
    {
        whereTypeIs(MyAccountType.Personal);
    }

    public void whereTypeIsNotPersonal()
    {
        whereTypeIsNot(MyAccountType.Personal);
    }

    public void whereTypeIsPersonal(boolean e)
    {
        if ( e )
            whereTypeIsPersonal();
        else
            whereTypeIsNotPersonal();
    }

    public void whereTypeIsBusiness()
    {
        whereTypeIs(MyAccountType.Business);
    }

    public void whereTypeIsNotBusiness()
    {
        whereTypeIsNot(MyAccountType.Business);
    }

    public void whereTypeIsBusiness(boolean e)
    {
        if ( e )
            whereTypeIsBusiness();
        else
            whereTypeIsNotBusiness();
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

    public void sortOnTypeCode()
    {
        parent().sortAscending(TYPE_CODE);
    }

    public void sortOnTypeCodeDescending()
    {
        parent().sortDescending(TYPE_CODE);
    }

    public void sortOnTypeCode(boolean asc)
    {
        if ( asc )
            sortOnTypeCode();
        else
            sortOnTypeCodeDescending();
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
    //# projections (typeCode)
    //##################################################

    public void selectTypeCode()
    {
        select(TYPE_CODE);
    }

    public void selectDistinctTypeCode()
    {
        selectDistinct(TYPE_CODE);
    }

    public void selectCountDistinctTypeCode()
    {
        selectCountDistinct(TYPE_CODE);
    }

    public void selectMinimumTypeCode()
    {
        selectMinimum(TYPE_CODE);
    }

    public void selectMaximumTypeCode()
    {
        selectMaximum(TYPE_CODE);
    }

    public void selectAverageTypeCode()
    {
        selectAverage(TYPE_CODE);
    }

    public void selectSumTypeCode()
    {
        selectSum(TYPE_CODE);
    }

    public void groupByTypeCode()
    {
        groupBy(TYPE_CODE);
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
    //# collection (AccountUsers)
    //##################################################

    public MyAccountUserCriteria joinToAccountUsers()
    {
        return new MyAccountUserCriteria(joinTo(ACCOUNT_USERS));
    }

    public MyAccountUserCriteria leftJoinToAccountUsers()
    {
        return new MyAccountUserCriteria(leftJoinTo(ACCOUNT_USERS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyAccountJunction addAnd()
    {
        return new MyAccountJunction(parent().addAnd());
    }

    public MyAccountJunction addOr()
    {
        return new MyAccountJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyAccountCriteria createOn(KmModelJunction junction)
    {
        return new MyAccountCriteria(parent(), junction.context());
    }

}
