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

public class MyAuditLogCriteria
    extends MyAbstractCriteria<MyAuditLog>
    implements MyAuditLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereTransactionUid()
    {
        return new KmhStringCondition(context(), fullName(TRANSACTION_UID));
    }

    public KmhStringCondition whereUserName()
    {
        return new KmhStringCondition(context(), fullName(USER_NAME));
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
    }

    public void whereTypeIs(MyAuditLogType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyAuditLogType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsAdd()
    {
        whereTypeIs(MyAuditLogType.Add);
    }

    public void whereTypeIsNotAdd()
    {
        whereTypeIsNot(MyAuditLogType.Add);
    }

    public void whereTypeIsAdd(boolean e)
    {
        if ( e )
            whereTypeIsAdd();
        else
            whereTypeIsNotAdd();
    }

    public void whereTypeIsUpdate()
    {
        whereTypeIs(MyAuditLogType.Update);
    }

    public void whereTypeIsNotUpdate()
    {
        whereTypeIsNot(MyAuditLogType.Update);
    }

    public void whereTypeIsUpdate(boolean e)
    {
        if ( e )
            whereTypeIsUpdate();
        else
            whereTypeIsNotUpdate();
    }

    public void whereTypeIsDelete()
    {
        whereTypeIs(MyAuditLogType.Delete);
    }

    public void whereTypeIsNotDelete()
    {
        whereTypeIsNot(MyAuditLogType.Delete);
    }

    public void whereTypeIsDelete(boolean e)
    {
        if ( e )
            whereTypeIsDelete();
        else
            whereTypeIsNotDelete();
    }

    public KmhStringCondition whereDomainType()
    {
        return new KmhStringCondition(context(), fullName(DOMAIN_TYPE));
    }

    public KmhStringCondition whereDomainName()
    {
        return new KmhStringCondition(context(), fullName(DOMAIN_NAME));
    }

    public KmhStringCondition whereDomainUid()
    {
        return new KmhStringCondition(context(), fullName(DOMAIN_UID));
    }

    public KmhStringCondition whereDomainBundleUid()
    {
        return new KmhStringCondition(context(), fullName(DOMAIN_BUNDLE_UID));
    }

    public KmhStringCondition whereFieldName()
    {
        return new KmhStringCondition(context(), fullName(FIELD_NAME));
    }

    public KmhStringCondition whereNewValue()
    {
        return new KmhStringCondition(context(), fullName(NEW_VALUE));
    }

    public KmhStringCondition whereOldValue()
    {
        return new KmhStringCondition(context(), fullName(OLD_VALUE));
    }

    public KmhStringCondition whereStringValue()
    {
        return new KmhStringCondition(context(), fullName(STRING_VALUE));
    }

    public KmhIntegerCondition whereIntegerValue()
    {
        return new KmhIntegerCondition(context(), fullName(INTEGER_VALUE));
    }

    public KmhPropertyCondition<Long> whereLongValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(LONG_VALUE));
    }

    public KmhPropertyCondition<Double> whereDoubleValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(DOUBLE_VALUE));
    }

    public KmhPropertyCondition<KmMoney> whereMoneyValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(MONEY_VALUE));
    }

    public KmhBooleanCondition whereBooleanValue()
    {
        return new KmhBooleanCondition(context(), fullName(BOOLEAN_VALUE));
    }

    public KmhDateCondition whereDateValue()
    {
        return new KmhDateCondition(context(), fullName(DATE_VALUE));
    }

    public KmhTimestampCondition whereTimestampValue()
    {
        return new KmhTimestampCondition(context(), fullName(TIMESTAMP_VALUE));
    }

    public KmhStringCondition whereUidValue()
    {
        return new KmhStringCondition(context(), fullName(UID_VALUE));
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

    public void sortOnTransactionUid()
    {
        parent().sortAscending(TRANSACTION_UID);
    }

    public void sortOnTransactionUidDescending()
    {
        parent().sortDescending(TRANSACTION_UID);
    }

    public void sortOnTransactionUid(boolean asc)
    {
        if ( asc )
            sortOnTransactionUid();
        else
            sortOnTransactionUidDescending();
    }

    public void sortOnUserName()
    {
        parent().sortAscending(USER_NAME);
    }

    public void sortOnUserNameDescending()
    {
        parent().sortDescending(USER_NAME);
    }

    public void sortOnUserName(boolean asc)
    {
        if ( asc )
            sortOnUserName();
        else
            sortOnUserNameDescending();
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

    public void sortOnDomainType()
    {
        parent().sortAscending(DOMAIN_TYPE);
    }

    public void sortOnDomainTypeDescending()
    {
        parent().sortDescending(DOMAIN_TYPE);
    }

    public void sortOnDomainType(boolean asc)
    {
        if ( asc )
            sortOnDomainType();
        else
            sortOnDomainTypeDescending();
    }

    public void sortOnDomainName()
    {
        parent().sortAscending(DOMAIN_NAME);
    }

    public void sortOnDomainNameDescending()
    {
        parent().sortDescending(DOMAIN_NAME);
    }

    public void sortOnDomainName(boolean asc)
    {
        if ( asc )
            sortOnDomainName();
        else
            sortOnDomainNameDescending();
    }

    public void sortOnDomainUid()
    {
        parent().sortAscending(DOMAIN_UID);
    }

    public void sortOnDomainUidDescending()
    {
        parent().sortDescending(DOMAIN_UID);
    }

    public void sortOnDomainUid(boolean asc)
    {
        if ( asc )
            sortOnDomainUid();
        else
            sortOnDomainUidDescending();
    }

    public void sortOnDomainBundleUid()
    {
        parent().sortAscending(DOMAIN_BUNDLE_UID);
    }

    public void sortOnDomainBundleUidDescending()
    {
        parent().sortDescending(DOMAIN_BUNDLE_UID);
    }

    public void sortOnDomainBundleUid(boolean asc)
    {
        if ( asc )
            sortOnDomainBundleUid();
        else
            sortOnDomainBundleUidDescending();
    }

    public void sortOnFieldName()
    {
        parent().sortAscending(FIELD_NAME);
    }

    public void sortOnFieldNameDescending()
    {
        parent().sortDescending(FIELD_NAME);
    }

    public void sortOnFieldName(boolean asc)
    {
        if ( asc )
            sortOnFieldName();
        else
            sortOnFieldNameDescending();
    }

    public void sortOnNewValue()
    {
        parent().sortAscending(NEW_VALUE);
    }

    public void sortOnNewValueDescending()
    {
        parent().sortDescending(NEW_VALUE);
    }

    public void sortOnNewValue(boolean asc)
    {
        if ( asc )
            sortOnNewValue();
        else
            sortOnNewValueDescending();
    }

    public void sortOnOldValue()
    {
        parent().sortAscending(OLD_VALUE);
    }

    public void sortOnOldValueDescending()
    {
        parent().sortDescending(OLD_VALUE);
    }

    public void sortOnOldValue(boolean asc)
    {
        if ( asc )
            sortOnOldValue();
        else
            sortOnOldValueDescending();
    }

    public void sortOnStringValue()
    {
        parent().sortAscending(STRING_VALUE);
    }

    public void sortOnStringValueDescending()
    {
        parent().sortDescending(STRING_VALUE);
    }

    public void sortOnStringValue(boolean asc)
    {
        if ( asc )
            sortOnStringValue();
        else
            sortOnStringValueDescending();
    }

    public void sortOnIntegerValue()
    {
        parent().sortAscending(INTEGER_VALUE);
    }

    public void sortOnIntegerValueDescending()
    {
        parent().sortDescending(INTEGER_VALUE);
    }

    public void sortOnIntegerValue(boolean asc)
    {
        if ( asc )
            sortOnIntegerValue();
        else
            sortOnIntegerValueDescending();
    }

    public void sortOnLongValue()
    {
        parent().sortAscending(LONG_VALUE);
    }

    public void sortOnLongValueDescending()
    {
        parent().sortDescending(LONG_VALUE);
    }

    public void sortOnLongValue(boolean asc)
    {
        if ( asc )
            sortOnLongValue();
        else
            sortOnLongValueDescending();
    }

    public void sortOnDoubleValue()
    {
        parent().sortAscending(DOUBLE_VALUE);
    }

    public void sortOnDoubleValueDescending()
    {
        parent().sortDescending(DOUBLE_VALUE);
    }

    public void sortOnDoubleValue(boolean asc)
    {
        if ( asc )
            sortOnDoubleValue();
        else
            sortOnDoubleValueDescending();
    }

    public void sortOnMoneyValue()
    {
        parent().sortAscending(MONEY_VALUE);
    }

    public void sortOnMoneyValueDescending()
    {
        parent().sortDescending(MONEY_VALUE);
    }

    public void sortOnMoneyValue(boolean asc)
    {
        if ( asc )
            sortOnMoneyValue();
        else
            sortOnMoneyValueDescending();
    }

    public void sortOnBooleanValue()
    {
        parent().sortAscending(BOOLEAN_VALUE);
    }

    public void sortOnBooleanValueDescending()
    {
        parent().sortDescending(BOOLEAN_VALUE);
    }

    public void sortOnBooleanValue(boolean asc)
    {
        if ( asc )
            sortOnBooleanValue();
        else
            sortOnBooleanValueDescending();
    }

    public void sortOnDateValue()
    {
        parent().sortAscending(DATE_VALUE);
    }

    public void sortOnDateValueDescending()
    {
        parent().sortDescending(DATE_VALUE);
    }

    public void sortOnDateValue(boolean asc)
    {
        if ( asc )
            sortOnDateValue();
        else
            sortOnDateValueDescending();
    }

    public void sortOnTimestampValue()
    {
        parent().sortAscending(TIMESTAMP_VALUE);
    }

    public void sortOnTimestampValueDescending()
    {
        parent().sortDescending(TIMESTAMP_VALUE);
    }

    public void sortOnTimestampValue(boolean asc)
    {
        if ( asc )
            sortOnTimestampValue();
        else
            sortOnTimestampValueDescending();
    }

    public void sortOnUidValue()
    {
        parent().sortAscending(UID_VALUE);
    }

    public void sortOnUidValueDescending()
    {
        parent().sortDescending(UID_VALUE);
    }

    public void sortOnUidValue(boolean asc)
    {
        if ( asc )
            sortOnUidValue();
        else
            sortOnUidValueDescending();
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
    //# projections (transactionUid)
    //##################################################

    public void selectTransactionUid()
    {
        select(TRANSACTION_UID);
    }

    public void selectDistinctTransactionUid()
    {
        selectDistinct(TRANSACTION_UID);
    }

    public void selectCountDistinctTransactionUid()
    {
        selectCountDistinct(TRANSACTION_UID);
    }

    public void selectMinimumTransactionUid()
    {
        selectMinimum(TRANSACTION_UID);
    }

    public void selectMaximumTransactionUid()
    {
        selectMaximum(TRANSACTION_UID);
    }

    public void selectAverageTransactionUid()
    {
        selectAverage(TRANSACTION_UID);
    }

    public void selectSumTransactionUid()
    {
        selectSum(TRANSACTION_UID);
    }

    public void groupByTransactionUid()
    {
        groupBy(TRANSACTION_UID);
    }

    //##################################################
    //# projections (userName)
    //##################################################

    public void selectUserName()
    {
        select(USER_NAME);
    }

    public void selectDistinctUserName()
    {
        selectDistinct(USER_NAME);
    }

    public void selectCountDistinctUserName()
    {
        selectCountDistinct(USER_NAME);
    }

    public void selectMinimumUserName()
    {
        selectMinimum(USER_NAME);
    }

    public void selectMaximumUserName()
    {
        selectMaximum(USER_NAME);
    }

    public void selectAverageUserName()
    {
        selectAverage(USER_NAME);
    }

    public void selectSumUserName()
    {
        selectSum(USER_NAME);
    }

    public void groupByUserName()
    {
        groupBy(USER_NAME);
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
    //# projections (domainType)
    //##################################################

    public void selectDomainType()
    {
        select(DOMAIN_TYPE);
    }

    public void selectDistinctDomainType()
    {
        selectDistinct(DOMAIN_TYPE);
    }

    public void selectCountDistinctDomainType()
    {
        selectCountDistinct(DOMAIN_TYPE);
    }

    public void selectMinimumDomainType()
    {
        selectMinimum(DOMAIN_TYPE);
    }

    public void selectMaximumDomainType()
    {
        selectMaximum(DOMAIN_TYPE);
    }

    public void selectAverageDomainType()
    {
        selectAverage(DOMAIN_TYPE);
    }

    public void selectSumDomainType()
    {
        selectSum(DOMAIN_TYPE);
    }

    public void groupByDomainType()
    {
        groupBy(DOMAIN_TYPE);
    }

    //##################################################
    //# projections (domainName)
    //##################################################

    public void selectDomainName()
    {
        select(DOMAIN_NAME);
    }

    public void selectDistinctDomainName()
    {
        selectDistinct(DOMAIN_NAME);
    }

    public void selectCountDistinctDomainName()
    {
        selectCountDistinct(DOMAIN_NAME);
    }

    public void selectMinimumDomainName()
    {
        selectMinimum(DOMAIN_NAME);
    }

    public void selectMaximumDomainName()
    {
        selectMaximum(DOMAIN_NAME);
    }

    public void selectAverageDomainName()
    {
        selectAverage(DOMAIN_NAME);
    }

    public void selectSumDomainName()
    {
        selectSum(DOMAIN_NAME);
    }

    public void groupByDomainName()
    {
        groupBy(DOMAIN_NAME);
    }

    //##################################################
    //# projections (domainUid)
    //##################################################

    public void selectDomainUid()
    {
        select(DOMAIN_UID);
    }

    public void selectDistinctDomainUid()
    {
        selectDistinct(DOMAIN_UID);
    }

    public void selectCountDistinctDomainUid()
    {
        selectCountDistinct(DOMAIN_UID);
    }

    public void selectMinimumDomainUid()
    {
        selectMinimum(DOMAIN_UID);
    }

    public void selectMaximumDomainUid()
    {
        selectMaximum(DOMAIN_UID);
    }

    public void selectAverageDomainUid()
    {
        selectAverage(DOMAIN_UID);
    }

    public void selectSumDomainUid()
    {
        selectSum(DOMAIN_UID);
    }

    public void groupByDomainUid()
    {
        groupBy(DOMAIN_UID);
    }

    //##################################################
    //# projections (domainBundleUid)
    //##################################################

    public void selectDomainBundleUid()
    {
        select(DOMAIN_BUNDLE_UID);
    }

    public void selectDistinctDomainBundleUid()
    {
        selectDistinct(DOMAIN_BUNDLE_UID);
    }

    public void selectCountDistinctDomainBundleUid()
    {
        selectCountDistinct(DOMAIN_BUNDLE_UID);
    }

    public void selectMinimumDomainBundleUid()
    {
        selectMinimum(DOMAIN_BUNDLE_UID);
    }

    public void selectMaximumDomainBundleUid()
    {
        selectMaximum(DOMAIN_BUNDLE_UID);
    }

    public void selectAverageDomainBundleUid()
    {
        selectAverage(DOMAIN_BUNDLE_UID);
    }

    public void selectSumDomainBundleUid()
    {
        selectSum(DOMAIN_BUNDLE_UID);
    }

    public void groupByDomainBundleUid()
    {
        groupBy(DOMAIN_BUNDLE_UID);
    }

    //##################################################
    //# projections (fieldName)
    //##################################################

    public void selectFieldName()
    {
        select(FIELD_NAME);
    }

    public void selectDistinctFieldName()
    {
        selectDistinct(FIELD_NAME);
    }

    public void selectCountDistinctFieldName()
    {
        selectCountDistinct(FIELD_NAME);
    }

    public void selectMinimumFieldName()
    {
        selectMinimum(FIELD_NAME);
    }

    public void selectMaximumFieldName()
    {
        selectMaximum(FIELD_NAME);
    }

    public void selectAverageFieldName()
    {
        selectAverage(FIELD_NAME);
    }

    public void selectSumFieldName()
    {
        selectSum(FIELD_NAME);
    }

    public void groupByFieldName()
    {
        groupBy(FIELD_NAME);
    }

    //##################################################
    //# projections (newValue)
    //##################################################

    public void selectNewValue()
    {
        select(NEW_VALUE);
    }

    public void selectDistinctNewValue()
    {
        selectDistinct(NEW_VALUE);
    }

    public void selectCountDistinctNewValue()
    {
        selectCountDistinct(NEW_VALUE);
    }

    public void selectMinimumNewValue()
    {
        selectMinimum(NEW_VALUE);
    }

    public void selectMaximumNewValue()
    {
        selectMaximum(NEW_VALUE);
    }

    public void selectAverageNewValue()
    {
        selectAverage(NEW_VALUE);
    }

    public void selectSumNewValue()
    {
        selectSum(NEW_VALUE);
    }

    public void groupByNewValue()
    {
        groupBy(NEW_VALUE);
    }

    //##################################################
    //# projections (oldValue)
    //##################################################

    public void selectOldValue()
    {
        select(OLD_VALUE);
    }

    public void selectDistinctOldValue()
    {
        selectDistinct(OLD_VALUE);
    }

    public void selectCountDistinctOldValue()
    {
        selectCountDistinct(OLD_VALUE);
    }

    public void selectMinimumOldValue()
    {
        selectMinimum(OLD_VALUE);
    }

    public void selectMaximumOldValue()
    {
        selectMaximum(OLD_VALUE);
    }

    public void selectAverageOldValue()
    {
        selectAverage(OLD_VALUE);
    }

    public void selectSumOldValue()
    {
        selectSum(OLD_VALUE);
    }

    public void groupByOldValue()
    {
        groupBy(OLD_VALUE);
    }

    //##################################################
    //# projections (stringValue)
    //##################################################

    public void selectStringValue()
    {
        select(STRING_VALUE);
    }

    public void selectDistinctStringValue()
    {
        selectDistinct(STRING_VALUE);
    }

    public void selectCountDistinctStringValue()
    {
        selectCountDistinct(STRING_VALUE);
    }

    public void selectMinimumStringValue()
    {
        selectMinimum(STRING_VALUE);
    }

    public void selectMaximumStringValue()
    {
        selectMaximum(STRING_VALUE);
    }

    public void selectAverageStringValue()
    {
        selectAverage(STRING_VALUE);
    }

    public void selectSumStringValue()
    {
        selectSum(STRING_VALUE);
    }

    public void groupByStringValue()
    {
        groupBy(STRING_VALUE);
    }

    //##################################################
    //# projections (integerValue)
    //##################################################

    public void selectIntegerValue()
    {
        select(INTEGER_VALUE);
    }

    public void selectDistinctIntegerValue()
    {
        selectDistinct(INTEGER_VALUE);
    }

    public void selectCountDistinctIntegerValue()
    {
        selectCountDistinct(INTEGER_VALUE);
    }

    public void selectMinimumIntegerValue()
    {
        selectMinimum(INTEGER_VALUE);
    }

    public void selectMaximumIntegerValue()
    {
        selectMaximum(INTEGER_VALUE);
    }

    public void selectAverageIntegerValue()
    {
        selectAverage(INTEGER_VALUE);
    }

    public void selectSumIntegerValue()
    {
        selectSum(INTEGER_VALUE);
    }

    public void groupByIntegerValue()
    {
        groupBy(INTEGER_VALUE);
    }

    //##################################################
    //# projections (longValue)
    //##################################################

    public void selectLongValue()
    {
        select(LONG_VALUE);
    }

    public void selectDistinctLongValue()
    {
        selectDistinct(LONG_VALUE);
    }

    public void selectCountDistinctLongValue()
    {
        selectCountDistinct(LONG_VALUE);
    }

    public void selectMinimumLongValue()
    {
        selectMinimum(LONG_VALUE);
    }

    public void selectMaximumLongValue()
    {
        selectMaximum(LONG_VALUE);
    }

    public void selectAverageLongValue()
    {
        selectAverage(LONG_VALUE);
    }

    public void selectSumLongValue()
    {
        selectSum(LONG_VALUE);
    }

    public void groupByLongValue()
    {
        groupBy(LONG_VALUE);
    }

    //##################################################
    //# projections (doubleValue)
    //##################################################

    public void selectDoubleValue()
    {
        select(DOUBLE_VALUE);
    }

    public void selectDistinctDoubleValue()
    {
        selectDistinct(DOUBLE_VALUE);
    }

    public void selectCountDistinctDoubleValue()
    {
        selectCountDistinct(DOUBLE_VALUE);
    }

    public void selectMinimumDoubleValue()
    {
        selectMinimum(DOUBLE_VALUE);
    }

    public void selectMaximumDoubleValue()
    {
        selectMaximum(DOUBLE_VALUE);
    }

    public void selectAverageDoubleValue()
    {
        selectAverage(DOUBLE_VALUE);
    }

    public void selectSumDoubleValue()
    {
        selectSum(DOUBLE_VALUE);
    }

    public void groupByDoubleValue()
    {
        groupBy(DOUBLE_VALUE);
    }

    //##################################################
    //# projections (moneyValue)
    //##################################################

    public void selectMoneyValue()
    {
        select(MONEY_VALUE);
    }

    public void selectDistinctMoneyValue()
    {
        selectDistinct(MONEY_VALUE);
    }

    public void selectCountDistinctMoneyValue()
    {
        selectCountDistinct(MONEY_VALUE);
    }

    public void selectMinimumMoneyValue()
    {
        selectMinimum(MONEY_VALUE);
    }

    public void selectMaximumMoneyValue()
    {
        selectMaximum(MONEY_VALUE);
    }

    public void selectAverageMoneyValue()
    {
        selectAverage(MONEY_VALUE);
    }

    public void selectSumMoneyValue()
    {
        selectSum(MONEY_VALUE);
    }

    public void groupByMoneyValue()
    {
        groupBy(MONEY_VALUE);
    }

    //##################################################
    //# projections (booleanValue)
    //##################################################

    public void selectBooleanValue()
    {
        select(BOOLEAN_VALUE);
    }

    public void selectDistinctBooleanValue()
    {
        selectDistinct(BOOLEAN_VALUE);
    }

    public void selectCountDistinctBooleanValue()
    {
        selectCountDistinct(BOOLEAN_VALUE);
    }

    public void selectMinimumBooleanValue()
    {
        selectMinimum(BOOLEAN_VALUE);
    }

    public void selectMaximumBooleanValue()
    {
        selectMaximum(BOOLEAN_VALUE);
    }

    public void selectAverageBooleanValue()
    {
        selectAverage(BOOLEAN_VALUE);
    }

    public void selectSumBooleanValue()
    {
        selectSum(BOOLEAN_VALUE);
    }

    public void groupByBooleanValue()
    {
        groupBy(BOOLEAN_VALUE);
    }

    //##################################################
    //# projections (dateValue)
    //##################################################

    public void selectDateValue()
    {
        select(DATE_VALUE);
    }

    public void selectDistinctDateValue()
    {
        selectDistinct(DATE_VALUE);
    }

    public void selectCountDistinctDateValue()
    {
        selectCountDistinct(DATE_VALUE);
    }

    public void selectMinimumDateValue()
    {
        selectMinimum(DATE_VALUE);
    }

    public void selectMaximumDateValue()
    {
        selectMaximum(DATE_VALUE);
    }

    public void selectAverageDateValue()
    {
        selectAverage(DATE_VALUE);
    }

    public void selectSumDateValue()
    {
        selectSum(DATE_VALUE);
    }

    public void groupByDateValue()
    {
        groupBy(DATE_VALUE);
    }

    //##################################################
    //# projections (timestampValue)
    //##################################################

    public void selectTimestampValue()
    {
        select(TIMESTAMP_VALUE);
    }

    public void selectDistinctTimestampValue()
    {
        selectDistinct(TIMESTAMP_VALUE);
    }

    public void selectCountDistinctTimestampValue()
    {
        selectCountDistinct(TIMESTAMP_VALUE);
    }

    public void selectMinimumTimestampValue()
    {
        selectMinimum(TIMESTAMP_VALUE);
    }

    public void selectMaximumTimestampValue()
    {
        selectMaximum(TIMESTAMP_VALUE);
    }

    public void selectAverageTimestampValue()
    {
        selectAverage(TIMESTAMP_VALUE);
    }

    public void selectSumTimestampValue()
    {
        selectSum(TIMESTAMP_VALUE);
    }

    public void groupByTimestampValue()
    {
        groupBy(TIMESTAMP_VALUE);
    }

    //##################################################
    //# projections (uidValue)
    //##################################################

    public void selectUidValue()
    {
        select(UID_VALUE);
    }

    public void selectDistinctUidValue()
    {
        selectDistinct(UID_VALUE);
    }

    public void selectCountDistinctUidValue()
    {
        selectCountDistinct(UID_VALUE);
    }

    public void selectMinimumUidValue()
    {
        selectMinimum(UID_VALUE);
    }

    public void selectMaximumUidValue()
    {
        selectMaximum(UID_VALUE);
    }

    public void selectAverageUidValue()
    {
        selectAverage(UID_VALUE);
    }

    public void selectSumUidValue()
    {
        selectSum(UID_VALUE);
    }

    public void groupByUidValue()
    {
        groupBy(UID_VALUE);
    }

    //##################################################
    //# association (User)
    //##################################################

    public void selectUserUid()
    {
        select(USER_UID);
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
        return new KmhStringCondition(parent(), fullName(USER_UID));
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyAuditLogJunction all()
    {
        return addAnd();
    }

    public MyAuditLogJunction any()
    {
        return addOr();
    }

    public MyAuditLogJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyAuditLogJunction addNotAnd()
    {
        return new MyAuditLogJunction(parent().addNotAnd());
    }

    public MyAuditLogJunction addNotOr()
    {
        return new MyAuditLogJunction(parent().addNotOr());
    }

    public MyAuditLogJunction addAnd()
    {
        return new MyAuditLogJunction(parent().addAnd());
    }

    public MyAuditLogJunction addOr()
    {
        return new MyAuditLogJunction(parent().addOr());
    }
}
