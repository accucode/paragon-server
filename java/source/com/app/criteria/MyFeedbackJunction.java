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

public class MyFeedbackJunction
    extends KmhModelJunction
    implements MyFeedbackDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhDateCondition whereClosedDate()
    {
        return new KmhDateCondition(context(), alias(), CLOSED_DATE);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), alias(), DESCRIPTION);
    }

    public KmhStringCondition whereNotes()
    {
        return new KmhStringCondition(context(), alias(), NOTES);
    }

    public KmhBooleanCondition whereOpen()
    {
        return new KmhBooleanCondition(context(), alias(), OPEN);
    }

    public KmhStringCondition wherePageKey()
    {
        return new KmhStringCondition(context(), alias(), PAGE_KEY);
    }

    public KmhStringCondition whereQueryString()
    {
        return new KmhStringCondition(context(), alias(), QUERY_STRING);
    }

    public KmhStringCondition whereRequestUrl()
    {
        return new KmhStringCondition(context(), alias(), REQUEST_URL);
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), alias(), STATUS_CODE);
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

    public KmhStringCondition whereWindowLocation()
    {
        return new KmhStringCondition(context(), alias(), WINDOW_LOCATION);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (ClosedBy)
    //##################################################

//    public MyUserCriteria joinToClosedBy()
//    {
//        return new MyUserCriteria(joinTo(CLOSED_BY));
//    }
//
//    public MyUserCriteria leftJoinToClosedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(CLOSED_BY));
//    }

    public KmhStringCondition whereClosedByUid()
    {
        return new KmhStringCondition(context(), alias(), CLOSED_BY_UID);
    }

    public void whereClosedByIs(MyUser e)
    {
        if ( e == null )
            whereClosedByUid().isNull();
        else
            whereClosedByUid().is(e.getUid());
    }

    public void whereClosedByIsNot(MyUser e)
    {
        if ( e == null )
            whereClosedByUid().isNotNull();
        else
            whereClosedByUid().isNot(e.getUid());
    }

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

    public MyFeedbackJunction addAnd()
    {
        return new MyFeedbackJunction(context().addAnd());
    }

    public MyFeedbackJunction addOr()
    {
        return new MyFeedbackJunction(context().addOr());
    }

}
