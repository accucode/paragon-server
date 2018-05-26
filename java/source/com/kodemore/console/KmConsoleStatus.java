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

package com.kodemore.console;

import com.kodemore.utility.Kmu;

/**
 * I provide a convenient way to update a status line in a dos
 * window.  The only 'trick' is the assumption that the backspace
 * character (ASCII 8) can be used to move the cursor position to
 * to the left.
 */
public class KmConsoleStatus
{
    //##################################################
    //# constants
    //##################################################

    public static final char BACKSPACE = 8;

    //##################################################
    //# static
    //##################################################

    /**
     * Print the string, right padded to the specified length.  This also
     * erases the previous string (if any) that was printed using this
     * method.  It is important to use the name length each time in order
     * to clear the previous value printed.
     */
    public static void print(Object e, int n)
    {
        String s = "";

        if ( e != null )
            s = e.toString();

        s = Kmu.truncate(s, n);
        s = Kmu.rightPad(s, n);

        System.out.print(s);
        System.out.print(Kmu.repeat(BACKSPACE, n));
    }

    //##################################################
    //# variables
    //##################################################

    private int _valueLength;

    //##################################################
    //# actions
    //##################################################

    /**
     * Start a new line.  Subsequent calls to print will update the
     * text on the line, clearing the previous value each time.
     */
    public void start()
    {
        start("");
    }

    /**
     * Start a new line; specifying a static prefix can significantly
     * help increase print speed and reduce flicker.
     */
    public void start(String prefix)
    {
        _valueLength = 0;
        System.out.print(prefix);
    }

    /**
     * Print a line; the previous value (if any) is automatically cleared.
     */
    public void print(Object e)
    {
        String s = "";

        if ( e != null )
            s = e.toString();

        System.out.print(Kmu.repeat(BACKSPACE, _valueLength));
        System.out.print(s);

        _valueLength = s.length();
    }

    public void stop()
    {
        System.out.println();
    }
}
