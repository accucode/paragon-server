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

public class MyMetaApplicationLog_FullTrace
    extends KmMetaStringProperty<MyApplicationLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fullTrace";
    }

    @Override
    public String getLabel()
    {
        return "Trace";
    }

    @Override
    public String getHelp()
    {
        return "All of the traces composed into a single string.  This is calculated (not stored in the db) and can be quite long.";
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
    public String getValueFor(MyApplicationLog model)
    {
        return model.getFullTrace();
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLog model, String value)
    {
        return model.hasFullTrace(value);
    }
    
    @Override
    public int compareValues(MyApplicationLog o1, MyApplicationLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
