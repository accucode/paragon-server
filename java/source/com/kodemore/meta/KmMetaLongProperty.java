package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdownField;
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

    public ScDropdownField<Long> newDropdown(int min, int max)
    {
        return newDropdown(getLabel(), min, max);
    }

    public ScDropdownField<Long> newDropdown(String label, int min, int max)
    {
        ScDropdownField<Long> e;
        e = new ScDropdownField<>();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);

        for ( int i = min; i <= max; i++ )
            e.addOption((long)i, i + "");

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
