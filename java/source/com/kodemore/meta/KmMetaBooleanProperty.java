package com.kodemore.meta;

import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.validator.KmBooleanValidator;

public abstract class KmMetaBooleanProperty<T>
    extends KmMetaProperty<T,Boolean>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScCheckboxField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScCheckboxField newField(String label)
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.setLabel(label);
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmBooleanValidator getValidator()
    {
        return null;
    }

}
