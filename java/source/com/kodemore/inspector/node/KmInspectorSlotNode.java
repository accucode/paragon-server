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

package com.kodemore.inspector.node;

/**
 * I am used to inspect an object in a collection.
 * I keep a source node an an index.  I appeal back
 * to the source node (and through it to its format)
 * to get the actual value.
 */
public class KmInspectorSlotNode
    extends KmInspectorNode
{
    //##################################################
    //# variables
    //##################################################

    private KmInspectorNodeIF _node;
    private int               _index;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorSlotNode(KmInspectorNodeIF n, int i)
    {
        _node = n;
        _index = i;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmInspectorNodeIF getNode()
    {
        return _node;
    }

    public void setNode(KmInspectorNodeIF o)
    {
        _node = o;
    }

    public int getIndex()
    {
        return _index;
    }

    public void setIndex(int o)
    {
        _index = o;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public String getName()
    {
        return "[" + _index + "]";
    }

    @Override
    public Object getValue()
    {
        return _node.getSlotAt(_index);
    }

    @Override
    public Class<?> getDeclaredClass()
    {
        return _node.getSlotClass();
    }

}
