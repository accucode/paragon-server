/*
  Copyright (c) 2005-2011 www.kodemore.com

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
import java.util.NoSuchElementException;

public class KmSingletonIterator<T>
    implements Iterator<T>
{
    //##################################################
    //# variables
    //##################################################

    private T       _value;
    private boolean _atEnd;

    //##################################################
    //# constructor
    //##################################################

    public KmSingletonIterator(T e)
    {
        _value = e;
    }

    //##################################################
    //# iterator
    //##################################################

    @Override
    public boolean hasNext()
    {
        return !_atEnd;
    }

    @Override
    public T next()
    {
        if ( _atEnd )
            throw new NoSuchElementException();

        _atEnd = true;
        return _value;
    }

    @Override
    public void remove()
    {
        throw new IllegalStateException();
    }

}
