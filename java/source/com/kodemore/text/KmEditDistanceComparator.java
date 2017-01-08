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

package com.kodemore.text;

import com.kodemore.comparator.KmComparator;
import com.kodemore.utility.Kmu;

/**
 * I sort strings accoding to their edit distance relative to
 * some common string.  The edit distance indicates how different
 * two string are from one another.
 *
 * For additional information see:
 * http://en.wikipedia.org/wiki/Edit_distance
 * http://en.wikipedia.org/wiki/Levenshtein_distance
 */
public class KmEditDistanceComparator
    extends KmComparator<String>
{
    //##################################################
    //# variables
    //##################################################

    private String _base;

    //##################################################
    //# constructor
    //##################################################

    public KmEditDistanceComparator()
    {
        _base = "";
    }

    public KmEditDistanceComparator(String base)
    {
        _base = base;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getBase()
    {
        return _base;
    }

    public void setBase(String e)
    {
        _base = e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compare(String s1, String s2)
    {
        int i1 = Kmu.getEditDistance(getBase(), s1);
        int i2 = Kmu.getEditDistance(getBase(), s2);

        if ( i1 < i2 )
            return -1;
        if ( i1 > i2 )
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object e)
    {
        return e instanceof KmEditDistanceComparator
            && ((KmEditDistanceComparator)e).getBase().equals(getBase());
    }

    @Override
    public int hashCode()
    {
        return getBase().hashCode();
    }

}
