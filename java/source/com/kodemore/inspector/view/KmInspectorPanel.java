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

package com.kodemore.inspector.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kodemore.inspector.KmInspector;
import com.kodemore.inspector.node.KmInspectorNodeIF;
import com.kodemore.inspector.node.KmInspectorNodeList;

public class KmInspectorPanel
    extends JPanel
{
    //##################################################
    //# variables
    //##################################################

    private JList             _listField;
    private JTextArea         _descriptionField;
    private JTextField        _declaredClassField;
    private JTextField        _valueClassField;
    private KmInspectorNodeIF _node;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorPanel()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        initializeComponents();
        initializeLayout();
    }

    public void initializeComponents()
    {
        _listField = new JList();
        _listField.addListSelectionListener(newListSelectionListener());
        _listField.addMouseListener(newMouseListener());
        _listField.registerKeyboardAction(
            newEnterAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
            WHEN_FOCUSED);
        _listField.registerKeyboardAction(
            newEscapeAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            WHEN_IN_FOCUSED_WINDOW);
        _listField.registerKeyboardAction(
            newEscapeAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
            WHEN_IN_FOCUSED_WINDOW);
        _listField.registerKeyboardAction(
            newEnterAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
            WHEN_IN_FOCUSED_WINDOW);
        _descriptionField = new JTextArea();
        _descriptionField.setLineWrap(true);
        _descriptionField.setWrapStyleWord(true);
        _declaredClassField = new JTextField();
        _valueClassField = new JTextField();
    }

    public void initializeLayout()
    {
        Dimension mSize = new Dimension(20, 20);
        Dimension pSize = new Dimension(150, 150);
        JComponent a = new JScrollPane(_listField);
        JComponent b = getRightComponent();
        a.setMinimumSize(mSize);
        a.setPreferredSize(pSize);
        b.setMinimumSize(mSize);
        b.setPreferredSize(pSize);
        JSplitPane sp = new JSplitPane();
        sp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        sp.setLeftComponent(a);
        sp.setRightComponent(b);
        setLayout(new BorderLayout());
        add(sp, "Center");
    }

    public JComponent getRightComponent()
    {
        KmInspectorGridBagBuilder b;
        b = new KmInspectorGridBagBuilder();
        b.setColumns(1);
        b.add(_declaredClassField);
        b.add(_valueClassField);
        b.setWeight(1, 1);
        b.add(new JScrollPane(_descriptionField));
        return b.getContainer();
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
        updateView();
    }

    //##################################################
    //# selection
    //##################################################

    public boolean hasSelectedNode()
    {
        return getSelectedNode() != null;
    }

    public KmInspectorNodeIF getSelectedNode()
    {
        return (KmInspectorNodeIF)_listField.getSelectedValue();
    }

    public Object getSelectedValue()
    {
        KmInspectorNodeIF n = getSelectedNode();
        return n == null
            ? null
            : n.getValue();
    }

    //##################################################
    //# events
    //##################################################

    public ListSelectionListener newListSelectionListener()
    {
        return new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent ev)
            {
                handleListSelection();
            }
        };
    }

    public MouseListener newMouseListener()
    {
        return new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent ev)
            {
                if ( ev.getClickCount() == 2 )
                    handleListDoubleClick();
            }
        };
    }

    public Action newEscapeAction()
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                handleEscape();
            }
        };
    }

    public Action newEnterAction()
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                handleListDoubleClick();
            }
        };
    }

    //##################################################
    //# handlers
    //##################################################

    public void handleListSelection()
    {
        updateItemFields();
    }

    public void handleListDoubleClick()
    {
        KmInspectorNodeIF n = getSelectedNode();
        if ( n == null )
            return;
        KmInspector.inspect(n, this);
    }

    public void handleEscape()
    {
        Window w = (Window)getTopLevelAncestor();
        w.dispose();
    }

    //##################################################
    //# update view
    //##################################################

    public void updateView()
    {
        clearView();
        if ( _node == null )
            return;
        KmInspectorNodeList v = _node.getChildren();
        if ( v == null )
            v = new KmInspectorNodeList();
        _listField.setListData(v.toArray());
        if ( v.size() > 0 )
        {
            _listField.setSelectedIndex(0);
            updateItemFields();
        }
    }

    public void updateItemFields()
    {
        clearItemFields();
        KmInspectorNodeIF n = getSelectedNode();
        if ( n == null )
            return;
        _declaredClassField.setText(n.getDeclaredClassType());
        _valueClassField.setText(n.getValueClassType());
        _descriptionField.setText(n.getDescription());
    }

    public void clearView()
    {
        _listField.setListData(new Object[0]);
        clearItemFields();
    }

    public void clearItemFields()
    {
        _declaredClassField.setText("");
        _valueClassField.setText("");
        _descriptionField.setText("");
    }

    //##################################################
    //# focus
    //##################################################

    @Override
    public void requestFocus()
    {
        _listField.requestFocus();
    }
}
