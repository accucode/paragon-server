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

package com.kodemore.utility;

/**
 * Used to test a simple boolean condition.
 * Return either ok, or an error message.
 *
 * IMMUTABLE. Instances can only be created via static instance creation
 * methods and cannot be modified once created.
 */
public class KmSimpleResult
{
    //##################################################
    //# constants
    //##################################################

    public static final KmSimpleResult OK = KmSimpleResult.createOk();

    //##################################################
    //# instance creation
    //##################################################

    private static KmSimpleResult createOk()
    {
        return new KmSimpleResult();
    }

    public static KmSimpleResult createError(String error)
    {
        KmSimpleResult e;
        e = new KmSimpleResult();
        e._error = error;
        return e;
    }

    public static KmSimpleResult createError(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        return createError(s);
    }

    //##################################################
    //# variables
    //##################################################

    private String _error;

    //##################################################
    //# constructor
    //##################################################

    private KmSimpleResult()
    {
        // private, ok
    }

    //##################################################
    //# status
    //##################################################

    public boolean isOk()
    {
        return !hasError();
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
        return _error != null;
    }

    public void checkError()
    {
        if ( hasError() )
            throw Kmu.newError(getError());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return isOk()
            ? Kmu.format("ok")
            : Kmu.format("error(%s)", getError());
    }

}
