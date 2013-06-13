package com.kodemore.property.type;

import com.kodemore.utility.Kmu;

public abstract class KmPropertyAbstractTypeIntegerRange
    extends KmPropertyAbstractType
{
    //##################################################
    //# abstract
    //##################################################

    public abstract Integer getMinimum();

    public abstract Integer getMaximum();

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return Kmu.format("integer %s..%s", getMinimum(), getMaximum());
    }

    @Override
    public Object validateValue(String key, String value)
    {
        Integer e = Kmu.parseInteger(value);
        if ( e == null )
            error("Property %s: Value (%s) is not an integer.", key, value);

        int n = e.intValue();

        Integer min = getMinimum();
        if ( min != null && e < min )
            error("Property %s: Value (%s) is less than %s.", key, n, min);

        Integer max = getMaximum();
        if ( max != null && e > max )
            error("Property %s: Value (%s) is greater than %s.", key, n, max);

        return e;
    }

    @Override
    public Object convertValue(String key, String value)
    {
        return validateValue(key, value);
    }

    //##################################################
    //# code generation
    //##################################################

    @Override
    public String formatGetValueFor()
    {
        return "getIntegerFor";
    }

    @Override
    public String formatJavaType()
    {
        return "Integer";
    }

}
