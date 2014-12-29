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
        return newField(getLabel());
    }

    @Override
    public ScQuantityField newField(String label)
    {
        ScQuantityField e;
        e = new ScQuantityField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
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
