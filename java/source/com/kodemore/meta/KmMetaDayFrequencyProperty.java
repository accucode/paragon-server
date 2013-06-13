package com.kodemore.meta;

import com.kodemore.servlet.field.ScField;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.validator.KmDayFrequencyValidator;

public abstract class KmMetaDayFrequencyProperty<T>
    extends KmMetaProperty<T,KmDayFrequency>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScField<KmDayFrequency> newField()
    {
        return null;
    }

    @Override
    public ScField<KmDayFrequency> newField(String label)
    {
        return null;
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
