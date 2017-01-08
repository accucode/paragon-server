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

public class MyMetaServerSession_LastTouchedLocalTime
    extends KmMetaTimeProperty<MyServerSession>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalTime";
    }

    @Override
    public String getLabel()
    {
        return "Last Touched";
    }

    @Override
    public String getHelp()
    {
        return "The last touched time of day based on the user's local timezone.";
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
    public KmTime getValueFor(MyServerSession model)
    {
        return model.getLastTouchedLocalTime();
    }

    @Override
    public boolean hasValueFor(MyServerSession model, KmTime value)
    {
        return model.hasLastTouchedLocalTime(value);
    }

}
