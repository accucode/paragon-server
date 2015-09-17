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
        return "A depot generally represents a facility where\nwork is processed for a particular project.  Usually, a depot is configured\nto correspond to a single building or street address.  However, in some cases\nit may be useful to define multiple depots within a single physical building,\nor to group multiple physical buildings together as a single depot.  Each\nworker is assigned to a single depot.  Additionally, product inventory (quantity\non hand) is tracked by depot.  Note: multiple project may define the same depot,\nsuch as \"Denver,\" but each depot is specific to its project and each depot\nmaintains a separate inventory, even if multiple projects contain a depot with\nthe same name.";
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
