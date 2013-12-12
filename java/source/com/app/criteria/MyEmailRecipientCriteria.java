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

public class MyEmailRecipientCriteria
    extends MyAbstractCriteria<MyEmailRecipient>
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipientCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyEmailRecipientCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmStringCriteria whereAddress()
    {
        return new KmStringCriteria(context(), fullName(ADDRESS));
    }

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public void whereTypeIs(MyEmailRecipientType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyEmailRecipientType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsTo()
    {
        whereTypeIs(MyEmailRecipientType.To);
    }

    public void whereTypeIsNotTo()
    {
        whereTypeIsNot(MyEmailRecipientType.To);
    }

    public void whereTypeIsTo(boolean e)
    {
        if ( e )
            whereTypeIsTo();
        else
            whereTypeIsNotTo();
    }

    public void whereTypeIsCc()
    {
        whereTypeIs(MyEmailRecipientType.Cc);
    }

    public void whereTypeIsNotCc()
    {
        whereTypeIsNot(MyEmailRecipientType.Cc);
    }

    public void whereTypeIsCc(boolean e)
    {
        if ( e )
            whereTypeIsCc();
        else
            whereTypeIsNotCc();
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

    public void sortOnAddress()
    {
        parent().sortAscending(ADDRESS);
    }

    public void sortOnAddressDescending()
    {
        parent().sortDescending(ADDRESS);
    }

    public void sortOnAddress(boolean asc)
    {
        if ( asc )
            sortOnAddress();
        else
            sortOnAddressDescending();
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
    //# projections (address)
    //##################################################

    public void selectAddress()
    {
        select(ADDRESS);
    }

    public void selectDistinctAddress()
    {
        selectDistinct(ADDRESS);
    }

    public void selectCountDistinctAddress()
    {
        selectCountDistinct(ADDRESS);
    }

    public void selectMinimumAddress()
    {
        selectMinimum(ADDRESS);
    }

    public void selectMaximumAddress()
    {
        selectMaximum(ADDRESS);
    }

    public void selectAverageAddress()
    {
        selectAverage(ADDRESS);
    }

    public void selectSumAddress()
    {
        selectSum(ADDRESS);
    }

    public void groupByAddress()
    {
        groupBy(ADDRESS);
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
    //# association (Email)
    //##################################################

    public void selectEmailUid()
    {
        select(EMAIL_UID);
    }

    public void selectMinimumEmailUid()
    {
        selectMinimum(EMAIL_UID);
    }

    public void selectMaximumEmailUid()
    {
        selectMaximum(EMAIL_UID);
    }

    public void groupByEmailUid()
    {
        groupBy(EMAIL);
    }

    public MyEmailCriteria joinToEmail()
    {
        return new MyEmailCriteria(joinTo(EMAIL));
    }

    public MyEmailCriteria leftJoinToEmail()
    {
        return new MyEmailCriteria(leftJoinTo(EMAIL));
    }

    public KmStringCriteria whereEmailUid()
    {
        return new KmStringCriteria(parent(), fullName(EMAIL_UID));
    }

    public void whereEmailIs(MyEmail e)
    {
        if ( e == null )
            whereEmailUid().isNull();
        else
            whereEmailUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyEmailRecipientJunction addAnd()
    {
        return new MyEmailRecipientJunction(parent().addAnd());
    }

    public MyEmailRecipientJunction addOr()
    {
        return new MyEmailRecipientJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyEmailRecipientCriteria createOn(KmModelJunction junction)
    {
        return new MyEmailRecipientCriteria(parent(), junction.context());
    }

}
