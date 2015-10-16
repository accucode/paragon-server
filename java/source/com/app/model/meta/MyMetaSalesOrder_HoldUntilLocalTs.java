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

public class MyMetaSalesOrder_HoldUntilLocalTs
    extends KmMetaTimestampProperty<MySalesOrder>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "holdUntilLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Holduntil";
    }

    @Override
    public String getHelp()
    {
        return "Indicates the order is on hold, and that the on-hold status should be automatically removed at a particular date and time.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
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
    public KmTimestamp getValueFor(MySalesOrder model)
    {
        return model.getHoldUntilLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, KmTimestamp value)
    {
        return model.hasHoldUntilLocalTs(value);
    }
    
}
