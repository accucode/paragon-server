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

package com.kodemore.servlet.utility;

import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.utility.Kmu;

public class ScJquery
{
    //##################################################
    //# reference
    //##################################################

    public static String formatReference(String e)
    {
        return Kmu.format("$('%s')", e);
    }

    public static String formatReference(ScHtmlIdIF e)
    {
        return formatReference(formatSelector(e));
    }

    public static String formatIdReference(String htmlId)
    {
        return formatReference(formatIdSelector(htmlId));
    }

    public static String formatClassReference(String css)
    {
        return formatReference(formatCssSelector(css));
    }

    //##################################################
    //# selectors
    //##################################################

    public static String formatSelector(String e)
    {
        return e;
    }

    public static String formatSelector(ScHtmlIdIF e)
    {
        return formatIdSelector(e.getHtmlId());
    }

    public static String formatIdSelector(String htmlId)
    {
        return "#" + htmlId;
    }

    public static String formatCssSelector(String css)
    {
        return "." + css;
    }

    //##################################################
    //# run on ready 
    //##################################################

    public static String runOnReady(String script)
    {
        return Kmu.format("$(function(){%s});", script);
    }

}
