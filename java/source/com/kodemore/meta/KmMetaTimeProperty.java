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
        ScTimeField e;
        e = new ScTimeField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScTimeField newField(String label)
    {
        ScTimeField e;
        e = newField();
        e.setLabel(label);
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
