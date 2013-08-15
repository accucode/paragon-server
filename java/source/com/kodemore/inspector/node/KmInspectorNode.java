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

package com.kodemore.inspector.node;

import java.lang.reflect.Array;
import java.util.StringTokenizer;

import com.kodemore.inspector.KmInspector;
import com.kodemore.inspector.format.KmInspectorFormatIF;

/**
 * I define some base behavior that all nodes use including
 * how to format the declared and value class names.
 */
public class KmInspectorNode
    implements KmInspectorNodeIF
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public Object getValue()
    {
        return null;
    }

    @Override
    public String getName()
    {
        return getNameFor(getValueClass());
    }

    public KmInspectorFormatIF getFormat()
    {
        return KmInspector.getFormatFor(this);
    }

    @Override
    public String getDescription()
    {
        return getFormat().getDescriptionFor(this);
    }

    @Override
    public KmInspectorNodeList getChildren()
    {
        return getFormat().getChildrenFor(this);
    }

    @Override
    public Class<?> getValueClass()
    {
        Object e = getValue();
        if ( e == null )
            return null;
        return e.getClass();
    }

    @Override
    public Class<?> getDeclaredClass()
    {
        return null;
    }

    @Override
    public Class<?> getSlotClass()
    {
        return getFormat().getSlotClassFor(this);
    }

    @Override
    public Object getSlotAt(int i)
    {
        return getFormat().getSlotAt(this, i);
    }

    public String getNameFor(Class<?> c)
    {
        if ( c == null )
            return "<null>";

        return getShortNameFor(c);
    }

    public String getShortNameFor(Class<?> c)
    {
        String s = c.getName();
        StringTokenizer st = new StringTokenizer(s, ".");
        while ( st.hasMoreTokens() )
            s = st.nextToken();
        return s;
    }

    @Override
    public String getValueClassType()
    {
        Class<?> c = getValueClass();
        if ( c == null )
            return getNameFor(null);

        if ( c.isArray() )
        {
            String name = getNameFor(c.getComponentType());
            int n = Array.getLength(getValue());
            return "<array> " + name + " [" + n + "]";
        }
        return getNameFor(c);
    }

    @Override
    public String getDeclaredClassType()
    {
        Class<?> c = getDeclaredClass();
        if ( c == null )
            return getNameFor(null);

        if ( c.isArray() )
        {
            String name = getNameFor(c.getComponentType());
            return "<array> " + name + " []";
        }
        return getNameFor(c);
    }

    //##################################################
    //# display
    //##################################################

    /**
     * Nodes are used in list components so return a
     * string that will make sense in a list box.
     */
    @Override
    public String toString()
    {
        return getName();
    }

}
