package com.kodemore.meta;

import com.kodemore.servlet.field.ScCostField;
import com.kodemore.types.KmCost;
import com.kodemore.validator.KmCostValidator;

public abstract class KmMetaCostProperty<T>
    extends KmMetaProperty<T,KmCost>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScCostField newField()
    {
        ScCostField e;
        e = new ScCostField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScCostField newField(String label)
    {
        ScCostField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmCostValidator getValidator()
    {
        return null;
    }
}
