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
 * Validation rules for feedback.
 */
public class MyFeedbackValidatorBase
    extends MyDomainValidator<MyFeedback>
{
    //##################################################
    //# static
    //##################################################

    public static final MyFeedbackValidator instance = new MyFeedbackValidator();

    //##################################################
    //# variables
    //##################################################

    private KmDateValidator closedDateValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator descriptionValidator;
    private KmStringValidator notesValidator;
    private KmBooleanValidator openValidator;
    private KmStringValidator pageKeyValidator;
    private KmStringValidator queryStringValidator;
    private KmStringValidator requestUrlValidator;
    private KmStringValidator statusCodeValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmStringValidator windowLocationValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFeedbackValidatorBase()
    {
        super();
        closedDateValidator = newClosedDateValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        descriptionValidator = newDescriptionValidator();
        notesValidator = newNotesValidator();
        openValidator = newOpenValidator();
        pageKeyValidator = newPageKeyValidator();
        queryStringValidator = newQueryStringValidator();
        requestUrlValidator = newRequestUrlValidator();
        statusCodeValidator = newStatusCodeValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        windowLocationValidator = newWindowLocationValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDateValidator getClosedDateValidator()
    {
        return closedDateValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getDescriptionValidator()
    {
        return descriptionValidator;
    }

    public KmStringValidator getNotesValidator()
    {
        return notesValidator;
    }

    public KmBooleanValidator getOpenValidator()
    {
        return openValidator;
    }

    public KmStringValidator getPageKeyValidator()
    {
        return pageKeyValidator;
    }

    public KmStringValidator getQueryStringValidator()
    {
        return queryStringValidator;
    }

    public KmStringValidator getRequestUrlValidator()
    {
        return requestUrlValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmStringValidator getWindowLocationValidator()
    {
        return windowLocationValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyFeedback value)
    {
        // fields...
        value.setClosedDate(closedDateValidator.convert(value.getClosedDate()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDescription(descriptionValidator.convert(value.getDescription()));
        value.setNotes(notesValidator.convert(value.getNotes()));
        value.setOpen(openValidator.convert(value.getOpen()));
        value.setPageKey(pageKeyValidator.convert(value.getPageKey()));
        value.setQueryString(queryStringValidator.convert(value.getQueryString()));
        value.setRequestUrl(requestUrlValidator.convert(value.getRequestUrl()));
        value.setStatusCode(statusCodeValidator.convert(value.getStatusCode()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setWindowLocation(windowLocationValidator.convert(value.getWindowLocation()));
    }

    @Override
    public void validateOnly(MyFeedback value, KmErrorList errors)
    {
        // fields...
        closedDateValidator.validateOn(value.getClosedDate(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        descriptionValidator.validateOn(value.getDescription(), errors);
        notesValidator.validateOn(value.getNotes(), errors);
        openValidator.validateOn(value.getOpen(), errors);
        pageKeyValidator.validateOn(value.getPageKey(), errors);
        queryStringValidator.validateOn(value.getQueryString(), errors);
        requestUrlValidator.validateOn(value.getRequestUrl(), errors);
        statusCodeValidator.validateOn(value.getStatusCode(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        windowLocationValidator.validateOn(value.getWindowLocation(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.addRequiredField("feedback", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmDateValidator newClosedDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModelName("feedback");
        e.setFieldName("closedDate");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("feedback");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDescriptionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("feedback");
        e.setFieldName("description");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNotesValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("feedback");
        e.setFieldName("notes");
        return e;
    }

    public KmBooleanValidator newOpenValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("feedback");
        e.setFieldName("open");
        e.setRequired();
        return e;
    }

    public KmStringValidator newPageKeyValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("feedback");
        e.setFieldName("pageKey");
        return e;
    }

    public KmStringValidator newQueryStringValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("feedback");
        e.setFieldName("queryString");
        return e;
    }

    public KmStringValidator newRequestUrlValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("feedback");
        e.setFieldName("requestUrl");
        return e;
    }

    public KmStringValidator newStatusCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("feedback");
        e.setFieldName("statusCode");
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
        e.setModelName("feedback");
        e.setFieldName("typeCode");
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("feedback");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("feedback");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newWindowLocationValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("feedback");
        e.setFieldName("windowLocation");
        return e;
    }


}

