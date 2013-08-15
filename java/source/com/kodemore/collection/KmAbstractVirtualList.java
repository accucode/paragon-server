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

package com.kodemore.collection;

import java.util.Iterator;

import com.kodemore.match.KmMatchIF;

public abstract class KmAbstractVirtualList<T>
    implements KmVirtualList<T>
{
    //##################################################
    //# abstract
    //##################################################

    @Override
    public abstract int getSize();

    @Override
    public abstract T get(int index);

    //##################################################
    //# convenience
    //##################################################

    @Override
    public T getSafe(int index)
    {
        if ( index < 0 )
            return null;

        if ( index >= getSize() )
            return null;

        return get(index);
    }

    @Override
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            int i = 0;

            @Override
            public boolean hasNext()
            {
                return i < getSize();
            }

            @Override
            public T next()
            {
                if ( !hasNext() )
                    throw new IndexOutOfBoundsException();

                return get(i++);
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Iterator<T> reverseIterator()
    {
        return new Iterator<T>()
        {
            int i = getSize() - 1;

            @Override
            public boolean hasNext()
            {
                return i >= 0;
            }

            @Override
            public T next()
            {
                if ( !hasNext() )
                    throw new IndexOutOfBoundsException();

                return get(i--);
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public KmVirtualList<T> filter(KmMatchIF<T> m)
    {
        return new KmFilteredVirtualList<T>(this, m);
    }
}
