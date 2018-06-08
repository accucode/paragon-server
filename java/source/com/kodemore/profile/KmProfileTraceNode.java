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

package com.kodemore.profile;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.utility.Kmu;

public class KmProfileTraceNode
{
    //##################################################
    //# static
    //##################################################

    public static final Comparator<KmProfileTraceNode> TOTAL_PERCENT_COMPARATOR = newComparator();

    private static Comparator<KmProfileTraceNode> newComparator()
    {
        return new KmComparator<KmProfileTraceNode>()
        {
            @Override
            public int compare(KmProfileTraceNode n1, KmProfileTraceNode n2)
            {
                double d1 = n1.getTotalPercent();
                double d2 = n2.getTotalPercent();
                return Kmu.compare(d2, d1);
            }
        };
    }

    //##################################################
    //# variables
    //##################################################

    private KmProfileTraceNode         _parent;
    private KmList<KmProfileTraceNode> _children;
    private int                        _traceId;
    private String                     _name;
    private int                        _lineNumber;

    private int    _count;
    private double _localPercent;
    private double _totalPercent;

    //##################################################
    //# constructor
    //##################################################

    public KmProfileTraceNode()
    {
        _traceId = -1;
        _lineNumber = -1;
        _children = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmProfileTraceNode getParent()
    {
        return _parent;
    }

    public void setParent(KmProfileTraceNode e)
    {
        _parent = e;
    }

    public int getTraceId()
    {
        return _traceId;
    }

    public void setTraceId(int e)
    {
        _traceId = e;
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
        return _name.equals(s);
    }

    public String getClassName()
    {
        int i = _name.lastIndexOf('.');
        return _name.substring(0, i);
    }

    public String getMethodName()
    {
        int i = _name.lastIndexOf('.') + 1;
        return _name.substring(i);
    }

    public int getLineNumber()
    {
        return _lineNumber;
    }

    public void setLineNumber(int e)
    {
        _lineNumber = e;
    }

    public double getLocalPercent()
    {
        return _localPercent;
    }

    public void setLocalPercent(double e)
    {
        _localPercent = e;
    }

    public double getTotalPercent()
    {
        return _totalPercent;
    }

    public void setTotalPercent(double e)
    {
        _totalPercent = e;
    }

    public int getCount()
    {
        return _count;
    }

    public void setCount(int e)
    {
        _count = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void fillInStats()
    {
        if ( _count == 0 )
            _count = 1;
        _totalPercent = _localPercent;

        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode e;
            e = i.next();
            e.fillInStats();
            _totalPercent += e.getTotalPercent();
        }
    }

    public void scaleTo(double newTotal)
    {
        double scale = newTotal / getTotalPercent();
        scaleBy(scale);
    }

    public void scaleBy(double scale)
    {
        _localPercent *= scale;
        _totalPercent *= scale;
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode e;
            e = i.next();
            e.scaleBy(scale);
        }
    }

    //##################################################
    //# children
    //##################################################

    public Iterator<KmProfileTraceNode> getChildren()
    {
        return _children.iterator();
    }

    public int getChildCount()
    {
        return _children.size();
    }

    public void addChild(KmProfileTraceNode child)
    {
        child.setParent(this);
        _children.add(child);
    }

    public void removeChild(KmProfileTraceNode child)
    {
        _children.remove(child);
        child.setParent(null);
    }

    public KmProfileTraceNode getFirstChild()
    {
        if ( isLeaf() )
            return null;
        return _children.getFirst();
    }

    public int getIndexOfChild(KmProfileTraceNode c)
    {
        return _children.indexOf(c);
    }

    public KmProfileTraceNode getChildAt(int i)
    {
        return _children.get(i);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void apply(KmProfileTrace t, KmProfileCpu cpu)
    {
        KmProfileTraceNode node = this;
        Iterator<KmProfileTraceLine> i = t.getTraceLinesFromRoot();
        while ( i.hasNext() )
        {
            KmProfileTraceLine line = i.next();
            node = node.getOrCreateChildFor(line);
        }
        node.apply(cpu);
    }

    public void apply(KmProfileCpu cpu)
    {
        if ( cpu == null )
            return;
        _localPercent += cpu.getSelf();
        _count += cpu.getCount();
    }

    public KmProfileTraceNode getOrCreateChildFor(KmProfileTraceLine line)
    {
        KmProfileTraceNode child;
        String name = line.getName();
        Iterator<KmProfileTraceNode> i = _children.iterator();
        while ( i.hasNext() )
        {
            child = i.next();
            if ( child.hasName(name) )
                return child;
        }
        child = new KmProfileTraceNode();
        child.setName(name);
        child.setLineNumber(line.getLineNumber());
        addChild(child);
        return child;
    }

    //##################################################
    //# display
    //##################################################

    public void printTree()
    {
        printTree(0);
    }

    public void printTree(int n)
    {
        System.out.println(getDisplayString(n));
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode child;
            child = i.next();
            child.printTree(n + 1);
        }
    }

