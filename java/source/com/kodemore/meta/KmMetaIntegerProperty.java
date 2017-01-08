package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdownField;
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
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        return e;
    }

    public ScDropdownField<Integer> newDropdown(int min, int max)
    {
        return newDropdown(getLabel(), min, max);
    }

    public ScDropdownField<Integer> newDropdown(String label, int min, int max)
    {
        ScDropdownField<Integer> e;
        e = new ScDropdownField<>();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);

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
