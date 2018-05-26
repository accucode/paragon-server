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

public class MyCustomerJunction
    extends KmhModelJunction
    implements MyCustomerDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereBillingAttention()
    {
        return new KmhStringCondition(context(), alias(), BILLING_ATTENTION);
    }

    public KmhStringCondition whereBillingCity()
    {
        return new KmhStringCondition(context(), alias(), BILLING_CITY);
    }

    public KmhStringCondition whereBillingCountry()
    {
        return new KmhStringCondition(context(), alias(), BILLING_COUNTRY);
    }

    public KmhStringCondition whereBillingPhone()
    {
        return new KmhStringCondition(context(), alias(), BILLING_PHONE);
    }

    public KmhStringCondition whereBillingPostalCode()
    {
        return new KmhStringCondition(context(), alias(), BILLING_POSTAL_CODE);
    }

    public KmhStringCondition whereBillingRegion()
    {
        return new KmhStringCondition(context(), alias(), BILLING_REGION);
    }

    public KmhStringCondition whereBillingStreet1()
    {
        return new KmhStringCondition(context(), alias(), BILLING_STREET_1);
    }

    public KmhStringCondition whereBillingStreet2()
    {
        return new KmhStringCondition(context(), alias(), BILLING_STREET_2);
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
    //# association (ApprovalContact)
    //##################################################

//    public MyCustomerContactCriteria joinToApprovalContact()
//    {
//        return new MyCustomerContactCriteria(joinTo(APPROVAL_CONTACT));
//    }
//
//    public MyCustomerContactCriteria leftJoinToApprovalContact()
//    {
//        return new MyCustomerContactCriteria(leftJoinTo(APPROVAL_CONTACT));
//    }

    public KmhStringCondition whereApprovalContactUid()
    {
        return new KmhStringCondition(context(), alias(), APPROVAL_CONTACT_UID);
    }

    public void whereApprovalContactIs(MyCustomerContact e)
    {
        if ( e == null )
            whereApprovalContactUid().isNull();
        else
            whereApprovalContactUid().is(e.getUid());
    }

    public void whereApprovalContactIsNot(MyCustomerContact e)
    {
        if ( e == null )
            whereApprovalContactUid().isNotNull();
        else
            whereApprovalContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (BillingContact)
    //##################################################

//    public MyCustomerContactCriteria joinToBillingContact()
//    {
//        return new MyCustomerContactCriteria(joinTo(BILLING_CONTACT));
//    }
//
//    public MyCustomerContactCriteria leftJoinToBillingContact()
//    {
//        return new MyCustomerContactCriteria(leftJoinTo(BILLING_CONTACT));
//    }

    public KmhStringCondition whereBillingContactUid()
    {
        return new KmhStringCondition(context(), alias(), BILLING_CONTACT_UID);
    }

    public void whereBillingContactIs(MyCustomerContact e)
    {
        if ( e == null )
            whereBillingContactUid().isNull();
        else
            whereBillingContactUid().is(e.getUid());
    }

    public void whereBillingContactIsNot(MyCustomerContact e)
    {
        if ( e == null )
            whereBillingContactUid().isNotNull();
        else
            whereBillingContactUid().isNot(e.getUid());
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

    public MyCustomerJunction addAnd()
    {
        return new MyCustomerJunction(context().addAnd());
    }

    public MyCustomerJunction addOr()
    {
        return new MyCustomerJunction(context().addOr());
    }

}
