//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaProduct_StatusName
    extends KmMetaStringProperty<MyProduct>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "statusName";
    }

    @Override
    public String getLabel()
    {
        return "Status";
    }

    @Override
    public String getHelp()
    {
        return "The status of this version.\n Draft. New versions always start as a draft and each (master) product can have only one draft at a time.\n Cancelled. Indicates that a draft was cancelled without ever being published.\n Published. When the user is done editing a draft, the draft is published for use.  Only one version can be published at a time. When a new version is published, the previously published version (if any) will be archived.\n Archived. A previously published version that has been superceded when a newer version has been published.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProduct model)
    {
        return model.getStatusName();
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, String value)
    {
        return model.hasStatusName(value);
    }
    
}
