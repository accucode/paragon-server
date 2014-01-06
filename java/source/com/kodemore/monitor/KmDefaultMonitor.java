/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.monitor;

/*
 com.kodemore.monitor.KmDefaultMonitor.enable();
 com.kodemore.monitor.KmDefaultMonitor.reset();
 com.kodemore.monitor.KmDefaultMonitor.beVerbose();
 com.kodemore.monitor.KmDefaultMonitor.print();
 */
public class KmDefaultMonitor
{
    //##################################################
    //# variables
    //##################################################

    private static final KmMonitor _monitor;

    static
    {
        _monitor = new KmMonitor();
        _monitor.disable();
    }

    //##################################################
    //# enable
    //##################################################

    public static void enable()
    {
        _monitor.enable();
    }

    public static void toggle()
    {
        _monitor.toggle();
    }

    public static void enable(boolean b)
    {
        _monitor.enable(b);
    }

    public static void disable()
    {
        _monitor.disable();
    }

    public static boolean isEnabled()
    {
        return _monitor.isEnabled();
    }

    //##################################################
    //# details
    //##################################################

    public static void enableDetails()
    {
        _monitor.enableDetails();
    }

    public static void enableDetails(boolean b)
    {
        _monitor.enableDetails(b);
    }

    public static void disableDetails()
    {
        _monitor.disableDetails();
    }

    public static boolean areDetailsEnabled()
    {
        return _monitor.areDetailsEnabled();
    }

    //##################################################
    //# manage
    //##################################################

    public static void reset()
    {
        _monitor.reset();
    }

    public static void start()
    {
        _monitor.start();
    }

    public static void stop()
    {
        _monitor.stop();
    }

    public static void enter(String name)
    {
        _monitor.enter(name);
    }

    public static void enter(String name, String details, Object... detailArgs)
    {
        _monitor.enter(name, details, detailArgs);
    }

    public static void exit()
    {
        _monitor.exit();
    }

    public static void log(String name)
    {
        _monitor.log(name);
    }

    public static void log(String name, String details, Object... detailArgs)
    {
        _monitor.log(name, details, detailArgs);
    }

    //##################################################
    //# print
    //##################################################

    public static void print()
    {
        _monitor.print();
    }

    public static void print(double minSeconds)
    {
        _monitor.print(minSeconds);
    }

    //##################################################
    //# nanos
    //##################################################

    public static double getTotalSeconds()
    {
        return _monitor.getTotalSeconds();
    }

    public static double getSeconds(String name)
    {
        return _monitor.getSeconds(name);
    }
}
