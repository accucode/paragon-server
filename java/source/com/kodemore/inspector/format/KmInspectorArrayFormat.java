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

package com.kodemore.inspector.format;

import java.lang.reflect.Array;

import com.kodemore.inspector.node.KmInspectorNodeIF;

/**
 * I am used to format the quasi primitive array type.
 */
public class KmInspectorArrayFormat
    extends KmInspectorAbstractCollectionFormat
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return e.getClass().isArray();
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public int getSlotCountFor(KmInspectorNodeIF nn)
    {
        Object e = nn.getValue();
        return Array.getLength(e);
    }

    @Override
    public Object getSlotAt(KmInspectorNodeIF n, int i)
    {
        Object e = n.getValue();
        Object o = Array.get(e, i);
        return o;
    }

    @Override
    public Class<?> getSlotClassFor(KmInspectorNodeIF n)
    {
        Class<?> dc = n.getDeclaredClass();
        if ( dc == null )
            return _getVClassFor(n);
        Class<?> c = dc.getComponentType();
        return c == null
            ? _getVClassFor(n)
            : c;
    }

    public Class<?> _getVClassFor(KmInspectorNodeIF n)
    {
        Class<?> c = n.getValueClass();
        return c == null
            ? null
            : c.getComponentType();
    }
}
