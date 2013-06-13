package com.kodemore.meta;

import com.kodemore.servlet.field.ScColorField;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.validator.KmHtmlColorValidator;

public abstract class KmMetaHtmlColorProperty<T>
    extends KmMetaProperty<T,KmHtmlColor>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScColorField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScColorField newField(String label)
    {
        ScColorField e;
        e = new ScColorField();
        e.setLabel(label);
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmHtmlColorValidator getValidator()
    {
        return null;
    }

}
