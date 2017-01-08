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

public class MyMetaServerSession_ClosedLocalTsMessage
    extends KmMetaStringProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Closed";
    }

    @Override
    public String getHelp()
    {
        return "The closed timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
    public String getValueFor(MyServerSession model)
    {
        return model.getClosedLocalTsMessage();
    }

    @Override
    public boolean hasValueFor(MyServerSession model, String value)
    {
        return model.hasClosedLocalTsMessage(value);
    }

}
