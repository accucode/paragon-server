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

public class MyMetaDepot
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDepot instance = new MyMetaDepot();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDepot()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "depot";
    }

    public static MyDepotValidator getValidator()
    {
        return MyDepotValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A depot generally represents a facility where work is processed for a particular project.  Usually, a depot is configured to correspond to a single building or street address.  However, in some cases it may be useful to define multiple depots within a single physical building, or to group multiple physical buildings together as a single depot.  Each worker is assigned to a single depot.  Additionally, product inventory (quantity on hand) is tracked by depot.  Note: multiple project may define the same depot, such as \"Denver,\" but each depot is specific to its project and each depot maintains a separate inventory, even if multiple projects contain a depot with the same name.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaDepot_Uid Uid = new MyMetaDepot_Uid();
    public static final MyMetaDepot_Name Name = new MyMetaDepot_Name();
    public static final MyMetaDepot_Phone Phone = new MyMetaDepot_Phone();
    public static final MyMetaDepot_LockVersion LockVersion = new MyMetaDepot_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaDepot_Project Project = new MyMetaDepot_Project();
}
