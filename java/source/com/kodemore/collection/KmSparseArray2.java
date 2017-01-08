/*
  Copyright (c) 2005-2015 www.kodemore.com

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

public class KmSparseArray2<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,T> _data;

    //##################################################
    //# constructors
    //##################################################

    public KmSparseArray2()
    {
        _data = new KmMap<>();
    }

    //##################################################
    //# value
    //##################################################

    public T getValueAt(int i, int j)
    {
        return getValueAt(i, j, null);
    }

    public T getValueAt(int i, int j, T def)
    {
        String key = key(i, j);

        return _data.containsKey(key)
            ? _data.get(key)
            : def;
    }

    public void setValueAt(int i, int j, T value)
    {
        _data.put(key(i, j), value);
    }

    public void removeValueAt(int i, int j)
    {
        _data.remove(key(i, j));
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasValueAt(int i, int j)
    {
        return _data.containsKey(key(i, j));
    }

    //##################################################
    //# supprort
    //##################################################

    private String key(int i, int j)
    {
        return i + "," + j;
    }
}
