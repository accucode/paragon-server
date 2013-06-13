/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import java.util.Date;

import com.kodemore.inspector.node.KmInspectorMethodNode;
import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorNodeList;

/**
 * I am used to format the vendor class java.util.Date.
 */
public class KmInspectorDateFormat
    extends KmInspectorFormat
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return e instanceof Date;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getDescriptionFor(KmInspectorNodeIF n)
    {
        Date d = (Date)n.getValue();
        return d.toString();
    }

    @Override
    public KmInspectorNodeList getChildrenFor(KmInspectorNodeIF n)
    {
        Date d = (Date)n.getValue();
        KmInspectorNodeList v = new KmInspectorNodeList();
        v.add(getThisNodeFor(n));
        v.add(new KmInspectorMethodNode(d, "getHours"));
        v.add(new KmInspectorMethodNode(d, "getMinutes"));
        v.add(new KmInspectorMethodNode(d, "getSeconds"));
        return v;
    }

}
