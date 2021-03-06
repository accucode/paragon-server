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
 * Validation rules for projectContact.
 */
public class MyProjectContactValidatorBase
    extends MyDomainValidator<MyProjectContact>
{
    //##################################################
    //# static
    //##################################################

    public static final MyProjectContactValidator instance = new MyProjectContactValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator emailValidator;
    private KmStringValidator firstNameValidator;
    private KmStringValidator fullNameValidator;
    private KmStringValidator lastNameValidator;
    private KmStringValidator nicknameValidator;
    private KmStringValidator phoneValidator;
    private KmStringValidator titleValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyProjectContactValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        emailValidator = newEmailValidator();
        firstNameValidator = newFirstNameValidator();
        fullNameValidator = newFullNameValidator();
        lastNameValidator = newLastNameValidator();
        nicknameValidator = newNicknameValidator();
        phoneValidator = newPhoneValidator();
        titleValidator = newTitleValidator();
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

    public KmStringValidator getNicknameValidator()
    {
        return nicknameValidator;
    }

    public KmStringValidator getPhoneValidator()
    {
        return phoneValidator;
    }

    public KmStringValidator getTitleValidator()
    {
        return titleValidator;
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
    public void convertOnly(MyProjectContact value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEmail(emailValidator.convert(value.getEmail()));
        value.setFirstName(firstNameValidator.convert(value.getFirstName()));
        value.setFullName(fullNameValidator.convert(value.getFullName()));
        value.setLastName(lastNameValidator.convert(value.getLastName()));
        value.setNickname(nicknameValidator.convert(value.getNickname()));
        value.setPhone(phoneValidator.convert(value.getPhone()));
        value.setTitle(titleValidator.convert(value.getTitle()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyProjectContact value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        emailValidator.validateOn(value.getEmail(), errors);
        firstNameValidator.validateOn(value.getFirstName(), errors);
        fullNameValidator.validateOn(value.getFullName(), errors);
        lastNameValidator.validateOn(value.getLastName(), errors);
        nicknameValidator.validateOn(value.getNickname(), errors);
        phoneValidator.validateOn(value.getPhone(), errors);
        titleValidator.validateOn(value.getTitle(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("projectContact", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("projectContact");
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
        e.setModelName("projectContact");
        e.setFieldName("email");
        return e;
    }

    public KmStringValidator newFirstNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
        e.setFieldName("firstName");
        return e;
    }

    public KmStringValidator newFullNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
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
        e.setModelName("projectContact");
        e.setFieldName("lastName");
        return e;
    }

    public KmStringValidator newNicknameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
        e.setFieldName("nickname");
        return e;
    }

    public KmStringValidator newPhoneValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
        e.setFieldName("phone");
        return e;
    }

    public KmStringValidator newTitleValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
        e.setFieldName("title");
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("projectContact");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("projectContact");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("projectContact");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

