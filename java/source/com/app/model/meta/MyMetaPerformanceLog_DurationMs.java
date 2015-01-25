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

public class MyMetaPerformanceLog_DurationMs
    extends KmMetaIntegerProperty<MyPerformanceLog>
    implements KmMetaDaoPropertyIF<MyPerformanceLog,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "durationMs";
    }

    @Override
    public String getLabel()
    {
        return "Duration Ms";
    }

    @Override
    public String getHelp()
    {
        return "The duration of the task in milliseconds.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyPerformanceLogValidator.instance.getDurationMsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "durationMs";
    }

    @Override
    public MyPerformanceLogDao getDao()
    {
        return getAccess().getPerformanceLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyPerformanceLog model)
    {
        return model.getDurationMs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLog model, Integer value)
    {
        model.setDurationMs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, Integer value)
    {
        return model.hasDurationMs(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
