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
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalBoolean;

public class ScFieldLayout
    extends ScChildContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean _showsHelp;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _showsHelp = new ScLocalBoolean(true);
    }

    //##################################################
    //# shows help
    //##################################################

    public boolean getShowsHelp()
    {
        return _showsHelp.getValue();
    }

    public void setShowsHelp(boolean e)
    {
        _showsHelp.setValue(e);
    }

    public void showHelp()
    {
        setShowsHelp(true);
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public <T extends ScControl> T add(T e)
    {
        ScErrorWrapper w;
        w = new ScErrorWrapper();
        w.setChild(e);

        super.add(w);

        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderSimpleElementOn(out, "div");
    }

    @Override
    protected void renderChildOn(KmHtmlBuilder out, ScControl e)
    {
        out.beginDivCss(KmCssDefaultConstantsIF.fieldLayoutRow);

        renderLabelOn(out, e);
        renderHelpOn(out, e);
        renderFieldOn(out, e);

        out.endDiv();
    }

    private void renderLabelOn(KmHtmlBuilder out, ScControl e)
    {
        if ( !e.hasLabel() )
            return;

        out.beginSpanCss(KmCssDefaultConstantsIF.fieldLayoutLabel);
        out.print(e.getLabel());
        out.endSpan();
    }

    private void renderHelpOn(KmHtmlBuilder out, ScControl e)
    {
        if ( !getShowsHelp() )
            return;

        if ( !e.hasHelp() )
            return;

        out.printNonBreakingSpace();

        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.formHelp();

        KmStyleBuilder style;
        style = new KmStyleBuilder();
        // style.hide();

        out.open("img");
        out.printAttribute("title", e.getHelp());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();
        out.end("img");
    }

    private void renderFieldOn(KmHtmlBuilder out, ScControl e)
    {
        out.render(e);
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return css().fieldLayout();
    }

}
