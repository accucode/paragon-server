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

public class MyMetaPerformanceLogSummaryVo_TotalMs
    extends KmMetaIntegerProperty<MyPerformanceLogSummaryVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "totalMs";
    }

    @Override
    public String getLabel()
    {
        return "Total Ms";
    }

    @Override
    public String getHelp()
    {
        return null;
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
        return MyPerformanceLogSummaryVoValidator.instance.getTotalMsValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyPerformanceLogSummaryVo model)
    {
        return model.getTotalMs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogSummaryVo model, Integer value)
    {
        model.setTotalMs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogSummaryVo model, Integer value)
    {
        return model.hasTotalMs(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLogSummaryVo o1, MyPerformanceLogSummaryVo o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
