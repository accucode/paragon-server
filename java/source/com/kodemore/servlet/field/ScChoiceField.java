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

package com.kodemore.servlet.field;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.html.KmCssBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScElementIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmCodedEnumIF;
import com.kodemore.utility.KmNamedEnumIF;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

/**
 * A simple choice field that shows few options as buttons.  This is
 * essenitally a reskin of radio buttons with some additional convenience
 * methods.
 */
public class ScChoiceField
    extends ScField<Object>
    implements ScElementIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalOptionList _options;

    private ScLocalObject _value;

    private ScLocalBoolean _disabled;

    @SuppressWarnings("rawtypes")
    private KmValidator _validator;

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    private ScAction _onChangeAction;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes client-side utilizes to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean _changeTracking;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _options = new ScLocalOptionList();

        _value = new ScLocalObject();
        _disabled = new ScLocalBoolean(false);

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _changeTracking = true;
    }

    //##################################################
    //# html class
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

    //##################################################
    //# html style
    //##################################################

    public String getStyle()
    {
        return _style.getValue();
    }

    public KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    @Override
    public void show()
    {
        style().show();
    }

    @Override
    public void hide()
    {
        style().hide();
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<?> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<?> e)
    {
        _validator = e;
    }

    public void clearValidator()
    {
        setValidator(null);
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    @Override
    public void setRequired()
    {
        if ( hasValidator() )
            getValidator().setRequired();
        else
            setValidator(new KmRequiredValidator<>());
    }

    public void setOptional()
    {
        if ( hasValidator() )
            getValidator().setOptional();
    }

    //##################################################
    //# session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
        _value.saveValue();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        resetValue();
    }

    //##################################################
    //# change tracking
    //##################################################

    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        warnIfInstalled();
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        if ( hasKeyParameter(data) )
        {
            String s = getKeyParameter(data);
            Object e = decode(s);
            setValue(e);
        }
    }

    //##################################################
    //# on change
    //##################################################

    public ScAction getOnChangeAction()
    {
        return _onChangeAction;
    }

    public void setOnChangeAction(ScAction e)
    {
        _onChangeAction = e;
    }

    public ScAction setOnChangeAction(Runnable e)
    {
        ScAction action = newAction(e);
        setOnChangeAction(action);
        return action;
    }

    public boolean hasOnChangeAction()
    {
        return _onChangeAction != null;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderAttributesOn(out);
        out.close();

        renderOptions(out, getOptions());

        out.endDiv();

        out.getPostDom().run(formatRenderScript());
    }

    private String formatRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.printfln("$('%s').buttonset();", getJquerySelector());

        if ( hasOnChangeAction() )
            out.printfln(
                "$('%s > input').change(function(){%s});",
                getJquerySelector(),
                formatOnChange());

        // Show visual indication of focus when focused
        out.printfln(
            "$('%s > input').focus(function(){%s});",
            getJquerySelector(),
            formatFocusScript());

        // Remove visual indication of focus when blurred
        out.printfln(
            "$('%s > input').blur(function(){%s});",
            getJquerySelector(),
            formatBlurScript());

        return out.toString();
    }

    private String formatFocusScript()
    {
        return Kmu.format(
            "$('%s').addClass('%s');",
            getJquerySelector(),
            KmCssDefaultConstantsIF.choiceFieldFocus);
    }

    private String formatBlurScript()
    {
        return Kmu.format(
            "$('%s').removeClass('%s');",
            getJquerySelector(),
            KmCssDefaultConstantsIF.choiceFieldFocus);
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute(formatCss());
    }

    protected KmCssBuilder formatCss()
    {
        return css().inlineBlock();
    }

    private void renderOptions(KmHtmlBuilder out, KmList<ScOption> v)
    {
        if ( v == null )
            return;

        Object selection = getValue();

        int i = 0;
        for ( ScOption e : v )
        {
            String radioId = getHtmlId() + i;
            i++;

            out.open("input");
            out.printAttribute("type", "radio");
            out.printAttribute("id", radioId);
            out.printAttribute("name", getHtmlName());

            String value = encode(e.getValue());
            out.printAttribute("value", value);

            if ( isDisabled() )
                out.printAttribute("disabled", true);

            boolean checked = e.hasValue(selection);

            if ( getChangeTracking() )
                printOldCheckedAttributeOn(out, checked);

            if ( checked )
                out.printAttribute("checked");

            out.close();
            out.open("label");
            out.printAttribute("for", radioId);
            out.close();
            out.print(e.getText());
            out.end("label");
        }
    }

    //##################################################
    //# validate
    //##################################################

    @SuppressWarnings("unchecked")
    @Override
    public boolean validateQuietly()
    {
        boolean ok = super.validateQuietly();

        if ( _validator == null )
            return ok;

        KmList<KmErrorIF> errors = new KmList<>();
        _validator.validateOnly(getValue(), errors);
        if ( errors.isEmpty() )
            return ok;

        setErrors(errors);
        return false;
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public Object getValue()
    {
        return _value.getValue();
    }

    @Override
    public void setValue(Object e)
    {
        _value.setValue(e);
    }

    @Override
    public void resetValue()
    {
        _value.resetValue();
    }

    public String getStringValue()
    {
        return (String)getValue();
    }

    public Integer getIntegerValue()
    {
        return (Integer)getValue();
    }

    public Boolean getBooleanValue()
    {
        return (Boolean)getValue();
    }

    public boolean hasValue(Object e)
    {
        return Kmu.isEqual(getValue(), e);
    }

    public void setOptions(KmList<ScOption> v)
    {
        _options._setValue(v);
    }

    public ScOption getOption(Object value)
    {
        for ( ScOption e : getOptions() )
            if ( e.hasValue(value) )
                return e;

        return null;
    }

    public KmList<ScOption> getOptions()
    {
        return _options.getValue();
    }

    /**
     * Set the selected value to be the first (only) option
     * if there is exactly one option available.
     */
    public void selectSingleOption()
    {
        if ( getOptions().isSingleton() )
            setValue(getOptions().getFirst().getValue());
    }

    //##################################################
    //# options
    //##################################################

    public void addOption(Object value, String label)
    {
        _options.add(value, label);
    }

    public void addOption(ScOption e)
    {
        _options.add(e.getValue(), e.getText());
    }

    public void addOption(Object value)
    {
        String label = "";

        if ( value != null )
            label = value.toString();

        addOption(value, label);
    }

    public void clearOptions()
    {
        _options.clear();
    }

    //##################################################
    //# coded enums
    //##################################################

    public void setValue(KmCodedEnumIF e)
    {
        setValue(e.getCode());
    }

    public void addOption(KmCodedEnumIF e)
    {
        addOption(e.getCode(), e.getName());
    }

    public void addOptions(KmCodedEnumIF[] v)
    {
        for ( KmCodedEnumIF e : v )
            addOption(e);
    }

    public void addCodedOptions(KmList<? extends KmCodedEnumIF> v)
    {
        for ( KmCodedEnumIF e : v )
            addOption(e);
    }

    //##################################################
    //# named enums
    //##################################################

    public void setValue(KmNamedEnumIF e)
    {
        setValue(e.ordinal());
    }

    public void addOption(KmNamedEnumIF e)
    {
        addOption(e.ordinal(), e.getName());
    }

    public void addOptions(KmNamedEnumIF[] v)
    {
        for ( KmNamedEnumIF e : v )
            addOption(e);
    }

    public void addOptionRange(Integer first, Integer last)
    {
        if ( first <= last )
        {
            for ( int i = first; i <= last; i++ )
                addOption(i);
            return;
        }

        for ( int i = last; i >= first; i-- )
            addOption(i);
    }

    //##################################################
    //# enabled
    //##################################################

    public void setDisabled(boolean e)
    {
        _disabled.setValue(e);
    }

    public void enable()
    {
        _disabled.setFalse();
    }

    public void disable()
    {
        _disabled.setTrue();
    }

    public boolean isDisabled()
    {
        return _disabled.isTrue();
    }

    public boolean isEnabled()
    {
        return !isDisabled();
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isEnabled();
    }

    //##################################################
    //# on change
    //##################################################

    private String formatOnChange()
    {
        if ( !hasOnChangeAction() )
            return null;

        ScForm form = findFormWrapper();
        ScHtmlIdIF block = findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getOnChangeAction());
        s.setForm(form);
        s.setBlockTarget(block);

        return s.formatScript();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajaxSetValue(getValue());
    }

    public void ajaxSetValue(Object e)
    {
        String value = encode(e);

        ajax().setValue(value);

        if ( getChangeTracking() )
            ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }

    public void ajaxHide()
    {
        ajax().hide();
    }

    public void ajaxShow()
    {
        ajax().show();
    }

    /**
     * Hide and option.  This also automatically disables that option.
     * See Kmu.hideChoiceByValue in Kmu.js
     */
    public void ajaxHideOption(Object value)
    {
        ajax().run("Kmu.hideChoiceByValue('%s', '%s');", getJquerySelector(), encode(value));
    }

    /**
     * Show and option.  This also automatically enables that option.
     * See Kmu.showChoiceByValue in Kmu.js
     */
    public void ajaxShowOption(Object value)
    {
        ajax().run("Kmu.showChoiceByValue('%s', '%s');", getJquerySelector(), encode(value));
    }

    /**
     * Disable an option.
     * See Kmu.disableChoiceByValue in Kmu.js
     */
    public void ajaxDisableOption(Object value)
    {
        ajax().run("Kmu.disableChoiceByValue('%s', '%s');", getJquerySelector(), encode(value));
    }

    /**
     * Enable an option.
     * See Kmu.enableChoiceByValue in Kmu.js
     */
    public void ajaxEnableOption(Object value)
    {
        ajax().run("Kmu.enableChoiceByValue('%s', '%s');", getJquerySelector(), encode(value));
    }
}
