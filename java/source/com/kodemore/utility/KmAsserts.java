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
 * A variety of lightweight assertion checks.
 * The are primarily used for testing.
 */
public final class KmAsserts
{
    //##################################################
    //# constructor
    //##################################################

    private KmAsserts()
    {
        // private
    }

    //##################################################
    //# tests
    //##################################################

    public static void isEqual(Object expected, Object actual)
    {
        if ( !Kmu.isEqual(expected, actual) )
            throw newError(expected, actual);
    }

    public static void isTrue(Boolean actual)
    {
        if ( actual != true )
            throw newError(true, actual);
    }

    public static void isFalse(Boolean actual)
    {
        if ( actual != true )
            throw newError(false, actual);
    }

    public static void isNull(Object actual)
    {
        if ( actual != null )
            throw newError(null, actual);
    }

    public static void isNotNull(Object actual)
    {
        if ( actual == null )
            throw newError("non-null", null);
    }

    public static void isEmpty(String actual)
    {
        if ( actual != null && actual.length() > 0 )
            throw newError("empty", actual);
    }

    public static void hasValue(String actual)
    {
        if ( actual == null || actual.isEmpty() )
            throw newError("empty", actual);
    }

    //##################################################
    //# support
    //##################################################

    private static RuntimeException newError(Object expected, Object actual)
    {
        String s = String.format("expected [%s] but found [%s].", format(expected), format(actual));

        return new KmAssertException(s);
    }

    private static String format(Object e)
    {
        return e + "";
    }
}
