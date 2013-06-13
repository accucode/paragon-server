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
    private KmStringValidator accessKeyValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator closedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator userNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyInvitationValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        statusCodeValidator = newStatusCodeValidator();
        accessKeyValidator = newAccessKeyValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        closedUtcTsValidator = newClosedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
        userNameValidator = newUserNameValidator();
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

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyInvitation value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setAccessKey(accessKeyValidator.convertOnly(value.getAccessKey()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setClosedUtcTs(closedUtcTsValidator.convertOnly(value.getClosedUtcTs()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyInvitation value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        accessKeyValidator.validateOnly(value.getAccessKey(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        closedUtcTsValidator.validateOnly(value.getClosedUtcTs(), errors);
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


}