    public String getDisplayString(int n)
    {
        StringBuilder out = new StringBuilder();

        for ( int i = 0; i < n; i++ )
            out.append("  ");

        out.append(getName());

        out.append(" (");
        out.append(Kmu.formatDouble(getTotalPercent(), 2));
        out.append("%");

        if ( getCount() > 1 )
        {
            out.append(", ");
            out.append(getCount());
        }

        out.append(")");

        return out.toString();
    }

    @Override
    public String toString()
    {
        return getDisplayString(0);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isRoot()
    {
        return _parent == null;
    }

    public boolean isLeaf()
    {
        return _children.isEmpty();
    }

    public boolean hasNamePrefix(String s)
    {
        return getName().startsWith(s);
    }

    public boolean hasNamePrefix(String[] arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( hasNamePrefix(arr[i]) )
                return true;

        return false;
    }

    //##################################################
    //# prune
    //##################################################

    public void pruneLeafsStartingWith(String[] prefixes)
    {
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode child = i.next();
            child.pruneLeafsStartingWith(prefixes);

            if ( hasNamePrefix(prefixes) && child.isLeaf() && child.hasNamePrefix(prefixes) )
            {
                child.setParent(null);
                i.remove();
            }
        }
    }

    public void pruneLeafsWithTotalLessThan(double min)
    {
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode child;
            child = i.next();
            child.pruneLeafsWithTotalLessThan(min);
            if ( child.isLeaf() && child.getTotalPercent() < min )
            {
                child.setParent(null);
                i.remove();
            }
        }
    }

    //##################################################
    //# collapse
    //##################################################

    public void collapseAllChainsStartingWith(String[] prefixes)
    {
        _collapseChainStartingWith(prefixes);
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode e = i.next();
            e.collapseAllChainsStartingWith(prefixes);
        }
    }

    public void _collapseChainStartingWith(String[] prefixes)
    {
        while ( true )
        {
            KmProfileTraceNode p = this;
            if ( p.getChildCount() != 1 )
                return;

            KmProfileTraceNode c = p.getFirstChild();
            if ( c.getChildCount() != 1 )
                return;

            KmProfileTraceNode t = c.getFirstChild();
            if ( t.getChildCount() == 0 )
                return;

            if ( !c.hasNamePrefix(prefixes) )
                return;

            c.removeChild(t);
            p.removeChild(c);
            p.addChild(t);
        }
    }

    public void collapseAllChainsWithTotalLessThan(double tolerance)
    {
        _collapseChainWithTotalLessThan(tolerance);

        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode e;
            e = i.next();
            e.collapseAllChainsWithTotalLessThan(tolerance);
        }
    }

    public void _collapseChainWithTotalLessThan(double tolerance)
    {
        while ( true )
        {
            KmProfileTraceNode p = this;
            if ( p.getChildCount() != 1 )
                return;

            KmProfileTraceNode c = p.getFirstChild();
            if ( c.getChildCount() != 1 )
                return;

            KmProfileTraceNode t = c.getFirstChild();
            if ( t.getChildCount() == 0 )
                return;

            if ( !Kmu.isEqual(c.getTotalPercent(), p.getTotalPercent(), tolerance) )
                return;
            if ( !Kmu.isEqual(c.getTotalPercent(), t.getTotalPercent(), tolerance) )
                return;

            c.removeChild(t);
            p.removeChild(c);
            p.addChild(t);
        }
    }

    //##################################################
    //# sort
    //##################################################

    public void sortAllChildren(Comparator<KmProfileTraceNode> c)
    {
        sortChildren(c);
        Iterator<KmProfileTraceNode> i = getChildren();
        while ( i.hasNext() )
        {
            KmProfileTraceNode e = i.next();
            e.sortAllChildren(c);
        }
    }

    public void sortChildren(Comparator<KmProfileTraceNode> c)
    {
        Collections.sort(_children, c);
    }

}
