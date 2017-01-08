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

package com.kodemore.servlet.field;

import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.types.KmQuantity;

public class ScQuantityField
    extends ScAbstractTextField<KmQuantity>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean _allowsDecimals;

    //##################################################
    //# constructor
    //##################################################

    public ScQuantityField()
    {
        _allowsDecimals = new ScLocalBoolean(true);
        _allowsDecimals.setAutoSave();
    }

    //##################################################
    //# defaults
    //##################################################

    @Override
    protected int getDefaultWidth()
    {
        return 100;
    }

    //##################################################
    //# allows decimal
    //##################################################

    public boolean getAllowsDecimals()
    {
        return _allowsDecimals.getValue();
    }

    public void setAllowsDecimals(boolean e)
    {
        _allowsDecimals.setValue(e);
    }

    //##################################################
    //# conversion
    //##################################################

    @Override
    protected KmQuantity textToValue(String text)
    {
        if ( getAllowsDecimals() )
            return getFormatter().parseQuantity(text);

        Integer i = getFormatter().parseInteger(text);
        return i == null
            ? null
            : new KmQuantity(i);
    }

    @Override
    protected String valueToText(KmQuantity value)
    {
        return getFormatter().formatQuantity(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public KmQuantity getSampleValue()
    {
        return getAllowsDecimals()
            ? new KmQuantity(1.23)
            : KmQuantity.ONE;
    }

}
