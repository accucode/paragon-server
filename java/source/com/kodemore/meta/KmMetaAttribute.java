package com.kodemore.meta;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.match.KmAbstractMatch;
import com.kodemore.match.KmMatchIF;

public abstract class KmMetaAttribute<T, V>
{
    //##################################################
    //# abstract
    //##################################################

    public abstract String getName();

    //##################################################
    //# tools
    //##################################################

    public KmAdaptorIF<T,V> getAdaptor()
    {
        return new KmAdaptorIF<T,V>()
        {
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
        };
    }

    public KmMatchIF<T> getMatch(final V value)
    {
        return new KmAbstractMatch<T>()
        {
            @Override
            public boolean matches(T model)
            {
                return hasValueFor(model, value);
            }
        };
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

}
