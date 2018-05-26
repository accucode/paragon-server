package com.kodemore.meta;

import com.kodemore.servlet.field.ScDurationField;
import com.kodemore.time.KmDuration;
import com.kodemore.validator.KmDurationValidator;

public abstract class KmMetaDurationProperty<T>
    extends KmMetaProperty<T,KmDuration>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScDurationField newField()
    {
        ScDurationField e;
        e = new ScDurationField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScDurationField newField(String label)
    {
        ScDurationField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmDurationValidator getValidator()
    {
        return null;
    }
}
