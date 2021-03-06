/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.collection;

import java.util.Iterator;

import org.apache.commons.collections4.iterators.PushbackIterator;

import com.google.common.base.Predicate;

/**
 * I allow peeks and pushbacks on an iterator.
 *
 * I extend the Apache common class with some additional convenience methods.
 */
public class KmPushbackIterator<T>
    extends PushbackIterator<T>
{
    //##################################################
    //# constructor
    //##################################################

    public KmPushbackIterator(Iterator<? extends T> i)
    {
        super(i);
    }

    //##################################################
    //# peek
    //##################################################

    /**
     * Return the next element WITHOUT removing it from the iterator.
     * Return null if already at the end.
     */
    public T peek()
    {
        if ( !hasNext() )
            return null;

        T e = next();
        pushback(e);
        return e;
    }

    /**
     * Return a list of the next elements that match the test.
     * Stop when either the iterator reaches the end, or a non-matching element.
     */
    public KmList<T> nextWhile(Predicate<T> test)
    {
        KmList<T> v = new KmList<>();

        while ( true )
        {
            if ( !hasNext() )
                break;

            if ( !test.apply(peek()) )
                break;

            v.add(next());
        }
        return v;
    }
}
