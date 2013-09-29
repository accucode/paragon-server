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
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaNamedCountVo_Name
    extends KmMetaStringProperty<MyNamedCountVo>
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
        return MyNamedCountVoValidator.instance.getNameValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyNamedCountVo model)
    {
        return model.getName();
    }
    
    @Override
    public void setValueFor(MyNamedCountVo model, String value)
    {
        model.setName(value);
    }
    
    @Override
    public boolean hasValueFor(MyNamedCountVo model, String value)
    {
        return model.hasName(value);
    }
    
    @Override
    public int compareValues(MyNamedCountVo o1, MyNamedCountVo o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
