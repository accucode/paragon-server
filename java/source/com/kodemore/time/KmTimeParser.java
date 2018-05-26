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

package com.kodemore.time;

import java.util.Iterator;

import com.kodemore.utility.Kmu;

/**
 * I define a basic time parser.
 */
public class KmTimeParser
    implements KmTimeParserIF
{
    //##################################################
    //# static
    //##################################################

    public static KmTime parseTime(String s)
    {
        return new KmTimeParser().parse(s);
    }

    //##################################################
    //# variables
    //##################################################

    private boolean _hour12; // 12 hour clock or military time

    //##################################################
    //# constructor
    //##################################################

    public KmTimeParser()
    {
        this(true);
    }

    public KmTimeParser(boolean hour12)
    {
        _hour12 = hour12;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public KmTime parse(String s)
    {
        if ( s == null )
            return null;

        s = s.trim();

        boolean hasPm = _hasPm(s);

        s = Kmu.stripLetters(s);
        s = s.replace(':', '.');

        int hh = 0;
        int mm = 0;
        int ss = 0;

        Iterator<String> i = Kmu.tokenize(s, '.').iterator();

        if ( i.hasNext() )
            hh = Kmu.parse_int(i.next(), -1);

        if ( i.hasNext() )
            mm = Kmu.parse_int(i.next(), -1);

        if ( i.hasNext() )
            ss = Kmu.parse_int(i.next(), -1);

        if ( hh < 0 )
            return null;

        if ( hh > 23 )
            return null;

        if ( mm < 0 )
            return null;

        if ( mm > 59 )
            return null;

        if ( ss < 0 )
            return null;

        if ( ss > 59 )
            return null;

        if ( _hour12 )
        {
            if ( hasPm && hh < 12 )
                hh += 12;

            if ( !hasPm && hh == 12 )
                hh = 0;
        }

        return KmTime.fromHourMinuteSecond(hh, mm, ss);
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean _hasPm(String s)
    {
        s = s.toLowerCase();

        if ( s.endsWith("pm") )
            return true;

        if ( s.endsWith("p") )
            return true;

        return false;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmTimeParser tp = new KmTimeParser();
        KmTime time;

        time = tp.parse("10:00");
        System.out.println("######");
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());

        time = tp.parse("04:42");
        System.out.println("######");
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
    }
}
