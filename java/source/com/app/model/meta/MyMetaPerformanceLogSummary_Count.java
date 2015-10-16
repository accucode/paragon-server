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

public class MyMetaPerformanceLogSummary_Count
    extends KmMetaIntegerProperty<MyPerformanceLogSummary>
    implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "count";
    }

    @Override
    public String getLabel()
    {
        return "Count";
    }

    @Override
    public String getHelp()
    {
        return "The number of performance logs being aggregated.";
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
        return MyPerformanceLogSummaryValidator.instance.getCountValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "count";
    }

    @Override
    public MyPerformanceLogSummaryDao getDao()
    {
        return getAccess().getPerformanceLogSummaryDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyPerformanceLogSummary model)
    {
        return model.getCount();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogSummary model, Integer value)
    {
        model.setCount(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
    {
        return model.hasCount(value);
    }
    
}
