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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmCssBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

public class ScFieldTable
    extends ScChildContainer
{
    //##################################################
    //# variables
    //##################################################

    private ScSpan _labelSpan;
    private ScText _labelText;

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    private ScLocalCss _rightCss;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _labelSpan = new ScSpan();
        _labelSpan.setParent(this);
        _labelSpan.css().label();

        _labelText = _labelSpan.addText();

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _rightCss = new ScLocalCss();
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
    //# css
    //##################################################

    public String getCss()
    {
        return _css.getValue();
    }

    public void setCss(String e)
    {
        _css.setValue(e);
    }

    public KmCssDefaultBuilder css()
    {
        return _css.toDefaultBuilder();
    }

    public String formatCss()
    {
        return css().fields().toString();
    }

    //##################################################
    //# style
    //##################################################

    public String getStyle()
    {
        return _style.getValue();
    }

    public void setStyle(String e)
    {
        _style.setValue(e);
    }

    public KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    public String formatStyle()
    {
        return getStyle();
    }

    //##################################################
    //# right
    //##################################################

    public String getRightCss()
    {
        return _rightCss.getValue();
    }

    public void setRightCss(String e)
    {
        _rightCss.setValue(e);
    }

    public KmCssDefaultBuilder rightCss()
    {
        return _rightCss.toDefaultBuilder();
    }

    public String formatRightCss()
    {
        return rightCss().toString();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmList<ScControl> v = getChildren();

        out.open("table");
        out.printAttribute("class", formatCss());
        out.printAttribute("style", formatStyle());
        out.close();

        int n = v.size();
        for ( int i = 0; i < n; i++ )
            renderRow(out, v.get(i), i);

        out.end("table");
    }

    private void renderRow(KmHtmlBuilder out, ScControl e, int row)
    {
        out.open("tr");
        out.printAttribute("class", "fields");
        out.close();
        renderLabelAndField(out, e, row);
        out.end("tr");
    }

    private void renderLabelAndField(KmHtmlBuilder out, ScControl e, int row)
    {
        renderLabel(out, e, row, 0);
        renderField(out, e, row, 1);
    }

    private void renderLabel(KmHtmlBuilder out, ScControl e, int row, int col)
    {
        beginTd(out, row, col);

        _labelText.setValue(e.getLabel());
        _labelSpan.renderOn(out);

        endTd(out);
    }

    private void renderField(KmHtmlBuilder out, ScControl e, int row, int col)
    {
        beginTd(out, row, col);

        e.renderOn(out);

        endTd(out);
    }

    private void beginTd(KmHtmlBuilder out, int row, int col)
    {
        KmCssBuilder css;
        css = new KmCssBuilder();

        css.add("fields");

        if ( row == 0 )
            css.add("fieldsTop");
        else
            css.add("fieldsMore");

        if ( col == 0 )
            css.add("fieldsLeft");
        else
        {
            css.add("fieldsRight");
            css.add(formatRightCss());
        }

        out.beginCss("td", css.getValue());
    }

    private void endTd(KmHtmlBuilder out)
    {
        out.end("td");
    }

}
