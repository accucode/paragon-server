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

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyAttachmentJunction
    extends KmhModelJunction
    implements MyAttachmentDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentJunction(KmhJunction context)
    {
        super(context);
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

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
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
    //# associations
    //##################################################
    //##################################################
    //# association (CreatedBy)
    //##################################################

//    public MyUserCriteria joinToCreatedBy()
//    {
//        return new MyUserCriteria(joinTo(CREATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToCreatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(CREATED_BY));
//    }

    public KmhStringCondition whereCreatedByUid()
    {
        return new KmhStringCondition(context(), alias(), CREATED_BY_UID);
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

//    public MyCustomerCriteria joinToCustomer()
//    {
//        return new MyCustomerCriteria(joinTo(CUSTOMER));
//    }
//
//    public MyCustomerCriteria leftJoinToCustomer()
//    {
//        return new MyCustomerCriteria(leftJoinTo(CUSTOMER));
//    }

    public KmhStringCondition whereCustomerUid()
    {
        return new KmhStringCondition(context(), alias(), CUSTOMER_UID);
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

//    public MyProjectCriteria joinToProject()
//    {
//        return new MyProjectCriteria(joinTo(PROJECT));
//    }
//
//    public MyProjectCriteria leftJoinToProject()
//    {
//        return new MyProjectCriteria(leftJoinTo(PROJECT));
//    }

    public KmhStringCondition whereProjectUid()
    {
        return new KmhStringCondition(context(), alias(), PROJECT_UID);
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

//    public MySiteCriteria joinToSite()
//    {
//        return new MySiteCriteria(joinTo(SITE));
//    }
//
//    public MySiteCriteria leftJoinToSite()
//    {
//        return new MySiteCriteria(leftJoinTo(SITE));
//    }

    public KmhStringCondition whereSiteUid()
    {
        return new KmhStringCondition(context(), alias(), SITE_UID);
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

//    public MyTenantCriteria joinToTenant()
//    {
//        return new MyTenantCriteria(joinTo(TENANT));
//    }
//
//    public MyTenantCriteria leftJoinToTenant()
//    {
//        return new MyTenantCriteria(leftJoinTo(TENANT));
//    }

    public KmhStringCondition whereTenantUid()
    {
        return new KmhStringCondition(context(), alias(), TENANT_UID);
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

//    public MyUserCriteria joinToUpdatedBy()
//    {
//        return new MyUserCriteria(joinTo(UPDATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToUpdatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(UPDATED_BY));
//    }

    public KmhStringCondition whereUpdatedByUid()
    {
        return new KmhStringCondition(context(), alias(), UPDATED_BY_UID);
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
    //# junction
    //##################################################

    public MyAttachmentJunction addAnd()
    {
        return new MyAttachmentJunction(context().addAnd());
    }

    public MyAttachmentJunction addOr()
    {
        return new MyAttachmentJunction(context().addOr());
    }

}
