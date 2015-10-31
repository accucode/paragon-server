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

    public KmhTimestampCondition whereUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UTC_TS));
    }

    public KmhStringCondition whereModelType()
    {
        return new KmhStringCondition(context(), fullName(MODEL_TYPE));
    }

    public KmhStringCondition whereModelName()
    {
        return new KmhStringCondition(context(), fullName(MODEL_NAME));
    }

    public KmhStringCondition whereModelUid()
    {
        return new KmhStringCondition(context(), fullName(MODEL_UID));
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

    public void sortOnUtcTs()
    {
        parent().sortAscending(UTC_TS);
    }

    public void sortOnUtcTsDescending()
    {
        parent().sortDescending(UTC_TS);
    }

    public void sortOnUtcTs(boolean asc)
    {
        if ( asc )
            sortOnUtcTs();
        else
            sortOnUtcTsDescending();
    }

    public void sortOnModelType()
    {
        parent().sortAscending(MODEL_TYPE);
    }

    public void sortOnModelTypeDescending()
    {
        parent().sortDescending(MODEL_TYPE);
    }

    public void sortOnModelType(boolean asc)
    {
        if ( asc )
            sortOnModelType();
        else
            sortOnModelTypeDescending();
    }

    public void sortOnModelName()
    {
        parent().sortAscending(MODEL_NAME);
    }

    public void sortOnModelNameDescending()
    {
        parent().sortDescending(MODEL_NAME);
    }

    public void sortOnModelName(boolean asc)
    {
        if ( asc )
            sortOnModelName();
        else
            sortOnModelNameDescending();
    }

    public void sortOnModelUid()
    {
        parent().sortAscending(MODEL_UID);
    }

    public void sortOnModelUidDescending()
    {
        parent().sortDescending(MODEL_UID);
    }

    public void sortOnModelUid(boolean asc)
    {
        if ( asc )
            sortOnModelUid();
        else
            sortOnModelUidDescending();
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
    //# projections (utcTs)
    //##################################################

    public void selectUtcTs()
    {
        select(UTC_TS);
    }

    public void selectDistinctUtcTs()
    {
        selectDistinct(UTC_TS);
    }

    public void selectCountDistinctUtcTs()
    {
        selectCountDistinct(UTC_TS);
    }

    public void selectMinimumUtcTs()
    {
        selectMinimum(UTC_TS);
    }

    public void selectMaximumUtcTs()
    {
        selectMaximum(UTC_TS);
    }

    public void selectAverageUtcTs()
    {
        selectAverage(UTC_TS);
    }

    public void selectSumUtcTs()
    {
        selectSum(UTC_TS);
    }

    public void groupByUtcTs()
    {
        groupBy(UTC_TS);
    }

    //##################################################
    //# projections (modelType)
    //##################################################

    public void selectModelType()
    {
        select(MODEL_TYPE);
    }

    public void selectDistinctModelType()
    {
        selectDistinct(MODEL_TYPE);
    }

    public void selectCountDistinctModelType()
    {
        selectCountDistinct(MODEL_TYPE);
    }

    public void selectMinimumModelType()
    {
        selectMinimum(MODEL_TYPE);
    }

    public void selectMaximumModelType()
    {
        selectMaximum(MODEL_TYPE);
    }

    public void selectAverageModelType()
    {
        selectAverage(MODEL_TYPE);
    }

    public void selectSumModelType()
    {
        selectSum(MODEL_TYPE);
    }

    public void groupByModelType()
    {
        groupBy(MODEL_TYPE);
    }

    //##################################################
    //# projections (modelName)
    //##################################################

    public void selectModelName()
    {
        select(MODEL_NAME);
    }

    public void selectDistinctModelName()
    {
        selectDistinct(MODEL_NAME);
    }

    public void selectCountDistinctModelName()
    {
        selectCountDistinct(MODEL_NAME);
    }

    public void selectMinimumModelName()
    {
        selectMinimum(MODEL_NAME);
    }

    public void selectMaximumModelName()
    {
        selectMaximum(MODEL_NAME);
    }

    public void selectAverageModelName()
    {
        selectAverage(MODEL_NAME);
    }

    public void selectSumModelName()
    {
        selectSum(MODEL_NAME);
    }

    public void groupByModelName()
    {
        groupBy(MODEL_NAME);
    }

    //##################################################
    //# projections (modelUid)
    //##################################################

    public void selectModelUid()
    {
        select(MODEL_UID);
    }

    public void selectDistinctModelUid()
    {
        selectDistinct(MODEL_UID);
    }

    public void selectCountDistinctModelUid()
    {
        selectCountDistinct(MODEL_UID);
    }

    public void selectMinimumModelUid()
    {
        selectMinimum(MODEL_UID);
    }

    public void selectMaximumModelUid()
    {
        selectMaximum(MODEL_UID);
    }

    public void selectAverageModelUid()
    {
        selectAverage(MODEL_UID);
    }

    public void selectSumModelUid()
    {
        selectSum(MODEL_UID);
    }

    public void groupByModelUid()
    {
        groupBy(MODEL_UID);
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
        groupBy(USER);
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
    //# junction
    //##################################################

    public MyAuditLogJunction addAnd()
    {
        return new MyAuditLogJunction(parent().addAnd());
    }

    public MyAuditLogJunction addOr()
    {
        return new MyAuditLogJunction(parent().addOr());
    }
}
