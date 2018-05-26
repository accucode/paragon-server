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
 * Validation rules for site.
 */
public class MySiteValidatorBase
    extends MyDomainValidator<MySite>
{
    //##################################################
    //# static
    //##################################################

    public static final MySiteValidator instance = new MySiteValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator addressAttentionValidator;
    private KmStringValidator addressCityValidator;
    private KmStringValidator addressCountryValidator;
    private KmStringValidator addressPhoneValidator;
    private KmStringValidator addressPostalCodeValidator;
    private KmStringValidator addressRegionValidator;
    private KmStringValidator addressStreet1Validator;
    private KmStringValidator addressStreet2Validator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator fullNameValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator numberValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySiteValidatorBase()
    {
        super();
        addressAttentionValidator = newAddressAttentionValidator();
        addressCityValidator = newAddressCityValidator();
        addressCountryValidator = newAddressCountryValidator();
        addressPhoneValidator = newAddressPhoneValidator();
        addressPostalCodeValidator = newAddressPostalCodeValidator();
        addressRegionValidator = newAddressRegionValidator();
        addressStreet1Validator = newAddressStreet1Validator();
        addressStreet2Validator = newAddressStreet2Validator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        enabledValidator = newEnabledValidator();
        fullNameValidator = newFullNameValidator();
        nameValidator = newNameValidator();
        numberValidator = newNumberValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getAddressAttentionValidator()
    {
        return addressAttentionValidator;
    }

    public KmStringValidator getAddressCityValidator()
    {
        return addressCityValidator;
    }

    public KmStringValidator getAddressCountryValidator()
    {
        return addressCountryValidator;
    }

    public KmStringValidator getAddressPhoneValidator()
    {
        return addressPhoneValidator;
    }

    public KmStringValidator getAddressPostalCodeValidator()
    {
        return addressPostalCodeValidator;
    }

    public KmStringValidator getAddressRegionValidator()
    {
        return addressRegionValidator;
    }

    public KmStringValidator getAddressStreet1Validator()
    {
        return addressStreet1Validator;
    }

    public KmStringValidator getAddressStreet2Validator()
    {
        return addressStreet2Validator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getFullNameValidator()
    {
        return fullNameValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getNumberValidator()
    {
        return numberValidator;
    }

    public KmStringValidator getTimeZoneCodeValidator()
    {
        return timeZoneCodeValidator;
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
    public void convertOnly(MySite value)
    {
        // fields...
        value.setAddressAttention(addressAttentionValidator.convert(value.getAddressAttention()));
        value.setAddressCity(addressCityValidator.convert(value.getAddressCity()));
        value.setAddressCountry(addressCountryValidator.convert(value.getAddressCountry()));
        value.setAddressPhone(addressPhoneValidator.convert(value.getAddressPhone()));
        value.setAddressPostalCode(addressPostalCodeValidator.convert(value.getAddressPostalCode()));
        value.setAddressRegion(addressRegionValidator.convert(value.getAddressRegion()));
        value.setAddressStreet1(addressStreet1Validator.convert(value.getAddressStreet1()));
        value.setAddressStreet2(addressStreet2Validator.convert(value.getAddressStreet2()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setFullName(fullNameValidator.convert(value.getFullName()));
        value.setName(nameValidator.convert(value.getName()));
        value.setNumber(numberValidator.convert(value.getNumber()));
        value.setTimeZoneCode(timeZoneCodeValidator.convert(value.getTimeZoneCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySite value, KmErrorList errors)
    {
        // fields...
        addressAttentionValidator.validateOn(value.getAddressAttention(), errors);
        addressCityValidator.validateOn(value.getAddressCity(), errors);
        addressCountryValidator.validateOn(value.getAddressCountry(), errors);
        addressPhoneValidator.validateOn(value.getAddressPhone(), errors);
        addressPostalCodeValidator.validateOn(value.getAddressPostalCode(), errors);
        addressRegionValidator.validateOn(value.getAddressRegion(), errors);
        addressStreet1Validator.validateOn(value.getAddressStreet1(), errors);
        addressStreet2Validator.validateOn(value.getAddressStreet2(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        fullNameValidator.validateOn(value.getFullName(), errors);
        nameValidator.validateOn(value.getName(), errors);
        numberValidator.validateOn(value.getNumber(), errors);
        timeZoneCodeValidator.validateOn(value.getTimeZoneCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasCustomer() )
            errors.addRequiredField("site", "customer");
        if ( !value.hasPriority() )
            errors.addRequiredField("site", "priority");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newAddressAttentionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressAttention");
        return e;
    }

    public KmStringValidator newAddressCityValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressCity");
        return e;
    }

    public KmStringValidator newAddressCountryValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressCountry");
        return e;
    }

    public KmStringValidator newAddressPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressPhone");
        return e;
    }

    public KmStringValidator newAddressPostalCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(20);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressPostalCode");
        return e;
    }

    public KmStringValidator newAddressRegionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressRegion");
        return e;
    }

    public KmStringValidator newAddressStreet1Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressStreet1");
        return e;
    }

    public KmStringValidator newAddressStreet2Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("addressStreet2");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("site");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("site");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFullNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("fullName");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNumberValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("number");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("timeZoneCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("site");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("site");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("site");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

