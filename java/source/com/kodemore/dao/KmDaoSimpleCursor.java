/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.dao;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.criteria.KmCriteria;

/**
 * A simple cursor that can be used with almost any criteria.
 * The only restriction is that criteria must NOT specify the
 * first or max results, since these are used to iterate
 * through the results.
 *
 * This cursor is not particularly efficient since the process
 * of using the first/max results generally forces the underlying
 * database query to execute a table scan.
 */
public class KmDaoSimpleCursor<T>
    extends KmDaoCursor<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The criteria to be iterated over.
     */
    private KmCriteria _criteria;

    /**
     * The next index to retrieve from.
     */
    private int        _index;

    //##################################################
    //# accessing
    //##################################################

    public void setCriteria(KmCriteria e)
    {
        _criteria = e;
        _criteria.setMaxResults(100);
        _index = 0;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected KmList<T> getNextBatch()
    {
        _criteria.setFirstResult(_index);
        KmList<?> v = _criteria.findAll();
        _index += v.size();
        return cast(v);
    }

}
