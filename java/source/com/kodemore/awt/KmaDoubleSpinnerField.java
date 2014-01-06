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

import javax.swing.KeyStroke;

import com.kodemore.utility.Kmu;

public class KmaDoubleSpinnerField
    extends KmaDoubleField
{
    //##################################################
    //# variables
    //##################################################

    private double _step;

    //##################################################
    //# constructor
    //##################################################

    public KmaDoubleSpinnerField()
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

    public double getStep()
    {
        return _step;
    }

    public void setStep(double e)
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

    public void _changeByStep(double delta)
    {
        double d;
        if ( hasValue() )
            d = getValue() + delta;
        else
            if ( delta > 0 )
                d = getMinimumValue();
            else
                d = getMaximumValue();

        if ( d < getMinimumValue() )
            d = getMinimumValue();

        if ( d > getMaximumValue() )
            d = getMaximumValue();

        if ( Kmu.isNearEqual(d, getValue()) )
            return;

        setValue(d);
        getAcceptActions().fire();
        getChangeActions().fire();
    }
}
