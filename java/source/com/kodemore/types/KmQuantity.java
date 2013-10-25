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

package com.kodemore.types;

import java.math.BigDecimal;

public class KmQuantity
    extends KmFixedDecimal<KmQuantity>
{
    //##################################################
    //# constants
    //##################################################

    public static final KmQuantity ZERO               = new KmQuantity(0);
    public static final KmQuantity ONE                = new KmQuantity(1);

    public static final KmQuantity MAX                = new KmQuantity(9999999.99999);

    public static final int        DATABASE_PRECISION = 12;
    public static final int        SCALE              = 5;

    //##################################################
    //# constructor
    //##################################################

    public KmQuantity()
    {
        super(0.0);
    }

    public KmQuantity(double value)
    {
        super(value);
    }

    public KmQuantity(int value)
    {
        super(value);
    }

    protected KmQuantity(BigDecimal value)
    {
        super(value);
    }

    //##################################################
    //# policy
    //##################################################

    @Override
    public int getScale()
    {
        return SCALE;
    }

    //##################################################
    //# add
    //##################################################

    public KmQuantity addSafe(KmQuantity e)
    {
        try
        {
            return add(e);
        }
        catch ( Exception ex )
        {
            return MAX;
        }
    }

    public KmQuantity addSafe(double e)
    {
        try
        {
            return add(e);
        }
        catch ( Exception ex )
        {
            return MAX;
        }
    }

    public KmQuantity addSafe(int e)
    {
        try
        {
            return add(e);
        }
        catch ( Exception ex )
        {
            return MAX;
        }
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected KmQuantity newFixed(BigDecimal value)
    {
        return new KmQuantity(value);
    }

    @Override
    public KmQuantity getZero()
    {
        return ZERO;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        // throws exception
        //System.out.println(new KmQuantity(10000000.0));

        // now throws exception because of the KmFixedDecimal change. - good
        //System.out.println(new KmQuantity(Integer.MAX_VALUE));

        // now throws exception because of the KmFixedDecimal change. - good
        //BigDecimal bd = new BigDecimal(Long.MAX_VALUE);
        //System.out.println(new KmQuantity(bd));

        double d = -1.0;
        System.out.println(new KmQuantity(d));
    }

}
