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
    private KmStringValidator typeCodeValidator;
    private KmStringValidator statusCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator closedUtcTsValidator;
    private KmStringValidator toEmailValidator;
    private KmStringValidator roleCodeValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator fromUserNameValidator;
    private KmStringValidator projectNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyInvitationValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        typeCodeValidator = newTypeCodeValidator();
        statusCodeValidator = newStatusCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        closedUtcTsValidator = newClosedUtcTsValidator();
        toEmailValidator = newToEmailValidator();
        roleCodeValidator = newRoleCodeValidator();
        lockVersionValidator = newLockVersionValidator();
        fromUserNameValidator = newFromUserNameValidator();
        projectNameValidator = newProjectNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getClosedUtcTsValidator()
    {
        return closedUtcTsValidator;
    }

    public KmStringValidator getToEmailValidator()
    {
        return toEmailValidator;
    }

    public KmStringValidator getRoleCodeValidator()
    {
        return roleCodeValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    public KmStringValidator getFromUserNameValidator()
    {
        return fromUserNameValidator;
    }

    public KmStringValidator getProjectNameValidator()
    {
        return projectNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyInvitation value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setClosedUtcTs(closedUtcTsValidator.convertOnly(value.getClosedUtcTs()));
        value.setToEmail(toEmailValidator.convertOnly(value.getToEmail()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyInvitation value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        closedUtcTsValidator.validateOnly(value.getClosedUtcTs(), errors);
        toEmailValidator.validateOnly(value.getToEmail(), errors);
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

    public KmStringValidator newToEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("toEmail");
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

    public KmStringValidator newFromUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("fromUserName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newProjectNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("invitation");
        e.setField("projectName");
        e.setRequired();
        return e;
    }


}

