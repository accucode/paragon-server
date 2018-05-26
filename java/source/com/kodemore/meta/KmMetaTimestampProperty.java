package com.kodemore.meta;

import com.kodemore.servlet.field.ScZonedTimestampField;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public abstract class KmMetaTimestampProperty<T>
    extends KmMetaProperty<T,KmTimestamp>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScZonedTimestampField newField()
    {
        ScZonedTimestampField e;
        e = new ScZonedTimestampField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScZonedTimestampField newField(String label)
    {
        ScZonedTimestampField e;
        e = newField();
        e.setLabel(label);
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
