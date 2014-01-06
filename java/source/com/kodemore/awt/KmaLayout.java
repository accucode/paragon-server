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

package com.kodemore.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

public class KmaLayout
    implements LayoutManager2
{
    //##################################################
    //# layoutmanager
    //##################################################

    @Override
    public void addLayoutComponent(String name, Component c)
    {
        addLayoutComponent(c, name);
    }

    @Override
    public void removeLayoutComponent(Component c)
    {
        // none
    }

    @Override
    public Dimension preferredLayoutSize(Container parent)
    {
        return _getSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent)
    {
        return _getSize(parent);
    }

    @Override
    public void layoutContainer(Container parent)
    {
        // none
    }

    //##################################################
    //# layoutmanager2
    //##################################################

    @Override
    public void addLayoutComponent(Component c, Object constraints)
    {
        // none
    }

    @Override
    public Dimension maximumLayoutSize(Container parent)
    {
        return _getSize(parent);
    }

    @Override
    public float getLayoutAlignmentX(Container parent)
    {
        return (float)0.5;
    }

    @Override
    public float getLayoutAlignmentY(Container parent)
    {
        return (float)0.5;
    }

    @Override
    public void invalidateLayout(Container parent)
    {
        // none
    }

    //##################################################
    //# utility
    //##################################################

    public Dimension _getSize(Container parent)
    {
        int w = 0;
        int h = 0;
        int n = parent.getComponentCount();
        for ( int i = 0; i < n; i++ )
        {
            Component c = parent.getComponent(i);
            Dimension d = c.getPreferredSize();
            w += d.width;
            h += d.height;
        }
        return new Dimension(w, h);
    }

}
