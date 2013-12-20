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

public class MyUserActivationCriteria
    extends MyAbstractCriteria<MyUserActivation>
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyUserActivationCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
    }

    public KmStringCriteria whereToken()
    {
        return new KmStringCriteria(context(), fullName(TOKEN));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereExpirationUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(EXPIRATION_UTC_TS));
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
    //# junction
    //##################################################

    public MyUserActivationJunction addAnd()
    {
        return new MyUserActivationJunction(parent().addAnd());
    }

    public MyUserActivationJunction addOr()
    {
        return new MyUserActivationJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyUserActivationCriteria createOn(KmModelJunction junction)
    {
        return new MyUserActivationCriteria(parent(), junction.context());
    }

}
