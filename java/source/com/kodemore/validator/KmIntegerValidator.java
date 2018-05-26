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

public class KmIntegerValidator
    extends KmValidator<Integer>
{
    //##################################################
    //# variables
    //##################################################

    private Integer _minimumValue;
    private Integer _maximumValue;

    //##################################################
    //# minimum value
    //##################################################

    public Integer getMinimumValue()
    {
        return _minimumValue;
    }

    public void setMinimumValue(Integer e)
    {
        _minimumValue = e;
    }

    //##################################################
    //# maximum value
    //##################################################

    public Integer getMaximumValue()
    {
        return _maximumValue;
    }

    public void setMaximumValue(Integer e)
    {
        _maximumValue = e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validateValueOn(Integer value, KmErrorList errors)
    {
        validateMinimumValue(value, errors);
        validateMaximumValue(value, errors);
    }

    private void validateMinimumValue(Integer value, KmErrorList errors)
    {
        Integer min = getMinimumValue();
        if ( min != null && value < min )
            errors.addMinimumValue(this, min + "");
    }

    private void validateMaximumValue(Integer value, KmErrorList errors)
    {
        Integer max = getMaximumValue();
        if ( max != null && value > max )
            errors.addMaximumValue(this, max + "");
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmIntegerValidator getCopy()
    {
        return (KmIntegerValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
