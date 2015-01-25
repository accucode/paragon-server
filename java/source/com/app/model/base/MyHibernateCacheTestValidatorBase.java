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

    private KmStringValidator uidValidator;
    private KmStringValidator dataValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyHibernateCacheTestValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        dataValidator = newDataValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getDataValidator()
    {
        return dataValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setData(dataValidator.convertOnly(value.getData()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyHibernateCacheTest value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        dataValidator.validateOnly(value.getData(), errors);
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
        e.setModel("hibernateCacheTest");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDataValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setModel("hibernateCacheTest");
        e.setField("data");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("hibernateCacheTest");
        e.setField("lockVersion");
        return e;
    }


}

