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
 * Validation rules for file.
 */
public class MyFileValidatorBase
    extends MyDomainValidator<MyFile>
{
    //##################################################
    //# static
    //##################################################

    public static final MyFileValidator instance = new MyFileValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator idValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator pathValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator statusCodeValidator;
    private KmIntegerValidator sizeValidator;
    private KmIntegerValidator partialSizeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFileValidatorBase()
    {
        super();
        idValidator = newIdValidator();
        nameValidator = newNameValidator();
        pathValidator = newPathValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        statusCodeValidator = newStatusCodeValidator();
        sizeValidator = newSizeValidator();
        partialSizeValidator = newPartialSizeValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getIdValidator()
    {
        return idValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getPathValidator()
    {
        return pathValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmIntegerValidator getSizeValidator()
    {
        return sizeValidator;
    }

    public KmIntegerValidator getPartialSizeValidator()
    {
        return partialSizeValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyFile value)
    {
        value.setId(idValidator.convertOnly(value.getId()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setPath(pathValidator.convertOnly(value.getPath()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setSize(sizeValidator.convertOnly(value.getSize()));
        value.setPartialSize(partialSizeValidator.convertOnly(value.getPartialSize()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyFile value, KmList<KmErrorIF> errors)
    {
        idValidator.validateOnly(value.getId(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        pathValidator.validateOnly(value.getPath(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        sizeValidator.validateOnly(value.getSize(), errors);
        partialSizeValidator.validateOnly(value.getPartialSize(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newIdValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("file");
        e.setField("id");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("file");
        e.setField("name");
        return e;
    }

    public KmStringValidator newPathValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("file");
        e.setField("path");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("file");
        e.setField("createdUtcTs");
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
        e.setModel("file");
        e.setField("statusCode");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newSizeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("file");
        e.setField("size");
        return e;
    }

    public KmIntegerValidator newPartialSizeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("file");
        e.setField("partialSize");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("file");
        e.setField("lockVersion");
        return e;
    }


}

