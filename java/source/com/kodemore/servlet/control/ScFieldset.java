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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalString;

public class ScFieldset
    extends ScChildContainerElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX      = KmCssDefaultConstantsIF.fieldset_prefix;
    private static final String PART_BODY   = KmCssDefaultConstantsIF.fieldset_part_body;
    private static final String PART_LEGEND = KmCssDefaultConstantsIF.fieldset_part_legend;

    private static final String FLAVOR_DEFAULT = KmCssDefaultConstantsIF.fieldset_flavor_default;
    private static final String FLAVOR_WARNING = KmCssDefaultConstantsIF.fieldset_flavor_warning;

    //##################################################
    //# instance creation
    //##################################################

    public static final ScFieldset createWith(String label, ScControl c)
    {
        ScFieldset e;
        e = new ScFieldset();
        e.setLabel(label);
        e.add(c);
        return e;
    }

    public static final ScFieldset createWith(ScControl c)
    {
        return createWith(c.getLabel(), c);
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _flavor;

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

    public void setFlavorWarning()
    {
        setFlavor(FLAVOR_WARNING);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("fieldset");
        renderAttributesOn(out);
        out.close();

        renderHelpOn(out);
        renderLegendOn(out);
        renderChildrenOn(out);

        out.end("fieldset");
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        Integer x = null;
        Integer y = -10;
        Integer z = null;
        out.printHelpImage(getHelp(), x, y, z);
    }

    private void renderLegendOn(KmHtmlBuilder out)
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

    //==================================================
    //= render :: css
    //==================================================

    @Override
    public KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss().getCopy();
        css.fieldset();
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
