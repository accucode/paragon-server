package com.kodemore.meta;

import com.kodemore.servlet.field.ScMoneyField;
import com.kodemore.types.KmMoney;
import com.kodemore.validator.KmMoneyValidator;

public abstract class KmMetaMoneyProperty<T>
    extends KmMetaProperty<T,KmMoney>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScMoneyField newField()
    {
        return newField(getLabel());
    }

    @Override
    public ScMoneyField newField(String label)
    {
        ScMoneyField e;
        e = new ScMoneyField();
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
    public KmMoneyValidator getValidator()
    {
        return null;
    }

}
