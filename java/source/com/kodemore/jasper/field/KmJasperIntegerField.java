/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper.field;

import com.kodemore.jasper.KmJasperExpression;
import com.kodemore.jasper.KmJasperType;

public class KmJasperIntegerField
    extends KmJasperField
{
    //##################################################
    //# constructor
    //##################################################

    public KmJasperIntegerField(String name)
    {
        super(name);
    }

    //##################################################
    //# type
    //##################################################

    @Override
    public KmJasperType getType()
    {
        return KmJasperType.Integer;
    }

    //##################################################
    //# expressions
    //##################################################

    public KmJasperExpression exprIsEven()
    {
        return exprHasRemainder(2, 0);
    }

    public KmJasperExpression exprIsOdd()
    {
        return exprHasRemainder(2, 1);
    }

    public KmJasperExpression exprHasRemainder(int divisor, int remainder)
    {
        return exprWrapBoolean("%s.intValue() %% %s == %s", formatToken(), divisor, remainder);
    }

    public KmJasperExpression exprIsNegative()
    {
        return exprIsLessThan(0);
    }

    public KmJasperExpression exprIsNotNegative()
    {
        return exprIsNotLessThan(0);
    }

    public KmJasperExpression exprIsPositive()
    {
        return exprIsGreaterThan(0);
    }

    public KmJasperExpression exprIsNotPositive()
    {
        return exprIsNotGreaterThan(0);
    }

    public KmJasperExpression exprIsLessThan(int i)
    {
        return exprWrapBoolean("%s.intValue() < %s", formatToken(), i);
    }

    public KmJasperExpression exprIsLessThanOrEqualTo(int i)
    {
        return exprWrapBoolean("%s.intValue() <= %s", formatToken(), i);
    }

    public KmJasperExpression exprIsNotLessThan(int i)
    {
        return exprIsGreaterThanOrEqualTo(i);
    }

    public KmJasperExpression exprIsGreaterThan(int i)
    {
        return exprWrapBoolean("%s.intValue() > %s", formatToken(), i);
    }

    public KmJasperExpression exprIsGreaterThanOrEqualTo(int i)
    {
        return exprWrapBoolean("%s.intValue() >= %s", formatToken(), i);
    }

    public KmJasperExpression exprIsNotGreaterThan(int i)
    {
        return exprIsLessThanOrEqualTo(i);
    }
}
