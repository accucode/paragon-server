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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.Kmu;

public class ScFieldTable
    extends ScChildContainer
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScSpan _labelSpan;
    private ScText _labelText;

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    private ScLocalCss     _rightCss;
    private ScLocalBoolean _fullWidth;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldTable()
    {
        _labelSpan = new ScSpan();
        _labelSpan.setParent(this);
        _labelSpan.css().label();

        _labelText = _labelSpan.addText();

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _rightCss = new ScLocalCss();
        _fullWidth = new ScLocalBoolean(getFullWidthDefault());
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public final <T extends ScControl> T add(T e)
    {
        if ( e == null )
            throw Kmu.newFatal("Cannot add NULL child.");

        addErrorWrapper(e);
        return e;
    }

    /**
     * Add an errorWrapper around e, then adds that wrapper
     * to myself. This is the same behavior as the more standard
     * add() method, but this returns the errorWrapper.
     */
    private <T extends ScControl> ScErrorWrapper addErrorWrapper(T e)
    {
        ScErrorWrapper w = e instanceof ScErrorWrapper
            ? (ScErrorWrapper)e
            : new ScErrorWrapper(e);

        return super.add(w);
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

    //##################################################
    //# full width
    //##################################################

    public void setFullWidth()
    {
        _fullWidth.setTrue();
    }

    public boolean getFullWidth()
    {
        return _fullWidth.getValue();
    }

    protected boolean getFullWidthDefault()
    {
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmList<ScErrorWrapper> v = getChildren().collect(e -> (ScErrorWrapper)e);

        out.open("table");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", formatCss());
        out.printAttribute("style", formatStyle());
        out.close();

        int n = v.size();
        for ( int i = 0; i < n; i++ )
            renderRow(out, v.get(i), i);

        out.end("table");
    }

    private void renderRow(KmHtmlBuilder out, ScErrorWrapper e, int row)
    {
        out.open("tr");
        out.printAttribute("class", "fields");
        out.close();
        renderLabelAndField(out, e, row);
        out.end("tr");
    }

    private void renderLabelAndField(KmHtmlBuilder out, ScErrorWrapper e, int row)
    {
        renderLabel(out, e, row, 0);
        renderStar(out, e, row, 1);
        renderField(out, e, row, 2);
    }

    private void renderStar(KmHtmlBuilder out, ScErrorWrapper wrapper, int row, int col)
    {
        beginTd(out, row, col);
        if ( isVisible(wrapper.getChild()) )
            if ( wrapper.containsRequiredField() )
            {
                out.beginDivCss(KmCssDefaultConstantsIF.requiredStar);
                out.print("*");
                out.endDiv();
            }
        endTd(out);
    }

    private void renderLabel(KmHtmlBuilder out, ScErrorWrapper e, int row, int col)
    {
        beginTd(out, row, col);
        if ( isVisible(e.getChild()) )
        {
            _labelText.setValue(e.getLabel());
            _labelSpan.renderOn(out);
        }
        endTd(out);
    }

    private void renderField(KmHtmlBuilder out, ScErrorWrapper e, int row, int col)
    {
        beginTd(out, row, col);
        e.renderOn(out);
        endTd(out);
    }

    private void beginTd(KmHtmlBuilder out, int row, int col)
    {
        String css = getCssFor(row, col);
        out.beginCss("td", css);
    }

    private void endTd(KmHtmlBuilder out)
    {
        out.end("td");
    }

    //##################################################
    //# support
    //##################################################

    private boolean isVisible(ScControl e)
    {
        if ( e instanceof ScVisibleIF )
            return ((ScVisibleIF)e).isVisible();

        return true;
    }

    private String getCssFor(int row, int col)
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.add("fields");

        applyRowCssTo(css, row);
        applyColumnCssTo(css, col);

        return css.getValue();
    }

    private void applyRowCssTo(KmCssDefaultBuilder css, int row)
    {
        if ( row == 0 )
            css.fieldsTop();
        else
            css.fieldsMore();
    }

    private void applyColumnCssTo(KmCssDefaultBuilder css, int col)
    {
        if ( col == 0 )
        {
            css.fieldsLeft();
            return;
        }

        if ( col == 1 )
        {
            css.fieldsStar();
            return;
        }

        if ( col == 2 )
        {
            css.fieldsRight();

            if ( _fullWidth.isTrue() )
                css.widthFull();

            css.add(rightCss().getValue());
            return;
        }
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    @Override
    public boolean isVisible()
    {
        return !style().hasHide();
    }

    @Override
    public void setVisible(boolean e)
    {
        style().show(e);
    }

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _htmlIdAjax().show(e);
    }

}
