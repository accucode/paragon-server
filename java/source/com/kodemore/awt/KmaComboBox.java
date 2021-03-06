/*
  Copyright (c) 2005-2018 www.kodemore.com

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

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

import com.kodemore.utility.KmFormatterIF;

public class KmaComboBox<E>
    extends JComboBox<E>
{
    //##################################################
    //# constructors
    //##################################################

    public KmaComboBox()
    {
        this(new Vector<E>());
    }

    public KmaComboBox(List<E> v)
    {
        setList(v);
        setRenderer(new KmaListBoxCellRenderer<E>());
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Dimension getPreferredSize()
    {
        Dimension d;
        d = super.getPreferredSize();
        d.width += 20;
        return d;
    }

    public void setList(List<E> v)
    {
        removeAllItems();
        for ( E e : v )
            addItem(e);
    }

    @SuppressWarnings("unchecked")
    public void setFormatter(KmFormatterIF f)
    {
        KmaListBoxCellRenderer<E> r;
        r = (KmaListBoxCellRenderer<E>)getRenderer();
        r.setFormatter(f);
    }

    public void setSelection(Object e)
    {
        setSelectedItem(e);
    }

    //##################################################
    //# selection
    //##################################################

    public String getSelectedString()
    {
        return getSelectedItem() + "";
    }

    public void addSelectionAction(Object receiver, String message)
    {
        ActionListener e = new KmaBlockAction(receiver, message);
        addActionListener(e);
    }

}
