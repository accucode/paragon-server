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
 * Validation rules for user.
 */
public class MyUserValidatorBase
    extends MyDomainValidator<MyUser>
{
    //##################################################
    //# static
    //##################################################

    public static final MyUserValidator instance = new MyUserValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator emailValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator firstNameValidator;
    private KmStringValidator fullNameValidator;
    private KmStringValidator lastNameValidator;
    private KmStringValidator memoValidator;
    private KmStringValidator nicknameValidator;
    private KmStringValidator passwordHashValidator;
    private KmStringValidator passwordSaltValidator;
    private KmStringValidator phoneValidator;
    private KmStringValidator roleCodeValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyUserValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        emailValidator = newEmailValidator();
        enabledValidator = newEnabledValidator();
        firstNameValidator = newFirstNameValidator();
        fullNameValidator = newFullNameValidator();
        lastNameValidator = newLastNameValidator();
        memoValidator = newMemoValidator();
        nicknameValidator = newNicknameValidator();
        passwordHashValidator = newPasswordHashValidator();
        passwordSaltValidator = newPasswordSaltValidator();
        phoneValidator = newPhoneValidator();
        roleCodeValidator = newRoleCodeValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getFirstNameValidator()
    {
        return firstNameValidator;
    }

    public KmStringValidator getFullNameValidator()
    {
        return fullNameValidator;
    }

    public KmStringValidator getLastNameValidator()
    {
        return lastNameValidator;
    }

    public KmStringValidator getMemoValidator()
    {
        return memoValidator;
    }

    public KmStringValidator getNicknameValidator()
    {
        return nicknameValidator;
    }

    public KmStringValidator getPasswordHashValidator()
    {
        return passwordHashValidator;
    }

    public KmStringValidator getPasswordSaltValidator()
    {
        return passwordSaltValidator;
    }

    public KmStringValidator getPhoneValidator()
    {
        return phoneValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
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
    public void convertOnly(MyUser value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEmail(emailValidator.convert(value.getEmail()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setFirstName(firstNameValidator.convert(value.getFirstName()));
        value.setFullName(fullNameValidator.convert(value.getFullName()));
        value.setLastName(lastNameValidator.convert(value.getLastName()));
        value.setMemo(memoValidator.convert(value.getMemo()));
        value.setNickname(nicknameValidator.convert(value.getNickname()));
        value.setPasswordHash(passwordHashValidator.convert(value.getPasswordHash()));
        value.setPasswordSalt(passwordSaltValidator.convert(value.getPasswordSalt()));
        value.setPhone(phoneValidator.convert(value.getPhone()));
        value.setRoleCode(roleCodeValidator.convert(value.getRoleCode()));
        value.setTimeZoneCode(timeZoneCodeValidator.convert(value.getTimeZoneCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyUser value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        emailValidator.validateOn(value.getEmail(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        firstNameValidator.validateOn(value.getFirstName(), errors);
        fullNameValidator.validateOn(value.getFullName(), errors);
        lastNameValidator.validateOn(value.getLastName(), errors);
        memoValidator.validateOn(value.getMemo(), errors);
        nicknameValidator.validateOn(value.getNickname(), errors);
        passwordHashValidator.validateOn(value.getPasswordHash(), errors);
        passwordSaltValidator.validateOn(value.getPasswordSalt(), errors);
        phoneValidator.validateOn(value.getPhone(), errors);
        roleCodeValidator.validateOn(value.getRoleCode(), errors);
        timeZoneCodeValidator.validateOn(value.getTimeZoneCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.addRequiredField("user", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("user");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setModelName("user");
        e.setFieldName("email");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("user");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFirstNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("firstName");
        return e;
    }

    public KmStringValidator newFullNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("fullName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newLastNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("lastName");
        return e;
    }

    public KmStringValidator newMemoValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("user");
        e.setFieldName("memo");
        return e;
    }

    public KmStringValidator newNicknameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("nickname");
        return e;
    }

    public KmStringValidator newPasswordHashValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("passwordHash");
        return e;
    }

    public KmStringValidator newPasswordSaltValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("passwordSalt");
        e.setRequired();
        return e;
    }

    public KmStringValidator newPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("user");
        e.setFieldName("phone");
        return e;
    }

    public KmStringValidator newRoleCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("user");
        e.setFieldName("roleCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModelName("user");
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
        e.setModelName("user");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("user");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("user");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

