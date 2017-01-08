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

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereHostname()
    {
        return new KmhStringCondition(context(), fullName(HOSTNAME));
    }

    public KmhStringCondition whereThemeCode()
    {
        return new KmhStringCondition(context(), fullName(THEME_CODE));
    }

    public KmhStringCondition whereIntacctCompanyId()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_COMPANY_ID));
    }

    public KmhStringCondition whereIntacctUserId()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_USER_ID));
    }

    public KmhStringCondition whereIntacctUserPassword()
    {
        return new KmhStringCondition(context(), fullName(INTACCT_USER_PASSWORD));
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

    public MyTenantJunction addAnd()
    {
        return new MyTenantJunction(context().addAnd());
    }

    public MyTenantJunction addOr()
    {
        return new MyTenantJunction(context().addOr());
    }

}
