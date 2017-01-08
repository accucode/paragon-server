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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmStringValidator firstNameValidator;
    private KmStringValidator lastNameValidator;
    private KmStringValidator nicknameValidator;
    private KmStringValidator emailValidator;
    private KmStringValidator passwordSaltValidator;
    private KmStringValidator passwordHashValidator;
    private KmStringValidator phoneValidator;
    private KmBooleanValidator activeValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator roleCodeValidator;
    private KmStringValidator dashboardOrientationTypeCodeValidator;
    private KmIntegerValidator dashboardLineCount1Validator;
    private KmIntegerValidator dashboardLineCount2Validator;
    private KmStringValidator dashboardPanelCodeAValidator;
    private KmStringValidator dashboardPanelCodeBValidator;
    private KmStringValidator dashboardPanelCodeCValidator;
    private KmStringValidator dashboardPanelCodeDValidator;
    private KmStringValidator dashboardPanelCodeEValidator;
    private KmStringValidator dashboardPanelCodeFValidator;
    private KmStringValidator dashboardPanelCodeGValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyUserValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        firstNameValidator = newFirstNameValidator();
        lastNameValidator = newLastNameValidator();
        nicknameValidator = newNicknameValidator();
        emailValidator = newEmailValidator();
        passwordSaltValidator = newPasswordSaltValidator();
        passwordHashValidator = newPasswordHashValidator();
        phoneValidator = newPhoneValidator();
        activeValidator = newActiveValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        roleCodeValidator = newRoleCodeValidator();
        dashboardOrientationTypeCodeValidator = newDashboardOrientationTypeCodeValidator();
        dashboardLineCount1Validator = newDashboardLineCount1Validator();
        dashboardLineCount2Validator = newDashboardLineCount2Validator();
        dashboardPanelCodeAValidator = newDashboardPanelCodeAValidator();
        dashboardPanelCodeBValidator = newDashboardPanelCodeBValidator();
        dashboardPanelCodeCValidator = newDashboardPanelCodeCValidator();
        dashboardPanelCodeDValidator = newDashboardPanelCodeDValidator();
        dashboardPanelCodeEValidator = newDashboardPanelCodeEValidator();
        dashboardPanelCodeFValidator = newDashboardPanelCodeFValidator();
        dashboardPanelCodeGValidator = newDashboardPanelCodeGValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmStringValidator getFirstNameValidator()
    {
        return firstNameValidator;
    }

    public KmStringValidator getLastNameValidator()
    {
        return lastNameValidator;
    }

    public KmStringValidator getNicknameValidator()
    {
        return nicknameValidator;
    }

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmStringValidator getPasswordSaltValidator()
    {
        return passwordSaltValidator;
    }

    public KmStringValidator getPasswordHashValidator()
    {
        return passwordHashValidator;
    }

    public KmStringValidator getPhoneValidator()
    {
        return phoneValidator;
    }

    public KmBooleanValidator getActiveValidator()
    {
        return activeValidator;
    }

    public KmStringValidator getTimeZoneCodeValidator()
    {
        return timeZoneCodeValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
    }

    public KmStringValidator getDashboardOrientationTypeCodeValidator()
    {
        return dashboardOrientationTypeCodeValidator;
    }

    public KmIntegerValidator getDashboardLineCount1Validator()
    {
        return dashboardLineCount1Validator;
    }

    public KmIntegerValidator getDashboardLineCount2Validator()
    {
        return dashboardLineCount2Validator;
    }

    public KmStringValidator getDashboardPanelCodeAValidator()
    {
        return dashboardPanelCodeAValidator;
    }

    public KmStringValidator getDashboardPanelCodeBValidator()
    {
        return dashboardPanelCodeBValidator;
    }

    public KmStringValidator getDashboardPanelCodeCValidator()
    {
        return dashboardPanelCodeCValidator;
    }

    public KmStringValidator getDashboardPanelCodeDValidator()
    {
        return dashboardPanelCodeDValidator;
    }

    public KmStringValidator getDashboardPanelCodeEValidator()
    {
        return dashboardPanelCodeEValidator;
    }

    public KmStringValidator getDashboardPanelCodeFValidator()
    {
        return dashboardPanelCodeFValidator;
    }

    public KmStringValidator getDashboardPanelCodeGValidator()
    {
        return dashboardPanelCodeGValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convertOnly(value.getUpdatedUtcTs()));
        value.setFirstName(firstNameValidator.convertOnly(value.getFirstName()));
        value.setLastName(lastNameValidator.convertOnly(value.getLastName()));
        value.setNickname(nicknameValidator.convertOnly(value.getNickname()));
        value.setEmail(emailValidator.convertOnly(value.getEmail()));
        value.setPasswordSalt(passwordSaltValidator.convertOnly(value.getPasswordSalt()));
        value.setPasswordHash(passwordHashValidator.convertOnly(value.getPasswordHash()));
        value.setPhone(phoneValidator.convertOnly(value.getPhone()));
        value.setActive(activeValidator.convertOnly(value.getActive()));
        value.setTimeZoneCode(timeZoneCodeValidator.convertOnly(value.getTimeZoneCode()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setDashboardOrientationTypeCode(dashboardOrientationTypeCodeValidator.convertOnly(value.getDashboardOrientationTypeCode()));
        value.setDashboardLineCount1(dashboardLineCount1Validator.convertOnly(value.getDashboardLineCount1()));
        value.setDashboardLineCount2(dashboardLineCount2Validator.convertOnly(value.getDashboardLineCount2()));
        value.setDashboardPanelCodeA(dashboardPanelCodeAValidator.convertOnly(value.getDashboardPanelCodeA()));
        value.setDashboardPanelCodeB(dashboardPanelCodeBValidator.convertOnly(value.getDashboardPanelCodeB()));
        value.setDashboardPanelCodeC(dashboardPanelCodeCValidator.convertOnly(value.getDashboardPanelCodeC()));
        value.setDashboardPanelCodeD(dashboardPanelCodeDValidator.convertOnly(value.getDashboardPanelCodeD()));
        value.setDashboardPanelCodeE(dashboardPanelCodeEValidator.convertOnly(value.getDashboardPanelCodeE()));
        value.setDashboardPanelCodeF(dashboardPanelCodeFValidator.convertOnly(value.getDashboardPanelCodeF()));
        value.setDashboardPanelCodeG(dashboardPanelCodeGValidator.convertOnly(value.getDashboardPanelCodeG()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyUser value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        updatedUtcTsValidator.validateOnly(value.getUpdatedUtcTs(), errors);
        firstNameValidator.validateOnly(value.getFirstName(), errors);
        lastNameValidator.validateOnly(value.getLastName(), errors);
        nicknameValidator.validateOnly(value.getNickname(), errors);
        emailValidator.validateOnly(value.getEmail(), errors);
        passwordSaltValidator.validateOnly(value.getPasswordSalt(), errors);
        passwordHashValidator.validateOnly(value.getPasswordHash(), errors);
        phoneValidator.validateOnly(value.getPhone(), errors);
        activeValidator.validateOnly(value.getActive(), errors);
        timeZoneCodeValidator.validateOnly(value.getTimeZoneCode(), errors);
        roleCodeValidator.validateOnly(value.getRoleCode(), errors);
        dashboardOrientationTypeCodeValidator.validateOnly(value.getDashboardOrientationTypeCode(), errors);
        dashboardLineCount1Validator.validateOnly(value.getDashboardLineCount1(), errors);
        dashboardLineCount2Validator.validateOnly(value.getDashboardLineCount2(), errors);
        dashboardPanelCodeAValidator.validateOnly(value.getDashboardPanelCodeA(), errors);
        dashboardPanelCodeBValidator.validateOnly(value.getDashboardPanelCodeB(), errors);
        dashboardPanelCodeCValidator.validateOnly(value.getDashboardPanelCodeC(), errors);
        dashboardPanelCodeDValidator.validateOnly(value.getDashboardPanelCodeD(), errors);
        dashboardPanelCodeEValidator.validateOnly(value.getDashboardPanelCodeE(), errors);
        dashboardPanelCodeFValidator.validateOnly(value.getDashboardPanelCodeF(), errors);
        dashboardPanelCodeGValidator.validateOnly(value.getDashboardPanelCodeG(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.add(new KmRequiredValidationError("user", "tenant"));
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
        e.setModel("user");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("user");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("user");
        e.setField("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFirstNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("firstName");
        return e;
    }

    public KmStringValidator newLastNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("lastName");
        return e;
    }

    public KmStringValidator newNicknameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("nickname");
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("email");
        e.setRequired();
        return e;
    }

    public KmStringValidator newPasswordSaltValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("passwordSalt");
        e.setRequired();
        return e;
    }

    public KmStringValidator newPasswordHashValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("passwordHash");
        return e;
    }

    public KmStringValidator newPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("phone");
        return e;
    }

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("user");
        e.setField("active");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("timeZoneCode");
        e.setRequired();
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
        e.setModel("user");
        e.setField("roleCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardOrientationTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardOrientationTypeCode");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDashboardLineCount1Validator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("user");
        e.setField("dashboardLineCount1");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDashboardLineCount2Validator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("user");
        e.setField("dashboardLineCount2");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardPanelCodeAValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeA");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDashboardPanelCodeBValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeB");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeCValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeC");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeDValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeD");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeEValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeE");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeFValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeF");
        return e;
    }

    public KmStringValidator newDashboardPanelCodeGValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("dashboardPanelCodeG");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("user");
        e.setField("lockVersion");
        return e;
    }


}

