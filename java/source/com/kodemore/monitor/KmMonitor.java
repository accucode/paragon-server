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

package com.kodemore.monitor;

import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/*
 com.kodemore.monitor.KmMonitor.enable();
 com.kodemore.monitor.KmMonitor.reset();
 com.kodemore.monitor.KmMonitor.beVerbose();
 com.kodemore.monitor.KmMonitor.print();
 */
public class KmMonitor
{
    //##################################################
    //# variables
    //##################################################

    private KmMonitorNode _root;
    private boolean       _enabled;
    private boolean       _details;

    //##################################################
    //# constructor
    //##################################################

    public KmMonitor()
    {
        _root = new KmMonitorNode("root");
        _enabled = true;
        _details = true;
    }

    //##################################################
    //# enable
    //##################################################

    public void enable()
    {
        _enabled = true;
    }

    public void toggle()
    {
        enable(!isEnabled());
    }

    public void enable(boolean b)
    {
        _enabled = b;
    }

    public void disable()
    {
        _enabled = false;
    }

    public boolean isEnabled()
    {
        return _enabled;
    }

    //##################################################
    //# details
    //##################################################

    public void enableDetails()
    {
        _details = true;
    }

    public void enableDetails(boolean b)
    {
        _details = b;
    }

    public void disableDetails()
    {
        _details = false;
    }

    public boolean areDetailsEnabled()
    {
        return _details;
    }

    //##################################################
    //# manage
    //##################################################

    public void reset()
    {
        _root = new KmMonitorNode("root");
    }

    public void start()
    {
        if ( !_enabled )
            return;
        _root.start();
        status(_root, "start");
    }

    public void stop()
    {
        if ( !_enabled )
            return;
        _root.stop();
        status(_root, "stop");
    }

    public void enter(String name)
    {
        if ( !_enabled )
            return;
        _root = _root.getChild(name);
        _root.start();
        status(_root, "enter");
    }

    public void enter(String name, String details, Object... detailArgs)
    {
        if ( !_enabled )
            return;
        enter(_format(name, details, detailArgs));
    }

    public void exit()
    {
        if ( !_enabled )
            return;
        status(_root, "exit");
        _root.stop();
        _root = _root.getParent();
    }

    public void log(String name)
    {
        if ( !_enabled )
            return;
        _root.getChild(name).hit();
    }

    public void log(String name, String details, Object... detailArgs)
    {
        if ( !_enabled )
            return;
        log(_format(name, details, detailArgs));
    }

    //##################################################
    //# print
    //##################################################

    public void print()
    {
        _root.getRoot().printTree();
    }

    public void print(double minSeconds)
    {
        _root.getRoot().printTree(minSeconds);
    }

    //##################################################
    //# nanos
    //##################################################

    public double getTotalSeconds()
    {
        return _root.getRoot().getNanos() / 1000000000.0;
    }

    public double getSeconds(String name)
    {
        return _root.getChild(name).getNanos() / 1000000000.0;
    }

    //##################################################
    //# private
    //##################################################

    private String _format(String name, String details, Object... detailArgs)
    {
        if ( !_details )
            return name;

        String s;
        s = Kmu.format(details, detailArgs);
        s = Kmu.format("%s: %s", name, s);
        return s;
    }

    private void status(KmMonitorNode node, String message)
    {
        KmLog.debug(node.getName() + ": " + message);
    }

}
