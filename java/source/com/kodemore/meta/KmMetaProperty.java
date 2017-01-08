package com.kodemore.meta;

import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextParagraph;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.validator.KmBooleanValidator;
import com.kodemore.validator.KmValidator;

public abstract class KmMetaProperty<T, V>
    extends KmMetaAttribute<T,V>
{
    //##################################################
    //# attributes
    //##################################################

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
    //# controls
    //##################################################

    public ScText newText()
    {
        ScText e;
        e = new ScText();
        e.setLabel(getLabel());
        e.setHelp(getHelp());
        e.setValue(this);
        return e;
    }

    public ScText newText(String label)
    {
        ScText e;
        e = newText();
        e.setLabel(label);
        return e;
    }

    public ScFieldText newFieldText()
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setLabel(getLabel());
        e.setHelp(getHelp());
        e.setValue(this);
        return e;
    }

    public ScFieldText newFieldText(String label)
    {
        ScFieldText e;
        e = newFieldText();
        e.setLabel(label);
        return e;
    }

    public ScTextSpan newTextSpan()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.setLabel(getLabel());
        e.setValue(this);
        e.setHelp(getHelp());
        return e;
    }

    public ScTextSpan newTextSpan(String label)
    {
        ScTextSpan e;
        e = newTextSpan();
        e.setLabel(label);
        e.setHelp(getHelp());
        return e;
    }

    public ScTextParagraph newTextParagraph()
    {
        ScTextParagraph e;
        e = new ScTextParagraph();
        e.setLabel(getLabel());
        e.setValue(this);
        e.setHelp(getHelp());
        return e;
    }

    public ScTextParagraph newTextParagraph(String label)
    {
        ScTextParagraph e;
        e = newTextParagraph();
        e.setLabel(label);
        e.setHelp(getHelp());
        return e;
    }

    public ScGridColumn<T> newGridColumn()
    {
        ScGridColumn<T> e;
        e = new ScGridColumn<>();
        e.setHeader(getLabel());
        e.setWidth(getColumnWidth() * 8);
        e.setDisplayAdaptor(this);
        e.setExportFunction(toObjectFunction());
        return e;
    }

    public ScFieldIF<V> newField()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @param label
     */
    public ScFieldIF<V> newField(String label)
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
        e.setValidator(validator);
        e.setValueAdaptor(this);
        e.setLabel(getLabel());
        e.setHelp(getHelp());
        return e;
    }

    protected ScCheckboxField newCheckboxField(String label, KmBooleanValidator validator)
    {
        ScCheckboxField e;
        e = newCheckboxField(validator);
        e.setLabel(label);
        e.setHelp(getHelp());
        return e;
    }
}
