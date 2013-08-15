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

import java.util.Iterator;
import java.util.Map;

import com.kodemore.inspector.node.KmInspectorNodeIF;

/**
 * I am used to format the vendor class java.util.Dictionary.
 */
public class KmInspectorMapFormat
    extends KmInspectorAbstractCollectionFormat
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return e instanceof Map<?,?>;
    }

    //##################################################
    //# accessing
    //##################################################

    public Map<?,?> getMapFor(KmInspectorNodeIF nn)
    {
        return (Map<?,?>)nn.getValue();
    }

    @Override
    public int getSlotCountFor(KmInspectorNodeIF nn)
    {
        return getMapFor(nn).size();
    }

    @Override
    public Object getSlotAt(KmInspectorNodeIF nn, int i)
    {
        return getMapValueAt(nn, i);
    }

    public Object getMapKeyAt(KmInspectorNodeIF nn, int i)
    {
        Iterator<?> e = getMapFor(nn).keySet().iterator();
        while ( i-- > 0 )
            e.next();
        return e.next();
    }

    public Object getMapValueAt(KmInspectorNodeIF nn, int i)
    {
        Iterator<?> e = getMapFor(nn).values().iterator();
        while ( i-- > 0 )
            e.next();
        return e.next();
    }

    @Override
    public String getDescriptionFor(KmInspectorNodeIF nn)
    {
        StringBuilder sb = new StringBuilder();
        int n = getSlotCountFor(nn);
        for ( int i = 0; i < n; i++ )
        {
            Object key = getMapKeyAt(nn, i);
            Object value = getMapValueAt(nn, i);
            sb.append("[");
            sb.append(i);
            sb.append("] ");
            sb.append(key);
            sb.append(" --> ");
            sb.append(value);
            sb.append("\n");
        }
        return sb.toString();
    }

}
