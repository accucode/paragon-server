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

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class KmaTable
    extends JTable
{
    //##################################################
    //# constants
    //##################################################

    public static final String SELECT_LISTENER = "SELECT";
    public static final String ACCEPT_LISTENER = "ACCEPT";

    //##################################################
    //# variables
    //##################################################

    private KmaActionGroup     _actions;

    //##################################################
    //# constructor
    //##################################################

    public KmaTable()
    {
        _initialize();
    }

    public KmaTable(TableModel m)
    {
        super(m);
        _initialize();
    }

    private void _initialize()
    {
        _actions = new KmaActionGroup();
        ListSelectionListener e = newListSelectionListener();
        getSelectionModel().addListSelectionListener(e);
        getColumnModel().getSelectionModel().addListSelectionListener(e);
        addMouseListener(newMouseListener());
        setSingleRowSelection();
        registerKeyboardAction(
            new KmaBlockAction(this, "fireAcceptListeners"),
            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
            WHEN_FOCUSED);
    }

    //##################################################
    //# selection
    //##################################################

    public void setSingleRowSelection()
    {
        setRowSelectionAllowed(true);
        //        setColumnSelectionAllowed(false);
        //        setCellSelectionEnabled(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void allowMultipleRowSelection()
    {
        setRowSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    public void setSelectedRow(int row)
    {
        setSelectedRow(row, true);
    }

    public void setSelectedRow(int row, boolean scrollTo)
    {
        getSelectionModel().setSelectionInterval(row, row);
        if ( scrollTo )
            makeRowVisible(row);
    }

    public void makeRowVisible(int row)
    {
        Rectangle r = getCellRect(row, 0, false);
        scrollRectToVisible(r);
    }

    //##################################################
    //# model
    //##################################################

    public void fireTableRowsInserted(int i, int j)
    {
        getAbstractModel().fireTableRowsInserted(i, j);
    }

    public void fireTableRowInserted(int i)
    {
        fireTableRowsInserted(i, i);
    }

    public void fireTableRowAdded()
    {
        int i = getModel().getRowCount();
        fireTableRowInserted(i);
    }

    public void fireTableRowsDeleted(int i, int j)
    {
        getAbstractModel().fireTableRowsDeleted(i, j);
    }

    public void fireTableRowDeleted(int i)
    {
        fireTableRowsDeleted(i, i);
    }

    public void fireTableDataChanged()
    {
        getAbstractModel().fireTableDataChanged();
    }

    public AbstractTableModel getAbstractModel()
    {
        return (AbstractTableModel)getModel();
    }

    public void rebuild()
    {
        getAbstractModel().fireTableStructureChanged();
    }

    //##################################################
    //# select listeners
    //##################################################

    public void addSelectListener(ActionListener e)
    {
        _actions.add(SELECT_LISTENER, e);
    }

    public void removeSelectListener(ActionListener e)
    {
        _actions.remove(SELECT_LISTENER, e);
    }

    public void fireSelectListeners()
    {
        if ( _actions == null )
            return;
        _actions.fire(SELECT_LISTENER);
    }

    //##################################################
    //# accept listeners
    //##################################################

    public void addAcceptListener(ActionListener e)
    {
        _actions.add(ACCEPT_LISTENER, e);
    }

    public void removeAcceptListener(ActionListener e)
    {
        _actions.remove(ACCEPT_LISTENER, e);
    }

    public void fireAcceptListeners()
    {
        if ( _actions == null )
            return;
        _actions.fire(ACCEPT_LISTENER);
    }

    //##################################################
    //# handlers
    //##################################################

    public MouseListener newMouseListener()
    {
        return new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent ev)
            {
                if ( ev.getClickCount() >= 2 )
                    handleDoubleClick();
            }
        };
    }

    public void handleSelectionChanged()
    {
        fireSelectListeners();
    }

    public void handleDoubleClick()
    {
        fireAcceptListeners();
    }

    public ListSelectionListener newListSelectionListener()
    {
        return new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent ev)
            {
                if ( ev.getValueIsAdjusting() )
                    return;
                handleSelectionChanged();
            }
        };
    }
}
