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

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UPDATED_UTC_TS));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), fullName(CODE));
    }

    public KmhStringCondition whereCompanyName()
    {
        return new KmhStringCondition(context(), fullName(COMPANY_NAME));
    }

    public KmhStringCondition whereSendEmailFrom()
    {
        return new KmhStringCondition(context(), fullName(SEND_EMAIL_FROM));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
    }

    public KmhIntegerCondition whereCatalogVersion()
    {
        return new KmhIntegerCondition(context(), fullName(CATALOG_VERSION));
    }

    public KmhPropertyCondition<KmDayFrequency> whereBusinessDays()
    {
        return new KmhPropertyCondition<>(context(), fullName(BUSINESS_DAYS));
    }

    public KmhTimeCondition whereBusinessStartTime()
    {
        return new KmhTimeCondition(context(), fullName(BUSINESS_START_TIME));
    }

    public KmhTimeCondition whereBusinessEndTime()
    {
        return new KmhTimeCondition(context(), fullName(BUSINESS_END_TIME));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

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
