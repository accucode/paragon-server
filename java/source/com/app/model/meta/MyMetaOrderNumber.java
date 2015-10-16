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

public class MyMetaOrderNumber
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaOrderNumber instance = new MyMetaOrderNumber();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaOrderNumber()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "orderNumber";
    }

    public static MyOrderNumberValidator getValidator()
    {
        return MyOrderNumberValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A utility table used to coordinate the generation of unique order numbers by date. The goal is to generate unique order numbers, that are still relatively short and easy to read.  Also, we would like the order numbers to provide a rough indication of the age of the order.\n Finally, we need to support some limited ability to format the order numbers to make them unique across multiple independent systems.  For example, by including a common prefix at the beginning of each order number, where the prefix\n This table maintains separate order numbers for each project.  The assumption is that these numbers are combined with a short project-specific prefix to generate a globally unique order number.\n The records in this table are typically prepopulated a week in advance.  Although collisions should be very rare, this help to ensure smooth operations since it is simpler to coordination collisions with optimistic record locking rather handling collisions related to duplicate key insertion.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaOrderNumber_Uid Uid = new MyMetaOrderNumber_Uid();
    public static final MyMetaOrderNumber_Date Date = new MyMetaOrderNumber_Date();
    public static final MyMetaOrderNumber_NextNumber NextNumber = new MyMetaOrderNumber_NextNumber();
    public static final MyMetaOrderNumber_LockVersion LockVersion = new MyMetaOrderNumber_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaOrderNumber_Project Project = new MyMetaOrderNumber_Project();
}
