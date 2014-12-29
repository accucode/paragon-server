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
        return newField(getLabel());
    }

    @Override
    public ScKilogramField newField(String label)
    {
        ScKilogramField e;
        e = new ScKilogramField();
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
    public KmKilogramValidator getValidator()
    {
        return null;
    }
}
