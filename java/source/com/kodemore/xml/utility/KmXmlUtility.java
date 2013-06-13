/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.xml.utility;

import com.kodemore.utility.Kmu;

public class KmXmlUtility
{
    public static String escape(String s)
    {
        s = Kmu.replaceAll(s, "&", "&amp;");
        s = Kmu.replaceAll(s, "<", "&lt;");
        s = Kmu.replaceAll(s, ">", "&gt;");
        s = Kmu.replaceAll(s, "'", "&apos;");
        s = Kmu.replaceAll(s, "\"", "&quot;");
        return s;
    }

    public static boolean isWhitespace(String s)
    {
        for ( char c : s.toCharArray() )
            if ( !isWhitespace(c) )
                return false;
        return true;
    }

    public static boolean hasWhitespace(String s)
    {
        for ( char c : s.toCharArray() )
            if ( isWhitespace(c) )
                return true;
        return false;
    }

    public static boolean hasNonWhitespace(String s)
    {
        return !isWhitespace(s);
    }

    public static boolean isWhitespace(char c)
    {
        if ( c == ' ' )
            return true;

        if ( c == '\t' )
            return true;

        if ( c == '\n' )
            return true;

        if ( c == '\r' )
            return true;

        return false;
    }
}
