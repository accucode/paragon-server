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

public class MyMetaThreadTopic_LastTouchLocalTime
    extends KmMetaTimeProperty<MyThreadTopic>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchLocalTime";
    }

    @Override
    public String getLabel()
    {
        return "Lasttouch";
    }

    @Override
    public String getHelp()
    {
        return "The last time the owner TOUCHED this task. This is used to coordinate ownership. JVM may shutdown, get restarted, or simply hang completely. If the current owner has not touched the record in the last 10 minutes, then it is assumed that the owner has died and that someone else should be assigned as the owner.";
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
    public KmTime getValueFor(MyThreadTopic model)
    {
        return model.getLastTouchLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyThreadTopic model, KmTime value)
    {
        return model.hasLastTouchLocalTime(value);
    }
    
}
