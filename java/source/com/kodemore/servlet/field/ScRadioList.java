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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmCssMarginBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSetCheckedByNameScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalOptionList;

/**
 * I select a single value using a collection of radio buttons.
 */
public class ScRadioList<T>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The currently selected value.
     */
    private ScLocal<T> _value;

    /**
     * The options define the display labels and values the list
     * of radio buttons.  Each option should have a distinct value.
     */
    private ScLocalOptionList<T> _options;

    /**
     * The height of the field in pixels.
     * The radio are organized in a series of columns.
     * The height determines how many options can be listed in each column.
     * If null, the height is not constrained.
     */
    private Integer _height;

    /**
     * If true, the radio buttons are disabled.
     * Bear in mind that disabled fields are NOT submitted with the form.
     * False by default.
     */
    private ScLocalBoolean _disabled;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss _cssMargin;

    //##################################################
    //# constructor
    //##################################################

    public ScRadioList()
    {
        _value = new ScLocal<>();
        _options = new ScLocalOptionList<>();
        _disabled = new ScLocalBoolean(false);
        _cssMargin = new ScLocalCss();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    //##################################################
    //# css
    //##################################################

    public KmCssMarginBuilder cssMargin()
    {
        return _cssMargin.toMarginBuilder();
    }

    //##################################################
    //# options
    //##################################################

    public void setOptions(KmList<ScOption<T>> v)
    {
        _options.setValue(v);
    }

    public void addOption(T value, String label)
    {
        _options.add(value, label);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        return _value.getValue();
    }

    @Override
    public void setValue(T e)
    {
        _value.setValue(e);
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _value.saveValue();
    }

    @Override
    public void resetValue()
    {
        _value.resetValue();
    }

    //##################################################
    //# disabled
    //##################################################

    public void setDisabled(boolean b)
    {
        _disabled.setValue(b);
    }

    public boolean isDisabled()
    {
        return _disabled.getValue();
    }

    public void setDisabled()
    {
        setDisabled(true);
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isDisabled();
    }

    //##################################################
    //# layout
    //##################################################

    /**
     * The list is treated as an INLINE element and displays
     * all items in a single column.
     */
    public void layoutInlineColumn()
    {
        _height = null;
    }

    /**
     * The list is treated as a BLOCK element with a specific height.
     * The elements are displayed in a multiple columns as needed,
     * and the list automatically scrolls horizontally as needed.
     */
    public void layoutBlockMultiColumn(int height)
    {
        _height = height;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String encodedValue = data.getParameter(getInputName());
        T value = decodeUnchecked(encodedValue);
        _value.setValue(value);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmCssDefaultBuilder css = getCss();
        KmStyleBuilder style = new KmStyleBuilder();
        applyLayoutTo(css, style);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        for ( ScOption<T> e : _options )
            renderOptionOn(out, e);

        out.endDiv();
    }

    private KmCssDefaultBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = newCssBuilder();
        css.radioList();
        css.addAll(cssMargin().getSelectors());
        return css;
    }

    private void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        if ( _height == null )
        {
            css.flexInlineColumn();
            return;
        }

        css.flexColumn().flexWrap().flexWrapAlignStart().flexCrossAlignStart().auto();
        style.height(_height);
    }

    private void renderOptionOn(KmHtmlBuilder out, ScOption<T> e)
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.flexRow().flexCrossAlignCenter();

        out.openDiv();
        out.printAttribute(css);
        out.close();

        renderOptionInputOn(out, e);
        renderOptionTextOn(out, e);

        out.endDiv();
    }

    private void renderOptionInputOn(KmHtmlBuilder out, ScOption<T> e)
    {
        String name = getInputName();

        T item = e.getValue();
        boolean checked = hasValue(item);

        out.open("input");
        out.printAttribute("type", "radio");
        out.printAttribute("name", name);
        out.printAttribute("value", encode(item));

        if ( getChangeTracking() )
            printOldCheckedAttributeOn(out, checked);

        if ( !isEditable() )
            out.printAttribute("disabled", "disabled");

        if ( checked )
            out.printAttribute("checked");

        out.close();
        // no end tag
    }

    private void renderOptionTextOn(KmHtmlBuilder out, ScOption<T> e)
    {
        out.open("span");
        out.close();
        out.print(e.getText());
        out.end("span");
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(T e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(T e, boolean updateOldValue)
    {
        ScSetCheckedByNameScript s;
        s = getRootScript().setCheckedByName();
        s.setName(getInputName());
        s.setValue(e);
        s.setChangeTracking(updateOldValue);
        s.setChecked(true);
    }

    @Override
    public void ajaxClearFieldValue()
    {
        ajaxClearFieldValue(getChangeTracking());
    }

    @Override
    public void ajaxClearFieldValue(boolean updateOldValue)
    {
        ScBlockScript ajax = getRootScript();

        ScSetCheckedByNameScript s;
        s = ajax.setCheckedByName();
        s.setName(getInputName());
        s.setChangeTracking(updateOldValue);
        s.setChecked(false);
    }

    //##################################################
    //# support
    //##################################################

    private String getInputName()
    {
        return getKeyToken();
    }
}
