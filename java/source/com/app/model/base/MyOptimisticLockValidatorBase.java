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
 * Validation rules for optimisticLock.
 */
public class MyOptimisticLockValidatorBase
    extends MyDomainValidator<MyOptimisticLock>
{
    //##################################################
    //# static
    //##################################################

    public static final MyOptimisticLockValidator instance = new MyOptimisticLockValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyOptimisticLockValidatorBase()
    {
        super();
        nameValidator = newNameValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyOptimisticLock value)
    {
        // fields...
        value.setName(nameValidator.convert(value.getName()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyOptimisticLock value, KmErrorList errors)
    {
        // fields...
        nameValidator.validateOn(value.getName(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("optimisticLock");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("optimisticLock");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

