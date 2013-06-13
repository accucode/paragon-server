package com.kodemore.meta;

import com.kodemore.servlet.field.ScTimeField;
import com.kodemore.time.KmTime;
import com.kodemore.validator.KmTimeValidator;

public abstract class KmMetaTimeProperty<T>
    extends KmMetaProperty<T,KmTime>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScTimeField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScTimeField newField(String label)
    {
        ScTimeField e;
        e = new ScTimeField();
        e.setLabel(label);
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmTimeValidator getValidator()
    {
        return null;
    }

}
