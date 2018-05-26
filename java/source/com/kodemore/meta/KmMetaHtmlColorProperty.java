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
        ScColorField e;
        e = new ScColorField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScColorField newField(String label)
    {
        ScColorField e;
        e = newField();
        e.setLabel(label);
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
