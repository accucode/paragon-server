package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.validator.KmLongValidator;

public abstract class KmMetaLongProperty<T>
    extends KmMetaProperty<T,Long>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScLongField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScLongField newField(String label)
    {
        ScLongField e;
        e = new ScLongField();
        e.setLabel(label);
        e.setHelp(getHelp());
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
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        e.addOptionRange(min, max);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmLongValidator getValidator()
    {
        return null;
    }

}
