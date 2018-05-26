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
  THE SOFTWARE.S
*/

package com.kodemore.time;

import com.kodemore.types.KmDayFrequency;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

/**
 * Simple tests for the business hour calculator.
 */
public class KmBusinessHourCalculatorTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new KmBusinessHourCalculatorTest().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmBusinessHourCalculator _calculator;
    private KmTimestamp              _start;

    //##################################################
    //# test
    //##################################################

    public void run()
    {
        initCalculator();

        testFromJan29();
        testFromJanToFeb();
        testFromMarToFeb();
        testFromLeapYear();
        testAddSubtractSame();
    }

    private void testFromJan29()
    {
        setPolicyMF95();
        setStart("1/29/2018 10a");

        test("hours.a", addHours(1), "1/29/2018 11a");
        test("hours.b", addHours(8), "1/30/2018 10a");
        test("hours.c", addHours(24), "2/1/2018 10a");

        test("hours.d", subtractHours(1), "1/29/2018 9a");
        test("hours.e", subtractHours(8), "1/26/2018 10a");
        test("hours.f", subtractHours(24), "1/24/2018 10a");

        test("days.a", addDays(1), "1/30/2018 10a");
        test("days.b", addDays(4), "2/2/2018 10a");

        test("days.c", subtractDays(1), "1/26/2018 10a");
        test("days.d", subtractDays(4), "1/23/2018 10a");

        test("weeks.a", addWeeks(1), "2/5/2018 10a");

        test("weeks.b", subtractWeeks(1), "1/22/2018 10a");

        test("months.a", addMonths(1), "2/28/2018 10a");
        test("months.b", addMonths(2), "3/29/2018 10a");

        test("months.c", subtractMonths(1), "12/29/2017 10a");
        test("months.d", subtractMonths(2), "11/29/2017 10a");
    }

    private void testFromJanToFeb()
    {
        KmDayFrequency days;
        days = KmDayFrequency.EMPTY.addSaturday().addSunday().addMonday().addTuesday();

        KmBusinessHourPolicy policy;
        policy = new KmBusinessHourPolicy();
        policy.setStartTime(KmTimeParser.parseTime("9a"));
        policy.setEndTime(KmTimeParser.parseTime("5p"));
        policy.setDays(days);
        setPolicy(policy);

        setStart("1/30/2018 10a");
        test("janToFeb.a", addMonths(1), "3/3/2018 9a");
    }

    private void testFromMarToFeb()
    {
        KmDayFrequency days;
        days = KmDayFrequency.ALL;

        KmBusinessHourPolicy policy;
        policy = new KmBusinessHourPolicy();
        policy.setStartTime(KmTimeParser.parseTime("9a"));
        policy.setEndTime(KmTimeParser.parseTime("5p"));
        policy.setDays(days);
        setPolicy(policy);

        setStart("3/31/2018 10a");
        test("MarToFeb.a", subtractMonths(1), "2/28/2018 10a");
    }

    private void testFromLeapYear()
    {
        setPolicyMonSun95();
        setStart("2/29/2000 10a");

        test("learYear.a", addYears(1), "2/28/2001 10a");
        test("learYear.b", addYears(4), "2/29/2004 10a");

        test("learYear.c", subtractYears(1), "2/28/1999 10a");
        test("learYear.d", subtractYears(4), "2/29/1996 10a");
    }

    private void testAddSubtractSame()
    {
        System.out.println("addSubtract, starting...");

        KmTimestamp start;
        KmTimestamp added;
        KmTimestamp subtracted;

        setPolicyMF95();

        int n = 10000;
        for ( int i = 0; i < n; i++ )
        {
            start = createRandomBusinessTimestamp();
            KmUnitDuration d = createRandomDuration();
            added = _calculator.add(start, d);
            subtracted = _calculator.subtract(added, d);

            if ( !Kmu.isEqual(start, subtracted) )
            {
                System.out.println("ERROR!");
                System.out.println("    duration  : " + d);
                System.out.println("    start     : " + start);
                System.out.println("    added     : " + added);
                System.out.println("    subtracted: " + subtracted);
                break;
            }
        }
        System.out.println("addSubtract, done.");
    }

    //##################################################
    //# support
    //##################################################

    private void test(String msg, KmTimestamp actualTs, String expected)
    {
        KmTimestamp expectedTs;
        expectedTs = KmTimestampParser.parseTimestamp(expected);

        if ( expectedTs.equals(actualTs) )
        {
            System.out.println(msg + ", ok.");
            return;
        }

        System.out.println(msg + ", ERROR!");
        System.out.println("    expected: " + expectedTs);
        System.out.println("    actual:   " + actualTs);
    }

    //##################################################
    //# add
    //##################################################

    private KmTimestamp addHours(int i)
    {
        return _calculator.addHours(_start, i);
    }

    private KmTimestamp addDays(int i)
    {
        return _calculator.addDays(_start, i);
    }

    private KmTimestamp addWeeks(int i)
    {
        return _calculator.addWeeks(_start, i);
    }

    private KmTimestamp addMonths(int i)
    {
        return _calculator.addMonths(_start, i);
    }

    private KmTimestamp addYears(int i)
    {
        return _calculator.addYears(_start, i);
    }

    //##################################################
    //# subtract
    //##################################################

    private KmTimestamp subtractHours(int i)
    {
        return _calculator.subtractHours(_start, i);
    }

    private KmTimestamp subtractDays(int i)
    {
        return _calculator.subtractDays(_start, i);
    }

    private KmTimestamp subtractWeeks(int i)
    {
        return _calculator.subtractWeeks(_start, i);
    }

    private KmTimestamp subtractMonths(int i)
    {
        return _calculator.subtractMonths(_start, i);
    }

    private KmTimestamp subtractYears(int i)
    {
        return _calculator.subtractYears(_start, i);
    }

    //##################################################
    //# calculator
    //##################################################

    private void initCalculator()
    {
        _calculator = new KmBusinessHourCalculator();
    }

    private void setPolicy(KmBusinessHourPolicy e)
    {
        _calculator.setPolicy(e);
    }

    /**
     * Set a simple policy, Mon-Fri, 9-5.
     */
    private void setPolicyMF95()
    {
        KmBusinessHourPolicy e;
        e = new KmBusinessHourPolicy();
        e.setStartTime(KmTimeParser.parseTime("9a"));
        e.setEndTime(KmTimeParser.parseTime("5p"));
        e.setDays(KmDayFrequency.MONDAY_THROUGH_FRIDAY);
        setPolicy(e);
    }

    /**
     * Set a simple policy, Mon-Sun, 9-5.
     */
    private void setPolicyMonSun95()
    {
        KmBusinessHourPolicy e;
        e = new KmBusinessHourPolicy();
        e.setStartTime(KmTimeParser.parseTime("9a"));
        e.setEndTime(KmTimeParser.parseTime("5p"));
        e.setDays(KmDayFrequency.ALL);
        setPolicy(e);
    }

    //##################################################
    //# start
    //##################################################

    private void setStart(String s)
    {
        _start = KmTimestampParser.parseTimestamp(s);
    }

    //##################################################
    //# support
    //##################################################

    private KmTimestamp createRandomBusinessTimestamp()
    {
        KmTimestamp now = KmClock.getUtcTimestamp();

        int secs;
        secs = KmRandom.getInstance().getInteger(KmTimeConstantsIF.SECONDS_PER_YEAR_APPROXIMATE);
        KmUnitDuration d = KmUnitDuration.fromSeconds(secs);

        return _calculator.add(now, d);
    }

    private KmUnitDuration createRandomDuration()
    {
        // Secs-Weeks
        KmTimeUnit unit = KmTimeUnit.getValues(KmTimeUnit.Second, KmTimeUnit.Week).getRandom();

        // Months-Years
        //        KmTimeUnit unit = KmTimeUnit.getValues(KmTimeUnit.Month, KmTimeUnit.Year).getRandom();

        int value = KmRandom.getInstance().getInteger(12);
        return new KmUnitDuration(value, unit);
    }
}
