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

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

public class KmaAction
    extends AbstractAction
{
    //##################################################
    //# constructors
    //##################################################

    public KmaAction()
    {
        initialize();
        setName("");
    }

    public KmaAction(String s)
    {
        initialize();
        setName(s);
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        // hook for subclasses
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String getName()
    {
        return (String)getValue(NAME);
    }

    public void setName(String s)
    {
        putValue(NAME, s);
    }

    public String getShortDescription()
    {
        return (String)getValue(SHORT_DESCRIPTION);
    }

    public void setShortDescription(String s)
    {
        putValue(SHORT_DESCRIPTION, s);
    }

    public String getLongDescription()
    {
        return (String)getValue(LONG_DESCRIPTION);
    }

    public void setLongDescription(String s)
    {
        putValue(LONG_DESCRIPTION, s);
    }

    //##################################################
    //# events
    //##################################################

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        actionPerformed();
    }

    public void actionPerformed()
    {
        invoke();
    }

    //##################################################
    //# accessing
    //##################################################

    public void invoke()
    {
        // hook for subclasses
    }

    //##################################################
    //# utility
    //##################################################

    public KmaButton newButton()
    {
        return newButton(getName());
    }

    public KmaButton newButton(String name)
    {
        KmaButton b;
        b = new KmaButton();
        b.setText(name);
        b.setEnabled(isEnabled());
        b.addActionListener(this);
        PropertyChangeListener l;
        l = _newPropertyChangeListener(b);
        addPropertyChangeListener(l);
        return b;
    }

    public JMenuItem newMenuItem()
    {
        JMenuItem i = new JMenuItem();
        i.setText(getName());
        i.addActionListener(this);
        return i;
    }

    //##################################################
    //# private
    //##################################################

    public PropertyChangeListener _newPropertyChangeListener(final KmaButton b)
    {
        return new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent ev)
            {
                String s = ev.getPropertyName();
                if ( s.equals("enabled") )
                {
                    Boolean enabledState = (Boolean)ev.getNewValue();
                    b.setEnabled(enabledState.booleanValue());
                    b.repaint();
                }
                if ( s.equals(Action.NAME) )
                {
                    String text = (String)ev.getNewValue();
                    b.setText(text);
                    b.repaint();
                }
                if ( s.equals(Action.SMALL_ICON) )
                {
                    Icon icon = (Icon)ev.getNewValue();
                    b.setIcon(icon);
                    b.invalidate();
                    b.repaint();
                }
            }
        };
    }

}
