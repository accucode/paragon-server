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

public class MyMetaSalesOrder_StatusName
    extends KmMetaStringProperty<MySalesOrder>
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
        return "A summary of the order's status.";
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
    public String getValueFor(MySalesOrder model)
    {
        return model.getStatusName();
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, String value)
    {
        return model.hasStatusName(value);
    }
    
}
