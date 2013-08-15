/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.types.KmQuantity;
import com.kodemore.utility.Kmu;

public class ScQuantityField
    extends ScAbstractTextField<KmQuantity>
{
    //##################################################
    //# value
    //##################################################

    @Override
    public KmQuantity getValueFor(String s)
    {
        return getFormatter().parseQuantity(s);
    }

    @Override
    public void setValue(KmQuantity value)
    {
        String s = getFormatter().formatQuantity(value);
        setText(s);
    }

    public void setValue(Double value)
    {
        if ( value == null )
            setValue((KmQuantity)null);
        else
            setValue(new KmQuantity(value));
    }

    @Override
    public String getSampleFormat()
    {
        return getFormatter().getQuantitySample();
    }

    @Override
    public String getInvalidMessage()
    {
        return "Invalid Quantity";
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( !Kmu.isAllDigitsWithOptionalLeadingNegativeCommasAndDecimal(getText()) )
        {
            addError("Cannot parse.");
            return false;
        }

        KmQuantity q = getValue();
        if ( q != null && q.isNegative() )
        {
            addError("Negative not allowed.");
            return false;
        }

        return true;
    }

}
