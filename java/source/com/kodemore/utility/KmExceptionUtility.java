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

package com.kodemore.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

import com.kodemore.collection.KmList;

public class KmExceptionUtility
{
    //##################################################
    //# constants
    //##################################################

    public static final String NEW_LINE = "\n";

    //##################################################
    //# print
    //##################################################

    public static void print(Throwable ex)
    {
        System.out.println(format(ex));
    }

    //##################################################
    //# format
    //##################################################

    public static String format(Throwable ex)
    {
        StringBuilder sb = new StringBuilder();
        formatOn(sb, ex);
        return sb.toString();
    }

    public static String formatNormal(Throwable ex)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }

    //##################################################
    //# format (support)
    //##################################################

    public static void formatOn(StringBuilder sb, Throwable ex)
    {
        KmList<Throwable> v = getExceptionChain(ex);
        v.reverse();

        Iterator<Throwable> i = v.iterator();
        Throwable cause = i.next();
        formatLongOn(sb, cause);

        while ( i.hasNext() )
            formatShortOn(sb, i.next(), cause);
    }

    public static void formatLongOn(StringBuilder sb, Throwable ex)
    {
        formatShortOn(sb, ex, ex.getStackTrace().length);
    }

    public static void formatShortOn(StringBuilder sb, Throwable ex, Throwable cause)
    {
        sb.append("Caused...");
        sb.append(NEW_LINE);
        int matches = countMatchingLines(ex, cause);
        if ( matches > 0 )
            matches--;
        int nonMatches = ex.getStackTrace().length - matches;
        formatShortOn(sb, ex, nonMatches);
        if ( matches > 0 )
        {
            sb.append("        ... ");
            sb.append(matches);
            sb.append(" more");
            sb.append(NEW_LINE);
        }
    }

    public static void formatShortOn(StringBuilder sb, Throwable ex, int lines)
    {
        sb.append(ex.getClass().getName());
        if ( ex.getMessage() != null )
        {
            sb.append(": ");
            sb.append(ex.getMessage());
        }
        sb.append(NEW_LINE);
        StackTraceElement[] arr = ex.getStackTrace();
        int n = Math.min(arr.length, lines);
        for ( int i = 0; i < n; i++ )
        {
            sb.append("        at ");
            sb.append(arr[i].toString());
            sb.append(NEW_LINE);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public static Throwable getCause(Throwable ex)
    {
        Throwable cause;
        while ( true )
        {
            cause = ex.getCause();
            if ( cause == null )
                return ex;
            ex = cause;
        }
    }

    //##################################################
    //# misc
    //##################################################

    /**
     * Count the number of lines that match between an exception and some
     * cause.  The comparison is performed from the end of the stack trace.
     */
    public static int countMatchingLines(Throwable ex, Throwable cause)
    {
        StackTraceElement[] exElements = ex.getStackTrace();
        StackTraceElement[] causeElements = cause.getStackTrace();

        int i = 0;
        int n = Math.min(exElements.length, causeElements.length);
        while ( i < n )
        {
            StackTraceElement exElement = exElements[exElements.length - i - 1];
            StackTraceElement causeElement = causeElements[causeElements.length - i - 1];
            if ( !causeElement.equals(exElement) )
                break;
            i++;
        }
        return i;
    }

    /**
     * Return the chain of exceptions that led to this exception.
     */
    public static KmList<Throwable> getExceptionChain(Throwable ex)
    {
        KmList<Throwable> v = new KmList<Throwable>();
        while ( true )
        {
            v.add(ex);
            ex = ex.getCause();
            if ( ex == null )
                break;
        }
        return v;
    }

}
