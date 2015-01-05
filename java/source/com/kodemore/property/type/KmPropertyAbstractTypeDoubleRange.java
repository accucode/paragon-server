package com.kodemore.property.type;

import com.kodemore.utility.Kmu;

public abstract class KmPropertyAbstractTypeDoubleRange
    extends KmPropertyAbstractType
{
    //##################################################
    //# abstract
    //##################################################

    public abstract Double getMinimum();

    public abstract Double getMaximum();

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return Kmu.format("double %s..%s", getMinimum(), getMaximum());
    }

    @Override
    public Object validateValue(String key, String value)
    {
        Double e = Kmu.parseDouble(value);
        if ( e == null )
            throw Kmu.newFatal("Property %s: Value (%s) is not a double.", key, value);

        double d = e.doubleValue();

        Double min = getMinimum();
        if ( min != null && e < min )
            throw Kmu.newFatal("Property %s: Value (%s) is less than %s.", key, d, min);

        Double max = getMaximum();
        if ( max != null && e > max )
            throw Kmu.newFatal("Property %s: Value (%s) is greater than %s.", key, d, max);

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
        return "getDoubleFor";
    }

    @Override
    public String formatJavaType()
    {
        return "Double";
    }

}
