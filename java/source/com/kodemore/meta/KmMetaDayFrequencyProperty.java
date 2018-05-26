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
        ScDayFrequencyField e;
        e = new ScDayFrequencyField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScDayFrequencyField newField(String label)
    {
        ScDayFrequencyField e;
        e = newField();
        e.setLabel(label);
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
