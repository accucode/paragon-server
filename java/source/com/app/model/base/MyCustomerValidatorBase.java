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

    private KmStringValidator uidValidator;
    private KmStringValidator nameValidator;
    private KmDoubleValidator discountRateValidator;
    private KmStringValidator addressStreet1Validator;
    private KmStringValidator addressStreet2Validator;
    private KmStringValidator addressCityValidator;
    private KmStringValidator addressRegionValidator;
    private KmStringValidator addressPostalCodeValidator;
    private KmStringValidator addressCountryValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyCustomerValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        discountRateValidator = newDiscountRateValidator();
        addressStreet1Validator = newAddressStreet1Validator();
        addressStreet2Validator = newAddressStreet2Validator();
        addressCityValidator = newAddressCityValidator();
        addressRegionValidator = newAddressRegionValidator();
        addressPostalCodeValidator = newAddressPostalCodeValidator();
        addressCountryValidator = newAddressCountryValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmDoubleValidator getDiscountRateValidator()
    {
        return discountRateValidator;
    }

    public KmStringValidator getAddressStreet1Validator()
    {
        return addressStreet1Validator;
    }

    public KmStringValidator getAddressStreet2Validator()
    {
        return addressStreet2Validator;
    }

    public KmStringValidator getAddressCityValidator()
    {
        return addressCityValidator;
    }

    public KmStringValidator getAddressRegionValidator()
    {
        return addressRegionValidator;
    }

    public KmStringValidator getAddressPostalCodeValidator()
    {
        return addressPostalCodeValidator;
    }

    public KmStringValidator getAddressCountryValidator()
    {
        return addressCountryValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setDiscountRate(discountRateValidator.convertOnly(value.getDiscountRate()));
        value.setAddressStreet1(addressStreet1Validator.convertOnly(value.getAddressStreet1()));
        value.setAddressStreet2(addressStreet2Validator.convertOnly(value.getAddressStreet2()));
        value.setAddressCity(addressCityValidator.convertOnly(value.getAddressCity()));
        value.setAddressRegion(addressRegionValidator.convertOnly(value.getAddressRegion()));
        value.setAddressPostalCode(addressPostalCodeValidator.convertOnly(value.getAddressPostalCode()));
        value.setAddressCountry(addressCountryValidator.convertOnly(value.getAddressCountry()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyCustomer value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        discountRateValidator.validateOnly(value.getDiscountRate(), errors);
        addressStreet1Validator.validateOnly(value.getAddressStreet1(), errors);
        addressStreet2Validator.validateOnly(value.getAddressStreet2(), errors);
        addressCityValidator.validateOnly(value.getAddressCity(), errors);
        addressRegionValidator.validateOnly(value.getAddressRegion(), errors);
        addressPostalCodeValidator.validateOnly(value.getAddressPostalCode(), errors);
        addressCountryValidator.validateOnly(value.getAddressCountry(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("customer", "project"));
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
        e.setModel("customer");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmDoubleValidator newDiscountRateValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("customer");
        e.setField("discountRate");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAddressStreet1Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressStreet1");
        return e;
    }

    public KmStringValidator newAddressStreet2Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressStreet2");
        return e;
    }

    public KmStringValidator newAddressCityValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressCity");
        return e;
    }

    public KmStringValidator newAddressRegionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressRegion");
        return e;
    }

    public KmStringValidator newAddressPostalCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(20);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressPostalCode");
        return e;
    }

    public KmStringValidator newAddressCountryValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("customer");
        e.setField("addressCountry");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("customer");
        e.setField("lockVersion");
        return e;
    }


}

