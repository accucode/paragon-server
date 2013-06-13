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

import java.util.Collection;

/**
 * I provide basic Stack functionality; e.g.: push & pop.
 */
public class KmStack<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmList<T> _list;

    //##################################################
    //# constructor
    //##################################################

    public KmStack()
    {
        _list = new KmList<T>();
    }

    //##################################################
    //# accessing
    //##################################################

    public void push(T e)
    {
        _list.add(e);
    }

    public void pushAll(Collection<T> v)
    {
        _list.addAll(v);
    }

    public T pop()
    {
        return _list.removeLast();
    }

    public T peek()
    {
        return _list.getLast();
    }

    public void clear()
    {
        _list.clear();
    }

    public int size()
    {
        return _list.size();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isEmpty()
    {
        return _list.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return _list.isNotEmpty();
    }

}
