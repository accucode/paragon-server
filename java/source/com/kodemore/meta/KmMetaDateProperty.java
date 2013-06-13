package com.kodemore.meta;

import com.kodemore.servlet.field.ScDateField;
import com.kodemore.time.KmDate;
import com.kodemore.validator.KmDateValidator;

public abstract class KmMetaDateProperty<T>
    extends KmMetaProperty<T,KmDate>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScDateField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScDateField newField(String label)
    {
        ScDateField e;
        e = new ScDateField();
        e.setLabel(label);
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDateValidator getValidator()
    {
        return null;
    }
}
