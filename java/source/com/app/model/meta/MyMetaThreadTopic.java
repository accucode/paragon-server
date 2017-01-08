//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaThreadTopic
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaThreadTopic instance = new MyMetaThreadTopic();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaThreadTopic()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "threadTopic";
    }

    public MyThreadTopicValidator getValidator()
    {
        return MyThreadTopicValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I help to ensure that only one thread runs a particular activity (topic), even across multiple JVMs.\n To correctly ensure that only one JVM is running a given task, every JVM must check this table before starting a particular topic.  Additionally, once a particular JVM is assigned ownership, it must 'touch' the pertinent topic at least once a minute, updating the lastTouched time.  Without this touch, a long running task will eventually be deemed hung/dead, and another JVM will be allowed to become the new owner.  This could result in multiple threads running the same task.  To avoid this, break long running tasks into smaller database transactions, and ensure that the topic is 'touched' periodically.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaThreadTopic_Code Code = new MyMetaThreadTopic_Code();
    public static final MyMetaThreadTopic_OwnerUid OwnerUid = new MyMetaThreadTopic_OwnerUid();
    public static final MyMetaThreadTopic_HostName HostName = new MyMetaThreadTopic_HostName();
    public static final MyMetaThreadTopic_HostAddress HostAddress = new MyMetaThreadTopic_HostAddress();
    public static final MyMetaThreadTopic_LastStartUtcTs LastStartUtcTs = new MyMetaThreadTopic_LastStartUtcTs();
    public static final MyMetaThreadTopic_LastEndUtcTs LastEndUtcTs = new MyMetaThreadTopic_LastEndUtcTs();
    public static final MyMetaThreadTopic_LastTouchUtcTs LastTouchUtcTs = new MyMetaThreadTopic_LastTouchUtcTs();
    public static final MyMetaThreadTopic_LockVersion LockVersion = new MyMetaThreadTopic_LockVersion();
    public static final MyMetaThreadTopic_DisplayString DisplayString = new MyMetaThreadTopic_DisplayString();
    public static final MyMetaThreadTopic_LastStartLocalTs LastStartLocalTs = new MyMetaThreadTopic_LastStartLocalTs();
    public static final MyMetaThreadTopic_LastStartLocalTsMessage LastStartLocalTsMessage = new MyMetaThreadTopic_LastStartLocalTsMessage();
    public static final MyMetaThreadTopic_LastStartLocalDate LastStartLocalDate = new MyMetaThreadTopic_LastStartLocalDate();
    public static final MyMetaThreadTopic_LastStartLocalTime LastStartLocalTime = new MyMetaThreadTopic_LastStartLocalTime();
    public static final MyMetaThreadTopic_LastEndLocalTs LastEndLocalTs = new MyMetaThreadTopic_LastEndLocalTs();
    public static final MyMetaThreadTopic_LastEndLocalTsMessage LastEndLocalTsMessage = new MyMetaThreadTopic_LastEndLocalTsMessage();
    public static final MyMetaThreadTopic_LastEndLocalDate LastEndLocalDate = new MyMetaThreadTopic_LastEndLocalDate();
    public static final MyMetaThreadTopic_LastEndLocalTime LastEndLocalTime = new MyMetaThreadTopic_LastEndLocalTime();
    public static final MyMetaThreadTopic_LastTouchLocalTs LastTouchLocalTs = new MyMetaThreadTopic_LastTouchLocalTs();
    public static final MyMetaThreadTopic_LastTouchLocalTsMessage LastTouchLocalTsMessage = new MyMetaThreadTopic_LastTouchLocalTsMessage();
    public static final MyMetaThreadTopic_LastTouchLocalDate LastTouchLocalDate = new MyMetaThreadTopic_LastTouchLocalDate();
    public static final MyMetaThreadTopic_LastTouchLocalTime LastTouchLocalTime = new MyMetaThreadTopic_LastTouchLocalTime();

    //##################################################
    //# associations
    //##################################################

}
