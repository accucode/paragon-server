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
        testRandom();
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
        policy.setTimeZone(KmTimeZone.SYSTEM_DEFAULT);
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
        policy.setTimeZone(KmTimeZone.SYSTEM_DEFAULT);
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

    private void testRandom()
    {
        System.out.println("addSubtract, starting...");

        int n = 10000;
        for ( int i = 0; i < n; i++ )
            if ( !_testRandom() )
                break;

        System.out.println("addSubtract, done.");
    }

    private boolean _testRandom()
    {
        setPolicyMF95();
        setStartRandom();

        KmTimestamp start = _calculator.getValue();
        KmUnitDuration duration = createRandomDuration();
        KmTimestamp add = _calculator.add(duration).getValue();
        KmTimestamp addNegative = _calculator.add(duration.negate()).getValue();
        KmTimestamp subtract = _calculator.subtract(duration).getValue();
        KmTimestamp end = _calculator.subtract(duration.negate()).getValue();

        if ( start.equals(end) )
            return true;

        System.out.println("ERROR!");
        System.out.println("    duration     : " + duration);
        System.out.println("    start        : " + start);
        System.out.println("    add(d)       : " + add);
        System.out.println("    add(-d)      : " + addNegative);
        System.out.println("    subtract(d)  : " + subtract);
        System.out.println("    subtract(-d) : " + end);
        return false;
    }

    //##################################################
    //# test
    //##################################################

    private void test(String msg, KmTimestamp actualTs, String expected)
    {
        KmTimestamp expectedTs;
        expectedTs = KmTimestampParser.parseTimestamp(expected);

        if ( actualTs.equals(expectedTs) )
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
        return _calculator.setValue(_start).addHours(i).getValue();
    }

    private KmTimestamp addDays(int i)
    {
        return _calculator.setValue(_start).addDays(i).getValue();
    }

    private KmTimestamp addWeeks(int i)
    {
        return _calculator.setValue(_start).addWeeks(i).getValue();
    }

    private KmTimestamp addMonths(int i)
    {
        return _calculator.setValue(_start).addMonths(i).getValue();
    }

    private KmTimestamp addYears(int i)
    {
        return _calculator.setValue(_start).addYears(i).getValue();
    }

    //##################################################
    //# subtract
    //##################################################

    private KmTimestamp subtractHours(int i)
    {
        return _calculator.setValue(_start).subtractHours(i).getValue();
    }

    private KmTimestamp subtractDays(int i)
    {
        return _calculator.setValue(_start).subtractDays(i).getValue();
    }

    private KmTimestamp subtractWeeks(int i)
    {
        return _calculator.setValue(_start).subtractWeeks(i).getValue();
    }

    private KmTimestamp subtractMonths(int i)
    {
        return _calculator.setValue(_start).subtractMonths(i).getValue();
    }

    private KmTimestamp subtractYears(int i)
    {
        return _calculator.setValue(_start).subtractYears(i).getValue();
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
        setPolicy(createPolicyMF95());
    }

    private KmBusinessHourPolicy createPolicyMF95()
    {
        KmBusinessHourPolicy e;
        e = new KmBusinessHourPolicy();
        e.setTimeZone(KmTimeZone.SYSTEM_DEFAULT);
        e.setStartTime(KmTimeParser.parseTime("9a"));
        e.setEndTime(KmTimeParser.parseTime("5p"));
        e.setDays(KmDayFrequency.MONDAY_THROUGH_FRIDAY);
        return e;
    }

    /**
     * Set a simple policy, Mon-Sun, 9-5.
     */
    private void setPolicyMonSun95()
    {
        KmBusinessHourPolicy e;
        e = new KmBusinessHourPolicy();
        e.setTimeZone(KmTimeZone.SYSTEM_DEFAULT);
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

    private void setStartRandom()
    {
        KmRandom r = KmRandom.getInstance();
        int secs = r.getInteger(KmTimeConstantsIF.SECONDS_PER_YEAR_APPROXIMATE);

        _calculator.setValueNow();
        _calculator.addSeconds(secs);
        _calculator.adjustValue();
    }

    //##################################################
    //# support
    //##################################################

    private KmUnitDuration createRandomDuration()
    {
        // Secs..Weeks
        KmTimeUnit unit = KmTimeUnit.getValues(KmTimeUnit.Second, KmTimeUnit.Week).getRandom();

        // Months..Years
        // KmTimeUnit unit = KmTimeUnit.getValues(KmTimeUnit.Month, KmTimeUnit.Year).getRandom();

        int value = KmRandom.getInstance().getInteger(100);
        return new KmUnitDuration(value, unit);
    }
}
