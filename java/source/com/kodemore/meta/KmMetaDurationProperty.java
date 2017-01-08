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
        return newField(getLabel());
    }

    @Override
    public ScDurationField newField(String label)
    {
        ScDurationField e;
        e = new ScDurationField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
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
