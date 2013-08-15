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

package com.kodemore.console;

import com.kodemore.utility.Kmu;

/**
 * I provide a convenient way to update a dos status line with a
 * progress meter.  The meter displays a static label, and the percent
 * complete.  Usage is to create the instance, call meter until done,
 * then call stop.
 */
public class KmConsoleMeter
{
    //##################################################
    //# constants
    //##################################################

    public static final char BACKSPACE = 8;

    //##################################################
    //# variables
    //##################################################

    private int              _count;
    private int              _total;
    private int              _lastPercent;
    private long             _beginNanos;
    private long             _endNanos;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create an instance with the specified static prefix and number
     * of expected iterations.  The prefix is used as a static label
     * to the left of the percentage.  The total is used to determine
     * the relative progress.
     */
    public KmConsoleMeter(String prefix, int total)
    {
        checkMaximumTotal(total);
        _count = 0;
        _total = total;
        _lastPercent = 0;
        _beginNanos = System.nanoTime();
        print(prefix + ":   0%");
    }

    //##################################################
    //# actions
    //##################################################

    /**
     * Update the progress meter's count by one.  This will only update
     * the progress bar if the percentage changed needs to be updated.
     */
    public void meter()
    {
        setMeter(_count + 1);
    }

    /**
     * Update the progress meter's count by the amount specified.  This will
     * only update the progress bar if the percentage changed needs to be updated.
     */
    public void setMeter(int count)
    {
        _count = count;

        int percent = _count * 100 / _total;
        if ( percent == _lastPercent )
            return;

        _lastPercent = percent;
        backspace(4);
        StringBuilder sb = new StringBuilder();

        if ( percent < 10 )
            sb.append(" ");

        if ( percent < 100 )
            sb.append(" ");

        sb.append(percent);
        sb.append("%");
        print(sb);
    }

    /**
     * Provide some clean up; print the total elapsed time and move the
     * cursor to a new line.
     */
    public void stop()
    {
        _endNanos = System.nanoTime();
        backspace(4);
        print("100%");
        double elapsed = _endNanos - _beginNanos;
        double seconds = elapsed / 1000000000;
        println("  (" + Kmu.formatDouble(seconds, 3) + ")");
    }

    //##################################################
    //# private
    //##################################################

    private void backspace(int n)
    {
        print(Kmu.repeat(BACKSPACE, n));
    }

    private void checkMaximumTotal(int n)
    {
        int max = Integer.MAX_VALUE / 100;
        if ( n >= max )
            throw new RuntimeException("Cannot use total bigger than: " + max);
    }

    private void print(Object e)
    {
        System.out.print(e);
    }

    private void println(Object e)
    {
        System.out.println(e);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        int n = 21474835;
        KmConsoleMeter m;
        m = new KmConsoleMeter("test", n);
        for ( int i = 0; i < n; i++ )
            m.meter();
        m.stop();
    }

}
