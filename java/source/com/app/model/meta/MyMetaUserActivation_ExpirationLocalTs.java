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

public class MyMetaUserActivation_ExpirationLocalTs
    extends KmMetaTimestampProperty<MyUserActivation>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "expirationLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Expiration";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when this activation expires.";
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
    public KmTimestamp getValueFor(MyUserActivation model)
    {
        return model.getExpirationLocalTs();
    }
    
    @Override
    public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
    {
        return model.hasExpirationLocalTs(value);
    }
    
    @Override
    public int compareValues(MyUserActivation o1, MyUserActivation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
