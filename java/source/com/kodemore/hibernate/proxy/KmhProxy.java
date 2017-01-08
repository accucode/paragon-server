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

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;

/**
 * I implement a very simple wrapper for Criteria and DetachedCriteria.
 * By using this proxy, you can pass either a Criteria or a DetachedCriteria into
 * other tools and operate on it in a generic manner.
 *
 * According to the Hibernate 4.3 javadocs, "All method [in DetachedCriteria]
 * have the same semantics and behavior as the corresponding methods of the Criteria
 * interface.
 *
 * Unfortunately, DetachedCriteria doesn't actually implement the Criteria interface,
 * so there is no easy way to implement behavior that can apply to either a Criteria
 * or a DetachedCriteria.
 */
public abstract class KmhProxy
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmhProxy create(Criteria e)
    {
        return new KmhCriteriaProxy(e);
    }

    public static KmhProxy create(DetachedCriteria e)
    {
        return new KmhDetachedCriteriaProxy(e);
    }

    //##################################################
    //# typing
    //##################################################

    public boolean isAttached()
    {
        return false;
    }

    public boolean isDetached()
    {
        return false;
    }

    public KmhCriteriaProxy asAttached()
    {
        throw new RuntimeException("Cannot cast to attached proxy.");
    }

    public KmhDetachedCriteriaProxy asDetached()
    {
        throw new RuntimeException("Cannot cast to detached proxy.");
    }

    //##################################################
    //# proxy
    //##################################################

    public abstract void add(Criterion e);

    public abstract void addOrder(Order e);

    public abstract String getAlias();

    public abstract KmhProxy createCriteria(String entityName, String alias, JoinType type);

    public abstract void setProjection(Projection e);

}
