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

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.kodemore.collection.KmList;

public class KmaSortableTable
    extends KmaTable
{
    //##################################################
    //# constructor
    //##################################################

    public KmaSortableTable(KmaSortableTableModel m)
    {
        super(m);

        JTableHeader th;
        th = getTableHeader();
        th.addMouseListener(newHeaderMouseListener());
        th.setDefaultRenderer(new SortableHeaderRenderer());

        registerKeyboardAction(
            new KmaBlockAction(this, "guiSetSortColumn"),
            KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0),
            WHEN_FOCUSED);

        registerKeyboardAction(
            new KmaBlockAction(this, "guiAddSortColumn"),
            KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, Event.CTRL_MASK),
            WHEN_FOCUSED);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaSortableTableModel getSortableModel()
    {
        return (KmaSortableTableModel)getModel();
    }

    public List<?> getList()
    {
        return getSortableModel().getList();
    }

    //##################################################
    //# sorting
    //##################################################

    public void setSortColumn(int i)
    {
        if ( i < 0 )
            return;

        if ( i >= getColumnCount() )
            return;

        int mi = convertColumnIndexToModel(i);
        List<?> v = getRowSelections();
        clearSelection();

        KmaSortableTableModel m = getSortableModel();
        if ( m.hasOneSortColumn(mi) )
            m.toggleSortColumn(mi);
        else
            m.setSortColumn(mi);

        setRowSelections(v);
        setSelectedColumn(i);

        JTableHeader th;
        th = getTableHeader();
        th.revalidate();
        th.repaint();
    }

    public void guiSetSortColumn()
    {
        int i = getSelectedColumn();
        setSortColumn(i);
    }

    public void guiAddSortColumn()
    {
        int i = getSelectedColumn();
        if ( i < 0 )
            return;
        int mi = convertColumnIndexToModel(i);
        List<?> v = getRowSelections();
        clearSelection();
        getSortableModel().toggleSortColumn(mi);
        setRowSelections(v);
        setSelectedColumn(i);
        getTableHeader().revalidate();
        getTableHeader().repaint();
    }

    //##################################################
    //# selections
    //##################################################

    public Object getRowSelection()
    {
        int i = getSelectedRow();
        if ( i < 0 )
            return null;
        return getList().get(i);
    }

    public void setRowSelection(Object e)
    {
        int i = getList().indexOf(e);
        setSelectedRow(i);
    }

    public KmList<Object> getRowSelections()
    {
        KmList<Object> v = new KmList<>();
        ListSelectionModel sm = getSelectionModel();
        int a = sm.getMinSelectionIndex();
        int b = sm.getMaxSelectionIndex();
        if ( a < 0 || b < 0 )
            return v;
        for ( int i = a; i <= b; i++ )
            v.add(getList().get(i));
        return v;
    }

    public void setRowSelections(List<?> v)
    {
        clearSelection();
        Iterator<?> i = v.iterator();
        while ( i.hasNext() )
        {
            Object e = i.next();
            int index = getList().indexOf(e);
            if ( index >= 0 )
                getSelectionModel().addSelectionInterval(index, index);
        }
    }

    public void setSelectedColumn(int i)
    {
        getColumnModel().getSelectionModel().setSelectionInterval(i, i);
    }

    //##################################################
    //# private
    //##################################################

    public MouseListener newHeaderMouseListener()
    {
        return new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent ev)
            {
                int n = getColumnCount();
                for ( int i = 0; i < n; i++ )
                {
                    Rectangle r = getTableHeader().getHeaderRect(i);
                    int x = ev.getX();
                    int y = ev.getY();
                    if ( r.contains(x, y) )
                    {
                        List<?> v = getRowSelections();
                        clearSelection();
                        int mi = convertColumnIndexToModel(i);
                        KmaSortableTableModel m;
                        m = getSortableModel();
                        if ( ev.isControlDown() )
                            m.toggleSortColumn(mi);
                        else
                            if ( m.hasOneSortColumn(mi) )
                                m.toggleSortColumn(mi);
                            else
                                m.setSortColumn(mi);
                        setRowSelections(v);
                        break;
                    }
                }
            }
        };
    }

    public class SortableHeaderRenderer
        extends JLabel
        implements TableCellRenderer
    {
        public KmaArrowIcon _icon;

        public SortableHeaderRenderer()
        {
            setBorder(BorderFactory.createRaisedBevelBorder());
            setHorizontalAlignment(CENTER);
            setHorizontalTextPosition(LEFT);
            _icon = new KmaArrowIcon();
            _icon.setArrowDown();
            _icon.setWidth(16);
            _icon.setHeight(16);
            _icon.setColor(Color.black);
            _icon.setInsets(4);
            setIcon(_icon);
        }

        @Override
        public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int col)
        {
            int mi = getColumnModel().getColumn(col).getModelIndex();
            KmaSortableTableModel m = getSortableModel();
            KmaSortableTableColumn sc = m.getSortedColumn(mi);
            if ( sc == null )
                _icon.setArrowNone();
            else
            {
                if ( m.isPrimarySortColumn(sc) )
                    _icon.setFill();
                else
                    _icon.setOutline();
                if ( sc.getAscending() )
                    _icon.setArrowDown();
                else
                    _icon.setArrowUp();
            }
            String s = getColumnName(col);
            setText(s);
            return this;
        }
    }

}
