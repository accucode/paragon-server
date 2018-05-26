package com.kodemore.meta;

import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScPercentField;
import com.kodemore.validator.KmDoubleValidator;

public abstract class KmMetaDoubleProperty<T>
    extends KmMetaProperty<T,Double>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScDoubleField newField()
    {
        ScDoubleField e;
        e = new ScDoubleField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScDoubleField newField(String label)
    {
        ScDoubleField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# percent field
    //##################################################

    public ScPercentField newPercentField()
    {
        return newPercentField(getLabel());
    }

    public ScPercentField newPercentField(String label)
    {
        ScPercentField e;
        e = new ScPercentField();
        e.setMeta(this);
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDoubleValidator getValidator()
    {
        return null;
    }

}
