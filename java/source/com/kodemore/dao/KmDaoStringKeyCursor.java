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

package com.kodemore.dao;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.meta.KmMetaDaoPropertyIF;

/**
 * A simple cursor used to iterate through the database.
 * The attribute must represent a unique, non-null key.
 *
 * NOTE! : The session will be flushed and cleared at the beginning
 * of each batch.
 *
 * Elements returned are guaranteed to be non-null.
 */
public class KmDaoStringKeyCursor<T>
    extends KmDaoCursor<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static <E> KmDaoStringKeyCursor<E> createOn(KmMetaDaoPropertyIF<E,String> attr)
    {
        KmDaoStringKeyCursor<E> e;
        e = new KmDaoStringKeyCursor<>();
        e.setProperty(attr);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * This property is used to sort, iterate through
     * the database.
     */
    private KmMetaDaoPropertyIF<T,String> _property;

    /**
     * The number of elements to retrieve in each batch;
     */
    private int _batchSize;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoStringKeyCursor()
    {
        _batchSize = 100;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMetaDaoPropertyIF<T,String> getProperty()
    {
        return _property;
    }

    public void setProperty(KmMetaDaoPropertyIF<T,String> e)
    {
        _property = e;
    }

    public int getBatchSize()
    {
        return _batchSize;
    }

    public void setBatchSize(int e)
    {
        _batchSize = e;
    }

    //##################################################
    //# batch
    //##################################################

    @Override
    protected KmList<T> getNextBatch()
    {
        KmMetaDaoPropertyIF<T,String> attr;
        attr = getProperty();

        KmhModelCriteria<T> c;
        c = attr.getDao().createCriteria();
        c.whereString(attr);

        if ( hasLast() )
        {
            String lastKey = attr.getValueFor(getLast());
            c.whereString(attr).isGreaterThan(lastKey);
        }

        c.sortOn(attr);
        c.setMaxResults(getBatchSize());

        return c.findAll();
    }
}
