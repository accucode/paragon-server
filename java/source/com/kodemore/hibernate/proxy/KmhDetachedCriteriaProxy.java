/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.hibernate.proxy;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;

/**
 * See superclass.
 */
public class KmhDetachedCriteriaProxy
    extends KmhProxy
{
    //##################################################
    //# variables
    //##################################################

    private DetachedCriteria _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmhDetachedCriteriaProxy(DetachedCriteria e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public DetachedCriteria getInner()
    {
        return _inner;
    }

    @Override
    public boolean isDetached()
    {
        return true;
    }

    @Override
    public KmhDetachedCriteriaProxy asDetached()
    {
        return this;
    }

    //##################################################
    //# proxy
    //##################################################

    @Override
    public void add(Criterion e)
    {
        _inner.add(e);
    }

    @Override
    public void addOrder(Order e)
    {
        _inner.addOrder(e);
    }

    @Override
    public String getAlias()
    {
        return _inner.getAlias();
    }

    @Override
    public KmhProxy createCriteria(String entityName, String alias, JoinType type)
    {
        DetachedCriteria e = _inner.createCriteria(entityName, alias, type);
        return new KmhDetachedCriteriaProxy(e);
    }

    @Override
    public void setProjection(Projection e)
    {
        _inner.setProjection(e);
    }

}
