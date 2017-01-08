package com.kodemore.meta;

import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScDropdownField;
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
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        return e;
    }

    //==================================================
    //= dropdown
    //==================================================

    public ScDropdownField<Boolean> newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdownField<Boolean> newDropdown(String label)
    {
        ScDropdownField<Boolean> e;
        e = new ScDropdownField<>();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        e.addOption(true, "Yes");
        e.addOption(false, "No");
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
