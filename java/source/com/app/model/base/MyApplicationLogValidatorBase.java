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
 * Validation rules for applicationLog.
 */
public class MyApplicationLogValidatorBase
    extends MyDomainValidator<MyApplicationLog>
{
    //##################################################
    //# static
    //##################################################

    public static final MyApplicationLogValidator instance = new MyApplicationLogValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator contextValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmIntegerValidator levelCodeValidator;
    private KmStringValidator levelNameValidator;
    private KmStringValidator loggerNameValidator;
    private KmStringValidator messageValidator;
    private KmStringValidator threadNameValidator;
    private KmStringValidator traceValidator;
    private KmStringValidator uidValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyApplicationLogValidatorBase()
    {
        super();
        contextValidator = newContextValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        levelCodeValidator = newLevelCodeValidator();
        levelNameValidator = newLevelNameValidator();
        loggerNameValidator = newLoggerNameValidator();
        messageValidator = newMessageValidator();
        threadNameValidator = newThreadNameValidator();
        traceValidator = newTraceValidator();
        uidValidator = newUidValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getContextValidator()
    {
        return contextValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmIntegerValidator getLevelCodeValidator()
    {
        return levelCodeValidator;
    }

    public KmStringValidator getLevelNameValidator()
    {
        return levelNameValidator;
    }

    public KmStringValidator getLoggerNameValidator()
    {
        return loggerNameValidator;
    }

    public KmStringValidator getMessageValidator()
    {
        return messageValidator;
    }

    public KmStringValidator getThreadNameValidator()
    {
        return threadNameValidator;
    }

    public KmStringValidator getTraceValidator()
    {
        return traceValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyApplicationLog value)
    {
        // fields...
        value.setContext(contextValidator.convert(value.getContext()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setLevelCode(levelCodeValidator.convert(value.getLevelCode()));
        value.setLevelName(levelNameValidator.convert(value.getLevelName()));
        value.setLoggerName(loggerNameValidator.convert(value.getLoggerName()));
        value.setMessage(messageValidator.convert(value.getMessage()));
        value.setThreadName(threadNameValidator.convert(value.getThreadName()));
        value.setTrace(traceValidator.convert(value.getTrace()));
        value.setUid(uidValidator.convert(value.getUid()));
    }

    @Override
    public void validateOnly(MyApplicationLog value, KmErrorList errors)
    {
        // fields...
        contextValidator.validateOn(value.getContext(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        levelCodeValidator.validateOn(value.getLevelCode(), errors);
        levelNameValidator.validateOn(value.getLevelName(), errors);
        loggerNameValidator.validateOn(value.getLoggerName(), errors);
        messageValidator.validateOn(value.getMessage(), errors);
        threadNameValidator.validateOn(value.getThreadName(), errors);
        traceValidator.validateOn(value.getTrace(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newContextValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("applicationLog");
        e.setFieldName("context");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("applicationLog");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLevelCodeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("applicationLog");
        e.setFieldName("levelCode");
        return e;
    }

    public KmStringValidator newLevelNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModelName("applicationLog");
        e.setFieldName("levelName");
        return e;
    }

    public KmStringValidator newLoggerNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("applicationLog");
        e.setFieldName("loggerName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newMessageValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("applicationLog");
        e.setFieldName("message");
        return e;
    }

    public KmStringValidator newThreadNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("applicationLog");
        e.setFieldName("threadName");
        return e;
    }

    public KmStringValidator newTraceValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("applicationLog");
        e.setFieldName("trace");
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("applicationLog");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }


}

