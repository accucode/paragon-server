package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.validator.KmIntegerValidator;

public abstract class KmMetaIntegerProperty<T>
    extends KmMetaProperty<T,Integer>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScIntegerField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScIntegerField newField(String label)
    {
        ScIntegerField e;
        e = new ScIntegerField();
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
    public KmIntegerValidator getValidator()
    {
        return null;
    }

}
