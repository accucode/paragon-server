package com.kodemore.hibernate.criteria;

/**
 * @param <T>  used as a placeholder and for clarity.
 */
public class KmModelJunction<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The target to which properties should be added.
     */
    private KmJunction         _context;

    /**
     * The context of the property.  Normally, the context
     * is the same as the parent.  When combining joined
     * models in junctions, the context may be different.
     * E.g.: context[or].add(parent.property).
     */
    private KmAbstractCriteria _parent;

    //##################################################
    //# constructor
    //##################################################

    public KmModelJunction(KmJunction context)
    {
        this(context, context);
    }

    public KmModelJunction(KmJunction context, KmAbstractCriteria parent)
    {
        _context = context;
        _parent = parent;
    }

    //##################################################
    //# support
    //##################################################

    public KmJunction context()
    {
        return _context;
    }

    public KmAbstractCriteria parent()
    {
        return _parent;
    }

    protected String fullName(String property)
    {
        return _parent.getFullName(property);
    }

    @SuppressWarnings(
    {
        "unchecked", "rawtypes"
    })
    public <E extends KmModelCriteria> E join(E c)
    {
        return (E)c.createOn(this);
    }

    protected KmAbstractCriteria root()
    {
        return parent().getRoot();
    }

}
