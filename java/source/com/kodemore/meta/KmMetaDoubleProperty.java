package com.kodemore.meta;

import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.validator.KmDoubleValidator;

public abstract class KmMetaDoubleProperty<T>
    extends KmMetaProperty<T,Double>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScDoubleField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScDoubleField newField(String label)
    {
        ScDoubleField e;
        e = new ScDoubleField();
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
    public KmDoubleValidator getValidator()
    {
        return null;
    }

}
