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

public class MyMetaAuditLog_CreatedLocalDate
    extends KmMetaDateProperty<MyAuditLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Created";
    }

    @Override
    public String getHelp()
    {
        return "The created date based on the user's local timezone.";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
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
    public KmDate getValueFor(MyAuditLog model)
    {
        return model.getCreatedLocalDate();
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, KmDate value)
    {
        return model.hasCreatedLocalDate(value);
    }

}
