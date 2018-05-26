/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.validator;

import com.kodemore.exception.error.KmErrorList;
import com.kodemore.types.KmMoney;

public class KmMoneyValidator
    extends KmValidator<KmMoney>
{
    //##################################################
    //# variables
    //##################################################

    private KmMoney _minimumValue;
    private KmMoney _maximumValue;

    //##################################################
    //# minimum value
    //##################################################

    public KmMoney getMinimumValue()
    {
        return _minimumValue;
    }

    public void setMinimumValue(KmMoney e)
    {
        _minimumValue = e;
    }

    //##################################################
    //# maximum value
    //##################################################

    public KmMoney getMaximumValue()
    {
        return _maximumValue;
    }

    public void setMaximumValue(KmMoney e)
    {
        _maximumValue = e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateValueOn(KmMoney value, KmErrorList errors)
    {
        validateMinimumValue(value, errors);
        validateMaximumValue(value, errors);
    }

    private void validateMinimumValue(KmMoney value, KmErrorList errors)
    {
        KmMoney min = getMinimumValue();
        if ( min != null && value.isLessThan(min) )
            errors.addMinimumValue(this, min.format());
    }

    private void validateMaximumValue(KmMoney value, KmErrorList errors)
    {
        KmMoney max = getMaximumValue();
        if ( max != null && value.isGreaterThan(max) )
            errors.addMaximumValue(this, max.format());
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmMoneyValidator getCopy()
    {
        return (KmMoneyValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
