/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.hibernate.basic;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;

/**
 * Junctions are used to model AND and ORs in the database query.
 *
 * At the top of the hibernate criteria, all conditions are implicitly
 * ANDed together.  Additional junctions can be added to the criteria
 * to compose arbitrarily complex combination of ANDs and ORs.
 *
 * The type (AND/OR) determines how the junction's children are
 * combined, NOT how the junction is combined with it's parent or siblings.
 */
public class KmhJunction
    extends KmhElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The context may be a criteria, or another junction.
     * This allows us to create composite junctions like
     * ... where a and (b or c or (d and e)).
     */
    private KmhElement _context;

    /**
     * The hibernate junction to which criterions must be added.
     */
    private Junction _junction;

    //##################################################
    //# constructor
    //##################################################

    public KmhJunction(KmhElement context, Junction e)
    {
        _context = context;
        _junction = e;
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    public KmhRootCriteria getRoot()
    {
        return _context.getRoot();
    }

    @Override
    public KmhCriteria getCriteria()
    {
        return _context.getCriteria();
    }

    @Override
    public void _add(Criterion e)
    {
        _junction.add(e);
    }

}
