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

public class KmDoubleValidator
    extends KmValidator<Double>
{
    //##################################################
    //# variables
    //##################################################

    private int _allDigits;
    private int _rightDigits;

    private Double _minimumValue;
    private Double _maximumValue;

    //##################################################
    //# digits
    //##################################################

    public int getAllDigits()
    {
        return _allDigits;
    }

    public void setAllDigits(int e)
    {
        _allDigits = e;
    }

    public int getRightDigits()
    {
        return _rightDigits;
    }

    public void setRightDigits(int e)
    {
        _rightDigits = e;
    }

    //##################################################
    //# minimum value
    //##################################################

    public Double getMinimumValue()
    {
        return _minimumValue;
    }

    public void setMinimumValue(Double e)
    {
        _minimumValue = e;
    }

    //##################################################
    //# maximum value
    //##################################################

    public Double getMaximumValue()
    {
        return _maximumValue;
    }

    public void setMaximumValue(Double e)
    {
        _maximumValue = e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateValueOn(Double value, KmErrorList errors)
    {
        validateLength(value, errors);
        validateMinimumValue(value, errors);
        validateMaximumValue(value, errors);
    }

    public void validateLength(Double value, KmErrorList errors)
    {
        double d = value.doubleValue();
        int i = (int)d;
        String s = i + "";
        int wholeNumberLength = _allDigits - _rightDigits;

        if ( s.length() > wholeNumberLength )
            errors.addFieldError(this, "maximum left digits is " + wholeNumberLength);
    }

    private void validateMinimumValue(Double value, KmErrorList errors)
    {
        Double min = getMinimumValue();
        if ( min != null && value < min )
            errors.addMinimumValue(this, min + "");
    }

    private void validateMaximumValue(Double value, KmErrorList errors)
    {
        Double max = getMaximumValue();
        if ( max != null && value > max )
            errors.addMaximumValue(this, max + "");
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmDoubleValidator getCopy()
    {
        return (KmDoubleValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
