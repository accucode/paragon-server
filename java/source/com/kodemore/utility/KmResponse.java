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

package com.kodemore.utility;

/**
 * Used to generically return a value, along with a possible error.
 * In some cases this can be much cleaner than throwing exceptions.
 */
public class KmResponse<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmResponse<String> createString(String value)
    {
        KmResponse<String> e;
        e = new KmResponse<String>();
        e.setValue(value);
        return e;
    }

    public static KmResponse<String> createStringError(String error)
    {
        KmResponse<String> e;
        e = new KmResponse<String>();
        e.setError(error);
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

    public KmResponse()
    {
        // none
    }

    public KmResponse(T e)
    {
        setValue(e);
    }

    //##################################################
    //# value
    //##################################################

    public T getValue()
    {
        return _value;
    }

    public void setValue(T e)
    {
        _value = e;
    }

    public boolean hasValue()
    {
        return _value != null;
    }

    //##################################################
    //# error
    //##################################################

    public String getError()
    {
        return _error;
    }

    public void setError(String e)
    {
        _error = e;
    }

    public boolean hasError()
    {
        return _error != null;
    }

    public boolean isOk()
    {
        return _error == null;
    }

}
