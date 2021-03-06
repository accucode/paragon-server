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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.time.KmDate;
import com.kodemore.utility.Kmu;

import com.app.utility.MyButtonUrls;

/**
 * http://jqueryui.com/demos/datepicker/
 */
public class ScDateField
    extends ScAbstractTextField<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public ScDateField()
    {
        setPlaceholder("mm/dd/yy");
    }

    //##################################################
    //# layout
    //##################################################

    @Override
    protected int getDefaultWidth()
    {
        return 130;
    }

    //##################################################
    //# conversion
    //##################################################

    @Override
    protected KmDate textToValue(String text)
    {
        return getFormatter().parseDate(text);
    }

    @Override
    protected String valueToText(KmDate value)
    {
        return getFormatter().formatDate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public KmDate getSampleValue()
    {
        return KmDate.fromYearMonthDay(2001, 1, 31);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderPostDomOn(KmHtmlBuilder out)
    {
        super.renderPostDomOn(out);
        out.getPostDom().run("%s.datepicker(%s);", getInputReference(), formatJqueryOptions());
    }

    private KmJsonMap formatJqueryOptions()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("showOn", "button");
        e.setString("showAnim", "slideDown");
        e.setString("buttonImage", MyButtonUrls.calendar());
        e.setBoolean("constrainInput", true);

        if ( hasTypeWatchAction() )
        {
            ScActionScript script;
            script = new ScActionScript();
            script.setAction(getTypeWatchAction());
            script.setBlockTarget(findBlockWrapper());
            script.setForm(findFormWrapper());
            script.formatScript();

            String fn;
            fn = Kmu.format("function(text,obj){%s}", script);

            e.setLiteral("onSelect", fn);
        }

        return e;
    }
}
