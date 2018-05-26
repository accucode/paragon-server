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

import com.kodemore.html.KmCssMarginBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * I represent a single radio button.
 * My value is always a boolean.
 *
 * The client is responsible for organizing multiple radio buttons.
 * When coordinating multiple radio buttons that are part of the same
 * logic group. the client should
 * -- set the same htmlName for all radioFields.
 * -- set a different optionValue for each radioField.
 */
public class ScRadioField
    extends ScField<Boolean>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The html name used for the radio.
     * This allows multiple radio buttons to share the same name/group.
     */
    private ScLocalString _htmlName;

    /**
     * The radio field's boolean value.
     * This represents whether the radio is checked.
     */
    private ScLocalBoolean _checked;

    /**
     * This is the internal value used to distinguish
     * between different radio buttons.  Each radio field
     * within a common group should use a distinct value.
     * This value must be compatible with ScEncoder.
     */
    private ScLocalObject _optionValue;

    /**
     * If true, the radio button is disabled.
     * False by default.
     */
    private ScLocalBoolean _disabled;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss _cssMargin;

    /**
     * If set, run this script when 'clicked.' This is also
     * called when the radio selection changes via keyboard.
     */
    private ScAction _clickAction;

    //##################################################
    //# constructor
    //##################################################

    public ScRadioField()
    {
        _htmlName = new ScLocalString(getKeyToken());
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
        return getKeyToken();
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
    //# read only
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
    //# on click
    //##################################################

    public void onClick(ScAction e)
    {
        setClickAction(e);
    }

    public void setClickAction(ScAction e)
    {
        _clickAction = e;
    }

    public ScAction getClickAction()
    {
        return _clickAction;
    }

    public boolean hasClickAction()
    {
        return _clickAction != null;
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
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(getCss());
        out.close();

        renderHelpOn(out);
        renderInputOn(out);

        out.endDiv();
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        out.printHelpImage(getHelp());
    }

    private void renderInputOn(KmHtmlBuilder out)
    {
        out.open("input");
        out.printAttribute("id", getInputHtmlId());
        out.printAttribute("name", getHtmlName());
        out.printAttribute("value", encode(getOptionValue()));
        out.printAttribute("type", "radio");

        if ( isChecked() )
            out.printAttribute("checked", "checked");

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        if ( getChangeTracking() )
            printOldCheckedAttributeOn(out, getValue());

        if ( hasClickAction() )
        {
            ScActionScript s;
            s = new ScActionScript();
            s.setAction(getClickAction());
            s.setForm(findFormWrapper());
            s.setBlockTarget(findBlockWrapper());
            out.printAttribute("onclick", s.formatScript());
        }

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
        css.radioField();
        css.addAll(cssMargin().getSelectors());

        if ( isEditable() )
            css.radioField_enabled();
        else
            css.radioField_disabled();

        return css;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getHtmlName();
        String param = data.getParameter(name);
        Object optionValue = decode(param);
        boolean checked = hasOptionValue(optionValue);

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
        Boolean htmlValue = value;

        ScHtmlIdAjax ajax;
        ajax = inputAjax();
        ajax.setChecked(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_CHECKED, htmlValue);
    }

    //##################################################
    //# support
    //##################################################

    private ScHtmlIdAjax inputAjax()
    {
        return newHtmlIdAjaxOn(getInputHtmlId());
    }
}
