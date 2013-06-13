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
import com.kodemore.inspector.support.KmSlotInspectorIF;

/**
 * I am used for format classes that implement the
 * interface SlotInspectorIF.
 */
public class KmInspectorSlotInspectorFormat
    extends KmInspectorInspectFormat
{
    //##################################################
    //# type
    //##################################################

    @Override
    public boolean appliesTo(Object e)
    {
        return e instanceof KmSlotInspectorIF;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public int getSlotCountFor(KmInspectorNodeIF n)
    {
        KmSlotInspectorIF e = (KmSlotInspectorIF)n.getValue();
        return e.getInspectorSlotCount();
    }

    @Override
    public Object getSlotAt(KmInspectorNodeIF n, int i)
    {
        KmSlotInspectorIF e = (KmSlotInspectorIF)n.getValue();
        return e.getInspectorSlotAt(i);
    }

    @Override
    public Class<?> getSlotClassFor(KmInspectorNodeIF n)
    {
        KmSlotInspectorIF e = (KmSlotInspectorIF)n.getValue();
        return e.getInspectorSlotClass();
    }

}
