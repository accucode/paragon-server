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

import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * Run this script after the target's promise is done.
 */
public class ScWhenDoneAjax
    extends ScHtmlIdAjax
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The element to wait for.
     */
    private ScHtmlIdIF _waitFor;

    //##################################################
    //# constructor
    //##################################################

    public ScWhenDoneAjax(ScHtmlIdIF target, ScHtmlIdIF waitFor)
    {
        super(target, ScBlockScript.create());
        _waitFor = waitFor;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        out.print(begin());
        out.print("{");
        super.formatScriptOn(out);
        out.print(end());
    }

    @Override
    public void formatMultilineScriptOn(KmStringBuilder out)
    {
        out.println(begin());
        out.println("{");
        super.formatMultilineScriptOn(out);
        out.println(end());
    }

    private String begin()
    {
        String sel = _waitFor.getJquerySelector();
        return Kmu.format("$(%s).promise().done(function()", json(sel));
    }

    private String end()
    {
        return "});";
    }
}
