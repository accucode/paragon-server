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

public class MyMemberJunction
    extends KmhModelJunction
    implements MyMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhIntegerCondition whereDashboardLineCount1()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_LINE_COUNT_1);
    }

    public KmhIntegerCondition whereDashboardLineCount2()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_LINE_COUNT_2);
    }

    public KmhStringCondition whereDashboardOrientationTypeCode()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_ORIENTATION_TYPE_CODE);
    }

    public KmhStringCondition whereDashboardPanelCodeA()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_A);
    }

    public KmhStringCondition whereDashboardPanelCodeB()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_B);
    }

    public KmhStringCondition whereDashboardPanelCodeC()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_C);
    }

    public KmhStringCondition whereDashboardPanelCodeD()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_D);
    }

    public KmhStringCondition whereDashboardPanelCodeE()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_E);
    }

    public KmhStringCondition whereDashboardPanelCodeF()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_F);
    }

    public KmhStringCondition whereDashboardPanelCodeG()
    {
        return new KmhStringCondition(context(), alias(), DASHBOARD_PANEL_CODE_G);
    }

    public KmhIntegerCondition whereDashboardRefreshMinutes()
    {
        return new KmhIntegerCondition(context(), alias(), DASHBOARD_REFRESH_MINUTES);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), alias(), ROLE_CODE);
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
    //# association (User)
    //##################################################

//    public MyUserCriteria joinToUser()
//    {
//        return new MyUserCriteria(joinTo(USER));
//    }
//
//    public MyUserCriteria leftJoinToUser()
//    {
//        return new MyUserCriteria(leftJoinTo(USER));
//    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(context(), alias(), USER_UID);
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
    //# junction
    //##################################################

    public MyMemberJunction addAnd()
    {
        return new MyMemberJunction(context().addAnd());
    }

    public MyMemberJunction addOr()
    {
        return new MyMemberJunction(context().addOr());
    }

}
