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

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyCustomerContactCriteria
    extends MyAbstractCriteria<MyCustomerContact>
    implements MyCustomerContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereTitle()
    {
        return new KmhStringCondition(context(), fullName(TITLE));
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), fullName(PHONE));
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhBooleanCondition whereOrderNotifications()
    {
        return new KmhBooleanCondition(context(), fullName(ORDER_NOTIFICATIONS));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnName()
    {
        parent().sortAscending(NAME);
    }

    public void sortOnNameDescending()
    {
        parent().sortDescending(NAME);
    }

    public void sortOnName(boolean asc)
    {
        if ( asc )
            sortOnName();
        else
            sortOnNameDescending();
    }

    public void sortOnTitle()
    {
        parent().sortAscending(TITLE);
    }

    public void sortOnTitleDescending()
    {
        parent().sortDescending(TITLE);
    }

    public void sortOnTitle(boolean asc)
    {
        if ( asc )
            sortOnTitle();
        else
            sortOnTitleDescending();
    }

    public void sortOnPhone()
    {
        parent().sortAscending(PHONE);
    }

    public void sortOnPhoneDescending()
    {
        parent().sortDescending(PHONE);
    }

    public void sortOnPhone(boolean asc)
    {
        if ( asc )
            sortOnPhone();
        else
            sortOnPhoneDescending();
    }

    public void sortOnEmail()
    {
        parent().sortAscending(EMAIL);
    }

    public void sortOnEmailDescending()
    {
        parent().sortDescending(EMAIL);
    }

    public void sortOnEmail(boolean asc)
    {
        if ( asc )
            sortOnEmail();
        else
            sortOnEmailDescending();
    }

    public void sortOnOrderNotifications()
    {
        parent().sortAscending(ORDER_NOTIFICATIONS);
    }

    public void sortOnOrderNotificationsDescending()
    {
        parent().sortDescending(ORDER_NOTIFICATIONS);
    }

    public void sortOnOrderNotifications(boolean asc)
    {
        if ( asc )
            sortOnOrderNotifications();
        else
            sortOnOrderNotificationsDescending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (name)
    //##################################################

    public void selectName()
    {
        select(NAME);
    }

    public void selectDistinctName()
    {
        selectDistinct(NAME);
    }

    public void selectCountDistinctName()
    {
        selectCountDistinct(NAME);
    }

    public void selectMinimumName()
    {
        selectMinimum(NAME);
    }

    public void selectMaximumName()
    {
        selectMaximum(NAME);
    }

    public void selectAverageName()
    {
        selectAverage(NAME);
    }

    public void selectSumName()
    {
        selectSum(NAME);
    }

    public void groupByName()
    {
        groupBy(NAME);
    }

    //##################################################
    //# projections (title)
    //##################################################

    public void selectTitle()
    {
        select(TITLE);
    }

    public void selectDistinctTitle()
    {
        selectDistinct(TITLE);
    }

    public void selectCountDistinctTitle()
    {
        selectCountDistinct(TITLE);
    }

    public void selectMinimumTitle()
    {
        selectMinimum(TITLE);
    }

    public void selectMaximumTitle()
    {
        selectMaximum(TITLE);
    }

    public void selectAverageTitle()
    {
        selectAverage(TITLE);
    }

    public void selectSumTitle()
    {
        selectSum(TITLE);
    }

    public void groupByTitle()
    {
        groupBy(TITLE);
    }

    //##################################################
    //# projections (phone)
    //##################################################

    public void selectPhone()
    {
        select(PHONE);
    }

    public void selectDistinctPhone()
    {
        selectDistinct(PHONE);
    }

    public void selectCountDistinctPhone()
    {
        selectCountDistinct(PHONE);
    }

    public void selectMinimumPhone()
    {
        selectMinimum(PHONE);
    }

    public void selectMaximumPhone()
    {
        selectMaximum(PHONE);
    }

    public void selectAveragePhone()
    {
        selectAverage(PHONE);
    }

    public void selectSumPhone()
    {
        selectSum(PHONE);
    }

    public void groupByPhone()
    {
        groupBy(PHONE);
    }

    //##################################################
    //# projections (email)
    //##################################################

    public void selectEmail()
    {
        select(EMAIL);
    }

    public void selectDistinctEmail()
    {
        selectDistinct(EMAIL);
    }

    public void selectCountDistinctEmail()
    {
        selectCountDistinct(EMAIL);
    }

    public void selectMinimumEmail()
    {
        selectMinimum(EMAIL);
    }

    public void selectMaximumEmail()
    {
        selectMaximum(EMAIL);
    }

    public void selectAverageEmail()
    {
        selectAverage(EMAIL);
    }

    public void selectSumEmail()
    {
        selectSum(EMAIL);
    }

    public void groupByEmail()
    {
        groupBy(EMAIL);
    }

    //##################################################
    //# projections (orderNotifications)
    //##################################################

    public void selectOrderNotifications()
    {
        select(ORDER_NOTIFICATIONS);
    }

    public void selectDistinctOrderNotifications()
    {
        selectDistinct(ORDER_NOTIFICATIONS);
    }

    public void selectCountDistinctOrderNotifications()
    {
        selectCountDistinct(ORDER_NOTIFICATIONS);
    }

    public void selectMinimumOrderNotifications()
    {
        selectMinimum(ORDER_NOTIFICATIONS);
    }

    public void selectMaximumOrderNotifications()
    {
        selectMaximum(ORDER_NOTIFICATIONS);
    }

    public void selectAverageOrderNotifications()
    {
        selectAverage(ORDER_NOTIFICATIONS);
    }

    public void selectSumOrderNotifications()
    {
        selectSum(ORDER_NOTIFICATIONS);
    }

    public void groupByOrderNotifications()
    {
        groupBy(ORDER_NOTIFICATIONS);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# association (Customer)
    //##################################################

    public void selectCustomerUid()
    {
        select(CUSTOMER_UID);
    }

    public void selectMinimumCustomerUid()
    {
        selectMinimum(CUSTOMER_UID);
    }

    public void selectMaximumCustomerUid()
    {
        selectMaximum(CUSTOMER_UID);
    }

    public void groupByCustomerUid()
    {
        groupBy(CUSTOMER);
    }

    public MyCustomerCriteria joinToCustomer()
    {
        return new MyCustomerCriteria(joinTo(CUSTOMER));
    }

    public MyCustomerCriteria leftJoinToCustomer()
    {
        return new MyCustomerCriteria(leftJoinTo(CUSTOMER));
    }

    public KmhStringCondition whereCustomerUid()
    {
        return new KmhStringCondition(parent(), fullName(CUSTOMER_UID));
    }

    public void whereCustomerIs(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNull();
        else
            whereCustomerUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyCustomerContactJunction addAnd()
    {
        return new MyCustomerContactJunction(parent().addAnd());
    }

    public MyCustomerContactJunction addOr()
    {
        return new MyCustomerContactJunction(parent().addOr());
    }
}
