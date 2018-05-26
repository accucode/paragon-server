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

package com.kodemore.monitor;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmMonitorNode
{
    //##################################################
    //# variables
    //##################################################

    private KmMonitorNode         _parent;
    private KmList<KmMonitorNode> _children;
    private String                _name;
    private long                  _nanos;
    private long                  _count;
    private long                  _start;

    //##################################################
    //# constructor
    //##################################################

    public KmMonitorNode()
    {
        this("");
    }

    public KmMonitorNode(String name)
    {
        _name = name;
        _parent = null;
        _children = new KmList<>();
        _nanos = 0;
        _count = 0;
        _start = -1;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMonitorNode getParent()
    {
        return _parent;
    }

    public void setParent(KmMonitorNode e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    public KmList<KmMonitorNode> getChildren()
    {
        return _children;
    }

    public KmMonitorNode _getChild(String s)
    {
        for ( KmMonitorNode e : _children )
            if ( e.hasName(s) )
                return e;
        return null;
    }

    public KmMonitorNode getChild(String s)
    {
        KmMonitorNode e = _getChild(s);
        if ( e == null )
        {
            e = new KmMonitorNode(s);
            e.setParent(this);
            _children.add(e);
        }
        return e;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName(String s)
    {
        return Kmu.isEqual(_name, s);
    }

    public long getNanos()
    {
        return _nanos;
    }

    public void setNanos(long e)
    {
        _nanos = e;
    }

    public long getCount()
    {
        return _count;
    }

    public void setCount(long e)
    {
        _count = e;
    }

    public double getAverageNanos()
    {
        if ( _count == 0 )
            return 0;

        return _nanos / (double)_count;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public int getDepth()
    {
        if ( hasParent() )
            return getParent().getDepth() + 1;
        return 0;
    }

    public KmMonitorNode getRoot()
    {
        if ( hasParent() )
            return getParent().getRoot();
        return this;
    }

    public boolean hasTime()
    {
        return _nanos > 0;
    }

    public double getSeconds()
    {
        return _nanos / 1000000000.0;
    }

    public double getMilliseconds()
    {
        return _nanos / 1000000.0;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return format();
    }

    public String format()
    {
        String indent = Kmu.repeat("  ", getDepth());
        String s = Kmu.format("%s%s", indent, getName());

        if ( getCount() > 0 )
            s += Kmu.format(" (%.0f ms, %s)", getMilliseconds(), getCount());

        return s;
    }

    public void print()
    {
        System.out.println(format());
    }

    public void printTree()
    {
        print();
        for ( KmMonitorNode e : _children )
            e.printTree();
    }

    public void printTree(double minSeconds)
    {
        if ( getSeconds() >= minSeconds )
            print();

        for ( KmMonitorNode e : _children )
            e.printTree(minSeconds);
    }

    //##################################################
    //# timing
    //##################################################

    public void hit()
    {
        _count++;
    }

    public void start()
    {
        _start = System.nanoTime();
    }

    public void stop()
    {
        _count++;
        _nanos = _nanos + System.nanoTime() - _start;
    }

}
