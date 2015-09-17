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

public class MyMetaAutoSignIn_LastTouchedLocalTs
    extends KmMetaTimestampProperty<MyAutoSignIn>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedLocalTs";
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
        return 16;
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
    public KmTimestamp getValueFor(MyAutoSignIn model)
    {
        return model.getLastTouchedLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        return model.hasLastTouchedLocalTs(value);
    }
    
}
