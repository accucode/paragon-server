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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonUtility;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.string.KmStringBuilder;

/**
 * I manage a list of scripts, roughly representing the
 * contents of a "block".  That is, the lines _between_
 * matching braces {...}.
 *
 * NOTE: In many cases, clients will simply use my helper
 * methods such as toast(...).  However, when clients
 * directly compose their own script, then those clients
 * are responsible for manually including any appropriate
 * whitespace or terminators.  The basic add/run methods
 * do NOT automatically add any spaced, linefeeds, or
 * semi-colons.
 */
public abstract class ScAbstractScript
    implements ScScriptIF, CharSequence
{
    //##################################################
    //# display
    //##################################################

    /**
     * Return the formatted script, runnable in javascript.
     */
    @Override
    public final String toString()
    {
        return formatScript();
    }

    //##################################################
    //# char sequence
    //##################################################

    @Override
    public int length()
    {
        return toString().length();
    }

    @Override
    public char charAt(int index)
    {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return toString().subSequence(start, end);
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public final String formatScript()
    {
        KmStringBuilder out = new KmStringBuilder();
        formatScriptOn(out);
        return out.toString();
    }

    @Override
    public abstract void formatScriptOn(KmStringBuilder out);

    @Override
    public final String formatMultilineScript()
    {
        KmStringBuilder out = new KmStringBuilder();
        formatMultilineScriptOn(out);
        return out.toString();
    }

    @Override
    public void formatMultilineScriptOn(KmStringBuilder out)
    {
        formatScriptOn(out);
        out.println();
    }

    //##################################################
    //# support
    //##################################################

    protected String json(ScHtmlIdIF e)
    {
        return json(e.getJquerySelector());
    }

    protected String json(CharSequence s)
    {
        return KmJsonUtility.format(s);
    }

    protected String json(Boolean e)
    {
        return KmJsonUtility.format(e);
    }

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected String formatReference(ScHtmlIdIF target)
    {
        return ScJquery.formatReference(target);
    }

}
