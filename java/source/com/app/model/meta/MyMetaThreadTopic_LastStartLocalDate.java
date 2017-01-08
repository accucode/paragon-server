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

public class MyMetaThreadTopic_LastStartLocalDate
    extends KmMetaDateProperty<MyThreadTopic>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastStartLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Last Start";
    }

    @Override
    public String getHelp()
    {
        return "The last start date based on the user's local timezone.";
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
    public KmDate getValueFor(MyThreadTopic model)
    {
        return model.getLastStartLocalDate();
    }

    @Override
    public boolean hasValueFor(MyThreadTopic model, KmDate value)
    {
        return model.hasLastStartLocalDate(value);
    }

}
