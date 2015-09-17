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

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.kodemore.collection.KmList;

/**
 * Used to iterate through the database in a batch fashion.
 *
 * NOTE! : The session will be flushed and cleared at the beginning
 * of each batch.
 *
 * Elements returned are guaranteed to be non-null.
 */
public abstract class KmDaoCursor<T>
    implements Iterator<T>, Iterable<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The most recent batch that was fetched.
     * Subclasses are responsible for implementing the
     * logic that fetches each batch upon request.
     */
    private KmList<T> _batch;

    /**
     * A cache of the current batch's size.  Also used
     * to specify 0 when the first batch has not been
     * loaded yet.
     */
    private int _currentBatchSize;

    /**
     * The current index within the current batch.
     * This value associated with this index may, or may not,
     * have already been returned depending on the state of
     * _ready.
     */
    private int _index;

    /**
     * The index is ready to return, or not.
     */
    private boolean _ready;

    /**
     * Used to indicate that the end of the cursor has been reached.
     * This is typically set to true when findNextBatch returns
     * an empty list.
     */
    private boolean _done;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoCursor()
    {
        _index = 0;
        _ready = false;
        _done = false;
        _batch = null;
        _currentBatchSize = 0;
    }

    //##################################################
    //# iterator
    //##################################################

    @Override
    public Iterator<T> iterator()
    {
        return this;
    }

    @Override
    public boolean hasNext()
    {
        if ( _ready )
            return true;

        if ( _done )
            return false;

        while ( true )
        {
            _index++;

            if ( _index >= _currentBatchSize )
            {
                flush();

                _batch = getNextBatch();
                _currentBatchSize = _batch.size();

                if ( _batch.isEmpty() )
                {
                    _done = true;
                    return false;
                }

                _index = 0;
            }

            T e = _batch.get(_index);
            if ( passes(e) )
            {
                _ready = true;
                return true;
            }
        }
    }

    @Override
    public T next()
    {
        if ( !hasNext() )
            throw new NoSuchElementException();

        _ready = false;
        return _batch.get(_index);
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# abstract
    //##################################################

    /**
     * Get the next batch of elements to iterate through.
     * The session is flushed and cleared each time a batch is fetched.
     * Returning an empty list implies that that the cursor is done.
     */
    protected abstract KmList<T> getNextBatch();

    /**
     * @param e unused, but defined for subclass overrides.
     */
    protected boolean passes(T e)
    {
        return true;
    }

    //##################################################
    //# convenience
    //##################################################

    protected KmList<T> getBatch()
    {
        return _batch;
    }

    protected boolean hasLast()
    {
        return _batch != null;
    }

    protected T getLast()
    {
        return _batch.getLast();
    }

    @SuppressWarnings("unchecked")
    protected KmList<T> cast(KmList<?> v)
    {
        return (KmList<T>)v;
    }

    protected KmDaoSession getDaoSession()
    {
        return KmDaoSessionManager.getInstance().getDaoSession();
    }

    private void flush()
    {
        KmDaoSession e;
        e = getDaoSession();
        e.flush();
        e.clear();
    }

}
