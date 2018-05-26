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

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

public enum KmTimeUnit
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    /**
     * WARNING: These code may be used in the database and changing
     * them will require a database migration.
     */
    Second("second"),
    Minute("minute"),
    Hour("hour"),
    Day("day"),
    Week("week"),
    Month("month"),
    Year("year");

    //##################################################
    //# variables
    //##################################################

    /**
     * A code that can be used to save values into the database
     */
    private String _code;

    //##################################################
    //# constructor
    //##################################################

    private KmTimeUnit(String code)
    {
        _code = code;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    //##################################################
    //# find
    //##################################################

    public static KmTimeUnit findCode(String e)
    {
        for ( KmTimeUnit unit : values() )
            if ( unit.hasCode(e) )
                return unit;

        return null;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getLabel()
    {
        String label = Kmu.formatCamelCaseAsCapitalizedWords(name());
        return Kmu.pluralize(label);
    }

    public String formatLabelFor(int qty)
    {
        return Kmu.pluralize(qty, getCode());
    }

    public String formatLabelFor(double qty)
    {
        return Kmu.pluralize(qty, getCode());
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmList<KmTimeUnit> getValues()
    {
        return KmList.createWith(values());
    }

    public static KmList<KmTimeUnit> getValues(KmTimeUnit from, KmTimeUnit to)
    {
        int fromIndex = from == null
            ? 0
            : from.ordinal();

        int toIndex = to == null
            ? values().length
            : to.ordinal();

        KmList<KmTimeUnit> v;
        v = getValues();
        return v.select(e -> e.ordinal() >= fromIndex && e.ordinal() <= toIndex);
    }
}
