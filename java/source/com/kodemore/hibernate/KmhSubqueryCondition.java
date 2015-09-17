package com.kodemore.hibernate;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Subqueries;

import com.kodemore.hibernate.basic.KmhElement;

public class KmhSubqueryCondition
{
    //##################################################
    //# variables
    //##################################################

    private KmhElement       _context;
    private DetachedCriteria _criteria;

    //##################################################
    //# constructor
    //##################################################

    public KmhSubqueryCondition(KmhElement context, DetachedCriteria criteria)
    {
        _context = context;
        _criteria = criteria;
    }

    //##################################################
    //# criteria
    //##################################################

    public void is(int e)
    {
        _context._add(Subqueries.eq(e, _criteria));
    }

    public void is(long e)
    {
        _context._add(Subqueries.eq(e, _criteria));
    }

    public void exists()
    {
        _context._add(Subqueries.exists(_criteria));
    }

}
