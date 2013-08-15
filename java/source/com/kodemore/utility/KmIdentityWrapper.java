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

package com.kodemore.utility;

/**
 * I am used to wrap other objects in order to perform
 * identity comparisons.  One area this can be useful
 * is the java collection classes that rely on the
 * equals() method rather than the identity operator (==).
 *
 */
public class KmIdentityWrapper<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static <V> KmIdentityWrapper<V> create(V e)
    {
        return new KmIdentityWrapper<V>(e);
    }

    //##################################################
    //# variables
    //##################################################

    private T _value;

    //##################################################
    //# constructor
    //##################################################

    public KmIdentityWrapper(T e)
    {
        _value = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public T getValue()
    {
        return _value;
    }

    public boolean hasValue(T e)
    {
        return _value == e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmIdentityWrapper) )
            return false;

        return ((KmIdentityWrapper)e).hasValue(_value);
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(_value);
    }
}
