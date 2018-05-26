package com.kodemore.meta;

import com.kodemore.servlet.field.ScKilogramField;
import com.kodemore.types.KmKilogram;
import com.kodemore.validator.KmKilogramValidator;

public abstract class KmMetaKilogramProperty<T>
    extends KmMetaProperty<T,KmKilogram>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScKilogramField newField()
    {
        ScKilogramField e;
        e = new ScKilogramField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScKilogramField newField(String label)
    {
        ScKilogramField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmKilogramValidator getValidator()
    {
        return null;
    }
}
