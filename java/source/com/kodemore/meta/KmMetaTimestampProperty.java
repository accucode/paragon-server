package com.kodemore.meta;

import com.kodemore.servlet.field.ScTimestampField;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public abstract class KmMetaTimestampProperty<T>
    extends KmMetaProperty<T,KmTimestamp>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScTimestampField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScTimestampField newField(String label)
    {
        ScTimestampField e;
        e = new ScTimestampField();
        e.setLabel(label);
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmTimestampValidator getValidator()
    {
        return null;
    }

}
