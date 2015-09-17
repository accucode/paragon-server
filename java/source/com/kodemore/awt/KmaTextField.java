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
import java.awt.Event;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class KmaTextField
    extends JTextField
    implements FocusListener, KeyListener, DocumentListener
{
    //##################################################
    //# variables
    //##################################################

    private String  _oldText;
    private boolean _selectOnFocus;
    private boolean _allowEmpty;
    private boolean _forceUpperCase;
    private boolean _autoRevertOnError;
    private boolean _autoRevertToRange;

    private KmaAction _extendedEditAction;

    private KmaActionMap _actions;

    //##################################################
    //# constructors
    //##################################################

    public KmaTextField(int columns)
    {
        this();
        setColumns(columns);
    }

    public KmaTextField()
    {
        _oldText = "";
        _selectOnFocus = true;
        _allowEmpty = true;
        _forceUpperCase = false;
        _autoRevertOnError = true;
        _autoRevertToRange = false;

        _actions = new KmaActionMap();

        setColumns(10);

        addFocusListener(this);
        addKeyListener(this);
        getDocument().addDocumentListener(this);

        registerKeyboardAction(
            newHelpAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0),
            WHEN_FOCUSED);

        registerKeyboardAction(
            newExtendedEditAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),
            WHEN_FOCUSED);

        registerKeyboardAction(
            newCancelAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK),
            WHEN_FOCUSED);

        registerKeyboardAction(
            newCancelAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, Event.ALT_MASK),
            WHEN_FOCUSED);

        registerKeyboardAction(
            newEnterAction(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
            WHEN_FOCUSED);
    }

    //##################################################
    //# super class override
    //##################################################

    @Override
    public String getText()
    {
        return super.getText().trim();
    }

    @Override
    public void setText(String s)
    {
        s = s.trim();

        if ( _forceUpperCase )
            s = s.toUpperCase();

        super.setText(s);
        _oldText = s;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getForceUpperCase()
    {
        return _forceUpperCase;
    }

    public void forceUpperCase()
    {
        setForceUpperCase(true);
    }

    public void setForceUpperCase(boolean o)
    {
        _forceUpperCase = o;
    }

    public boolean getSelectOnFocus()
    {
        return _selectOnFocus;
    }

    public void setSelectOnFocus(boolean o)
    {
        _selectOnFocus = o;
    }

    public boolean getAllowEmpty()
    {
        return _allowEmpty;
    }

    public void setAllowEmpty()
    {
        setAllowEmpty(true);
    }

    public void setAllowEmpty(boolean o)
    {
        _allowEmpty = o;
    }

    public boolean getAutoRevertOnError()
    {
        return _autoRevertOnError;
    }

    public void setAutoRevertOnError(boolean b)
    {
        _autoRevertOnError = b;
    }

    public KmaAction getExtendedEditAction()
    {
        return _extendedEditAction;
    }

    public void setExtendedEditAction(KmaAction o)
    {
        _extendedEditAction = o;
    }

    public boolean getAutoRevertToRange()
    {
        return _autoRevertToRange;
    }

    public void setAutoRevertToRange(boolean e)
    {
        _autoRevertToRange = e;
    }

    //##################################################
    //# enablement
    //##################################################

    public void setEditable()
    {
        setEnabled(true);
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    public void setReadOnly(boolean b)
    {
        if ( b )
        {
            setEnabled(false);
            setDisabledTextColor(Color.black);
        }
        else
        {
            setEnabled(true);
            setDisabledTextColor(Color.black);
        }
    }

    //##################################################
    //# focus listener
    //##################################################

    @Override
    public void focusGained(FocusEvent ev)
    {
        if ( _selectOnFocus )
        {
            int n = getDocument().getLength();
            select(0, n);
        }
        repaint();
    }

    @Override
    public void focusLost(FocusEvent ev)
    {
        handleAccept();
    }

    public void handleAccept()
    {
        if ( !isTextValid() )
        {
            updateForChangeError();
            repaint();
            return;
        }

        if ( hasChanged() )
        {
            updateForChange();
            getAcceptActions().fire();
            getChangeActions().fire();
            repaint();
            return;
        }

        getAcceptActions().fire();
    }

    //##################################################
    //# key listener
    //##################################################

    @Override
    public void keyTyped(KeyEvent ev)
    {
        if ( _forceUpperCase )
            forceToUpperCase(ev);
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

    public KmaAction newEnterAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleAccept();
                if ( _selectOnFocus )
                    selectAll();
            }
        };
    }

    //##################################################
    //# actions
    //##################################################

    public KmaAction newHelpAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleHelp();
            }
        };
    }

    public KmaAction newExtendedEditAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleExtendedEdit();
            }
        };
    }

    public KmaAction newCancelAction()
    {
        return new KmaAction()
        {
            @Override
            public void invoke()
            {
                handleCancel();
            }
        };
    }

    public KmaAction newAcceptAction()
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

    //##################################################
    //# handlers
    //##################################################

    public void handleHelp()
    {
        String t = "Help: " + getHelpTitle();
        String m = getHelpMessage();
        KmaAwtUtility.showMessage(this, t, m);
    }

    public void handleCancel()
    {
        updateText();
    }

    //##################################################
    //# actions
    //##################################################

    public KmaActionList getAcceptActions()
    {
        return _actions.get("accept");
    }

    public KmaActionList getChangeActions()
    {
        return _actions.get("change");
    }

    public KmaActionList getErrorActions()
    {
        return _actions.get("error");
    }

    public KmaActionList getDocumentChangeActions()
    {
        return _actions.get("documentChange");
    }

    //##################################################
    //# document listener
    //##################################################

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        getDocumentChangeActions().fire();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        getDocumentChangeActions().fire();
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        getDocumentChangeActions().fire();
    }

    //##################################################
    //# utility
    //##################################################

    public void clear()
    {
        setText("");
    }

    public void forceToUpperCase(KeyEvent ev)
    {
        char c = ev.getKeyChar();
        if ( c == KeyEvent.CHAR_UNDEFINED )
            return;

        if ( !Character.isLowerCase(c) )
            return;

        c = Character.toUpperCase(c);
        ev.setKeyChar(c);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasChanged()
    {
        return !getText().equals(_oldText);
    }

    public boolean isEmpty()
    {
        return getText().equals("");
    }

    public boolean hasText()
    {
        return !isEmpty();
    }

    //##################################################
    //# validate
    //##################################################

    public boolean isTextValid()
    {
        String s = getText();
        return isTextValid(s);
    }

    //##################################################
    //# subclass override
    //##################################################

    //==================================================
    //= update
    //==================================================

    /**
     * I am used by subclasses keep a cached value of some
     * alternate data type like: int, float, boolean...
     * Use the current value of getText() to set the new
     * value of the cache.
     */
    public void updateValue()
    {
        _oldText = getText();
    }

    /**
     * I am used by subclasses keep a cached value of some
     * alternate data type like: int, float, boolean...
     * Use the current value of the cache to call setText()
     * with some standard format of the value.
     */
    public void updateText()
    {
        setText(_oldText);
    }

    /**
     * I am used by subclasses to handle when my data changes
     * based on my configuration for allowing empty strings
     * and my current value
     */
    public void updateForChange()
    {
        updateValue();
        updateText();
    }

    public void updateForChangeError()
    {
        if ( _autoRevertToRange )
            if ( updateValueToRange() )
                return;

        if ( _autoRevertOnError )
            updateText();
        else
            getErrorActions().fire();
    }

    public boolean updateValueToRange()
    {
        return false;
    }

    //==================================================
    //= testing
    //==================================================

    public boolean isTextValid(String s)
    {
        if ( !getAllowEmpty() )
            if ( s.equals("") )
                return false;

        return true;
    }

    //==================================================
    //= help
    //==================================================

    public String getHelpTitle()
    {
        return "Text Field";
    }

    public String getHelpMessage()
    {
        return "Enter some text.";
    }

    //##################################################
    //# handlers
    //##################################################

    public void handleExtendedEdit()
    {
        if ( _extendedEditAction != null )
            _extendedEditAction.invoke();
    }

    public KmaAction newAction(String msg)
    {
        return new KmaBlockAction(this, msg);
    }

}
