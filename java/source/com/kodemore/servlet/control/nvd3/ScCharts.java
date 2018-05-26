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

package com.kodemore.servlet.control.nvd3;

import com.kodemore.utility.Kmu;

/**
 * Static utilities for charts.
 */
public class ScCharts
{
    /**
     * Make a label safer for use in a chart.
     *
     * This is NOT 100% safe. To make this truly safe we will need to either
     * manually patch the Nvd3 library, or switch to a different charting library.
     *
     * As of Jan 2018, the current version of Nvd3 handles labels inconsistently.
     * Labels are treated as both html and plaintext.
     * This means there is no safe way for us to handle html control characters.
     * If we encode the labels to make them safe for html, the plaintext is not readable.
     * If we don't encode the labels, then we are subject to html injection bugs.
     *
     * The best solution available at present is to strip those characters that are
     * likely to cause problems. We strip EOL characters, angle brackets, quotes,
     * and any non-printable characters.
     */
    public static String toSafeLabel(String s)
    {
        s = Kmu.stripNonSingleLinePrintable(s);
        s = Kmu.stripCharacters(s, '\"');
        s = Kmu.stripCharacters(s, '\"');
        s = Kmu.stripCharacters(s, '<');
        s = Kmu.stripCharacters(s, '>');
        s = Kmu.stripCharacters(s, '\\');
        return s;
    }
}
