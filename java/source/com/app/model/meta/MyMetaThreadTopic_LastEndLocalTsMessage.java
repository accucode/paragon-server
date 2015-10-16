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

public class MyMetaThreadTopic_LastEndLocalTsMessage
    extends KmMetaStringProperty<MyThreadTopic>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastEndLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Lastend";
    }

    @Override
    public String getHelp()
    {
        return "The last time the owner ENDED this task. This is only used for auditing; not for coordinating ownership.";
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
    public String getValueFor(MyThreadTopic model)
    {
        return model.getLastEndLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyThreadTopic model, String value)
    {
        return model.hasLastEndLocalTsMessage(value);
    }
    
}
