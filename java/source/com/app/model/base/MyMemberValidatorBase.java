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
 * Validation rules for member.
 */
public class MyMemberValidatorBase
    extends MyDomainValidator<MyMember>
{
    //##################################################
    //# static
    //##################################################

    public static final MyMemberValidator instance = new MyMemberValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator roleCodeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyMemberValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
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
    public void convertOnly(MyMember value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyMember value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        roleCodeValidator.validateOnly(value.getRoleCode(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("member", "project"));
        if ( !value.hasUser() )
            errors.add(new KmRequiredValidationError("member", "user"));
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
        e.setModel("member");
        e.setField("uid");
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
        e.setModel("member");
        e.setField("roleCode");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("member");
        e.setField("lockVersion");
        return e;
    }


}

