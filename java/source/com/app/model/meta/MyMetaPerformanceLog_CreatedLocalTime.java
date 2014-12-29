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

public class MyMetaPerformanceLog_CreatedLocalTime
    extends KmMetaTimeProperty<MyPerformanceLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalTime";
    }

    @Override
    public String getLabel()
    {
        return "Created";
    }

    @Override
    public String getHelp()
    {
        return "The approximate date and time when the task was run. In practice this will be very close to when the task ended but may lag a few milliseconds.";
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
    public KmTime getValueFor(MyPerformanceLog model)
    {
        return model.getCreatedLocalTime();
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, KmTime value)
    {
        return model.hasCreatedLocalTime(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
