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
 * Validation rules for project.
 */
public class MyProjectValidatorBase
    extends MyDomainValidator<MyProject>
{
    //##################################################
    //# static
    //##################################################

    public static final MyProjectValidator instance = new MyProjectValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator orderNumberPrefixValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyProjectValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        orderNumberPrefixValidator = newOrderNumberPrefixValidator();
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

    public KmStringValidator getOrderNumberPrefixValidator()
    {
        return orderNumberPrefixValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyProject value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setOrderNumberPrefix(orderNumberPrefixValidator.convertOnly(value.getOrderNumberPrefix()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyProject value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        orderNumberPrefixValidator.validateOnly(value.getOrderNumberPrefix(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
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
        e.setModel("project");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("project");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOrderNumberPrefixValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("project");
        e.setField("orderNumberPrefix");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("project");
        e.setField("lockVersion");
        return e;
    }


}

