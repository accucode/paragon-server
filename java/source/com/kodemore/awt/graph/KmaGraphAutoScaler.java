/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.awt.graph;

import com.kodemore.utility.Kmu;

public class KmaGraphAutoScaler
{
    //##################################################
    //# variables
    //##################################################

    private double   _minimum;
    private double   _maximum;
    private int      _maximumDivisions;
    private double   _minimumLower;

    private double   _lower;
    private double   _upper;
    private double   _majorUnit;
    private double   _minorUnit;

    private double[] _majorUnitOptions;
    private double[] _minorUnitOptions;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphAutoScaler()
    {
        _majorUnitOptions = new double[]
        {
            1,
            2,
            4,
            5,
            8
        };
        _minorUnitOptions = new double[]
        {
            0.2,
            0.5,
            1,
            1,
            2
        };
        _maximumDivisions = 10;
        _minimumLower = 0;
    }

    //##################################################
    //# accessing (setup)
    //##################################################

    public double getMinimum()
    {
        return _minimum;
    }

    public void setMinimum(double e)
    {
        _minimum = e;
    }

    public double getMaximum()
    {
        return _maximum;
    }

    public void setMaximum(double e)
    {
        _maximum = e;
    }

    public int getMaximumDivisions()
    {
        return _maximumDivisions;
    }

    public void setMaximumDivisions(int e)
    {
        _maximumDivisions = e;
    }

    public double[] getMajorUnitOptions()
    {
        return _majorUnitOptions;
    }

    public void setMajorUnitOptions(double[] arr)
    {
        _majorUnitOptions = arr;
    }

    public double[] getMinorUnitOptions()
    {
        return _minorUnitOptions;
    }

    public void setMinorUnitOptions(double[] arr)
    {
        _minorUnitOptions = arr;
    }

    public double getMinimumLower()
    {
        return _minimumLower;
    }

    public void setMinimumLower(double e)
    {
        _minimumLower = e;
    }

    //##################################################
    //# accessing (results)
    //##################################################

    public double getLower()
    {
        return _lower;
    }

    public double getUpper()
    {
        return _upper;
    }

    public double getMajorUnit()
    {
        return _majorUnit;
    }

    public double getMinorUnit()
    {
        return _minorUnit;
    }

    //##################################################
    //# actions
    //##################################################

    public void computeAutoUnits()
    {
        int maxDivs = getMaximumDivisions();
        double minValue = getMinimum();
        double maxValue = getMaximum();

        double units[] = getMajorUnitOptions();
        int n = units.length;
        int m = 1;
        while ( true )
        {
            for ( int i = 0; i < n; i++ )
            {
                double u = units[i] * m;
                double lower = (int)(minValue / u) * u;

                if ( Kmu.isNearEqual(lower, minValue) )
                    lower -= u;

                if ( lower < _minimumLower )
                    lower = _minimumLower;

                double upper = ((int)(maxValue / u) + 1) * u;
                double divs = (upper - lower) / u;
                if ( divs <= maxDivs )
                {
                    _lower = lower;
                    _upper = upper;
                    _majorUnit = u;
                    _minorUnit = getMinorUnitOptions()[i] * m;
                    return;
                }
            }
            m *= 10;
        }
    }

    //##################################################
    //# display
    //##################################################

    public void printDebug()
    {
        System.out.println("AutoScaler");
        System.out.println("    Setup");
        System.out.println("        min:  " + getMinimum());
        System.out.println("        max:  " + getMaximum());
        System.out.println("        divs: " + getMaximumDivisions());
        System.out.println("    Results");
        System.out.println("        lower: " + getLower());
        System.out.println("        upper: " + getUpper());
        System.out.println("        major: " + getMajorUnit());
        System.out.println("        minor: " + getMinorUnit());
        System.out.println("        divs:  " + (int)((getUpper() - getLower()) / getMajorUnit()));
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmaGraphAutoScaler e = new KmaGraphAutoScaler();
        e.setMinimum(0);
        e.setMaximum(100);
        e.setMaximumDivisions(12);
        e.computeAutoUnits();
        e.printDebug();
    }
}
