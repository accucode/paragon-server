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
 * Validation rules for salesOrder.
 */
public class MySalesOrderValidatorBase
    extends MyDomainValidator<MySalesOrder>
{
    //##################################################
    //# static
    //##################################################

    public static final MySalesOrderValidator instance = new MySalesOrderValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator numberValidator;
    private KmStringValidator statusCodeValidator;
    private KmTimestampValidator holdUntilUtcTsValidator;
    private KmBooleanValidator expediteValidator;
    private KmBooleanValidator taxExemptValidator;
    private KmDoubleValidator taxRateValidator;
    private KmDoubleValidator discountRateValidator;
    private KmMoneyValidator totalPriceValidator;
    private KmMoneyValidator totalTaxValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySalesOrderValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        numberValidator = newNumberValidator();
        statusCodeValidator = newStatusCodeValidator();
        holdUntilUtcTsValidator = newHoldUntilUtcTsValidator();
        expediteValidator = newExpediteValidator();
        taxExemptValidator = newTaxExemptValidator();
        taxRateValidator = newTaxRateValidator();
        discountRateValidator = newDiscountRateValidator();
        totalPriceValidator = newTotalPriceValidator();
        totalTaxValidator = newTotalTaxValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getNumberValidator()
    {
        return numberValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmTimestampValidator getHoldUntilUtcTsValidator()
    {
        return holdUntilUtcTsValidator;
    }

    public KmBooleanValidator getExpediteValidator()
    {
        return expediteValidator;
    }

    public KmBooleanValidator getTaxExemptValidator()
    {
        return taxExemptValidator;
    }

    public KmDoubleValidator getTaxRateValidator()
    {
        return taxRateValidator;
    }

    public KmDoubleValidator getDiscountRateValidator()
    {
        return discountRateValidator;
    }

    public KmMoneyValidator getTotalPriceValidator()
    {
        return totalPriceValidator;
    }

    public KmMoneyValidator getTotalTaxValidator()
    {
        return totalTaxValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySalesOrder value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setNumber(numberValidator.convertOnly(value.getNumber()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setHoldUntilUtcTs(holdUntilUtcTsValidator.convertOnly(value.getHoldUntilUtcTs()));
        value.setExpedite(expediteValidator.convertOnly(value.getExpedite()));
        value.setTaxExempt(taxExemptValidator.convertOnly(value.getTaxExempt()));
        value.setTaxRate(taxRateValidator.convertOnly(value.getTaxRate()));
        value.setDiscountRate(discountRateValidator.convertOnly(value.getDiscountRate()));
        value.setTotalPrice(totalPriceValidator.convertOnly(value.getTotalPrice()));
        value.setTotalTax(totalTaxValidator.convertOnly(value.getTotalTax()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySalesOrder value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        numberValidator.validateOnly(value.getNumber(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        holdUntilUtcTsValidator.validateOnly(value.getHoldUntilUtcTs(), errors);
        expediteValidator.validateOnly(value.getExpedite(), errors);
        taxExemptValidator.validateOnly(value.getTaxExempt(), errors);
        taxRateValidator.validateOnly(value.getTaxRate(), errors);
        discountRateValidator.validateOnly(value.getDiscountRate(), errors);
        totalPriceValidator.validateOnly(value.getTotalPrice(), errors);
        totalTaxValidator.validateOnly(value.getTotalTax(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("salesOrder", "project"));
        if ( !value.hasCustomer() )
            errors.add(new KmRequiredValidationError("salesOrder", "customer"));
        if ( !value.hasRegion() )
            errors.add(new KmRequiredValidationError("salesOrder", "region"));
        if ( !value.hasPowerType() )
            errors.add(new KmRequiredValidationError("salesOrder", "powerType"));
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
        e.setModel("salesOrder");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNumberValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("salesOrder");
        e.setField("number");
        e.setRequired();
        return e;
    }

    public KmStringValidator newStatusCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("salesOrder");
        e.setField("statusCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newHoldUntilUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("salesOrder");
        e.setField("holdUntilUtcTs");
        return e;
    }

    public KmBooleanValidator newExpediteValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("salesOrder");
        e.setField("expedite");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newTaxExemptValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("salesOrder");
        e.setField("taxExempt");
        e.setRequired();
        return e;
    }

    public KmDoubleValidator newTaxRateValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("salesOrder");
        e.setField("taxRate");
        e.setRequired();
        return e;
    }

    public KmDoubleValidator newDiscountRateValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("salesOrder");
        e.setField("discountRate");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newTotalPriceValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrder");
        e.setField("totalPrice");
        e.setRequired();
        return e;
    }

    public KmMoneyValidator newTotalTaxValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("salesOrder");
        e.setField("totalTax");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("salesOrder");
        e.setField("lockVersion");
        return e;
    }


}

