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

public class MyMetaUserActivation_UpdatedLocalTsMessage
    extends KmMetaStringProperty<MyUserActivation>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "updatedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Updated";
    }

    @Override
    public String getHelp()
    {
        return "The updated timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
    public String getValueFor(MyUserActivation model)
    {
        return model.getUpdatedLocalTsMessage();
    }

    @Override
    public boolean hasValueFor(MyUserActivation model, String value)
    {
        return model.hasUpdatedLocalTsMessage(value);
    }

}
