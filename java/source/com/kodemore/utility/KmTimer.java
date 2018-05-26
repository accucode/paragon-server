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
 * I implement a simple stopwatch.  Each timer has a name which is printed
 * as part of the toString.  Timers may be started, stopped, and reset.
 * The accumulated number of milliseconds and seconds can be determined easily.
 * The default toString displays the total accumulated time in seconds.
 * Note: it is not necessary to stop a timer in order to print it.
 * Note: as of 1.5 the implementation has been converted to use the new System.nanoTime.
 */
public class KmTimer
{
    //##################################################
    //# static
    //##################################################

    /**
     * This convenience method creates and starts a new timer with the
     * specified name.
     */
    public static KmTimer run(String s, Object... args)
    {
        KmTimer t;
        t = new KmTimer();
        t.setName(Kmu.format(s, args));
        t.start();
        return t;
    }

    /**
     * This convenience method creates and starts a new timer with no name.
     */
    public static KmTimer run()
    {
        return run("");
    }

    //##################################################
    //# variables
    //##################################################

    private String _name;
    private long   _start;
    private long   _accumulationNanos;
    private long   _lapNanos;
    private int    _startCount;

    //##################################################
    //# constructors
    //##################################################

    /**
     * Create a new timer with no name.  The time is initially stopped
     * and must be explicitly started.
     */
    public KmTimer()
    {
        _initialize();
    }

    /**
     * Create a new timer with a name.  The time is initially stopped
     * and must be explicitly started.
     */
    public KmTimer(String s)
    {
        _initialize();
        _name = s;
    }

    //##################################################
    //# actions
    //##################################################

    /**
     * If the timer is stopped, then start it.  If the time is already
     * running then do nothing.  This will not reset any previously
     * accumulated time.
     */
    public void start()
    {
        if ( _start == -1 )
        {
            _start = _now();
            _lapNanos = 0;
            _startCount++;
        }
    }

    /**
     * If the timer is running then stop it, otherwise, do nothing.  It
     * is not necessary to call stop in order to print the timer or access
     * the accumulated time.
     */
    public void stop()
    {
        if ( _start == -1 )
            return;
        _lapNanos = _now() - _start;
        _accumulationNanos += _lapNanos;
        _start = -1;
    }

    /**
     * Set the accumulated time to 0.  If the timer was already running then
     * leave it running so that time immediately begins to accumulate.  If the
     * time was not running, then leave it in a stopped state.
     */
    public void reset()
    {
        _accumulationNanos = 0;
        _lapNanos = 0;
        _startCount = 0;
        if ( _start != -1 )
        {
            _start = _now();
            _startCount = 1;
        }
    }

    /**
     * Mark the end of a lap.
     * The lap time is recorded, the total time and averages are updated.
     */
    public void lap()
    {
        stop();
        start();
    }

    /**
     * Set the accumulated time to 0 and immediately start the timer.
     */
    public void restart()
    {
        reset();
        start();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String s)
    {
        _name = s;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(_name);
    }

    /**
     * Determine if the timer is currently running.
     */
    public boolean isRunning()
    {
        return _start > -1;
    }

    /**
     * Return the accumulated time in nano-seconds (10^-9).
     */
    public long getNanoseconds()
    {
        long i = _accumulationNanos;
        if ( isRunning() )
            i += _now() - _start;
        return i;
    }

    /**
     * Return the accumulated time in picoseconds (10^-6).
     */
    public double getPicoseconds()
    {
        return getNanoseconds() / 1000.0;
    }

    /**
     * Return the accumulated time in milliseconds.
     */
    public double getMilliseconds()
    {
        return getNanoseconds() / 1000000.0;
    }

    /**
     * Return the accumulated time in seconds.
     */
    public double getSeconds()
    {
        return getNanoseconds() / 1000000000.0;
    }

    //##################################################
    //# average
    //##################################################

    public double getAverageNanoseconds()
    {
        if ( _startCount == 0 )
            return 0;

        return getNanoseconds() / (double)_startCount;
    }

    public double getAverageMilliseconds()
    {
        return getAverageNanoseconds() / 1000000.0;
    }

    public double getAverageSeconds()
    {
        return getAverageNanoseconds() / 1000000000.0;
    }

    //##################################################
    //# lap
    //##################################################

    public double getLapNanoseconds()
    {
        return _lapNanos;
    }

    public double getLapMilliseconds()
    {
        return getLapNanoseconds() / 1000000.0;
    }

    public double getLapSeconds()
    {
        return getLapNanoseconds() / 1000000000.0;
    }

    //##################################################
    //# printing
    //##################################################

    /**
     * As this is a utility class the toString is used for convenience
     * to print a user friendly string.  The timer's name and accumulated
     * time are dipslayed.  The time is displayed in seconds.
     */
    @Override
    public String toString()
    {
        return format();
    }

    public void print()
    {
        print(3);
    }

    public void print(int scale)
    {
        System.out.println(format(scale));
    }

    public String format()
    {
        return format(3);
    }

    public String format(int scale)
    {
        double d = getSeconds();
        String s = Kmu.formatDouble(d, scale) + " secs";

        return hasName()
            ? getName() + ": " + s
            : s;
    }

    public void printAverage()
    {
        printAverage(3);
    }

    public void printAverage(int scale)
    {
        System.out.println(formatAverage(scale));
    }

    public String formatAverage(int scale)
    {
        double d = getAverageSeconds();
        String s = Kmu.formatDouble(d, scale) + " secs (average)";

        return hasName()
            ? getName() + ": " + s
            : s;
    }

    public String formatLap(int scale)
    {
        double d = getLapSeconds();
        String s = Kmu.formatDouble(d, scale) + "sec (lap)";

        return hasName()
            ? getName() + ": " + s
            : s;
    }

    //==================================================
    //= average ms
    //==================================================

    public void printAverageMs()
    {
        System.out.println(formatAverageMs(0));
    }

    public String formatAverageMs(int scale)
    {
        double d = getAverageMilliseconds();
        String s = Kmu.formatDouble(d, scale) + " ms (average)";

        return hasName()
            ? getName() + ": " + s
            : s;
    }

    //##################################################
    //# private
    //##################################################

    public void _initialize()
    {
        _name = "";
        _start = -1;
        _accumulationNanos = 0;
        _lapNanos = 0;
        _startCount = 0;
    }

    public long _now()
    {
        return System.nanoTime();
    }
}
