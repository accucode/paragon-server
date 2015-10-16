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
 * Validation rules for orderNumber.
 */
public class MyOrderNumberValidatorBase
    extends MyDomainValidator<MyOrderNumber>
{
    //##################################################
    //# static
    //##################################################

    public static final MyOrderNumberValidator instance = new MyOrderNumberValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmDateValidator dateValidator;
    private KmIntegerValidator nextNumberValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyOrderNumberValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        dateValidator = newDateValidator();
        nextNumberValidator = newNextNumberValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmDateValidator getDateValidator()
    {
        return dateValidator;
    }

    public KmIntegerValidator getNextNumberValidator()
    {
        return nextNumberValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyOrderNumber value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setDate(dateValidator.convertOnly(value.getDate()));
        value.setNextNumber(nextNumberValidator.convertOnly(value.getNextNumber()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyOrderNumber value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        dateValidator.validateOnly(value.getDate(), errors);
        nextNumberValidator.validateOnly(value.getNextNumber(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("orderNumber", "project"));
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
        e.setModel("orderNumber");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmDateValidator newDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModel("orderNumber");
        e.setField("date");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newNextNumberValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("orderNumber");
        e.setField("nextNumber");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("orderNumber");
        e.setField("lockVersion");
        return e;
    }


}

