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

package com.kodemore.servlet.control;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalObject;

/**
 * A simple, lightweight popup menu.
 * Based on 'popr'
 * http://www.tipue.com/popr/
 */
public class ScPopupMenuItem
{
    //##################################################
    //# variables
    //##################################################

    private String         _text;
    private ScAction       _action;
    private ScLocalObject  _argument;
    private ScLocalBoolean _visible;

    //##################################################
    //# constructor
    //##################################################

    public ScPopupMenuItem()
    {
        _text = "text";
        _action = null;
        _argument = new ScLocalObject();
        _visible = new ScLocalBoolean(true);
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    //##################################################
    //# action
    //##################################################

    public ScAction getAction()
    {
        return _action;
    }

    public void setAction(ScAction e)
    {
        _action = e;
    }

    //==================================================
    //= action argument
    //==================================================

    public Object getArgument()
    {
        return _argument.getValue();
    }

    public void setArgument(Object e)
    {
        _argument.setValue(e);
    }

    //##################################################
    //# visible
    //##################################################

    public boolean getVisible()
    {
        return _visible.isTrue();
    }

    public void setVisible(boolean e)
    {
        _visible.setValue(e);
    }

    public boolean isVisible()
    {
        return getVisible();
    }

    public void show()
    {
        setVisible(true);
    }

    public void hide()
    {
        setVisible(false);
    }
}
