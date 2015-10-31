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

public class MyMetaNextOrderNumber
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNextOrderNumber instance = new MyMetaNextOrderNumber();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNextOrderNumber()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "nextOrderNumber";
    }

    public static MyNextOrderNumberValidator getValidator()
    {
        return MyNextOrderNumberValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A utility table used to coordinate the generation of unique order numbers by date. The goal is to generate unique order numbers, that are still relatively short and easy to read.  Also, we would like the order numbers to provide a rough indication of the age of the order.\n Finally, we need to support some limited ability to format the order numbers to make them unique across multiple independent systems.  For example, by including a common prefix at the beginning of each order number.\n This table maintains separate order numbers for each project.  The assumption is that these numbers are combined with a short project-specific prefix to generate a globally unique order number.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaNextOrderNumber_Uid Uid = new MyMetaNextOrderNumber_Uid();
    public static final MyMetaNextOrderNumber_Date Date = new MyMetaNextOrderNumber_Date();
    public static final MyMetaNextOrderNumber_NextNumber NextNumber = new MyMetaNextOrderNumber_NextNumber();
    public static final MyMetaNextOrderNumber_LockVersion LockVersion = new MyMetaNextOrderNumber_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaNextOrderNumber_Project Project = new MyMetaNextOrderNumber_Project();
}
