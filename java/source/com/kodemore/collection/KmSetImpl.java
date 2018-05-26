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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * A set is an unordered collection that may contain some value
 * only once.
 *
 * EG: A set is like a map where the key and value are the same.
 */
public class KmSetImpl<T>
    extends HashSet<T>
    implements KmSet<T>
{
    //##################################################
    //# constructor
    //##################################################

    public KmSetImpl()
    {
        super();
    }

    public KmSetImpl(int n)
    {
        super(n);
    }

    //##################################################
    //# misc
    //##################################################

    @Override
    public KmList<T> toList()
    {
        return new KmList<>(iterator());
    }

    @Override
    public boolean addNonNull(T e)
    {
        if ( e != null )
            return add(e);

        return false;
    }

    @Override
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    @Override
    public boolean containsAny(Collection<T> v)
    {
        for ( T e : v )
            if ( contains(e) )
                return true;

        return false;
    }

    @Override
    public boolean containsNone(Collection<T> v)
    {
        return !containsAny(v);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String format()
    {
        StringBuilder out = new StringBuilder();

        Iterator<T> i = iterator();
        while ( i.hasNext() )
        {
            T e = i.next();
            out.append(e);

            if ( i.hasNext() )
                out.append(", ");
        }

        return out.toString();
    }
}
