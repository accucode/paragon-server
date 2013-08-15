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

package com.kodemore.phonetic;

import com.kodemore.utility.Kmu;

/**
 * I sort strings accoding to their edit distance relative to
 * some common string.  The edit distance indicates how different
 * two string are from one another.
 */
public class KmAdjustedEditDistanceComparator
    extends KmEditDistanceComparator
{
    //##################################################
    //# constructor
    //##################################################

    public KmAdjustedEditDistanceComparator()
    {
        super();
    }

    public KmAdjustedEditDistanceComparator(String base)
    {
        super(base);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compare(String s1, String s2)
    {
        double d1 = Kmu.getAdjustedEditDistance(getBase(), s1);
        double d2 = Kmu.getAdjustedEditDistance(getBase(), s2);
        if ( d1 < d2 )
            return -1;
        if ( d1 > d2 )
            return 1;
        return 0;
    }

}
