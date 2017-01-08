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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator fileNameValidator;
    private KmBlobValidator bytesValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyDownloadValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        nameValidator = newNameValidator();
        typeCodeValidator = newTypeCodeValidator();
        fileNameValidator = newFileNameValidator();
        bytesValidator = newBytesValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getFileNameValidator()
    {
        return fileNameValidator;
    }

    public KmBlobValidator getBytesValidator()
    {
        return bytesValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setFileName(fileNameValidator.convertOnly(value.getFileName()));
        value.setBytes(bytesValidator.convertOnly(value.getBytes()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyDownload value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        fileNameValidator.validateOnly(value.getFileName(), errors);
        bytesValidator.validateOnly(value.getBytes(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasUser() )
            errors.add(new KmRequiredValidationError("download", "user"));
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
        e.setModel("download");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("download");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(200);
        e.setAllowsPrintable(true);
        e.setModel("download");
        e.setField("name");
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
        e.setModel("download");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFileNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("download");
        e.setField("fileName");
        return e;
    }

    public KmBlobValidator newBytesValidator()
    {
        KmBlobValidator e;
        e = new KmBlobValidator();
        e.setModel("download");
        e.setField("bytes");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("download");
        e.setField("lockVersion");
        return e;
    }


}

