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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;

/**
 * Render children as an accordion.
 * The label of each child acts as the title.
 * Clients should usually add block level children such as divs or boxes.
 *
 * Depends on: jquery, jqueryUI.
 * http://api.jqueryui.com/accordion/
 */
public final class ScAccordion
    extends ScDiv
{
    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        super.renderControlOn(out);

        out.getPostDom().run("%s.accordion(%s);", getJqueryReference(), getOptions());
    }

    @Override
    protected void renderChildOn(KmHtmlBuilder out, ScControl e)
    {
        out.printHeader(1, e.getLabel());

        super.renderChildOn(out, e);
    }

    //##################################################
    //# support
    //##################################################

    private KmJsonMap getOptions()
    {
        KmJsonMap v;
        v = new KmJsonMap();
        v.setInteger("animate", 100);
        v.setBoolean("collapsible", true);
        v.setString("heightStyle", "content");
        return v;
    }

}
