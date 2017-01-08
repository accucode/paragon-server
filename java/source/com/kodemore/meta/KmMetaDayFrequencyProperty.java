package com.kodemore.meta;

import com.kodemore.servlet.field.ScDayFrequencyField;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.validator.KmDayFrequencyValidator;

public abstract class KmMetaDayFrequencyProperty<T>
    extends KmMetaProperty<T,KmDayFrequency>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScDayFrequencyField newField()
    {
        return newField(null);
    }

    @Override
    public ScDayFrequencyField newField(String label)
    {
        ScDayFrequencyField e;
        e = new ScDayFrequencyField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDayFrequencyValidator getValidator()
    {
        return null;
    }

}
