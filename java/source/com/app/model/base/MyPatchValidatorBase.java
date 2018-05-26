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
 * Validation rules for patch.
 */
public class MyPatchValidatorBase
    extends MyDomainValidator<MyPatch>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPatchValidator instance = new MyPatchValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator installedUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator sourceValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPatchValidatorBase()
    {
        super();
        installedUtcTsValidator = newInstalledUtcTsValidator();
        nameValidator = newNameValidator();
        sourceValidator = newSourceValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getInstalledUtcTsValidator()
    {
        return installedUtcTsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getSourceValidator()
    {
        return sourceValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPatch value)
    {
        // fields...
        value.setInstalledUtcTs(installedUtcTsValidator.convert(value.getInstalledUtcTs()));
        value.setName(nameValidator.convert(value.getName()));
        value.setSource(sourceValidator.convert(value.getSource()));
    }

    @Override
    public void validateOnly(MyPatch value, KmErrorList errors)
    {
        // fields...
        installedUtcTsValidator.validateOn(value.getInstalledUtcTs(), errors);
        nameValidator.validateOn(value.getName(), errors);
        sourceValidator.validateOn(value.getSource(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newInstalledUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("patch");
        e.setFieldName("installedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("patch");
        e.setFieldName("name");
        return e;
    }

    public KmStringValidator newSourceValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("patch");
        e.setFieldName("source");
        e.setRequired();
        return e;
    }


}

