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
        ScMoneyField e;
        e = new ScMoneyField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScMoneyField newField(String label)
    {
        ScMoneyField e;
        e = newField();
        e.setLabel(label);
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
