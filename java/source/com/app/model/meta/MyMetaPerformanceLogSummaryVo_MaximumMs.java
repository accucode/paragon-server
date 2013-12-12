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

public class MyMetaPerformanceLogSummaryVo_MaximumMs
    extends KmMetaIntegerProperty<MyPerformanceLogSummaryVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "maximumMs";
    }

    @Override
    public String getLabel()
    {
        return "Maximum Ms";
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
        return MyPerformanceLogSummaryVoValidator.instance.getMaximumMsValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyPerformanceLogSummaryVo model)
    {
        return model.getMaximumMs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogSummaryVo model, Integer value)
    {
        model.setMaximumMs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogSummaryVo model, Integer value)
    {
        return model.hasMaximumMs(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLogSummaryVo o1, MyPerformanceLogSummaryVo o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
