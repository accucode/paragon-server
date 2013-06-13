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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalString;

public class ScFieldset
    extends ScContainerElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX         = KmCssDefaultConstantsIF.fieldset_prefix;
    private static final String PART_BODY      = KmCssDefaultConstantsIF.fieldset_part_body;
    private static final String PART_LEGEND    = KmCssDefaultConstantsIF.fieldset_part_legend;
    private static final String FLAVOR_DEFAULT = KmCssDefaultConstantsIF.fieldset_flavor_default;

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _flavor;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldset()
    {
        _flavor = new ScLocalString();
        setFlavorDefault();
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    private void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    public void setFlavorDefault()
    {
        setFlavor(FLAVOR_DEFAULT);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderSimpleElementOn(out, "fieldset");
    }

    @Override
    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        renderLegend(out);

        super.renderChildrenOn(out);
    }

    private void renderLegend(KmHtmlBuilder out)
    {
        // <legend class="fieldset-legend-default">The Legend</legend>

        out.open("legend");
        out.printAttribute(formatLegendCss());
        out.close();

        if ( hasLabel() )
            out.print(getLabel());
        else
            out.printNonBreakingSpace();

        out.end("legend");
    }

    @Override
    public KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss();
        css.add(PREFIX, PART_BODY, getFlavor());
        return css;
    }

    public KmCssDefaultBuilder formatLegendCss()
    {
        KmCssDefaultBuilder css;
        css = newCssBuilder();
        css.add(PREFIX, PART_LEGEND, getFlavor());
        return css;
    }

}
