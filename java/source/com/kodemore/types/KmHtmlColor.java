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

package com.kodemore.types;

import java.io.Serializable;

import com.kodemore.utility.Kmu;

/**
 * I represent and html color as a string in the form #RRGGBB.
 */
public class KmHtmlColor
    implements Comparable<KmHtmlColor>, Serializable
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmHtmlColor create(String s)
    {
        s = normalize(s);

        return s == null
            ? null
            : new KmHtmlColor(s);
    }

    public static KmHtmlColor createBlack()
    {
        return create("#000000");
    }

    public static KmHtmlColor createDarkGray()
    {
        return create("#444444");
    }

    public static KmHtmlColor createYellow()
    {
        return create("#ffff00");
    }

    public static KmHtmlColor createRed()
    {
        return create("#FF0000");
    }

    public static KmHtmlColor createGreen()
    {
        return create("#00FF00");
    }

    public static KmHtmlColor createBlue()
    {
        return create("#0000FF");
    }

    //##################################################
    //# static: common
    //##################################################

    private static String normalize(String s)
    {
        if ( s == null )
            return null;

        s = Kmu.removePrefix(s, "#");
        s = s.toUpperCase();

        if ( !Kmu.isAllHexDigits(s) )
            return null;

        if ( s.length() == 6 )
            return "#" + s;

        if ( s.length() == 3 )
        {
            StringBuilder out;
            out = new StringBuilder();
            out.append("#");
            out.append(s.charAt(0));
            out.append(s.charAt(0));
            out.append(s.charAt(1));
            out.append(s.charAt(1));
            out.append(s.charAt(2));
            out.append(s.charAt(2));
            return out.toString();
        }

        return null;
    }

    //##################################################
    //# variables
    //##################################################

    private String _hexValue;

    //##################################################
    //# constructor
    //##################################################

    private KmHtmlColor(String e)
    {
        _hexValue = normalize(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getHexValue()
    {
        return _hexValue;
    }

    public boolean hasHexValue(String e)
    {
        return _hexValue.equals(e);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmHtmlColor) )
            return false;

        return ((KmHtmlColor)e).hasHexValue(_hexValue);
    }

    @Override
    public int hashCode()
    {
        return _hexValue.hashCode();
    }

    @Override
    public int compareTo(KmHtmlColor e)
    {
        return _hexValue.compareTo(e.getHexValue());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getHexValue();
    }

}
