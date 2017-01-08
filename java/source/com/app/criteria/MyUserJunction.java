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

public class MyUserJunction
    extends KmhModelJunction
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserJunction(KmhJunction context)
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

    public KmhStringCondition whereFirstName()
    {
        return new KmhStringCondition(context(), fullName(FIRST_NAME));
    }

    public KmhStringCondition whereLastName()
    {
        return new KmhStringCondition(context(), fullName(LAST_NAME));
    }

    public KmhStringCondition whereNickname()
    {
        return new KmhStringCondition(context(), fullName(NICKNAME));
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhStringCondition wherePasswordSalt()
    {
        return new KmhStringCondition(context(), fullName(PASSWORD_SALT));
    }

    public KmhStringCondition wherePasswordHash()
    {
        return new KmhStringCondition(context(), fullName(PASSWORD_HASH));
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), fullName(PHONE));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
    }

    public KmhStringCondition whereTimeZoneCode()
    {
        return new KmhStringCondition(context(), fullName(TIME_ZONE_CODE));
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), fullName(ROLE_CODE));
    }

    public KmhStringCondition whereDashboardOrientationTypeCode()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_ORIENTATION_TYPE_CODE));
    }

    public KmhIntegerCondition whereDashboardLineCount1()
    {
        return new KmhIntegerCondition(context(), fullName(DASHBOARD_LINE_COUNT_1));
    }

    public KmhIntegerCondition whereDashboardLineCount2()
    {
        return new KmhIntegerCondition(context(), fullName(DASHBOARD_LINE_COUNT_2));
    }

    public KmhStringCondition whereDashboardPanelCodeA()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_A));
    }

    public KmhStringCondition whereDashboardPanelCodeB()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_B));
    }

    public KmhStringCondition whereDashboardPanelCodeC()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_C));
    }

    public KmhStringCondition whereDashboardPanelCodeD()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_D));
    }

    public KmhStringCondition whereDashboardPanelCodeE()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_E));
    }

    public KmhStringCondition whereDashboardPanelCodeF()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_F));
    }

    public KmhStringCondition whereDashboardPanelCodeG()
    {
        return new KmhStringCondition(context(), fullName(DASHBOARD_PANEL_CODE_G));
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

    public MyUserJunction addAnd()
    {
        return new MyUserJunction(context().addAnd());
    }

    public MyUserJunction addOr()
    {
        return new MyUserJunction(context().addOr());
    }

}
