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

public class MyMetaAutoSignIn_LastTouchedLocalTsMessage
    extends KmMetaStringProperty<MyAutoSignIn>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Lasttouched";
    }

    @Override
    public String getHelp()
    {
        return "The date and time the user logged in.  This is generally updated each time the user logs in either manaully or automatically.";
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
    public String getValueFor(MyAutoSignIn model)
    {
        return model.getLastTouchedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, String value)
    {
        return model.hasLastTouchedLocalTsMessage(value);
    }
    
}
