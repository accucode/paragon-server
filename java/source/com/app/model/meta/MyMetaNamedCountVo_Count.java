//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyNamedCountVo;
import com.app.model.MyNamedCountVoValidator;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

public class MyMetaNamedCountVo_Count
    extends KmMetaIntegerProperty<MyNamedCountVo>
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
        return MyNamedCountVoValidator.instance.getCountValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyNamedCountVo model)
    {
        return model.getCount();
    }
    
    @Override
    public void setValueFor(MyNamedCountVo model, Integer value)
    {
        model.setCount(value);
    }
    
    @Override
    public boolean hasValueFor(MyNamedCountVo model, Integer value)
    {
        return model.hasCount(value);
    }
    
    @Override
    public int compareValues(MyNamedCountVo o1, MyNamedCountVo o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
