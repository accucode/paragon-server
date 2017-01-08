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

public class MyMetaPatch
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPatch instance = new MyMetaPatch();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPatch()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "patch";
    }

    public MyPatchValidator getValidator()
    {
        return MyPatchValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The list of all database patches. These are used to coordinate database migrations. During database migration checks, the list of patches on the file system are compared to the list of patches known in this table.  f";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPatch_Name Name = new MyMetaPatch_Name();
    public static final MyMetaPatch_InstalledUtcTs InstalledUtcTs = new MyMetaPatch_InstalledUtcTs();
    public static final MyMetaPatch_Source Source = new MyMetaPatch_Source();
    public static final MyMetaPatch_DisplayString DisplayString = new MyMetaPatch_DisplayString();
    public static final MyMetaPatch_InstalledLocalTs InstalledLocalTs = new MyMetaPatch_InstalledLocalTs();
    public static final MyMetaPatch_InstalledLocalTsMessage InstalledLocalTsMessage = new MyMetaPatch_InstalledLocalTsMessage();
    public static final MyMetaPatch_InstalledLocalDate InstalledLocalDate = new MyMetaPatch_InstalledLocalDate();
    public static final MyMetaPatch_InstalledLocalTime InstalledLocalTime = new MyMetaPatch_InstalledLocalTime();

    //##################################################
    //# associations
    //##################################################

}
