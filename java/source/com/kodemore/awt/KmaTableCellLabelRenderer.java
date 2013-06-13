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

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

public class KmaTableCellLabelRenderer
    extends KmaLabel
    implements TableCellRenderer
{
    //##################################################
    //# variables
    //##################################################

    private Border                   _noBorder;
    private boolean                  _showFocus;
    private KmaTableCellRendererData _data;
    private Color                    _focusBorderColor;

    //##################################################
    //# constructor
    //##################################################

    public KmaTableCellLabelRenderer()
    {
        _data = new KmaTableCellRendererData();
        showFocus();
        setNoBorder(1);
        setup();
    }

    public void setup()
    {
        setNormal();
    }

    //##################################################
    //# border
    //##################################################

    public Border getNoBorder()
    {
        return _noBorder;
    }

    public void setNoBorder(Border e)
    {
        _noBorder = e;
    }

    public void setNoBorder(int i)
    {
        setNoBorder(i, i);
    }

    public void setNoBorder(int x, int y)
    {
        setNoBorder(y, x, y, x);
    }

    public void setNoBorder(int top, int left, int bottom, int right)
    {
        setNoBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    }

    //##################################################
    //# focus
    //##################################################

    public boolean getShowFocus()
    {
        return _showFocus;
    }

    public void setShowFocus(boolean e)
    {
        _showFocus = e;
    }

    public void showFocus()
    {
        setShowFocus(true);
    }

    public void hideFocus()
    {
        setShowFocus(false);
    }

    public Color getFocusBorderColor()
    {
        return _focusBorderColor;
    }

    public void setFocusBorderColor(Color e)
    {
        _focusBorderColor = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public Component getTableCellRendererComponent(
        JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row,
        int col)
    {
        _data.table = table;
        _data.value = value;
        _data.isSelected = isSelected;
        _data.hasFocus = hasFocus;
        _data.row = row;
        _data.column = col;

        setupColors(_data);
        setupBorder(_data);
        setupAlignment(_data);
        setupFont(_data);
        setupText(_data);
        setupOpaque(_data);
        return this;
    }

    public void setupColors(KmaTableCellRendererData d)
    {
        if ( d.isSelected )
        {
            super.setForeground(d.table.getSelectionForeground());
            super.setBackground(d.table.getSelectionBackground());
        }
        else
        {
            super.setForeground(d.table.getForeground());
            super.setBackground(d.table.getBackground());
        }
    }

    public void setupBorder(KmaTableCellRendererData d)
    {
        if ( getShowFocus() && d.hasFocus )
        {
            if ( _focusBorderColor == null )
                setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            else
                setBorder(BorderFactory.createLineBorder(_focusBorderColor));
            if ( d.table.isCellEditable(d.row, d.column) )
            {
                super.setForeground(UIManager.getColor("Table.focusCellForeground"));
                super.setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        else
            setBorder(_noBorder);
    }

    public void setupAlignment(KmaTableCellRendererData d)
    {
        alignCenterX();
    }

    public void setupFont(KmaTableCellRendererData d)
    {
        setFont(d.table.getFont());
    }

    public void setupText(KmaTableCellRendererData d)
    {
        setText(d.value + "");
    }

    public void setupOpaque(KmaTableCellRendererData d)
    {
        Color back = getBackground();
        boolean colorMatch = back != null
            && back.equals(d.table.getBackground())
            && d.table.isOpaque();
        setOpaque(!colorMatch);
    }

}
