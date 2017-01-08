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

import java.util.Iterator;

import com.kodemore.collection.KmList;

public class KmaRangeSpinner
    extends KmaSpinner
{
    //##################################################
    //# variables
    //##################################################

    private int               _value;
    private int               _leftValue;
    private int               _rightValue;
    private int               _step;

    private KmList<KmaAction> _changeActions;

    //##################################################
    //# constructors
    //##################################################

    public KmaRangeSpinner()
    {
        _value = 0;
        _leftValue = 0;
        _rightValue = 10;
        _step = 1;

        _changeActions = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getLeftValue()
    {
        return _leftValue;
    }

    public void setLeftValue(int e)
    {
        _leftValue = e;
    }

    public int getRightValue()
    {
        return _rightValue;
    }

    public void setRightValue(int e)
    {
        _rightValue = e;
    }

    public int getStep()
    {
        return _step;
    }

    public void setStep(int e)
    {
        _step = e;
    }

    public int getValue()
    {
        return _value;
    }

    public void setValue(int e)
    {
        _value = e;
    }

    //##################################################
    //# update
    //##################################################

    @Override
    public void handleLeft()
    {
        int old = _value;

        if ( _leftValue < _rightValue )
            _value -= _step;
        else
            _value += _step;

        checkBounds();

        if ( old != _value )
            fireChangeActions();
    }

    @Override
    public void handleRight()
    {
        int old = _value;

        if ( _leftValue < _rightValue )
            _value += _step;
        else
            _value -= _step;

        checkBounds();

        if ( old != _value )
            fireChangeActions();
    }

    public void checkBounds()
    {
        if ( _value < getMinValue() )
            _value = getMinValue();

        if ( _value < getMaxValue() )
            _value = getMaxValue();
    }

    public int getMinValue()
    {
        return Math.min(_leftValue, _rightValue);
    }

    public int getMaxValue()
    {
        return Math.max(_leftValue, _rightValue);
    }

    //##################################################
    //# listeners
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
        Iterator<KmaAction> i = _changeActions.iterator();
        while ( i.hasNext() )
        {
            KmaAction a = i.next();
            a.invoke();
        }
    }

}
