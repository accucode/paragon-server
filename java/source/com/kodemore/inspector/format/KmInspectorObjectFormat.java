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

import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorNodeList;
import com.kodemore.inspector.support.KmInspectorUtility;

/**
 * I am used to provide a default format for any object.
 * I cannot format a null value.
 */
public class KmInspectorObjectFormat
    extends KmInspectorFormat
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return e != null;
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
        Object e = n.getValue();
        KmInspectorNodeList v = KmInspectorUtility.getLocalVariableNodesFor(e);
        KmInspectorNodeIF node = getThisNodeFor(n);
        v.addFirst(node);
        return v;
    }

}
