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
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Validation rules for customer.
 */
public class MyCustomerValidatorBase
    extends MyDomainValidator<MyCustomer>
{
    //##################################################
    //# static
    //##################################################

    public static final MyCustomerValidator instance = new MyCustomerValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator billingAttentionValidator;
    private KmStringValidator billingCityValidator;
    private KmStringValidator billingCountryValidator;
    private KmStringValidator billingPhoneValidator;
    private KmStringValidator billingPostalCodeValidator;
    private KmStringValidator billingRegionValidator;
    private KmStringValidator billingStreet1Validator;
    private KmStringValidator billingStreet2Validator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyCustomerValidatorBase()
    {
        super();
        billingAttentionValidator = newBillingAttentionValidator();
        billingCityValidator = newBillingCityValidator();
        billingCountryValidator = newBillingCountryValidator();
        billingPhoneValidator = newBillingPhoneValidator();
        billingPostalCodeValidator = newBillingPostalCodeValidator();
        billingRegionValidator = newBillingRegionValidator();
        billingStreet1Validator = newBillingStreet1Validator();
        billingStreet2Validator = newBillingStreet2Validator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        enabledValidator = newEnabledValidator();
        nameValidator = newNameValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getBillingAttentionValidator()
    {
        return billingAttentionValidator;
    }

    public KmStringValidator getBillingCityValidator()
    {
        return billingCityValidator;
    }

    public KmStringValidator getBillingCountryValidator()
    {
        return billingCountryValidator;
    }

    public KmStringValidator getBillingPhoneValidator()
    {
        return billingPhoneValidator;
    }

    public KmStringValidator getBillingPostalCodeValidator()
    {
        return billingPostalCodeValidator;
    }

    public KmStringValidator getBillingRegionValidator()
    {
        return billingRegionValidator;
    }

    public KmStringValidator getBillingStreet1Validator()
    {
        return billingStreet1Validator;
    }

    public KmStringValidator getBillingStreet2Validator()
    {
        return billingStreet2Validator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyCustomer value)
    {
        // fields...
        value.setBillingAttention(billingAttentionValidator.convert(value.getBillingAttention()));
        value.setBillingCity(billingCityValidator.convert(value.getBillingCity()));
        value.setBillingCountry(billingCountryValidator.convert(value.getBillingCountry()));
        value.setBillingPhone(billingPhoneValidator.convert(value.getBillingPhone()));
        value.setBillingPostalCode(billingPostalCodeValidator.convert(value.getBillingPostalCode()));
        value.setBillingRegion(billingRegionValidator.convert(value.getBillingRegion()));
        value.setBillingStreet1(billingStreet1Validator.convert(value.getBillingStreet1()));
        value.setBillingStreet2(billingStreet2Validator.convert(value.getBillingStreet2()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setName(nameValidator.convert(value.getName()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyCustomer value, KmErrorList errors)
    {
        // fields...
        billingAttentionValidator.validateOn(value.getBillingAttention(), errors);
        billingCityValidator.validateOn(value.getBillingCity(), errors);
        billingCountryValidator.validateOn(value.getBillingCountry(), errors);
        billingPhoneValidator.validateOn(value.getBillingPhone(), errors);
        billingPostalCodeValidator.validateOn(value.getBillingPostalCode(), errors);
        billingRegionValidator.validateOn(value.getBillingRegion(), errors);
        billingStreet1Validator.validateOn(value.getBillingStreet1(), errors);
        billingStreet2Validator.validateOn(value.getBillingStreet2(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        nameValidator.validateOn(value.getName(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("customer", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newBillingAttentionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingAttention");
        return e;
    }

    public KmStringValidator newBillingCityValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingCity");
        return e;
    }

    public KmStringValidator newBillingCountryValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingCountry");
        return e;
    }

    public KmStringValidator newBillingPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingPhone");
        return e;
    }

    public KmStringValidator newBillingPostalCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(20);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingPostalCode");
        return e;
    }

    public KmStringValidator newBillingRegionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingRegion");
        return e;
    }

    public KmStringValidator newBillingStreet1Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingStreet1");
        return e;
    }

    public KmStringValidator newBillingStreet2Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("billingStreet2");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("customer");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("customer");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("customer");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("customer");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("customer");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

