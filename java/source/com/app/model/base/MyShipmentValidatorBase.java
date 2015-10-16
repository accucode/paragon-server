//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.exception.error.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Validation rules for shipment.
 */
public class MyShipmentValidatorBase
    extends MyDomainValidator<MyShipment>
{
    //##################################################
    //# static
    //##################################################

    public static final MyShipmentValidator instance = new MyShipmentValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator trackingNumberValidator;
    private KmDoubleValidator weightValidator;
    private KmMoneyValidator costValidator;
    private KmBooleanValidator invoiceCustomerValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyShipmentValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        trackingNumberValidator = newTrackingNumberValidator();
        weightValidator = newWeightValidator();
        costValidator = newCostValidator();
        invoiceCustomerValidator = newInvoiceCustomerValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getTrackingNumberValidator()
    {
        return trackingNumberValidator;
    }

    public KmDoubleValidator getWeightValidator()
    {
        return weightValidator;
    }

    public KmMoneyValidator getCostValidator()
    {
        return costValidator;
    }

    public KmBooleanValidator getInvoiceCustomerValidator()
    {
        return invoiceCustomerValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyShipment value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setTrackingNumber(trackingNumberValidator.convertOnly(value.getTrackingNumber()));
        value.setWeight(weightValidator.convertOnly(value.getWeight()));
        value.setCost(costValidator.convertOnly(value.getCost()));
        value.setInvoiceCustomer(invoiceCustomerValidator.convertOnly(value.getInvoiceCustomer()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyShipment value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        trackingNumberValidator.validateOnly(value.getTrackingNumber(), errors);
        weightValidator.validateOnly(value.getWeight(), errors);
        costValidator.validateOnly(value.getCost(), errors);
        invoiceCustomerValidator.validateOnly(value.getInvoiceCustomer(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasSalesOrder() )
            errors.add(new KmRequiredValidationError("shipment", "salesOrder"));
        if ( !value.hasAccount() )
            errors.add(new KmRequiredValidationError("shipment", "account"));
        if ( !value.hasMethod() )
            errors.add(new KmRequiredValidationError("shipment", "method"));
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("shipment");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTrackingNumberValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("shipment");
        e.setField("trackingNumber");
        return e;
    }

    public KmDoubleValidator newWeightValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("shipment");
        e.setField("weight");
        return e;
    }

    public KmMoneyValidator newCostValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("shipment");
        e.setField("cost");
        return e;
    }

    public KmBooleanValidator newInvoiceCustomerValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("shipment");
        e.setField("invoiceCustomer");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("shipment");
        e.setField("lockVersion");
        return e;
    }


}

