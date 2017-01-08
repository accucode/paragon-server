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

public class MyMetaOptimisticLock
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaOptimisticLock instance = new MyMetaOptimisticLock();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaOptimisticLock()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "optimisticLock";
    }

    public MyOptimisticLockValidator getValidator()
    {
        return MyOptimisticLockValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "This table is used to coordinate optimistic locks in rare circumstances where the pertinent modifications would otherwise not necessarily touch the same record.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaOptimisticLock_Name Name = new MyMetaOptimisticLock_Name();
    public static final MyMetaOptimisticLock_LockVersion LockVersion = new MyMetaOptimisticLock_LockVersion();
    public static final MyMetaOptimisticLock_DisplayString DisplayString = new MyMetaOptimisticLock_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
