//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MyUser;
import com.app.model.MyUserValidator;
import com.app.model.core.MyDomainValidator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.validator.KmBooleanValidator;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;

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
    private KmStringValidator nameValidator;
    private KmStringValidator emailValidator;
    private KmBooleanValidator verifiedValidator;
    private KmStringValidator passwordSaltValidator;
    private KmStringValidator passwordHashValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator roleCodeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyUserValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        emailValidator = newEmailValidator();
        verifiedValidator = newVerifiedValidator();
        passwordSaltValidator = newPasswordSaltValidator();
        passwordHashValidator = newPasswordHashValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        roleCodeValidator = newRoleCodeValidator();
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

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmBooleanValidator getVerifiedValidator()
    {
        return verifiedValidator;
    }

    public KmStringValidator getPasswordSaltValidator()
    {
        return passwordSaltValidator;
    }

    public KmStringValidator getPasswordHashValidator()
    {
        return passwordHashValidator;
    }

    public KmStringValidator getTimeZoneCodeValidator()
    {
        return timeZoneCodeValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setEmail(emailValidator.convertOnly(value.getEmail()));
        value.setVerified(verifiedValidator.convertOnly(value.getVerified()));
        value.setPasswordSalt(passwordSaltValidator.convertOnly(value.getPasswordSalt()));
        value.setPasswordHash(passwordHashValidator.convertOnly(value.getPasswordHash()));
        value.setTimeZoneCode(timeZoneCodeValidator.convertOnly(value.getTimeZoneCode()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyUser value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        emailValidator.validateOnly(value.getEmail(), errors);
        verifiedValidator.validateOnly(value.getVerified(), errors);
        passwordSaltValidator.validateOnly(value.getPasswordSalt(), errors);
        passwordHashValidator.validateOnly(value.getPasswordHash(), errors);
        timeZoneCodeValidator.validateOnly(value.getTimeZoneCode(), errors);
        roleCodeValidator.validateOnly(value.getRoleCode(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
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

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("name");
        e.setRequired();
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

    public KmBooleanValidator newVerifiedValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("user");
        e.setField("verified");
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

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModel("user");
        e.setField("timeZoneCode");
        return e;
    }

    public KmStringValidator newRoleCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("user");
        e.setField("roleCode");
        e.setRequired();
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

