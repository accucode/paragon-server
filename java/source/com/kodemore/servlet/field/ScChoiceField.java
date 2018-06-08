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
import com.kodemore.html.KmCssBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

/**
 * A simple choice field that shows few options as buttons.  This is
 * essenitally a reskin of radio buttons with some additional convenience
 * methods.
 */
public class ScChoiceField<T>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The ID of the outer html element.
     */
    private ScLocalString _htmlId;

    /**
     * The value of the field.
     * The type must be compatible with ScEncoder.
     */
    private ScLocal<T> _value;

    /**
     * The list of options to be displayed.
     * The values must be the same type as the choice field's value.
     */
    private ScLocalOptionList<T> _options;

    /**
     * If disabled, the user will not be able to change the value.
     * Also disabled values are not sent to the server when the form is submitted.
     * Enabled by default.
     */
    private ScLocalBoolean _disabled;

    /**
     * If set, the action is called any time the web user
     * changes the value in the browser.
     */
    private ScAction _onChangeAction;

    //##################################################
    //# constructor
    //##################################################

    public ScChoiceField()
    {
        _htmlId = new ScLocalString(getKeyToken());
        _value = new ScLocal<>();
        _options = new ScLocalOptionList<>();
        _disabled = new ScLocalBoolean(false);
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public final String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public final void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    public String getHtmlName()
    {
        return getHtmlId();
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
    //# options
    //##################################################

    public void setOptions(KmList<ScOption<T>> v)
    {
        _options._setValue(v);
    }

    public KmList<ScOption<T>> getOptions()
    {
        return _options.getValue();
    }

    /**
     * Set the selected value to be the first (only) option
     * if there is exactly one option available.
     */
    public void selectSingleOption()
    {
        if ( !getOptions().isSingleton() )
            return;

        T e = getOptions().getFirst().getValue();
        setValue(e);
    }

    //##################################################
    //# options
    //##################################################

    public void addOption(T value, String label)
    {
        _options.add(value, label);
    }

    public void addOption(ScOption<T> e)
    {
        _options.add(e.getValue(), e.getText());
    }

    public void addOption(T value)
    {
        String label = value == null
            ? KmVirtualOptions.NONE
            : getFormatter().formatAny(value);

        addOption(value, label);
    }

    public void clearOptions()
    {
        _options.clear();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        if ( !data.hasParameter(getHtmlName()) )
            return;

        String s = data.getParameter(getHtmlName());
        T e = decodeUnchecked(s);
        setValue(e);
    }

    //##################################################
    //# on change
    //##################################################

    public void onChange(ScAction e)
    {
        _onChangeAction = e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute("name", getHtmlName());
        out.printAttribute(getCss());
        out.close();

        renderChangeTrackingOn(out);
        renderOptionsOn(out, getOptions());
        renderHelpOn(out);

        out.endDiv();
        out.getPostDom().run(formatRenderScript());
    }

    protected KmCssBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.choiceField();
        return css;
    }

    private void renderChangeTrackingOn(KmHtmlBuilder out)
    {
        if ( !getChangeTracking() )
            return;

        out.open("input");
        out.printAttribute("id", getHiddenHtmlId());
        out.printAttribute("type", "hidden");
        out.printAttribute("value", encode(getValue()));
        printOldValueAttributeOn(out, encode(getValue()));
        out.close();
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        if ( !hasHelp() )
            return;

        out.printHelpImage(getHelp());
    }

    private void renderOptionsOn(KmHtmlBuilder out, KmList<ScOption<T>> v)
    {
        int i = 0;
        for ( ScOption<T> e : v )
        {
            String radioId = getHtmlId() + i;
            i++;

            renderOptionInputOn(out, e, radioId);
            renderOptionLabelOn(out, e, radioId);
        }
    }

    private void renderOptionInputOn(KmHtmlBuilder out, ScOption<T> e, String radioId)
    {
        out.open("input");
        out.printAttribute("type", "radio");
        out.printAttribute("id", radioId);
        out.printAttribute("name", getHtmlName());
        out.printAttribute("value", encode(e.getValue()));

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        boolean checked = e.hasValue(getValue());
        if ( checked )
            out.printAttribute("checked", "checked");

        out.close();
        // no end tag
    }

    private void renderOptionLabelOn(KmHtmlBuilder out, ScOption<T> e, String radioId)
    {
        out.open("label");
        out.printAttribute("for", radioId);
        out.close();
        out.print(e.getText());
        out.end("label");
    }

    //##################################################
    //# scripts
    //##################################################

    private String formatRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("$('%s').buttonset();", getJquerySelector());

        // Update hidden field with selected value for change tracking;
        if ( getChangeTracking() )
            out.printfln(
                "$('%s > input').change(function(){Kmu.updateChoiceHiddenField('%s');});",
                getJquerySelector(),
                getJquerySelector());

        if ( _onChangeAction != null )
            out.printfln(
                "$('%s > input').change(function(){%s});",
                getJquerySelector(),
                formatOnChange());

        // Show visual indication of focus
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
        ScForm form = findFormWrapper();
        ScHtmlIdIF block = findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(_onChangeAction);
        s.setForm(form);
        s.setBlockTarget(block);

        return s.formatScript();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    @Override
    public void ajaxSetFieldValue(T value)
    {
        ajaxSetFieldValue(value, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(T value, boolean updateOldValue)
    {
        KmList<ScOption<T>> options = getOptions();
        if ( options.isEmpty() )
            return;

        for ( ScOption<T> option : options )
        {
            boolean checked = option.hasValue(value);
            ajaxSetOptionValue(getInputTargetFor(option), checked);
        }

        if ( updateOldValue )
            ajaxSetHiddenValue(value);

        getRootScript().run("%s.buttonset('refresh');", getJqueryReference());
    }

    /**
     * Hide and option.  This also automatically disables that option.
     * See Kmu.hideChoiceByValue in Kmu.js
     */
    public void ajaxHideOption(Object value)
    {
        getRootScript().run(
            "Kmu.hideChoiceByValue('%s','%s');",
            getJquerySelector(),
            encode(value));
    }

    /**
     * Show and option.  This also automatically enables that option.
     * See Kmu.showChoiceByValue in Kmu.js
     */
    public void ajaxShowOption(Object value)
    {
        getRootScript().run(
            "Kmu.showChoiceByValue('%s','%s');",
            getJquerySelector(),
            encode(value));
    }

    /**
     * Disable an option.
     * See Kmu.disableChoiceByValue in Kmu.js
     */
    public void ajaxDisableOption(Object value)
    {
        getRootScript().run(
            "Kmu.disableChoiceByValue('%s','%s');",
            getJquerySelector(),
            encode(value));
    }

    /**
     * Enable an option.
     * See Kmu.enableChoiceByValue in Kmu.js
     */
    public void ajaxEnableOption(Object value)
    {
        getRootScript().run(
            "Kmu.enableChoiceByValue('%s','%s');",
            getJquerySelector(),
            encode(value));
    }

    //##################################################
    //# support
    //##################################################

    private String getHiddenHtmlId()
    {
        return getHtmlId() + "hidden";
    }

    private ScHtmlId getTargetForHiddenField()
    {
        String htmlId = getHiddenHtmlId();
        ScBlockScript script = getRootScript();
        return new ScHtmlId(htmlId, script);
    }

    private void ajaxSetHiddenValue(Object e)
    {
        String htmlValue = encode(e);

        ScHtmlIdAjax ajax;
        ajax = ScHtmlIdAjax.createOnRoot(getTargetForHiddenField());
        ajax.setValue(htmlValue);

        if ( getChangeTracking() )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }

    private ScHtmlId getInputTargetFor(ScOption<T> e)
    {
        if ( getOptions().isEmpty() )
            return null;

        int i = getOptions().indexOf(e);

        String htmlId = getHtmlId() + i;

        ScBlockScript script = getRootScript();
        return new ScHtmlId(htmlId, script);
    }

    private void ajaxSetOptionValue(ScHtmlId target, boolean checked)
    {
        ScHtmlIdAjax ajax = ScHtmlIdAjax.createOnRoot(target);

        ajax.run("$('%s').prop('checked',%s);", target.getJquerySelector(), checked);
    }
}
