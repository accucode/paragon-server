//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

import com.app.model.MyPerformanceLogSummaryVo;
import com.app.model.MyPerformanceLogSummaryVoValidator;

public class MyMetaPerformanceLogSummaryVo_Name
    extends KmMetaStringProperty<MyPerformanceLogSummaryVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "name";
    }

    @Override
    public String getLabel()
    {
        return "Name";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyPerformanceLogSummaryVoValidator.instance.getNameValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPerformanceLogSummaryVo model)
    {
        return model.getName();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogSummaryVo model, String value)
    {
        model.setName(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogSummaryVo model, String value)
    {
        return model.hasName(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLogSummaryVo o1, MyPerformanceLogSummaryVo o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
