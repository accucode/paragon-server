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
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAttributeValue_SalesOrderLine
    extends KmMetaDaoAssociation<MyAttributeValue,MySalesOrderLine>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "salesOrderLine";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySalesOrderLine getValueFor(MyAttributeValue model)
    {
        return model.getSalesOrderLine();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, MySalesOrderLine value)
    {
        model.setSalesOrderLine(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, MySalesOrderLine value)
    {
        return model.hasSalesOrderLine(value);
    }
}
