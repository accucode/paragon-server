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

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kodemore.block.KmBlockFormatter;
import com.kodemore.utility.KmFormatterIF;

public class KmaListBox
    extends JList
    implements ListSelectionListener
{
    //##################################################
    //# variables
    //##################################################

    private KmaActionMap _actions;

    //##################################################
    //# constructors
    //##################################################

    public KmaListBox()
    {
        setModel(new DefaultListModel());
        _initialize();
    }

    public KmaListBox(ListModel e)
    {
        super(e);
        _initialize();
    }

    private void _initialize()
    {
        _actions = new KmaActionMap();
        addListSelectionListener(this);
        addMouseListener(newMouseListener());
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCellRenderer(new KmaListBoxCellRenderer());
        registerKeyboardAction(
            newEnterAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
            WHEN_FOCUSED);
    }

    //##################################################
    //# accessing
    //##################################################

    public void add(Object e)
    {
        getDefaultListModel().addElement(e);
    }

    public void addAll(Collection<?> v)
    {
        Iterator<?> i = v.iterator();
        while ( i.hasNext() )
            add(i.next());
    }

    public void remove(Object e)
    {
        getDefaultListModel().removeElement(e);
    }

    @Override
    public void removeAll()
    {
        clearSelection();
        getDefaultListModel().clear();
    }

    public void replaceAll(Collection<?> c)
    {
        removeAll();
        addAll(c);
    }

    public DefaultListModel getDefaultListModel()
    {
        return (DefaultListModel)getModel();
    }

    //##################################################
    //# selection
    //##################################################

    public Object getSelectedItem()
    {
        return super.getSelectedValue();
    }

    public void setSelectedValue(Object e)
    {
        setSelectedValue(e, true);
    }

    @Override
    public void setSelectedValue(Object e, boolean show)
    {
        int i = getIndexOf(e);
        setSelectionIndex(i);
        if ( hasSelection() )
            ensureIndexIsVisible(i);
    }

    public int getIndexOf(Object e)
    {
        ListModel m = getModel();
        int n = m.getSize();
        for ( int i = 0; i < n; i++ )
            if ( m.getElementAt(i).equals(e) )
                return i;
        return -1;
    }

    public void setSelectionIndex(int i)
    {
        if ( i < 0 )
            clearSelection();
        else
            getDefaultListSelectionModel().setSelectionInterval(i, i);
    }

    @Override
    public void valueChanged(ListSelectionEvent ev)
    {
        if ( ev.getValueIsAdjusting() )
            return;
        getSelectListeners().fire();
    }

    public DefaultListSelectionModel getDefaultListSelectionModel()
    {
        return (DefaultListSelectionModel)getSelectionModel();
    }

    public boolean hasSelection()
    {
        return !isSelectionEmpty();
    }

    //##################################################
    //# select listeners
    //##################################################

    public KmaActionList getSelectListeners()
    {
        return _actions.get("select");
    }

    public KmaActionList getAcceptListeners()
    {
        return _actions.get("accept");
    }

    //##################################################
    //# display
    //##################################################

    public KmaListBoxCellRenderer getListBoxCellRenderer()
    {
        return (KmaListBoxCellRenderer)getCellRenderer();
    }

    public void setFormatter(KmFormatterIF f)
    {
        getListBoxCellRenderer().setFormatter(f);
    }

    public void setFormatter(Object receiver, String message)
    {
        setFormatter(new KmBlockFormatter(receiver, message));
    }

    //##################################################
    //# utility
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

    public void handleDoubleClick()
    {
        handleAccept();
    }

    public KmaAction newEnterAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleAccept();
            }
        };
    }

    public void handleAccept()
    {
        getAcceptListeners().fire();
    }

    //##################################################
    //# km list model
    //##################################################

    public KmaListModel getKmaListModel()
    {
        return (KmaListModel)getModel();
    }

    public void fireContentsChanged()
    {
        fireContentsChanged(0, getModel().getSize() - 1);
    }

    public void fireContentsChanged(int i)
    {
        getKmaListModel().fireContentsChanged(i, i);
    }

    public void fireContentsChanged(int i, int j)
    {
        getKmaListModel().fireContentsChanged(i, j);
    }

    public void fireIntervalAdded(int i)
    {
        getKmaListModel().fireIntervalAdded(i, i);
    }

    public void fireIntervalAdded(int i, int j)
    {
        getKmaListModel().fireIntervalAdded(i, j);
    }

    public void fireIntervalRemoved(int i)
    {
        getKmaListModel().fireIntervalRemoved(i, i);
    }

    public void fireIntervalRemoved(int i, int j)
    {
        getKmaListModel().fireIntervalRemoved(i, j);
    }

}
