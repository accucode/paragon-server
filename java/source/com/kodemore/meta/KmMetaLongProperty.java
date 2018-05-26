package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.servlet.field.ScStaticDropdownField;
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
        ScLongField e;
        e = new ScLongField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScLongField newField(String label)
    {
        ScLongField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    public ScDropdownField<Long> newDropdown(int min, int max)
    {
        return newDropdown(getLabel(), min, max);
    }

    public ScDropdownField<Long> newDropdown(String label, int min, int max)
    {
        ScStaticDropdownField<Long> e;
        e = new ScStaticDropdownField<>();
        e.setMeta(this);
        e.setLabel(label);

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
