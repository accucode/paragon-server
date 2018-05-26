package com.kodemore.meta;

import com.kodemore.servlet.field.ScUnitDurationField;
import com.kodemore.time.KmUnitDuration;
import com.kodemore.validator.KmUnitDurationValidator;

public abstract class KmMetaUnitDurationProperty<T>
    extends KmMetaProperty<T,KmUnitDuration>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScUnitDurationField newField()
    {
        ScUnitDurationField e;
        e = new ScUnitDurationField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScUnitDurationField newField(String label)
    {
        ScUnitDurationField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmUnitDurationValidator getValidator()
    {
        return null;
    }
}
