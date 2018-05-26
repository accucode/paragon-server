package com.kodemore.meta;

import java.util.function.Predicate;

import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.validator.KmBooleanValidator;

public abstract class KmMetaBooleanProperty<T>
    extends KmMetaProperty<T,Boolean>
    implements Predicate<T>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScCheckboxField newField()
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScCheckboxField newField(String label)
    {
        ScCheckboxField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# dropdown
    //##################################################

    public ScDropdownField<Boolean> newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdownField<Boolean> newDropdown(String label)
    {
        ScStaticDropdownField<Boolean> e;
        e = new ScStaticDropdownField<>();
        e.setMeta(this);
        e.setLabel(label);
        e.addOption(true, "Yes");
        e.addOption(false, "No");
        return e;
    }

    //##################################################
    //# checkbox
    //##################################################

    public ScCheckboxField newCheckboxField()
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.setMeta(this);
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

    //##################################################
    //# predicate
    //##################################################

    @Override
    public boolean test(T t)
    {
        return getValueFor(t);
    }

}
