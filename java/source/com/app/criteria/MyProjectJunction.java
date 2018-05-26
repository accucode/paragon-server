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

public class MyProjectJunction
    extends KmhModelJunction
    implements MyProjectDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhBooleanCondition whereAutoSiteNumberEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), AUTO_SITE_NUMBER_ENABLED);
    }

    public KmhIntegerCondition whereAutoSiteNumberPadding()
    {
        return new KmhIntegerCondition(context(), alias(), AUTO_SITE_NUMBER_PADDING);
    }

    public KmhStringCondition whereAutoSiteNumberPrefix()
    {
        return new KmhStringCondition(context(), alias(), AUTO_SITE_NUMBER_PREFIX);
    }

    public KmhPropertyCondition<KmDayFrequency> whereBusinessDays()
    {
        return new KmhPropertyCondition<>(context(), alias(), BUSINESS_DAYS);
    }

    public KmhTimeCondition whereBusinessEndTime()
    {
        return new KmhTimeCondition(context(), alias(), BUSINESS_END_TIME);
    }

    public KmhTimeCondition whereBusinessStartTime()
    {
        return new KmhTimeCondition(context(), alias(), BUSINESS_START_TIME);
    }

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), alias(), CODE);
    }

    public KmhStringCondition whereCompanyName()
    {
        return new KmhStringCondition(context(), alias(), COMPANY_NAME);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), alias(), DESCRIPTION);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhIntegerCondition whereNextAutoSiteNumber()
    {
        return new KmhIntegerCondition(context(), alias(), NEXT_AUTO_SITE_NUMBER);
    }

    public KmhStringCondition whereSendEmailFrom()
    {
        return new KmhStringCondition(context(), alias(), SEND_EMAIL_FROM);
    }

    public KmhStringCondition whereTimeZoneCode()
    {
        return new KmhStringCondition(context(), alias(), TIME_ZONE_CODE);
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
    //# association (DefaultPriority)
    //##################################################

//    public MyPriorityCriteria joinToDefaultPriority()
//    {
//        return new MyPriorityCriteria(joinTo(DEFAULT_PRIORITY));
//    }
//
//    public MyPriorityCriteria leftJoinToDefaultPriority()
//    {
//        return new MyPriorityCriteria(leftJoinTo(DEFAULT_PRIORITY));
//    }

    public KmhStringCondition whereDefaultPriorityUid()
    {
        return new KmhStringCondition(context(), alias(), DEFAULT_PRIORITY_UID);
    }

    public void whereDefaultPriorityIs(MyPriority e)
    {
        if ( e == null )
            whereDefaultPriorityUid().isNull();
        else
            whereDefaultPriorityUid().is(e.getUid());
    }

    public void whereDefaultPriorityIsNot(MyPriority e)
    {
        if ( e == null )
            whereDefaultPriorityUid().isNotNull();
        else
            whereDefaultPriorityUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Supervisor)
    //##################################################

//    public MyUserCriteria joinToSupervisor()
//    {
//        return new MyUserCriteria(joinTo(SUPERVISOR));
//    }
//
//    public MyUserCriteria leftJoinToSupervisor()
//    {
//        return new MyUserCriteria(leftJoinTo(SUPERVISOR));
//    }

    public KmhStringCondition whereSupervisorUid()
    {
        return new KmhStringCondition(context(), alias(), SUPERVISOR_UID);
    }

    public void whereSupervisorIs(MyUser e)
    {
        if ( e == null )
            whereSupervisorUid().isNull();
        else
            whereSupervisorUid().is(e.getUid());
    }

    public void whereSupervisorIsNot(MyUser e)
    {
        if ( e == null )
            whereSupervisorUid().isNotNull();
        else
            whereSupervisorUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SupportContact)
    //##################################################

//    public MyProjectContactCriteria joinToSupportContact()
//    {
//        return new MyProjectContactCriteria(joinTo(SUPPORT_CONTACT));
//    }
//
//    public MyProjectContactCriteria leftJoinToSupportContact()
//    {
//        return new MyProjectContactCriteria(leftJoinTo(SUPPORT_CONTACT));
//    }

    public KmhStringCondition whereSupportContactUid()
    {
        return new KmhStringCondition(context(), alias(), SUPPORT_CONTACT_UID);
    }

    public void whereSupportContactIs(MyProjectContact e)
    {
        if ( e == null )
            whereSupportContactUid().isNull();
        else
            whereSupportContactUid().is(e.getUid());
    }

    public void whereSupportContactIsNot(MyProjectContact e)
    {
        if ( e == null )
            whereSupportContactUid().isNotNull();
        else
            whereSupportContactUid().isNot(e.getUid());
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

    public MyProjectJunction addAnd()
    {
        return new MyProjectJunction(context().addAnd());
    }

    public MyProjectJunction addOr()
    {
        return new MyProjectJunction(context().addOr());
    }

}
