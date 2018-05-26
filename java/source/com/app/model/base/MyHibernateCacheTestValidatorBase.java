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
 * Validation rules for hibernateCacheTest.
 */
public class MyHibernateCacheTestValidatorBase
    extends MyDomainValidator<MyHibernateCacheTest>
{
    //##################################################
    //# static
    //##################################################

    public static final MyHibernateCacheTestValidator instance = new MyHibernateCacheTestValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator dataValidator;
    private KmStringValidator uidValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyHibernateCacheTestValidatorBase()
    {
        super();
        dataValidator = newDataValidator();
        uidValidator = newUidValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getDataValidator()
    {
        return dataValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyHibernateCacheTest value)
    {
        // fields...
        value.setData(dataValidator.convert(value.getData()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyHibernateCacheTest value, KmErrorList errors)
    {
        // fields...
        dataValidator.validateOn(value.getData(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newDataValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setModelName("hibernateCacheTest");
        e.setFieldName("data");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("hibernateCacheTest");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("hibernateCacheTest");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

