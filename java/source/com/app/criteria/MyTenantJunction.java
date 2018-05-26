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

public class MyTenantJunction
    extends KmhModelJunction
    implements MyTenantDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

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

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereHostname()
    {
        return new KmhStringCondition(context(), alias(), HOSTNAME);
    }

    public KmhStringCondition whereMemo()
    {
        return new KmhStringCondition(context(), alias(), MEMO);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereThemeCode()
    {
        return new KmhStringCondition(context(), alias(), THEME_CODE);
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

    public MyTenantJunction addAnd()
    {
        return new MyTenantJunction(context().addAnd());
    }

    public MyTenantJunction addOr()
    {
        return new MyTenantJunction(context().addOr());
    }

}
