package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScStaticDropdownField;
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
        ScIntegerField e;
        e = new ScIntegerField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScIntegerField newField(String label)
    {
        ScIntegerField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    public ScDropdownField<Integer> newDropdown(int min, int max)
    {
        return newDropdown(getLabel(), min, max);
    }

    public ScDropdownField<Integer> newDropdown(String label, int min, int max)
    {
        ScStaticDropdownField<Integer> e;
        e = new ScStaticDropdownField<>();
        e.setMeta(this);
        e.setLabel(label);

        for ( int i = min; i <= max; i++ )
            e.addOption(i, i + "");

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
