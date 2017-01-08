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
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * I represent a single checkbox button.
 * My value is always a boolean.
 */
public class ScCheckboxField
    extends ScField<Boolean>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The html name used for the checkbox input element.
     * The default is usually acceptable.
     * However, it may be overridden if the client is manually
     * organizing multiple checkboxes into a group.
     */
    private ScLocalString  _htmlName;

    /**
     * The radio field's boolean value.
     * This represents whether the radio is checked.
     */
    private ScLocalBoolean _checked;

    /**
     * The value set in the input element and subsequently
     * returned to the server when the form is submitted.
     * This defaults to null, which is usually fine.
     *
     * However, this may be sent to any encodable value
     * (ScEncoder) if the client is manually organizing
     * multiple checkboxes into a group with the same htmlName.
     */
    private ScLocalObject  _optionValue;

    /**
     * If true, the checkbox button is disabled.
     * Bear in mind that disabled fields are NOT submitted with the form.
     * False by default.
     */
    private ScLocalBoolean _disabled;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss     _cssMargin;

    private ScAction       _onChangeAction;

    //##################################################
    //# constructor
    //##################################################

    public ScCheckboxField()
    {
        _htmlName = new ScLocalString(getKey());
        _checked = new ScLocalBoolean(false);
        _optionValue = new ScLocalObject();
        _disabled = new ScLocalBoolean(false);
        _cssMargin = new ScLocalCss();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    private String getInputHtmlId()
    {
        return getHtmlId() + "-input";
    }

    //##################################################
    //# html name
    //##################################################

    public String getHtmlName()
    {
        return _htmlName.getValue();
    }

    public void setHtmlName(String e)
    {
        _htmlName.setValue(e);
    }

    //##################################################
    //# css
    //##################################################

    public KmCssMarginBuilder cssMargin()
    {
        return _cssMargin.toMarginBuilder();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValue()
    {
        return _checked.isTrue();
    }

    @Override
    public void setValue(Boolean value)
    {
        _checked.setValue(value);
    }

    public boolean isChecked()
    {
        return _checked.isTrue();
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _checked.saveValue();
    }

    @Override
    public void resetValue()
    {
        _checked.resetValue();
    }

    //##################################################
    //# option value
    //##################################################

    public Object getOptionValue()
    {
        return _optionValue.getValue();
    }

    public void setOptionValue(Object e)
    {
        _optionValue.setValue(e);
    }

    public boolean hasOptionValue(Object e)
    {
        return _optionValue.hasValue(e);
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
    //# on change
    //##################################################

    public void onChange(ScAction e)
    {
        _onChangeAction = e;
    }

    public void onChange(Runnable e)
    {
        onChange(newCheckedAction(e));
    }

    private String formatOnChange()
    {
        if ( _onChangeAction == null )
            return null;

        ScForm form = findFormWrapper();
        ScHtmlIdIF block = findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(_onChangeAction);
        s.setForm(form);
        s.setModel(getModel());
        s.setBlockTarget(block);

        return s.formatScript();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        KmStyleBuilder style = newStyleBuilder();
        if ( !getVisible() )
            style.hide();

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(getCss());
        out.printAttribute(style);
        out.close();

        renderImageOn(out);
        renderInputOn(out);

        out.endDiv();
    }

    private void renderImageOn(KmHtmlBuilder out)
    {
        out.printHelpImage(getHelp());
    }

    private void renderInputOn(KmHtmlBuilder out)
    {
        out.open("input");
        out.printAttribute("id", getInputHtmlId());
        out.printAttribute("name", getHtmlName());
        out.printAttribute("value", encode(getOptionValue()));
        out.printAttribute("type", "checkbox");
        out.printAttribute("onchange", formatOnChange());

        if ( isChecked() )
            out.printAttribute("checked", "checked");

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        if ( getChangeTracking() )
            printOldCheckedAttributeOn(out, getValue());

        out.close();
        // no end tab
    }

    //==================================================
    //= render :: css
    //==================================================

    /**
     * Get the basic css for the outer/wrapper div.
     */
    private KmCssDefaultBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.checkboxField();
        css.addAll(cssMargin().getSelectors());

        if ( isEditable() )
            css.checkboxField_enabled();
        else
            css.checkboxField_disabled();

        return css;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        boolean checked = false;

        String name = getHtmlName();
        if ( data.hasParameter(name) )
        {
            Object optionValue = decode(data.getParameter(name));
            checked = hasOptionValue(optionValue);
        }

        setValue(checked);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(Boolean value)
    {
        ajaxSetFieldValue(value, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(Boolean value, boolean updateOldValue)
    {
        if ( value == null )
            value = false;

        ScHtmlIdAjax ajax;
        ajax = inputAjax();
        ajax.setChecked(value);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_CHECKED, value);
    }

    //##################################################
    //# support
    //##################################################

    private ScHtmlIdAjax inputAjax()
    {
        return newHtmlIdAjaxOn(getInputHtmlId());
    }
}
