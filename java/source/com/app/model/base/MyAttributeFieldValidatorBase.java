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
 * Validation rules for attributeField.
 */
public class MyAttributeFieldValidatorBase
    extends MyDomainValidator<MyAttributeField>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAttributeFieldValidator instance = new MyAttributeFieldValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator categoryCodeValidator;
    private KmStringValidator nameValidator;
    private KmBooleanValidator activeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAttributeFieldValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        categoryCodeValidator = newCategoryCodeValidator();
        nameValidator = newNameValidator();
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

    public KmStringValidator getCategoryCodeValidator()
    {
        return categoryCodeValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
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
    public void convertOnly(MyAttributeField value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCategoryCode(categoryCodeValidator.convertOnly(value.getCategoryCode()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setActive(activeValidator.convertOnly(value.getActive()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAttributeField value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        categoryCodeValidator.validateOnly(value.getCategoryCode(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        activeValidator.validateOnly(value.getActive(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.add(new KmRequiredValidationError("attributeField", "project"));
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
        e.setModel("attributeField");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newCategoryCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("attributeField");
        e.setField("categoryCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("attributeField");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("attributeField");
        e.setField("active");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("attributeField");
        e.setField("lockVersion");
        return e;
    }


}

