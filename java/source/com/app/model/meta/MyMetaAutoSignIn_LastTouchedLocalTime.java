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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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

public class MyMetaAutoSignIn_LastTouchedLocalTime
    extends KmMetaTimeProperty<MyAutoSignIn>
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
    public KmTime getValueFor(MyAutoSignIn model)
    {
        return model.getLastTouchedLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, KmTime value)
    {
        return model.hasLastTouchedLocalTime(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
