package com.kodemore.meta;

import com.kodemore.servlet.field.ScTextField;
import com.kodemore.validator.KmStringValidator;

public abstract class KmMetaStringProperty<T>
    extends KmMetaProperty<T,String>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScTextField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScTextField newField(String label)
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel(label);
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmStringValidator getValidator()
    {
        return null;
    }
}
