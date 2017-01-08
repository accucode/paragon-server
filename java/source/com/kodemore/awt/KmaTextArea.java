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

package com.kodemore.awt;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.kodemore.collection.KmList;

public class KmaTextArea
    extends JTextArea
{
    //##################################################
    //# variables
    //##################################################

    private String            _oldText;
    private boolean           _selectOnFocus;
    private KmList<KmaAction> _changeActions;

    //##################################################
    //# constructors
    //##################################################

    public KmaTextArea()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        _oldText = "";
        _selectOnFocus = true;
        _changeActions = new KmList<>();

        setRows(4);
        setColumns(10);
        addFocusListener(newFocusListener());
        addKeyListener(newKeyListener());
        setWordWrap(true);
        installRepainter();
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getWordWrap()
    {
        return getLineWrap() && getWrapStyleWord();
    }

    public void setWordWrap(boolean b)
    {
        setLineWrap(b);
        setWrapStyleWord(b);
    }

    public boolean getSelectOnFocus()
    {
        return _selectOnFocus;
    }

    public void setSelectOnFocus(boolean o)
    {
        _selectOnFocus = o;
    }

    @Override
    public void setText(String s)
    {
        super.setText(s);

        _oldText = s;
        setCaretPosition(0);
    }

    //##################################################
    //# focus listener
    //##################################################

    public FocusListener newFocusListener()
    {
        return new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent ev)
            {
                if ( !_selectOnFocus )
                    return;

                int n = getDocument().getLength();
                select(n, 0);
                repaint();
            }

            @Override
            public void focusLost(FocusEvent ev)
            {
                if ( !_oldText.equals(getText()) )
                    fireChangeActions();

                _oldText = getText();
                repaint();
            }
        };
    }

    //##################################################
    //# key listener
    //##################################################

    public KeyListener newKeyListener()
    {
        return new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ev)
            {
                // ignored
            }

            @Override
            public void keyPressed(KeyEvent ev)
            {
                // ignored
            }

            @Override
            public void keyReleased(KeyEvent ev)
            {
                // ignored
            }
        };
    }

    //##################################################
    //# repainter
    //##################################################

    public void installRepainter()
    {
        getDocument().addDocumentListener(newRepaintDocumentListener());
    }

    public DocumentListener newRepaintDocumentListener()
    {
        return new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent ev)
            {
                handleDocumentChange();
            }

            @Override
            public void removeUpdate(DocumentEvent ev)
            {
                handleDocumentChange();
            }

            @Override
            public void changedUpdate(DocumentEvent ev)
            {
                handleDocumentChange();
            }

            public void handleDocumentChange()
            {
                repaint();
            }
        };
    }

    //##################################################
    //# other
    //##################################################

    // /**
    // * Disable the use of tabs within a text area. The
    // * tab key will now be used as a focus traversal key.
    // */
    // public boolean isManagingFocus()
    // {
    // return false;
    // }
    //
    //##################################################
    //# enablement
    //##################################################

    public void setReadOnly()
    {
        setEnabled(false);
        setDisabledTextColor(Color.black);
        setSelectOnFocus(false);
    }

    //##################################################
    //# change actions
    //##################################################

    public void addChangeAction(KmaAction a)
    {
        _changeActions.add(a);
    }

    public void removeChangeAction(KmaAction a)
    {
        _changeActions.remove(a);
    }

    public void fireChangeActions()
    {
        for ( KmaAction e : _changeActions )
            e.invoke();
    }
}
