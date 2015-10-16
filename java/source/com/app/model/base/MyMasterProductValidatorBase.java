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
 * Validation rules for masterProduct.
 */
public class MyMasterProductValidatorBase
    extends MyDomainValidator<MyMasterProduct>
{
    //##################################################
    //# static
    //##################################################

    public static final MyMasterProductValidator instance = new MyMasterProductValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator partNumberValidator;
    private KmBooleanValidator activeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyMasterProductValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        partNumberValidator = newPartNumberValidator();
        activeValidator = newActiveValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getPartNumberValidator()
    {
        return partNumberValidator;
    }

    public KmBooleanValidator getActiveValidator()
    {
        return activeValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyMasterProduct value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setPartNumber(partNumberValidator.convertOnly(value.getPartNumber()));
        value.setActive(activeValidator.convertOnly(value.getActive()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyMasterProduct value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        partNumberValidator.validateOnly(value.getPartNumber(), errors);
        activeValidator.validateOnly(value.getActive(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("masterProduct", "project"));
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
        e.setModel("masterProduct");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newPartNumberValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("masterProduct");
        e.setField("partNumber");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("masterProduct");
        e.setField("active");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("masterProduct");
        e.setField("lockVersion");
        return e;
    }


}

