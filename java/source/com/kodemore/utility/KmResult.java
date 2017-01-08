/*
  Copyright (c) 2005-2016 www.kodemore.com

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
 * Used to generically return a value, along with a possible error.
 * In some cases this can be much cleaner than throwing exceptions.
 *
 * IMMUTABLE. Instances can only be created via static instance creation
 * methods and cannot be modified once created.
 */
public class KmResult<T>
{
    //##################################################
    //# constants
    //##################################################

    public static final KmResult<Boolean> TRUE  = KmResult.createValue(true);
    public static final KmResult<Boolean> FALSE = KmResult.createValue(false);

    //##################################################
    //# instance creation
    //##################################################

    public static <T> KmResult<T> createValue(T value)
    {
        KmResult<T> e;
        e = new KmResult<>();
        e._value = value;
        return e;
    }

    public static <T> KmResult<T> createError(String error)
    {
        KmResult<T> e;
        e = new KmResult<>();
        e._error = error;
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private T      _value;
    private String _error;

    //##################################################
    //# constructor
    //##################################################

    private KmResult()
    {
        // private
    }

    //##################################################
    //# status
    //##################################################

    public boolean isOk()
    {
        return !hasError();
    }

    //##################################################
    //# value
    //##################################################

    public T getValue()
    {
        return _value;
    }

    public boolean hasValue()
    {
        return getValue() != null;
    }

    //##################################################
    //# error
    //##################################################

    public String getError()
    {
        return _error;
    }

    public boolean hasError()
    {
        return getError() != null;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return isOk()
            ? Kmu.format("value(%s)", getValue())
            : Kmu.format("error(%s)", getError());
    }
}
