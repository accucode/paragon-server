package com.kodemore.meta;

import com.kodemore.servlet.field.ScQuantityField;
import com.kodemore.types.KmQuantity;
import com.kodemore.validator.KmQuantityValidator;

public abstract class KmMetaQuantityProperty<T>
    extends KmMetaProperty<T,KmQuantity>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScQuantityField newField()
    {
        ScQuantityField e;
        e = new ScQuantityField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScQuantityField newField(String label)
    {
        ScQuantityField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmQuantityValidator getValidator()
    {
        return null;
    }
}
