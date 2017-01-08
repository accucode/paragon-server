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

package com.kodemore.time;

import java.time.Month;
import java.time.Year;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I define a basic date parser.  Options may be set for various parsing
 * methods.
 */
public class KmDateParser
    implements KmDateParserIF, KmConstantsIF
{
    //##################################################
    //# static
    //##################################################

    public static KmDate parseDate(String s)
    {
        return new KmDateParser().parse(s);
    }

    public static KmDate parseXsd(String s)
    {
        KmDateParser e;
        e = new KmDateParser();
        e.setSeparator('-');
        e.setOneNumberMode(ONE_NUMBER_MODE_NONE);
        e.setTwoNumberMode(TWO_NUMBER_MODE_NONE);
        e.setThreeNumberMode(THREE_NUMBER_MODE_YEAR_MONTH_DAY);
        return e.parse(s);
    }

    //##################################################
    //# static
    //##################################################

    // kludge: change to enum
    public static final int ONE_NUMBER_MODE_NONE                   = 0;
    public static final int ONE_NUMBER_MODE_DAY_OFFSET             = 1;

    public static final int TWO_NUMBER_MODE_NONE                   = 0;
    public static final int TWO_NUMBER_MODE_MONTH_DAY_CLOSEST_YEAR = 1;
    public static final int TWO_NUMBER_MODE_MONTH_DAY_CURRENT_YEAR = 2;
    public static final int TWO_NUMBER_MODE_MONTH_YEAR_FIRST_DAY   = 3;
    public static final int TWO_NUMBER_MODE_MONTH_YEAR_LAST_DAY    = 4;

    public static final int THREE_NUMBER_MODE_NONE                 = 0;
    public static final int THREE_NUMBER_MODE_MONTH_DAY_YEAR       = 1;
    public static final int THREE_NUMBER_MODE_YEAR_MONTH_DAY       = 2;

    //##################################################
    //# variables
    //##################################################

    private char            _separator;
    private int             _centurySplitYear;
    private int             _minimumYear;
    private int             _maximumYear;

    private int             _oneNumberMode;
    private int             _twoNumberMode;
    private int             _threeNumberMode;

    //##################################################
    //# constructor
    //##################################################

    public KmDateParser()
    {
        _separator = '/';
        _centurySplitYear = 30;
        _minimumYear = 1800;
        _maximumYear = 9999;
        _oneNumberMode = ONE_NUMBER_MODE_DAY_OFFSET;
        _twoNumberMode = TWO_NUMBER_MODE_MONTH_DAY_CLOSEST_YEAR;
        _threeNumberMode = THREE_NUMBER_MODE_MONTH_DAY_YEAR;
    }

    //##################################################
    //# accessing
    //##################################################

    //==================================================
    //= separator
    //==================================================

    public char getSeparator()
    {
        return _separator;
    }

    public void setSeparator(char e)
    {
        _separator = e;
    }

    public void setSeparatorDash()
    {
        setSeparator('-');
    }

    public void setSeparatorSlash()
    {
        setSeparator('-');
    }

    //==================================================
    //= century split
    //==================================================

    public int getCenturySplitYear()
    {
        return _centurySplitYear;
    }

    public void setCenturySplitYear(int e)
    {
        _centurySplitYear = e;
    }

    //==================================================
    //= min year
    //==================================================

    public int getMinimumYear()
    {
        return _minimumYear;
    }

    public void setMinimumYear(int e)
    {
        _minimumYear = e;
    }

    //==================================================
    //= max year
    //==================================================

    public int getMaximumYear()
    {
        return _maximumYear;
    }

    public void setMaximumYear(int e)
    {
        _maximumYear = e;
    }

    //##################################################
    //# parse modes
    //##################################################

    public int getOneNumberMode()
    {
        return _oneNumberMode;
    }

    public void setOneNumberMode(int e)
    {
        _oneNumberMode = e;
    }

    public int getTwoNumberMode()
    {
        return _twoNumberMode;
    }

    public void setTwoNumberMode(int e)
    {
        _twoNumberMode = e;
    }

    public int getThreeNumberMode()
    {
        return _threeNumberMode;
    }

    public void setThreeNumberMode(int e)
    {
        _threeNumberMode = e;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public KmDate parse(String s)
    {
        try
        {
            if ( s == null )
                return null;

            KmList<Integer> arr = getFields(s);
            if ( arr.containsNull() )
                return null;

            switch ( arr.size() )
            {
                case 1:
                    return parse1(arr.get(0));

                case 2:
                    return parse2(arr.get(0), arr.get(1));

                case 3:
                    return parse3(arr.get(0), arr.get(1), arr.get(2));
            }

            return null;
        }
        catch ( IllegalArgumentException ex )
        {
            return null;
        }
    }

    public KmList<Integer> getFields(String s)
    {
        return Kmu.tokenize(s.trim(), _separator).collect(e -> Kmu.parseInteger(e));
    }

    //==================================================
    //= parse 1
    //==================================================

    private KmDate parse1(int a)
    {
        if ( _oneNumberMode == ONE_NUMBER_MODE_DAY_OFFSET )
            return parse1_dayOffset(a);

        return null;
    }

    private KmDate parse1_dayOffset(int a)
    {
        KmDate d = KmDate.todayUtc().addDays(a);

        int yy = d.getYear();
        if ( yy < _minimumYear )
            return null;

        if ( yy > _maximumYear )
            return null;

        return d;
    }

    //==================================================
    //= parse 2
    //==================================================

    private KmDate parse2(int a, int b)
    {
        if ( _twoNumberMode == TWO_NUMBER_MODE_MONTH_DAY_CLOSEST_YEAR )
            return parse2_mmdd_closestYear(a, b);

        if ( _twoNumberMode == TWO_NUMBER_MODE_MONTH_DAY_CURRENT_YEAR )
            return parse2_mmdd_currentYear(a, b);

        if ( _twoNumberMode == TWO_NUMBER_MODE_MONTH_YEAR_FIRST_DAY )
            return parse2_mmyy_firstDay(a, b);

        if ( _twoNumberMode == TWO_NUMBER_MODE_MONTH_YEAR_LAST_DAY )
            return parse2_mmyy_lastDay(a, b);

        return null;
    }

    private KmDate parse2_mmdd_closestYear(int a, int b)
    {
        int mm = a;
        int dd = b;

        KmDate today = KmDate.todayUtc();
        int yy = today.getYear();

        KmDate d1 = KmDate.fromYearMonthDay(yy - 1, mm, dd);
        KmDate d2 = KmDate.fromYearMonthDay(yy, mm, dd);
        KmDate d3 = KmDate.fromYearMonthDay(yy + 1, mm, dd);

        int n1 = Math.abs(d1.getDaysUntil(today));
        int n2 = Math.abs(d2.getDaysUntil(today));
        int n3 = Math.abs(d3.getDaysUntil(today));

        if ( n1 < n2 )
            return d1;

        if ( n3 < n2 )
            return d3;

        return d2;
    }

    private KmDate parse2_mmdd_currentYear(int a, int b)
    {
        int mm = a;
        int dd = b;
        int yy = KmDate.todayUtc().getYear();

        return createDate(yy, mm, dd);
    }

    private KmDate parse2_mmyy_firstDay(int a, int b)
    {
        int mm = a;
        int yy = coerceYear(b);
        int dd = 1;

        return createDate(yy, mm, dd);
    }

    private KmDate parse2_mmyy_lastDay(int a, int b)
    {
        int mm = a;
        int yy = coerceYear(b);

        boolean leap = Year.isLeap(yy);
        int dd = Month.of(mm).length(leap);

        return createDate(yy, mm, dd);
    }

    //==================================================
    //= parse 3
    //==================================================

    private KmDate parse3(int a, int b, int c)
    {
        if ( _threeNumberMode == THREE_NUMBER_MODE_MONTH_DAY_YEAR )
            return parse3_mmddyy(a, b, c);

        if ( _threeNumberMode == THREE_NUMBER_MODE_YEAR_MONTH_DAY )
            return parse3_yymmdd(a, b, c);

        return null;
    }

    private KmDate parse3_mmddyy(int a, int b, int c)
    {
        int mm = a;
        int dd = b;
        int yy = c;
        return createDate(yy, mm, dd);
    }

    private KmDate parse3_yymmdd(int a, int b, int c)
    {
        int yy = a;
        int mm = b;
        int dd = c;
        return createDate(yy, mm, dd);
    }

    //##################################################
    //# utility
    //##################################################

    public int coerceYear(int yy)
    {
        if ( yy == UNDEFINED_INT )
            return yy;

        if ( yy >= 100 )
            return yy;

        if ( yy >= _centurySplitYear )
            yy += 1900;

        else
            yy += 2000;

        return yy;
    }

    public KmDate createDate(int yy, int mm, int dd)
    {
        yy = coerceYear(yy);

        if ( mm < 1 )
            return null;

        if ( mm > 12 )
            return null;

        if ( yy < getMinimumYear() )
            return null;

        if ( yy > getMaximumYear() )
            return null;

        if ( dd < 1 )
            return null;

        if ( dd > KmDateUtility.getDaysInYearMonth(yy, mm) )
            return null;

        return KmDate.fromYearMonthDay(yy, mm, dd);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmDateParser p;
        p = new KmDateParser();
        p.setSeparator('-');
        p.setThreeNumberMode(KmDateParser.THREE_NUMBER_MODE_YEAR_MONTH_DAY);
        String s = "2016-07-31";
        KmDate d = p.parse(s);

        System.out.println("    s: " + s);
        System.out.println("    d: " + d);
    }
}
