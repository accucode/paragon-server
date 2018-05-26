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
import com.kodemore.types.KmQuantity;

public class KmQuantityValidator
    extends KmValidator<KmQuantity>
{
    //##################################################
    //# variables
    //##################################################

    private KmQuantity _minimumValue;
    private KmQuantity _maximumValue;

    //##################################################
    //# minimum value
    //##################################################

    public KmQuantity getMinimumValue()
    {
        return _minimumValue;
    }

    public void setMinimumValue(KmQuantity e)
    {
        _minimumValue = e;
    }

    //##################################################
    //# maximum value
    //##################################################

    public KmQuantity getMaximumValue()
    {
        return _maximumValue;
    }

    public void setMaximumValue(KmQuantity e)
    {
        _maximumValue = e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateValueOn(KmQuantity value, KmErrorList errors)
    {
        validateMinimumValue(value, errors);
        validateMaximumValue(value, errors);
    }

    private void validateMinimumValue(KmQuantity value, KmErrorList errors)
    {
        KmQuantity min = getMinimumValue();
        if ( min != null && value.isLessThan(min) )
            errors.addMinimumValue(this, min.format());
    }

    private void validateMaximumValue(KmQuantity value, KmErrorList errors)
    {
        KmQuantity max = getMaximumValue();
        if ( max != null && value.isGreaterThan(max) )
            errors.addMaximumValue(this, max.format());
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmQuantityValidator getCopy()
    {
        return (KmQuantityValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
