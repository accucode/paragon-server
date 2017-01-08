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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

/**
 * http://www.eyecon.ro/colorpicker/
 */
public class ScColorField
    extends ScAbstractTextField<KmHtmlColor>
{
    //##################################################
    //# constructor
    //##################################################

    public ScColorField()
    {
    }

    //##################################################
    //# conversion
    //##################################################

    @Override
    protected KmHtmlColor textToValue(String text)
    {
        return Kmu.hasValue(text)
            ? KmHtmlColor.create(text)
            : null;
    }

    @Override
    protected String valueToText(KmHtmlColor value)
    {
        return value != null
            ? value.getHexValue()
            : "";
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public KmHtmlColor getSampleValue()
    {
        return KmHtmlColor.createBlack();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderPostDomOn(KmHtmlBuilder out)
    {
        super.renderPostDomOn(out);
        out.getPostDom().run("Kmu.installColorField('%s');", getInputSelector());
    }

}
