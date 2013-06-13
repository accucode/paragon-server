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

package com.kodemore.awt;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.kodemore.utility.KmDisplayStringIF;
import com.kodemore.utility.KmFormatterIF;

/**
 * I am used to render a cell in a list box.  I am adapted
 * from com.sun.java.swing.plaf.basic.BasicListCellRenderer.
 */
public class KmaListBoxCellRenderer
    extends JLabel
    implements ListCellRenderer
{
    //##################################################
    //# constants
    //##################################################

    public static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

    //##################################################
    //# variables
    //##################################################

    private KmFormatterIF      _formatter;

    //##################################################
    //# constructors
    //##################################################

    public KmaListBoxCellRenderer()
    {
        setOpaque(true);
        setBorder(noFocusBorder);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFormatterIF getFormatter()
    {
        return _formatter;
    }

    public void setFormatter(KmFormatterIF f)
    {
        _formatter = f;
    }

    //##################################################
    //# rendering
    //##################################################

    @Override
    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus)
    {
        if ( isSelected )
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if ( value instanceof Icon )
            setIcon((Icon)value);
        else
            setText(getDisplayStringFor(value));
        setFont(list.getFont());
        setBorder(cellHasFocus
            ? UIManager.getBorder("List.focusCellHighlightBorder")
            : noFocusBorder);
        return this;
    }

    //##################################################
    //# display
    //##################################################

    public String getDisplayStringFor(Object value)
    {
        if ( _formatter != null )
            return _formatter.format(value);
        if ( value instanceof KmDisplayStringIF )
            return ((KmDisplayStringIF)value).getDisplayString();
        if ( value == null )
            return "-- null --";
        return value + "";
    }
}
