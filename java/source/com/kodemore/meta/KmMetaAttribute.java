package com.kodemore.meta;

import java.util.function.Function;

import com.kodemore.adaptor.KmAdaptorIF;

public abstract class KmMetaAttribute<T, V>
    implements KmAdaptorIF<T,V>
{
    //##################################################
    //# abstract
    //##################################################

    public abstract String getName();

    public abstract String getLabel();

    public abstract String getHelp();

    //##################################################
    //# tools
    //##################################################

    /**
     * This is useful to get around generic typing issues when you really
     * need an untyped Object, but cannot use ? for various reasons.
     */
    public Function<T,Object> toObjectFunction()
    {
        return this::getValueFor;
    }

    //##################################################
    //# value
    //##################################################

    public abstract V getValueFor(T model);

    public abstract boolean hasValueFor(T model, V value);

    /**
     * @param model unused, but defined for subclassing.
     * @param value unused, but defined for subclassing.
     */
    public void setValueFor(T model, V value)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# adaptor
    //##################################################

    @Override
    public V getValue(T model)
    {
        return getValueFor(model);
    }

    @Override
    public void setValue(T model, V value)
    {
        setValueFor(model, value);
    }

}
