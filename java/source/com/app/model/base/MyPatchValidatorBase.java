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

    private KmStringValidator nameValidator;
    private KmTimestampValidator installedUtcTsValidator;
    private KmStringValidator sourceValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPatchValidatorBase()
    {
        super();
        nameValidator = newNameValidator();
        installedUtcTsValidator = newInstalledUtcTsValidator();
        sourceValidator = newSourceValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmTimestampValidator getInstalledUtcTsValidator()
    {
        return installedUtcTsValidator;
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
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setInstalledUtcTs(installedUtcTsValidator.convertOnly(value.getInstalledUtcTs()));
        value.setSource(sourceValidator.convertOnly(value.getSource()));
    }

    @Override
    public void validateOnly(MyPatch value, KmList<KmErrorIF> errors)
    {
        // fields...
        nameValidator.validateOnly(value.getName(), errors);
        installedUtcTsValidator.validateOnly(value.getInstalledUtcTs(), errors);
        sourceValidator.validateOnly(value.getSource(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("patch");
        e.setField("name");
        return e;
    }

    public KmTimestampValidator newInstalledUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("patch");
        e.setField("installedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSourceValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("patch");
        e.setField("source");
        e.setRequired();
        return e;
    }


}

