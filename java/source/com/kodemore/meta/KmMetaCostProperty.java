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
        return newField(getLabel());
    }

    @Override
    public ScCostField newField(String label)
    {
        ScCostField e;
        e = new ScCostField();
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
    public KmCostValidator getValidator()
    {
        return null;
    }
}
