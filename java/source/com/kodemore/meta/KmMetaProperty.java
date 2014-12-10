package com.kodemore.meta;

import com.kodemore.comparator.KmComparator;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScField;
import com.kodemore.validator.KmBooleanValidator;
import com.kodemore.validator.KmValidator;

public abstract class KmMetaProperty<T, V>
    extends KmMetaAttribute<T,V>
{
    //##################################################
    //# attributes
    //##################################################

    public abstract String getLabel();

    public abstract boolean isEditable();

    public abstract int getColumnWidth();

    //##################################################
    //# validator
    //##################################################

    public abstract KmValidator<V> getValidator();

    public boolean hasValidator()
    {
        return getValidator() != null;
    }

    //##################################################
    //# compare
    //##################################################

    public KmComparator<T> getComparator()
    {
        return new KmComparator<T>()
        {
            @Override
            public int compare(T o1, T o2)
            {
                return compareValues(o1, o2, getNullsOnTop());
            }
        };
    }

    //##################################################
    //# controls
    //##################################################

    public ScText newText()
    {
        ScText e;
        e = new ScText();
        e.setLabel(getLabel());
        e.setValue(getAdaptor());
        return e;
    }

    public ScText newText(String label)
    {
        ScText e;
        e = newText();
        e.setLabel(label);
        return e;
    }

    public ScTextSpan newSpannedText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.setLabel(getLabel());
        e.setValue(getAdaptor());
        return e;
    }

    public ScTextSpan newSpannedText(String label)
    {
        ScTextSpan e;
        e = newSpannedText();
        e.setLabel(label);
        return e;
    }

    public ScGridColumn<T> newGridColumn()
    {
        ScGridColumn<T> e;
        e = new ScGridColumn<T>();
        e.setHeader(getLabel());
        e.setWidth(getColumnWidth() * 8);
        e.setDisplayAdaptor(getAdaptor());
        e.setCsvAdaptor(getAdaptor());
        return e;
    }

    public ScField<V> newField()
    {
        throw new UnsupportedOperationException();
    }

    public ScField<V> newField(String label)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# controls: support
    //##################################################

    protected ScCheckboxField newCheckboxField(KmBooleanValidator validator)
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.setValueAdaptor(getAdaptor());
        e.setLabel(getLabel());
        e.setValidator(validator);
        return e;
    }

    protected ScCheckboxField newCheckboxField(String label, KmBooleanValidator validator)
    {
        ScCheckboxField e;
        e = newCheckboxField(validator);
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# value
    //##################################################

    public abstract int compareValues(T o1, T o2, boolean nullsOnTop);
}
