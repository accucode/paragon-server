package com.kodemore.hibernate;

import com.kodemore.hibernate.basic.KmhJunction;
import com.kodemore.hibernate.basic.KmhRootCriteria;

public class KmhModelJunction
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The target to which properties should be added.
     */
    private KmhJunction _context;

    //##################################################
    //# constructor
    //##################################################

    public KmhModelJunction(KmhJunction context)
    {
        _context = context;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmhJunction context()
    {
        return _context;
    }

    /**
     * I am used to create compound junctions on values from different models.
     * For example, suppose that you want all of the Items that are EITHER in
     * an active Catalog, or in an inacative Catalog but marked Important.
     *
     * itemCriteria = access.getItemDao().createCriteria();
     * catalogCriteria = itemCriteria.joinCatalog();
     * or = catalogCriteria.addOr();
     * or.whereActive().isFalse();
     * and = or.addAnd();
     * and.whereActive().isFalse();
     * and.where(itemCriteria.whereImportant()).isTrue();
     *
     * In most cases, this is not needed since each junction provides
     * convenience methods to operation on its own attributes.  However, when
     * creating compound and/or conditions that combine attributes from different
     * models, the containing junction can only provide convenience methods for
     * it primary context.
     */
    public <E extends KmhPropertyCondition<?>> E whereCriteria(E e)
    {
        e._setContext(context());
        return e;
    }

    //##################################################
    //# support
    //##################################################

    protected String fullName(String property)
    {
        return context().getFullName(property);
    }

    protected KmhRootCriteria root()
    {
        return context().getRoot();
    }

}
