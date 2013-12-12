//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.model.MyPerformanceLogSummaryVo;
import com.app.model.MyPerformanceLogSummaryVoValidator;

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
