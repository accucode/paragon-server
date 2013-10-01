//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MyInvitation;
import com.app.model.MyInvitationValidator;
import com.app.model.core.MyDomainValidator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;
import com.kodemore.validator.KmTimestampValidator;

/**
 * Validation rules for invitation.
 */
public class MyInvitationValidatorBase
    extends MyDomainValidator<MyInvitation>
{
    //##################################################
    //# static
    //##################################################

    public static final MyInvitationValidator instance = new MyInvitationValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator statusCodeValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator accessKeyValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator closedUtcTsValidator;
    private KmStringValidator emailValidator;
    private KmStringValidator roleCodeValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator userNameValidator;
    private KmStringValidator accountNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyInvitationValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        statusCodeValidator = newStatusCodeValidator();
        typeCodeValidator = newTypeCodeValidator();
        accessKeyValidator = newAccessKeyValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        closedUtcTsValidator = newClosedUtcTsValidator();
        emailValidator = newEmailValidator();
        roleCodeValidator = newRoleCodeValidator();
        lockVersionValidator = newLockVersionValidator();
        userNameValidator = newUserNameValidator();
        accountNameValidator = newAccountNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getAccessKeyValidator()
    {
        return accessKeyValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getClosedUtcTsValidator()
    {
        return closedUtcTsValidator;
    }

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    public KmStringValidator getAccountNameValidator()
    {
        return accountNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyInvitation value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setAccessKey(accessKeyValidator.convertOnly(value.getAccessKey()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setClosedUtcTs(closedUtcTsValidator.convertOnly(value.getClosedUtcTs()));
        value.setEmail(emailValidator.convertOnly(value.getEmail()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyInvitation value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        accessKeyValidator.validateOnly(value.getAccessKey(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        closedUtcTsValidator.validateOnly(value.getClosedUtcTs(), errors);
        emailValidator.validateOnly(value.getEmail(), errors);
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
        e.setModel("invitation");
        e.setField("uid");
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
        e.setModel("invitation");
        e.setField("statusCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("invitation");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAccessKeyValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("accessKey");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("invitation");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newClosedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("invitation");
        e.setField("closedUtcTs");
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("email");
        e.setRequired();
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
        e.setModel("invitation");
        e.setField("roleCode");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("invitation");
        e.setField("lockVersion");
        return e;
    }

    public KmStringValidator newUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("userName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAccountNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("accountName");
        e.setRequired();
        return e;
    }


}

