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
    private KmStringValidator nameValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyDownloadValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
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

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyDownload value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
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
        e.setModel("download");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("download");
        e.setField("name");
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

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("download");
        e.setField("lockVersion");
        return e;
    }


}

