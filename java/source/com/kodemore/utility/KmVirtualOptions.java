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
 * Standard formatting and common constants for virtual options.
 *
 * For example, the user may be presented with the choice of selecting
 * one of several values: Red, Blue, Green. But the user is also allowed to
 * select [all] or [none]. These additional values are referred to as virtual
 * options.
 *
 * Avoid formats or values that would require escaping in html, xml, or sql.
 */
public class KmVirtualOptions
{
    //##################################################
    //# constants
    //##################################################

    public static final String NONE    = KmVirtualOptions.format("none");
    public static final String UNKNOWN = KmVirtualOptions.format("unknown");
    public static final String ANY     = KmVirtualOptions.format("any");
    public static final String NULL    = KmVirtualOptions.format("null");
    public static final String EMPTY   = KmVirtualOptions.format("empty");

    //##################################################
    //# format
    //##################################################

    /**
     * Format a string for use as a virtual option.
     * Common options should be defined as a constant for consistency.
     */
    public static String format(String e)
    {
        return "[" + e + "]";
    }
}
