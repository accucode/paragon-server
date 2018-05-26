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

public class MyAttachmentCriteria
    extends MyAbstractCriteria<MyAttachment>
    implements MyAttachmentDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyAttachment e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyAttachment e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhPropertyCondition<KmBlob> whereContent()
    {
        return new KmhPropertyCondition<>(context(), alias(), CONTENT);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereOwnerTypeCode()
    {
        return new KmhStringCondition(context(), alias(), OWNER_TYPE_CODE);
    }

    public void whereOwnerTypeIs(MyAttachmentOwnerType e)
    {
        if ( e == null )
            whereOwnerTypeCode().isNull();
        else
            whereOwnerTypeCode().is(e.getCode());
    }

    public void whereOwnerTypeIsNot(MyAttachmentOwnerType e)
    {
        if ( e == null )
            whereOwnerTypeCode().isNull();
        else
            whereOwnerTypeCode().isNot(e.getCode());
    }

    public void whereOwnerTypeIsProject()
    {
        whereOwnerTypeIs(MyAttachmentOwnerType.Project);
    }

    public void whereOwnerTypeIsNotProject()
    {
        whereOwnerTypeIsNot(MyAttachmentOwnerType.Project);
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
        whereOwnerTypeIs(MyAttachmentOwnerType.Customer);
    }

    public void whereOwnerTypeIsNotCustomer()
    {
        whereOwnerTypeIsNot(MyAttachmentOwnerType.Customer);
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
        whereOwnerTypeIs(MyAttachmentOwnerType.Site);
    }

    public void whereOwnerTypeIsNotSite()
    {
        whereOwnerTypeIsNot(MyAttachmentOwnerType.Site);
    }

    public void whereOwnerTypeIsSite(boolean e)
    {
        if ( e )
            whereOwnerTypeIsSite();
        else
            whereOwnerTypeIsNotSite();
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public void whereTypeIs(MyAttachmentType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyAttachmentType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsOther()
    {
        whereTypeIs(MyAttachmentType.Other);
    }

    public void whereTypeIsNotOther()
    {
        whereTypeIsNot(MyAttachmentType.Other);
    }

    public void whereTypeIsOther(boolean e)
    {
        if ( e )
            whereTypeIsOther();
        else
            whereTypeIsNotOther();
    }

    public void whereTypeIsText()
    {
        whereTypeIs(MyAttachmentType.Text);
    }

    public void whereTypeIsNotText()
    {
        whereTypeIsNot(MyAttachmentType.Text);
    }

    public void whereTypeIsText(boolean e)
    {
        if ( e )
            whereTypeIsText();
        else
            whereTypeIsNotText();
    }

    public void whereTypeIsPdf()
    {
        whereTypeIs(MyAttachmentType.Pdf);
    }

    public void whereTypeIsNotPdf()
    {
        whereTypeIsNot(MyAttachmentType.Pdf);
    }

    public void whereTypeIsPdf(boolean e)
    {
        if ( e )
            whereTypeIsPdf();
        else
            whereTypeIsNotPdf();
    }

    public void whereTypeIsImage()
    {
        whereTypeIs(MyAttachmentType.Image);
    }

    public void whereTypeIsNotImage()
    {
        whereTypeIsNot(MyAttachmentType.Image);
    }

    public void whereTypeIsImage(boolean e)
    {
        if ( e )
            whereTypeIsImage();
        else
            whereTypeIsNotImage();
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

    public void sortOnContent()
    {
        parent().sortAscending(CONTENT);
    }

    public void sortOnContentDescending()
    {
        parent().sortDescending(CONTENT);
    }

    public void sortOnContent(boolean asc)
    {
        if ( asc )
            sortOnContent();
        else
            sortOnContentDescending();
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
    //# projections (content)
    //##################################################

    public void selectContent()
    {
        select(CONTENT);
    }

    public void selectDistinctContent()
    {
        selectDistinct(CONTENT);
    }

    public void selectCountDistinctContent()
    {
        selectCountDistinct(CONTENT);
    }

    public void selectMinimumContent()
    {
        selectMinimum(CONTENT);
    }

    public void selectMaximumContent()
    {
        selectMaximum(CONTENT);
    }

    public void selectAverageContent()
    {
        selectAverage(CONTENT);
    }

    public void selectSumContent()
    {
        selectSum(CONTENT);
    }

    public void groupByContent()
    {
        groupBy(CONTENT);
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

    public MyAttachmentJunction all()
    {
        return addAnd();
    }

    public MyAttachmentJunction any()
    {
        return addOr();
    }

    public MyAttachmentJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyAttachmentJunction addNotAnd()
    {
        return new MyAttachmentJunction(parent().addNotAnd());
    }

    public MyAttachmentJunction addNotOr()
    {
        return new MyAttachmentJunction(parent().addNotOr());
    }

    public MyAttachmentJunction addAnd()
    {
        return new MyAttachmentJunction(parent().addAnd());
    }

    public MyAttachmentJunction addOr()
    {
        return new MyAttachmentJunction(parent().addOr());
    }
}
