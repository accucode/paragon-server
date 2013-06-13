package com.kodemore.meta;

import com.kodemore.servlet.field.ScRateField;
import com.kodemore.types.KmRate;
import com.kodemore.validator.KmRateValidator;

public abstract class KmMetaRateProperty<T>
    extends KmMetaProperty<T,KmRate>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScRateField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScRateField newField(String label)
    {
        ScRateField e;
        e = new ScRateField();
        e.setLabel(label);
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmRateValidator getValidator()
    {
        return null;
    }
}
