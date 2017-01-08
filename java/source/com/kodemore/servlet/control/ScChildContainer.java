/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;

/**
 * I provide a common implementation for subclasses that manage
 * a collection of children.  I do not provide any layout, structure,
 * or styling.
 */
public abstract class ScChildContainer
    extends ScContainer
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScControl> _children;

    //##################################################
    //# constructor
    //##################################################

    public ScChildContainer()
    {
        _children = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public final KmList<ScControl> getChildren()
    {
        return _children;
    }

    public ScControl getChildAt(int i)
    {
        return getChildren().getAt(i);
    }

    public boolean hasChildren()
    {
        return getChildren().isNotEmpty();
    }

    @Override
    public <T extends ScControl> T add(T e)
    {
        e.setParent(this);

        _children.add(e);

        return e;
    }

    @Override
    public void clear()
    {
        _children.clear();
    }

    @Override
    public boolean isEmpty()
    {
        return getChildren().isEmpty();
    }

}
