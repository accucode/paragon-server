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

package com.kodemore.exception.error;

public class KmDecimalCharacteristicValidationError
    extends KmValidationError
{
    //##################################################
    //# variables
    //##################################################

    private double _value;
    private int    _length;

    //##################################################
    //# constructor
    //##################################################

    public KmDecimalCharacteristicValidationError(
        String model,
        String field,
        double value,
        int length)
    {
        super(model, field);
        _value = value;
        _length = length;
    }

    //##################################################
    //# accessing
    //##################################################

    public double getValue()
    {
        return _value;
    }

    public void setValue(double e)
    {
        _value = e;
    }

    public int getLength()
    {
        return _length;
    }

    public void setLength(int e)
    {
        _length = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatProblem(StringBuilder out)
    {
        out.append("maximum left digits is ");
        out.append(_length);
    }

}
