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

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class KmaIntegerSpinnerField
    extends KmaIntegerField
{
    //##################################################
    //# variables
    //##################################################

    private int _step;

    //##################################################
    //# constructor
    //##################################################

    public KmaIntegerSpinnerField()
    {
        _step = 1;

        registerKeyboardAction(
            newAction("guiStepUp"),
            KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
            WHEN_FOCUSED);

        registerKeyboardAction(
            newAction("guiStepDown"),
            KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
            WHEN_FOCUSED);
    }

    //##################################################
    //# accessing
    //##################################################

    public int getStep()
    {
        return _step;
    }

    public void setStep(int e)
    {
        _step = e;
    }

    //##################################################
    //# actions
    //##################################################

    public void guiStepUp()
    {
        _changeByStep(getStep());
    }

    public void guiStepDown()
    {
        _changeByStep(-getStep());
    }

    public void _changeByStep(int delta)
    {
        int i;

        if ( hasValue() )
            i = getValue() + delta;
        else
            if ( delta > 0 )
                i = getMinimumValue();
            else
                i = getMaximumValue();

        if ( i < getMinimumValue() )
            i = getMinimumValue();

        if ( i > getMaximumValue() )
            i = getMaximumValue();

        if ( i == getValue() )
            return;

        setValue(i);
        getAcceptActions().fire();
        getChangeActions().fire();
    }
}
