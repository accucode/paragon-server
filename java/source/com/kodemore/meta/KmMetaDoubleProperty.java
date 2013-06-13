package com.kodemore.meta;

import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScDropdown;
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
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        return e;
    }

    public ScDropdown newDropdown(int min, int max)
    {
        return newDropdown(getLabel(), min, max);
    }

    public ScDropdown newDropdown(String label, int min, int max)
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel(label);
        e.setValue(getAdaptor());
        e.addOptionRange(min, max);
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
