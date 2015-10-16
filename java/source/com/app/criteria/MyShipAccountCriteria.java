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

public class MyShipAccountCriteria
    extends MyAbstractCriteria<MyShipAccount>
    implements MyShipAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipAccountCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), fullName(DESCRIPTION));
    }

    public KmhBooleanCondition whereBilledToCustomer()
    {
        return new KmhBooleanCondition(context(), fullName(BILLED_TO_CUSTOMER));
    }

    public KmhStringCondition whereShipOnAccountName()
    {
        return new KmhStringCondition(context(), fullName(SHIP_ON_ACCOUNT_NAME));
    }

    public KmhStringCondition whereShipOnAccountNumber()
    {
        return new KmhStringCondition(context(), fullName(SHIP_ON_ACCOUNT_NUMBER));
    }

    public KmhStringCondition whereBillToTypeCode()
    {
        return new KmhStringCondition(context(), fullName(BILL_TO_TYPE_CODE));
    }

    public void whereBillToTypeIs(MyShipAccountBillToType e)
    {
        if ( e == null )
            whereBillToTypeCode().isNull();
        else
            whereBillToTypeCode().is(e.getCode());
    }

    public void whereBillToTypeIsNot(MyShipAccountBillToType e)
    {
        if ( e == null )
            whereBillToTypeCode().isNull();
        else
            whereBillToTypeCode().isNot(e.getCode());
    }

    public void whereBillToTypeIsSender()
    {
        whereBillToTypeIs(MyShipAccountBillToType.Sender);
    }

    public void whereBillToTypeIsNotSender()
    {
        whereBillToTypeIsNot(MyShipAccountBillToType.Sender);
    }

    public void whereBillToTypeIsSender(boolean e)
    {
        if ( e )
            whereBillToTypeIsSender();
        else
            whereBillToTypeIsNotSender();
    }

    public void whereBillToTypeIsReceiving()
    {
        whereBillToTypeIs(MyShipAccountBillToType.Receiving);
    }

    public void whereBillToTypeIsNotReceiving()
    {
        whereBillToTypeIsNot(MyShipAccountBillToType.Receiving);
    }

    public void whereBillToTypeIsReceiving(boolean e)
    {
        if ( e )
            whereBillToTypeIsReceiving();
        else
            whereBillToTypeIsNotReceiving();
    }

    public void whereBillToTypeIsThird()
    {
        whereBillToTypeIs(MyShipAccountBillToType.Third);
    }

    public void whereBillToTypeIsNotThird()
    {
        whereBillToTypeIsNot(MyShipAccountBillToType.Third);
    }

    public void whereBillToTypeIsThird(boolean e)
    {
        if ( e )
            whereBillToTypeIsThird();
        else
            whereBillToTypeIsNotThird();
    }

    public KmhStringCondition whereBillToAccount()
    {
        return new KmhStringCondition(context(), fullName(BILL_TO_ACCOUNT));
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

    public void sortOnDescription()
    {
        parent().sortAscending(DESCRIPTION);
    }

    public void sortOnDescriptionDescending()
    {
        parent().sortDescending(DESCRIPTION);
    }

    public void sortOnDescription(boolean asc)
    {
        if ( asc )
            sortOnDescription();
        else
            sortOnDescriptionDescending();
    }

    public void sortOnBilledToCustomer()
    {
        parent().sortAscending(BILLED_TO_CUSTOMER);
    }

    public void sortOnBilledToCustomerDescending()
    {
        parent().sortDescending(BILLED_TO_CUSTOMER);
    }

    public void sortOnBilledToCustomer(boolean asc)
    {
        if ( asc )
            sortOnBilledToCustomer();
        else
            sortOnBilledToCustomerDescending();
    }

    public void sortOnShipOnAccountName()
    {
        parent().sortAscending(SHIP_ON_ACCOUNT_NAME);
    }

    public void sortOnShipOnAccountNameDescending()
    {
        parent().sortDescending(SHIP_ON_ACCOUNT_NAME);
    }

    public void sortOnShipOnAccountName(boolean asc)
    {
        if ( asc )
            sortOnShipOnAccountName();
        else
            sortOnShipOnAccountNameDescending();
    }

    public void sortOnShipOnAccountNumber()
    {
        parent().sortAscending(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void sortOnShipOnAccountNumberDescending()
    {
        parent().sortDescending(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void sortOnShipOnAccountNumber(boolean asc)
    {
        if ( asc )
            sortOnShipOnAccountNumber();
        else
            sortOnShipOnAccountNumberDescending();
    }

    public void sortOnBillToTypeCode()
    {
        parent().sortAscending(BILL_TO_TYPE_CODE);
    }

    public void sortOnBillToTypeCodeDescending()
    {
        parent().sortDescending(BILL_TO_TYPE_CODE);
    }

    public void sortOnBillToTypeCode(boolean asc)
    {
        if ( asc )
            sortOnBillToTypeCode();
        else
            sortOnBillToTypeCodeDescending();
    }

    public void sortOnBillToAccount()
    {
        parent().sortAscending(BILL_TO_ACCOUNT);
    }

    public void sortOnBillToAccountDescending()
    {
        parent().sortDescending(BILL_TO_ACCOUNT);
    }

    public void sortOnBillToAccount(boolean asc)
    {
        if ( asc )
            sortOnBillToAccount();
        else
            sortOnBillToAccountDescending();
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
    //# projections (description)
    //##################################################

    public void selectDescription()
    {
        select(DESCRIPTION);
    }

    public void selectDistinctDescription()
    {
        selectDistinct(DESCRIPTION);
    }

    public void selectCountDistinctDescription()
    {
        selectCountDistinct(DESCRIPTION);
    }

    public void selectMinimumDescription()
    {
        selectMinimum(DESCRIPTION);
    }

    public void selectMaximumDescription()
    {
        selectMaximum(DESCRIPTION);
    }

    public void selectAverageDescription()
    {
        selectAverage(DESCRIPTION);
    }

    public void selectSumDescription()
    {
        selectSum(DESCRIPTION);
    }

    public void groupByDescription()
    {
        groupBy(DESCRIPTION);
    }

    //##################################################
    //# projections (billedToCustomer)
    //##################################################

    public void selectBilledToCustomer()
    {
        select(BILLED_TO_CUSTOMER);
    }

    public void selectDistinctBilledToCustomer()
    {
        selectDistinct(BILLED_TO_CUSTOMER);
    }

    public void selectCountDistinctBilledToCustomer()
    {
        selectCountDistinct(BILLED_TO_CUSTOMER);
    }

    public void selectMinimumBilledToCustomer()
    {
        selectMinimum(BILLED_TO_CUSTOMER);
    }

    public void selectMaximumBilledToCustomer()
    {
        selectMaximum(BILLED_TO_CUSTOMER);
    }

    public void selectAverageBilledToCustomer()
    {
        selectAverage(BILLED_TO_CUSTOMER);
    }

    public void selectSumBilledToCustomer()
    {
        selectSum(BILLED_TO_CUSTOMER);
    }

    public void groupByBilledToCustomer()
    {
        groupBy(BILLED_TO_CUSTOMER);
    }

    //##################################################
    //# projections (shipOnAccountName)
    //##################################################

    public void selectShipOnAccountName()
    {
        select(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectDistinctShipOnAccountName()
    {
        selectDistinct(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectCountDistinctShipOnAccountName()
    {
        selectCountDistinct(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectMinimumShipOnAccountName()
    {
        selectMinimum(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectMaximumShipOnAccountName()
    {
        selectMaximum(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectAverageShipOnAccountName()
    {
        selectAverage(SHIP_ON_ACCOUNT_NAME);
    }

    public void selectSumShipOnAccountName()
    {
        selectSum(SHIP_ON_ACCOUNT_NAME);
    }

    public void groupByShipOnAccountName()
    {
        groupBy(SHIP_ON_ACCOUNT_NAME);
    }

    //##################################################
    //# projections (shipOnAccountNumber)
    //##################################################

    public void selectShipOnAccountNumber()
    {
        select(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectDistinctShipOnAccountNumber()
    {
        selectDistinct(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectCountDistinctShipOnAccountNumber()
    {
        selectCountDistinct(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectMinimumShipOnAccountNumber()
    {
        selectMinimum(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectMaximumShipOnAccountNumber()
    {
        selectMaximum(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectAverageShipOnAccountNumber()
    {
        selectAverage(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void selectSumShipOnAccountNumber()
    {
        selectSum(SHIP_ON_ACCOUNT_NUMBER);
    }

    public void groupByShipOnAccountNumber()
    {
        groupBy(SHIP_ON_ACCOUNT_NUMBER);
    }

    //##################################################
    //# projections (billToTypeCode)
    //##################################################

    public void selectBillToTypeCode()
    {
        select(BILL_TO_TYPE_CODE);
    }

    public void selectDistinctBillToTypeCode()
    {
        selectDistinct(BILL_TO_TYPE_CODE);
    }

    public void selectCountDistinctBillToTypeCode()
    {
        selectCountDistinct(BILL_TO_TYPE_CODE);
    }

    public void selectMinimumBillToTypeCode()
    {
        selectMinimum(BILL_TO_TYPE_CODE);
    }

    public void selectMaximumBillToTypeCode()
    {
        selectMaximum(BILL_TO_TYPE_CODE);
    }

    public void selectAverageBillToTypeCode()
    {
        selectAverage(BILL_TO_TYPE_CODE);
    }

    public void selectSumBillToTypeCode()
    {
        selectSum(BILL_TO_TYPE_CODE);
    }

    public void groupByBillToTypeCode()
    {
        groupBy(BILL_TO_TYPE_CODE);
    }

    //##################################################
    //# projections (billToAccount)
    //##################################################

    public void selectBillToAccount()
    {
        select(BILL_TO_ACCOUNT);
    }

    public void selectDistinctBillToAccount()
    {
        selectDistinct(BILL_TO_ACCOUNT);
    }

    public void selectCountDistinctBillToAccount()
    {
        selectCountDistinct(BILL_TO_ACCOUNT);
    }

    public void selectMinimumBillToAccount()
    {
        selectMinimum(BILL_TO_ACCOUNT);
    }

    public void selectMaximumBillToAccount()
    {
        selectMaximum(BILL_TO_ACCOUNT);
    }

    public void selectAverageBillToAccount()
    {
        selectAverage(BILL_TO_ACCOUNT);
    }

    public void selectSumBillToAccount()
    {
        selectSum(BILL_TO_ACCOUNT);
    }

    public void groupByBillToAccount()
    {
        groupBy(BILL_TO_ACCOUNT);
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
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectMinimumProjectUid()
    {
        selectMinimum(PROJECT_UID);
    }

    public void selectMaximumProjectUid()
    {
        selectMaximum(PROJECT_UID);
    }

    public void groupByProjectUid()
    {
        groupBy(PROJECT);
    }

    public MyProjectCriteria joinToProject()
    {
        return new MyProjectCriteria(joinTo(PROJECT));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECT));
    }

    public KmhStringCondition whereProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(PROJECT_UID));
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
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
    //# association (Carrier)
    //##################################################

    public void selectCarrierUid()
    {
        select(CARRIER_UID);
    }

    public void selectMinimumCarrierUid()
    {
        selectMinimum(CARRIER_UID);
    }

    public void selectMaximumCarrierUid()
    {
        selectMaximum(CARRIER_UID);
    }

    public void groupByCarrierUid()
    {
        groupBy(CARRIER);
    }

    public MyShipCarrierCriteria joinToCarrier()
    {
        return new MyShipCarrierCriteria(joinTo(CARRIER));
    }

    public MyShipCarrierCriteria leftJoinToCarrier()
    {
        return new MyShipCarrierCriteria(leftJoinTo(CARRIER));
    }

    public KmhStringCondition whereCarrierUid()
    {
        return new KmhStringCondition(parent(), fullName(CARRIER_UID));
    }

    public void whereCarrierIs(MyShipCarrier e)
    {
        if ( e == null )
            whereCarrierUid().isNull();
        else
            whereCarrierUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyShipAccountJunction addAnd()
    {
        return new MyShipAccountJunction(parent().addAnd());
    }

    public MyShipAccountJunction addOr()
    {
        return new MyShipAccountJunction(parent().addOr());
    }
}
