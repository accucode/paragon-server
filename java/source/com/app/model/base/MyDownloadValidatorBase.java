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
 * Validation rules for download.
 */
public class MyDownloadValidatorBase
    extends MyDomainValidator<MyDownload>
{
    //##################################################
    //# static
    //##################################################

    public static final MyDownloadValidator instance = new MyDownloadValidator();

    //##################################################
    //# variables
    //##################################################

    private KmBlobValidator bytesValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator fileNameValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyDownloadValidatorBase()
    {
        super();
        bytesValidator = newBytesValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        fileNameValidator = newFileNameValidator();
        nameValidator = newNameValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBlobValidator getBytesValidator()
    {
        return bytesValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getFileNameValidator()
    {
        return fileNameValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
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
    public void convertOnly(MyDownload value)
    {
        // fields...
        value.setBytes(bytesValidator.convert(value.getBytes()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setFileName(fileNameValidator.convert(value.getFileName()));
        value.setName(nameValidator.convert(value.getName()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyDownload value, KmErrorList errors)
    {
        // fields...
        bytesValidator.validateOn(value.getBytes(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        fileNameValidator.validateOn(value.getFileName(), errors);
        nameValidator.validateOn(value.getName(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasUser() )
            errors.addRequiredField("download", "user");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBlobValidator newBytesValidator()
    {
        KmBlobValidator e;
        e = new KmBlobValidator();
        e.setModelName("download");
        e.setFieldName("bytes");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("download");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFileNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("download");
        e.setFieldName("fileName");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(255);
        e.setAllowsPrintable(true);
        e.setModelName("download");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("download");
        e.setFieldName("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("download");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("download");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

