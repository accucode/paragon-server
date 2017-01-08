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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator loggerNameValidator;
    private KmStringValidator contextValidator;
    private KmStringValidator messageValidator;
    private KmStringValidator levelNameValidator;
    private KmIntegerValidator levelCodeValidator;
    private KmStringValidator threadNameValidator;
    private KmStringValidator traceValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyApplicationLogValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        loggerNameValidator = newLoggerNameValidator();
        contextValidator = newContextValidator();
        messageValidator = newMessageValidator();
        levelNameValidator = newLevelNameValidator();
        levelCodeValidator = newLevelCodeValidator();
        threadNameValidator = newThreadNameValidator();
        traceValidator = newTraceValidator();
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

    public KmStringValidator getLoggerNameValidator()
    {
        return loggerNameValidator;
    }

    public KmStringValidator getContextValidator()
    {
        return contextValidator;
    }

    public KmStringValidator getMessageValidator()
    {
        return messageValidator;
    }

    public KmStringValidator getLevelNameValidator()
    {
        return levelNameValidator;
    }

    public KmIntegerValidator getLevelCodeValidator()
    {
        return levelCodeValidator;
    }

    public KmStringValidator getThreadNameValidator()
    {
        return threadNameValidator;
    }

    public KmStringValidator getTraceValidator()
    {
        return traceValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyApplicationLog value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setLoggerName(loggerNameValidator.convertOnly(value.getLoggerName()));
        value.setContext(contextValidator.convertOnly(value.getContext()));
        value.setMessage(messageValidator.convertOnly(value.getMessage()));
        value.setLevelName(levelNameValidator.convertOnly(value.getLevelName()));
        value.setLevelCode(levelCodeValidator.convertOnly(value.getLevelCode()));
        value.setThreadName(threadNameValidator.convertOnly(value.getThreadName()));
        value.setTrace(traceValidator.convertOnly(value.getTrace()));
    }

    @Override
    public void validateOnly(MyApplicationLog value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        loggerNameValidator.validateOnly(value.getLoggerName(), errors);
        contextValidator.validateOnly(value.getContext(), errors);
        messageValidator.validateOnly(value.getMessage(), errors);
        levelNameValidator.validateOnly(value.getLevelName(), errors);
        levelCodeValidator.validateOnly(value.getLevelCode(), errors);
        threadNameValidator.validateOnly(value.getThreadName(), errors);
        traceValidator.validateOnly(value.getTrace(), errors);
        // required associations...
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
        e.setModel("applicationLog");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("applicationLog");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newLoggerNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("loggerName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newContextValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("context");
        return e;
    }

    public KmStringValidator newMessageValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("applicationLog");
        e.setField("message");
        return e;
    }

    public KmStringValidator newLevelNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("levelName");
        return e;
    }

    public KmIntegerValidator newLevelCodeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("applicationLog");
        e.setField("levelCode");
        return e;
    }

    public KmStringValidator newThreadNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("threadName");
        return e;
    }

    public KmStringValidator newTraceValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("applicationLog");
        e.setField("trace");
        return e;
    }


}

