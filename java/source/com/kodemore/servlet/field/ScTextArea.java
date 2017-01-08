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

import com.kodemore.html.KmCssMarginBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * I am a multi-line text area, that uses the <textarea>
 * html tag.  I do not support empty string ("") values.
 * Instead empty strings (both get and set) are converted
 * to nulls.
 */
public class ScTextArea
    extends ScField<String>
{
    //##################################################
    //# enum :: layout
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
    {
        /**
         * Treat the control as an inline element with a fixed size.
         * This is similar to the way a standalone textarea element works.
         * This is the default.
         */
        inline,

        /**
         * Treat the control as a block (not inline) element.
         * The control will generally span the entire row, similar to a div.
         * The height must be to a specific value (in pixels).
         */
        block,

        /**
         * For use inside a flexbox (row), the child will fill the available space.
         * The row and height may be specified, or not.
         */
        flexFiller,

        /**
         * For use inside a non-static container.
         * This uses absolute positioning to fill the entire container.
         */
        fill
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _text;
    private ScLocalBoolean _readOnly;

    /**
     * The layout to coordinate with my parent.
     * The use of width and height depend on the selected layout.
     */
    private Layout         _layout;
    private Integer        _width;
    private Integer        _height;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss     _cssMargin;

    /**
     * Enable/disable spellchecking. Enabled by default.
     */
    private ScLocalBoolean _spellCheck;

    //##################################################
    //# constructor
    //##################################################

    public ScTextArea()
    {
        _text = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _cssMargin = new ScLocalCss();
        _spellCheck = new ScLocalBoolean(true);
        layoutInline();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    private String getAreaHtmlId()
    {
        return getHtmlId() + "-a";
    }

    private String getAreaHtmlName()
    {
        return getAreaHtmlId();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        layoutInline(300, 100);
    }

    public void layoutInline(int w, int h)
    {
        _layout = Layout.inline;
        _width = w;
        _height = h;
    }

    public void layoutBlock(int h)
    {
        _layout = Layout.block;
        _width = null;
        _height = h;
    }

    public void layoutFlexFiller()
    {
        layoutFlexFiller(null, null);
    }

    /**
     * Note that the width and height are optional (allows null).
     */
    public void layoutFlexFiller(Integer w, Integer h)
    {
        _layout = Layout.flexFiller;
        _width = w;
        _height = h;
    }

    public void layoutFill()
    {
        _layout = Layout.fill;
    }

    //##################################################
    //# css
    //##################################################

    public KmCssMarginBuilder cssMargin()
    {
        return _cssMargin.toMarginBuilder();
    }

    //##################################################
    //# spell check
    //##################################################

    public boolean getSpellCheck()
    {
        return _spellCheck.getValue();
    }

    public void setSpellCheck(boolean e)
    {
        _spellCheck.setValue(e);
    }

    public void disableSpellCheck()
    {
        setSpellCheck(false);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        return textToValue(_text.getValue());
    }

    @Override
    public void setValue(String value)
    {
        _text.setValue(valueToText(value));
    }

    public boolean isEmpty()
    {
        return _text.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //==================================================
    //= value :: conversion
    //==================================================

    private String textToValue(String text)
    {
        return Kmu.isEmpty(text)
            ? null
            : text;
    }

    private String valueToText(String value)
    {
        return value == null
            ? ""
            : value;
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _text.saveValue();
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    //##################################################
    //# read only
    //##################################################

    public void setReadOnly(boolean b)
    {
        _readOnly.setValue(b);
    }

    public boolean isReadOnly()
    {
        return _readOnly.getValue();
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isReadOnly();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmCssDefaultBuilder css = getCss();
        KmStyleBuilder style = new KmStyleBuilder();

        if ( !getVisible() )
            style.hide();

        applyLayoutTo(css, style);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        renderImageOn(out);
        renderTextAreaOn(out);

        out.endDiv();
    }

    private void renderImageOn(KmHtmlBuilder out)
    {
        if ( !hasHelp() )
            return;

        ScImage e;
        e = new ScImage();
        e.css().helpTriangle().helpTooltip();
        e.setSource(getUrls().getHelpIndicatorUrl());
        e.setHoverText(getHelp());
        e.renderOn(out);
    }

    private void renderTextAreaOn(KmHtmlBuilder out)
    {
        out.open("textarea");
        out.printAttribute("id", getAreaHtmlId());
        out.printAttribute("name", getAreaHtmlName());

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, getValue());

        if ( !getSpellCheck() )
            out.printAttribute("spellcheck", false);

        out.close();
        out.printWithoutBreaks(getValue());
        out.end("textarea");
    }

    //==================================================
    //= render :: support
    //==================================================

    /**
     * Get the basic css for the outer/wrapper div.
     */
    private KmCssDefaultBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.textArea();
        css.addAll(cssMargin().getSelectors());

        if ( isEditable() )
            css.textArea_editable();
        else
            css.textArea_readonly();

        return css;
    }

    /**
     * Apply the additional styling necessary to make the layout work correctly.
     */
    private void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        switch ( _layout )
        {
            case inline:
                css.flexInlineRow();
                style.width(_width);
                style.height(_height);
                break;

            case block:
                css.flexRow();
                style.height(_height);
                break;

            case flexFiller:
                css.flexChildFiller();
                css.flexRow();
                style.width(_width);
                style.height(_height);
                break;

            case fill:
                css.fill();
                css.flexRow();
                break;
        }
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getAreaHtmlName();
        if ( data.hasParameter(name) )
            _text.setValue(data.getParameter(name));
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(String value)
    {
        ajaxSetFieldValue(value, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(String value, boolean updateOldValue)
    {
        String htmlValue = valueToText(value);

        ScHtmlIdAjax ajax;
        ajax = areaAjax();
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }

    //==================================================
    //= ajax :: support
    //==================================================

    private ScHtmlIdAjax areaAjax()
    {
        ScHtmlId htmlId = new ScHtmlId(getAreaHtmlId(), getRootScript());
        return ScHtmlIdAjax.createOnRoot(htmlId);
    }
}
