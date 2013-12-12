//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;

import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserValidator;
import com.app.model.core.MyDomainValidator;

/**
 * Validation rules for accountUser.
 */
public class MyAccountUserValidatorBase
    extends MyDomainValidator<MyAccountUser>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAccountUserValidator instance = new MyAccountUserValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator roleCodeValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator accountNameValidator;
    private KmStringValidator userNameValidator;
    private KmStringValidator userEmailValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAccountUserValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        roleCodeValidator = newRoleCodeValidator();
        lockVersionValidator = newLockVersionValidator();
        accountNameValidator = newAccountNameValidator();
        userNameValidator = newUserNameValidator();
        userEmailValidator = newUserEmailValidator();
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

    public KmStringValidator getAccountNameValidator()
    {
        return accountNameValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    public KmStringValidator getUserEmailValidator()
    {
        return userEmailValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAccountUser value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setRoleCode(roleCodeValidator.convertOnly(value.getRoleCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAccountUser value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
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
        e.setModel("accountUser");
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
        e.setModel("accountUser");
        e.setField("roleCode");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("accountUser");
        e.setField("lockVersion");
        return e;
    }

    public KmStringValidator newAccountNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("accountUser");
        e.setField("accountName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("accountUser");
        e.setField("userName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUserEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("accountUser");
        e.setField("userEmail");
        e.setRequired();
        return e;
    }


}

