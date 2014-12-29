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

public class MyMetaSettings
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSettings instance = new MyMetaSettings();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSettings()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "settings";
    }

    public static MySettingsValidator getValidator()
    {
        return MySettingsValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A single record with global settings.  This provides a simply, typesafe way to store\nsome global settings in the database.  For example, we could define a global contact\n(email or phone) for technical assistance with the portal.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSettings_Code Code = new MyMetaSettings_Code();
    public static final MyMetaSettings_SomeMessage SomeMessage = new MyMetaSettings_SomeMessage();
    public static final MyMetaSettings_LockVersion LockVersion = new MyMetaSettings_LockVersion();

    //##################################################
    //# associations
    //##################################################

}
