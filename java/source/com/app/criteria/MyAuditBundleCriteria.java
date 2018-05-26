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

public class MyAuditBundleCriteria
    extends MyAbstractCriteria<MyAuditBundle>
    implements MyAuditBundleDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundleCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyAuditBundle e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyAuditBundle e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereChangeTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CHANGE_TYPE_CODE);
    }

    public void whereChangeTypeIs(MyAuditBundleChangeType e)
    {
        if ( e == null )
            whereChangeTypeCode().isNull();
        else
            whereChangeTypeCode().is(e.getCode());
    }

    public void whereChangeTypeIsNot(MyAuditBundleChangeType e)
    {
        if ( e == null )
            whereChangeTypeCode().isNull();
        else
            whereChangeTypeCode().isNot(e.getCode());
    }

    public void whereChangeTypeIsAdd()
    {
        whereChangeTypeIs(MyAuditBundleChangeType.Add);
    }

    public void whereChangeTypeIsNotAdd()
    {
        whereChangeTypeIsNot(MyAuditBundleChangeType.Add);
    }

    public void whereChangeTypeIsAdd(boolean e)
    {
        if ( e )
            whereChangeTypeIsAdd();
        else
            whereChangeTypeIsNotAdd();
    }

    public void whereChangeTypeIsUpdate()
    {
        whereChangeTypeIs(MyAuditBundleChangeType.Update);
    }

    public void whereChangeTypeIsNotUpdate()
    {
        whereChangeTypeIsNot(MyAuditBundleChangeType.Update);
    }

    public void whereChangeTypeIsUpdate(boolean e)
    {
        if ( e )
            whereChangeTypeIsUpdate();
        else
            whereChangeTypeIsNotUpdate();
    }

    public void whereChangeTypeIsDelete()
    {
        whereChangeTypeIs(MyAuditBundleChangeType.Delete);
    }

    public void whereChangeTypeIsNotDelete()
    {
        whereChangeTypeIsNot(MyAuditBundleChangeType.Delete);
    }

    public void whereChangeTypeIsDelete(boolean e)
    {
        if ( e )
            whereChangeTypeIsDelete();
        else
            whereChangeTypeIsNotDelete();
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDomainName()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_NAME);
    }

    public KmhStringCondition whereDomainType()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_TYPE);
    }

    public KmhStringCondition whereDomainUid()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_UID);
    }

    public KmhStringCondition whereTransactionUid()
    {
        return new KmhStringCondition(context(), alias(), TRANSACTION_UID);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhStringCondition whereUserName()
    {
        return new KmhStringCondition(context(), alias(), USER_NAME);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnChangeTypeCode()
    {
        parent().sortAscending(CHANGE_TYPE_CODE);
    }

    public void sortOnChangeTypeCodeDescending()
    {
        parent().sortDescending(CHANGE_TYPE_CODE);
    }

    public void sortOnChangeTypeCode(boolean asc)
    {
        if ( asc )
            sortOnChangeTypeCode();
        else
            sortOnChangeTypeCodeDescending();
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

    //##################################################
    //# projections (changeTypeCode)
    //##################################################

    public void selectChangeTypeCode()
    {
        select(CHANGE_TYPE_CODE);
    }

    public void selectDistinctChangeTypeCode()
    {
        selectDistinct(CHANGE_TYPE_CODE);
    }

    public void selectCountDistinctChangeTypeCode()
    {
        selectCountDistinct(CHANGE_TYPE_CODE);
    }

    public void selectMinimumChangeTypeCode()
    {
        selectMinimum(CHANGE_TYPE_CODE);
    }

    public void selectMaximumChangeTypeCode()
    {
        selectMaximum(CHANGE_TYPE_CODE);
    }

    public void selectAverageChangeTypeCode()
    {
        selectAverage(CHANGE_TYPE_CODE);
    }

    public void selectSumChangeTypeCode()
    {
        selectSum(CHANGE_TYPE_CODE);
    }

    public void groupByChangeTypeCode()
    {
        groupBy(CHANGE_TYPE_CODE);
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
    //# collection (Logs)
    //##################################################

    public MyAuditLogCriteria joinToLogs()
    {
        return new MyAuditLogCriteria(joinTo(LOGS));
    }

    public MyAuditLogCriteria leftJoinToLogs()
    {
        return new MyAuditLogCriteria(leftJoinTo(LOGS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyAuditBundleJunction all()
    {
        return addAnd();
    }

    public MyAuditBundleJunction any()
    {
        return addOr();
    }

    public MyAuditBundleJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyAuditBundleJunction addNotAnd()
    {
        return new MyAuditBundleJunction(parent().addNotAnd());
    }

    public MyAuditBundleJunction addNotOr()
    {
        return new MyAuditBundleJunction(parent().addNotOr());
    }

    public MyAuditBundleJunction addAnd()
    {
        return new MyAuditBundleJunction(parent().addAnd());
    }

    public MyAuditBundleJunction addOr()
    {
        return new MyAuditBundleJunction(parent().addOr());
    }
}
