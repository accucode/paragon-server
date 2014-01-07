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

import javax.swing.AbstractListModel;

public abstract class KmaListModel
    extends AbstractListModel
{
    //##################################################
    //# abstract
    //##################################################

    @Override
    public abstract int getSize();

    @Override
    public abstract Object getElementAt(int i);

    //##################################################
    //# event notification
    //##################################################

    public void fireContentsChanged(int i)
    {
        fireContentsChanged(i, i);
    }

    public void fireContentsChanged(int i, int j)
    {
        super.fireContentsChanged(this, i, j);
    }

    public void fireIntervalAdded(int i)
    {
        fireIntervalAdded(i, i);
    }

    public void fireIntervalAdded(int i, int j)
    {
        super.fireIntervalAdded(this, i, j);
    }

    public void fireIntervalRemoved(int i)
    {
        fireIntervalRemoved(i, i);
    }

    public void fireIntervalRemoved(int i, int j)
    {
        super.fireIntervalRemoved(this, i, j);
    }
}
