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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAuditLog_FieldNameLabel
    extends KmMetaStringProperty<MyAuditLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fieldNameLabel";
    }

    @Override
    public String getLabel()
    {
        return "Field Name Label";
    }

    @Override
    public String getHelp()
    {
        return "A more friendly format of the field name. E.g.: count => Count; primaryShippingAddress => Primary Shipping Address; etc.";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
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
    public String getValueFor(MyAuditLog model)
    {
        return model.getFieldNameLabel();
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, String value)
    {
        return model.hasFieldNameLabel(value);
    }

}
