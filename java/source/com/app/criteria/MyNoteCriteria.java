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

public class MyNoteCriteria
    extends MyAbstractCriteria<MyNote>
    implements MyNoteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyNoteCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyNote e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyNote e)
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

    public KmhStringCondition whereMessage()
    {
        return new KmhStringCondition(context(), alias(), MESSAGE);
    }

    public KmhStringCondition whereOwnerTypeCode()
    {
        return new KmhStringCondition(context(), alias(), OWNER_TYPE_CODE);
    }

    public void whereOwnerTypeIs(MyNoteOwnerType e)
    {
        if ( e == null )
            whereOwnerTypeCode().isNull();
        else
            whereOwnerTypeCode().is(e.getCode());
    }

    public void whereOwnerTypeIsNot(MyNoteOwnerType e)
    {
        if ( e == null )
            whereOwnerTypeCode().isNull();
        else
            whereOwnerTypeCode().isNot(e.getCode());
    }

    public void whereOwnerTypeIsProject()
    {
        whereOwnerTypeIs(MyNoteOwnerType.Project);
    }

    public void whereOwnerTypeIsNotProject()
    {
        whereOwnerTypeIsNot(MyNoteOwnerType.Project);
    }

    public void whereOwnerTypeIsProject(boolean e)
    {
        if ( e )
            whereOwnerTypeIsProject();
        else
            whereOwnerTypeIsNotProject();
    }

    public void whereOwnerTypeIsCustomer()
    {
        whereOwnerTypeIs(MyNoteOwnerType.Customer);
    }

    public void whereOwnerTypeIsNotCustomer()
    {
        whereOwnerTypeIsNot(MyNoteOwnerType.Customer);
    }

    public void whereOwnerTypeIsCustomer(boolean e)
    {
        if ( e )
            whereOwnerTypeIsCustomer();
        else
            whereOwnerTypeIsNotCustomer();
    }

    public void whereOwnerTypeIsSite()
    {
        whereOwnerTypeIs(MyNoteOwnerType.Site);
    }

    public void whereOwnerTypeIsNotSite()
    {
        whereOwnerTypeIsNot(MyNoteOwnerType.Site);
    }

    public void whereOwnerTypeIsSite(boolean e)
    {
        if ( e )
            whereOwnerTypeIsSite();
        else
            whereOwnerTypeIsNotSite();
    }

    public KmhStringCondition whereSourceTypeCode()
    {
        return new KmhStringCondition(context(), alias(), SOURCE_TYPE_CODE);
    }

    public void whereSourceTypeIs(MyNoteSourceType e)
    {
        if ( e == null )
            whereSourceTypeCode().isNull();
        else
            whereSourceTypeCode().is(e.getCode());
    }

    public void whereSourceTypeIsNot(MyNoteSourceType e)
    {
        if ( e == null )
            whereSourceTypeCode().isNull();
        else
            whereSourceTypeCode().isNot(e.getCode());
    }

    public void whereSourceTypeIsUser()
    {
        whereSourceTypeIs(MyNoteSourceType.User);
    }

    public void whereSourceTypeIsNotUser()
    {
        whereSourceTypeIsNot(MyNoteSourceType.User);
    }

    public void whereSourceTypeIsUser(boolean e)
    {
        if ( e )
            whereSourceTypeIsUser();
        else
            whereSourceTypeIsNotUser();
    }

    public void whereSourceTypeIsSystem()
    {
        whereSourceTypeIs(MyNoteSourceType.System);
    }

    public void whereSourceTypeIsNotSystem()
    {
        whereSourceTypeIsNot(MyNoteSourceType.System);
    }

    public void whereSourceTypeIsSystem(boolean e)
    {
        if ( e )
            whereSourceTypeIsSystem();
        else
            whereSourceTypeIsNotSystem();
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

    public void sortOnMessage()
    {
        parent().sortAscending(MESSAGE);
    }

    public void sortOnMessageDescending()
    {
        parent().sortDescending(MESSAGE);
    }

    public void sortOnMessage(boolean asc)
    {
        if ( asc )
            sortOnMessage();
        else
            sortOnMessageDescending();
    }

    public void sortOnOwnerTypeCode()
    {
        parent().sortAscending(OWNER_TYPE_CODE);
    }

    public void sortOnOwnerTypeCodeDescending()
    {
        parent().sortDescending(OWNER_TYPE_CODE);
    }

    public void sortOnOwnerTypeCode(boolean asc)
    {
        if ( asc )
            sortOnOwnerTypeCode();
        else
            sortOnOwnerTypeCodeDescending();
    }

    public void sortOnSourceTypeCode()
    {
        parent().sortAscending(SOURCE_TYPE_CODE);
    }

    public void sortOnSourceTypeCodeDescending()
    {
        parent().sortDescending(SOURCE_TYPE_CODE);
    }

    public void sortOnSourceTypeCode(boolean asc)
    {
        if ( asc )
            sortOnSourceTypeCode();
        else
            sortOnSourceTypeCodeDescending();
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
    //# projections (message)
    //##################################################

    public void selectMessage()
    {
        select(MESSAGE);
    }

    public void selectDistinctMessage()
    {
        selectDistinct(MESSAGE);
    }

    public void selectCountDistinctMessage()
    {
        selectCountDistinct(MESSAGE);
    }

    public void selectMinimumMessage()
    {
        selectMinimum(MESSAGE);
    }

    public void selectMaximumMessage()
    {
        selectMaximum(MESSAGE);
    }

    public void selectAverageMessage()
    {
        selectAverage(MESSAGE);
    }

    public void selectSumMessage()
    {
        selectSum(MESSAGE);
    }

    public void groupByMessage()
    {
        groupBy(MESSAGE);
    }

    //##################################################
    //# projections (ownerTypeCode)
    //##################################################

    public void selectOwnerTypeCode()
    {
        select(OWNER_TYPE_CODE);
    }

    public void selectDistinctOwnerTypeCode()
    {
        selectDistinct(OWNER_TYPE_CODE);
    }

    public void selectCountDistinctOwnerTypeCode()
    {
        selectCountDistinct(OWNER_TYPE_CODE);
    }

    public void selectMinimumOwnerTypeCode()
    {
        selectMinimum(OWNER_TYPE_CODE);
    }

    public void selectMaximumOwnerTypeCode()
    {
        selectMaximum(OWNER_TYPE_CODE);
    }

    public void selectAverageOwnerTypeCode()
    {
        selectAverage(OWNER_TYPE_CODE);
    }

    public void selectSumOwnerTypeCode()
    {
        selectSum(OWNER_TYPE_CODE);
    }

    public void groupByOwnerTypeCode()
    {
        groupBy(OWNER_TYPE_CODE);
    }

    //##################################################
    //# projections (sourceTypeCode)
    //##################################################

    public void selectSourceTypeCode()
    {
        select(SOURCE_TYPE_CODE);
    }

    public void selectDistinctSourceTypeCode()
    {
        selectDistinct(SOURCE_TYPE_CODE);
    }

    public void selectCountDistinctSourceTypeCode()
    {
        selectCountDistinct(SOURCE_TYPE_CODE);
    }

    public void selectMinimumSourceTypeCode()
    {
        selectMinimum(SOURCE_TYPE_CODE);
    }

    public void selectMaximumSourceTypeCode()
    {
        selectMaximum(SOURCE_TYPE_CODE);
    }

    public void selectAverageSourceTypeCode()
    {
        selectAverage(SOURCE_TYPE_CODE);
    }

    public void selectSumSourceTypeCode()
    {
        selectSum(SOURCE_TYPE_CODE);
    }

    public void groupBySourceTypeCode()
    {
        groupBy(SOURCE_TYPE_CODE);
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
    //# association (Customer)
    //##################################################

    public void selectCustomerUid()
    {
        select(CUSTOMER_UID);
    }

    public void selectCountDistinctCustomerUid()
    {
        selectCountDistinct(CUSTOMER_UID);
    }
    
    public void selectDistinctCustomerUid()
    {
        selectDistinct(CUSTOMER_UID);
    }

    public void selectMinimumCustomerUid()
    {
        selectMinimum(CUSTOMER_UID);
    }

    public void selectMaximumCustomerUid()
    {
        selectMaximum(CUSTOMER_UID);
    }

    public void groupByCustomerUid()
    {
        groupBy(CUSTOMER_UID);
    }

    public MyCustomerCriteria joinToCustomer()
    {
        return new MyCustomerCriteria(joinTo(CUSTOMER));
    }

    public MyCustomerCriteria leftJoinToCustomer()
    {
        return new MyCustomerCriteria(leftJoinTo(CUSTOMER));
    }

    public KmhStringCondition whereCustomerUid()
    {
        return new KmhStringCondition(parent(), alias(), CUSTOMER_UID);
    }

    public void whereCustomerIs(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNull();
        else
            whereCustomerUid().is(e.getUid());
    }

    public void whereCustomerIsNot(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNotNull();
        else
            whereCustomerUid().isNot(e.getUid());
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
    //# association (Site)
    //##################################################

    public void selectSiteUid()
    {
        select(SITE_UID);
    }

    public void selectCountDistinctSiteUid()
    {
        selectCountDistinct(SITE_UID);
    }
    
    public void selectDistinctSiteUid()
    {
        selectDistinct(SITE_UID);
    }

    public void selectMinimumSiteUid()
    {
        selectMinimum(SITE_UID);
    }

    public void selectMaximumSiteUid()
    {
        selectMaximum(SITE_UID);
    }

    public void groupBySiteUid()
    {
        groupBy(SITE_UID);
    }

    public MySiteCriteria joinToSite()
    {
        return new MySiteCriteria(joinTo(SITE));
    }

    public MySiteCriteria leftJoinToSite()
    {
        return new MySiteCriteria(leftJoinTo(SITE));
    }

    public KmhStringCondition whereSiteUid()
    {
        return new KmhStringCondition(parent(), alias(), SITE_UID);
    }

    public void whereSiteIs(MySite e)
    {
        if ( e == null )
            whereSiteUid().isNull();
        else
            whereSiteUid().is(e.getUid());
    }

    public void whereSiteIsNot(MySite e)
    {
        if ( e == null )
            whereSiteUid().isNotNull();
        else
            whereSiteUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Tenant)
    //##################################################

    public void selectTenantUid()
    {
        select(TENANT_UID);
    }

    public void selectCountDistinctTenantUid()
    {
        selectCountDistinct(TENANT_UID);
    }
    
    public void selectDistinctTenantUid()
    {
        selectDistinct(TENANT_UID);
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
        return new KmhStringCondition(parent(), alias(), TENANT_UID);
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    public void whereTenantIsNot(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNotNull();
        else
            whereTenantUid().isNot(e.getUid());
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
    //# junction :: alias
    //##################################################

    public MyNoteJunction all()
    {
        return addAnd();
    }

    public MyNoteJunction any()
    {
        return addOr();
    }

    public MyNoteJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyNoteJunction addNotAnd()
    {
        return new MyNoteJunction(parent().addNotAnd());
    }

    public MyNoteJunction addNotOr()
    {
        return new MyNoteJunction(parent().addNotOr());
    }

    public MyNoteJunction addAnd()
    {
        return new MyNoteJunction(parent().addAnd());
    }

    public MyNoteJunction addOr()
    {
        return new MyNoteJunction(parent().addOr());
    }
}
