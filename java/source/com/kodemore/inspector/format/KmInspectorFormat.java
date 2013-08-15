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

import com.kodemore.inspector.node.KmInspectorNamedNode;
import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorNodeList;

/**
 * I am an abstract format that defines some default
 * behavior.  Normally, all formats will be a subclass
 * of me.
 */
public class KmInspectorFormat
    implements KmInspectorFormatIF
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return false;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getDescriptionFor(KmInspectorNodeIF n)
    {
        return n.getValue() + "";
    }

    @Override
    public KmInspectorNodeList getChildrenFor(KmInspectorNodeIF n)
    {
        KmInspectorNodeList v = new KmInspectorNodeList();
        v.add(getThisNodeFor(n));
        return v;
    }

    //##################################################
    //# collection
    //##################################################

    @Override
    public int getSlotCountFor(KmInspectorNodeIF nn)
    {
        return 0;
    }

    @Override
    public Object getSlotAt(KmInspectorNodeIF nn, int i)
    {
        return null;
    }

    @Override
    public Class<?> getSlotClassFor(KmInspectorNodeIF nn)
    {
        return null;
    }

    //##################################################
    //# utility
    //##################################################

    public KmInspectorNodeIF getThisNodeFor(KmInspectorNodeIF n)
    {
        String s = "this";
        Object e = n.getValue();
        Class<?> c = n.getDeclaredClass();
        return new KmInspectorNamedNode(s, e, c);
    }

}
