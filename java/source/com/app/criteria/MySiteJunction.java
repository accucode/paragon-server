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

public class MySiteJunction
    extends KmhModelJunction
    implements MySiteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereAddressAttention()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_ATTENTION);
    }

    public KmhStringCondition whereAddressCity()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_CITY);
    }

    public KmhStringCondition whereAddressCountry()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_COUNTRY);
    }

    public KmhStringCondition whereAddressPhone()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_PHONE);
    }

    public KmhStringCondition whereAddressPostalCode()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_POSTAL_CODE);
    }

    public KmhStringCondition whereAddressRegion()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_REGION);
    }

    public KmhStringCondition whereAddressStreet1()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_STREET_1);
    }

    public KmhStringCondition whereAddressStreet2()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_STREET_2);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereFullName()
    {
        return new KmhStringCondition(context(), alias(), FULL_NAME);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereNumber()
    {
        return new KmhStringCondition(context(), alias(), NUMBER);
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
    //# association (InstallContact)
    //##################################################

//    public MySiteContactCriteria joinToInstallContact()
//    {
//        return new MySiteContactCriteria(joinTo(INSTALL_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToInstallContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(INSTALL_CONTACT));
//    }

    public KmhStringCondition whereInstallContactUid()
    {
        return new KmhStringCondition(context(), alias(), INSTALL_CONTACT_UID);
    }

    public void whereInstallContactIs(MySiteContact e)
    {
        if ( e == null )
            whereInstallContactUid().isNull();
        else
            whereInstallContactUid().is(e.getUid());
    }

    public void whereInstallContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereInstallContactUid().isNotNull();
        else
            whereInstallContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (MainContact)
    //##################################################

//    public MySiteContactCriteria joinToMainContact()
//    {
//        return new MySiteContactCriteria(joinTo(MAIN_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToMainContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(MAIN_CONTACT));
//    }

    public KmhStringCondition whereMainContactUid()
    {
        return new KmhStringCondition(context(), alias(), MAIN_CONTACT_UID);
    }

    public void whereMainContactIs(MySiteContact e)
    {
        if ( e == null )
            whereMainContactUid().isNull();
        else
            whereMainContactUid().is(e.getUid());
    }

    public void whereMainContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereMainContactUid().isNotNull();
        else
            whereMainContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Priority)
    //##################################################

//    public MyPriorityCriteria joinToPriority()
//    {
//        return new MyPriorityCriteria(joinTo(PRIORITY));
//    }
//
//    public MyPriorityCriteria leftJoinToPriority()
//    {
//        return new MyPriorityCriteria(leftJoinTo(PRIORITY));
//    }

    public KmhStringCondition wherePriorityUid()
    {
        return new KmhStringCondition(context(), alias(), PRIORITY_UID);
    }

    public void wherePriorityIs(MyPriority e)
    {
        if ( e == null )
            wherePriorityUid().isNull();
        else
            wherePriorityUid().is(e.getUid());
    }

    public void wherePriorityIsNot(MyPriority e)
    {
        if ( e == null )
            wherePriorityUid().isNotNull();
        else
            wherePriorityUid().isNot(e.getUid());
    }

    //##################################################
    //# association (RequesterContact)
    //##################################################

//    public MySiteContactCriteria joinToRequesterContact()
//    {
//        return new MySiteContactCriteria(joinTo(REQUESTER_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToRequesterContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(REQUESTER_CONTACT));
//    }

    public KmhStringCondition whereRequesterContactUid()
    {
        return new KmhStringCondition(context(), alias(), REQUESTER_CONTACT_UID);
    }

    public void whereRequesterContactIs(MySiteContact e)
    {
        if ( e == null )
            whereRequesterContactUid().isNull();
        else
            whereRequesterContactUid().is(e.getUid());
    }

    public void whereRequesterContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereRequesterContactUid().isNotNull();
        else
            whereRequesterContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SalesContact)
    //##################################################

//    public MySiteContactCriteria joinToSalesContact()
//    {
//        return new MySiteContactCriteria(joinTo(SALES_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToSalesContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(SALES_CONTACT));
//    }

    public KmhStringCondition whereSalesContactUid()
    {
        return new KmhStringCondition(context(), alias(), SALES_CONTACT_UID);
    }

    public void whereSalesContactIs(MySiteContact e)
    {
        if ( e == null )
            whereSalesContactUid().isNull();
        else
            whereSalesContactUid().is(e.getUid());
    }

    public void whereSalesContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereSalesContactUid().isNotNull();
        else
            whereSalesContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SchedulingContact)
    //##################################################

//    public MySiteContactCriteria joinToSchedulingContact()
//    {
//        return new MySiteContactCriteria(joinTo(SCHEDULING_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToSchedulingContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(SCHEDULING_CONTACT));
//    }

    public KmhStringCondition whereSchedulingContactUid()
    {
        return new KmhStringCondition(context(), alias(), SCHEDULING_CONTACT_UID);
    }

    public void whereSchedulingContactIs(MySiteContact e)
    {
        if ( e == null )
            whereSchedulingContactUid().isNull();
        else
            whereSchedulingContactUid().is(e.getUid());
    }

    public void whereSchedulingContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereSchedulingContactUid().isNotNull();
        else
            whereSchedulingContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (TechnicalContact)
    //##################################################

//    public MySiteContactCriteria joinToTechnicalContact()
//    {
//        return new MySiteContactCriteria(joinTo(TECHNICAL_CONTACT));
//    }
//
//    public MySiteContactCriteria leftJoinToTechnicalContact()
//    {
//        return new MySiteContactCriteria(leftJoinTo(TECHNICAL_CONTACT));
//    }

    public KmhStringCondition whereTechnicalContactUid()
    {
        return new KmhStringCondition(context(), alias(), TECHNICAL_CONTACT_UID);
    }

    public void whereTechnicalContactIs(MySiteContact e)
    {
        if ( e == null )
            whereTechnicalContactUid().isNull();
        else
            whereTechnicalContactUid().is(e.getUid());
    }

    public void whereTechnicalContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereTechnicalContactUid().isNotNull();
        else
            whereTechnicalContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Type)
    //##################################################

//    public MyChoiceCriteria joinToType()
//    {
//        return new MyChoiceCriteria(joinTo(TYPE));
//    }
//
//    public MyChoiceCriteria leftJoinToType()
//    {
//        return new MyChoiceCriteria(leftJoinTo(TYPE));
//    }

    public KmhStringCondition whereTypeUid()
    {
        return new KmhStringCondition(context(), alias(), TYPE_UID);
    }

    public void whereTypeIs(MyChoice e)
    {
        if ( e == null )
            whereTypeUid().isNull();
        else
            whereTypeUid().is(e.getUid());
    }

    public void whereTypeIsNot(MyChoice e)
    {
        if ( e == null )
            whereTypeUid().isNotNull();
        else
            whereTypeUid().isNot(e.getUid());
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

    public MySiteJunction addAnd()
    {
        return new MySiteJunction(context().addAnd());
    }

    public MySiteJunction addOr()
    {
        return new MySiteJunction(context().addOr());
    }

}
