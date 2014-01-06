/*
  Copyright (c) 2005-2014 www.kodemore.com

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

/**
 * I define the interface that inspector formats
 * must implement.
 */
public interface KmInspectorFormatIF
{
    //##################################################
    //# type
    //##################################################

    /**
     * Determine if this format can be used for some instance.
     */
    boolean appliesTo(Object e);

    //##################################################
    //# accessing
    //##################################################

    /**
     * Get the long description.
     */
    String getDescriptionFor(KmInspectorNodeIF nn);

    /**
     * Get the vector of children.  Each child in the
     * vector must be an instance of KmNodeIF.
     */
    KmInspectorNodeList getChildrenFor(KmInspectorNodeIF nn);

    //##################################################
    //# collection
    //##################################################

    /**
     * Used for collection types.
     * Get the number of items in the collection.
     */
    int getSlotCountFor(KmInspectorNodeIF nn);

    /**
     * Used for collection types.
     * Get the item at some zero-based index.
     */
    Object getSlotAt(KmInspectorNodeIF nn, int i);

    /**
     * Used for collection types.
     * Get the declared type of the items.
     */
    Class<?> getSlotClassFor(KmInspectorNodeIF nn);
}
