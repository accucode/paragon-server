/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import java.util.List;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.filter.KmFilter;
import com.kodemore.html.KmCssBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScElementIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.KmCodedEnumIF;
import com.kodemore.utility.KmNamedEnumIF;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

// todo_wyatt: fix chosen styling in page header

public class ScDropdown
    extends ScField<Object>
    implements ScElementIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If not null, refetch the options from the filter
     * each time render is executed.
     */
    private KmFilter<ScOption> _optionFilter;

    private ScLocalOptionList  _options;
    private ScLocalOptionList  _prefixes;

    private ScLocalObject      _value;
    private ScLocalAdaptor     _optionLabelAdaptor;
    private ScLocalAdaptor     _optionValueAdaptor;

    private ScLocalBoolean     _disabled;

    @SuppressWarnings("rawtypes")
    private KmValidator        _validator;

    private ScLocalCss         _css;
    private ScLocalStyle       _style;

    private ScActionIF         _action;

    private ScLocalBoolean     _usesChosen;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _options = new ScLocalOptionList();
        _optionLabelAdaptor = new ScLocalAdaptor();
        _optionValueAdaptor = new ScLocalAdaptor();
        _prefixes = new ScLocalOptionList();
        _value = new ScLocalObject();
        _disabled = new ScLocalBoolean(false);

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _usesChosen = new ScLocalBoolean(true);
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

    @Override
    public void show()
    {
        css().remove().hide();
    }

    @Override
    public void hide()
    {
        css().hide();
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

    //##################################################
    //# chosen
    //##################################################

    public boolean usesChosen()
    {
        return _usesChosen.getValue();
    }

    public void setUsesChosen(boolean e)
    {
        _usesChosen.setValue(e);
    }

    public void setUsesChosen()
    {
        setUsesChosen(true);
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
            setValidator(new KmRequiredValidator<Object>());
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

    protected String getDefaultFocusKey()
    {
        return getKey();
    }

    //##################################################
    //# prefixes
    //##################################################

    public KmList<ScOption> getPrefixes()
    {
        return _prefixes.getValue();
    }

    public void setPrefixes(KmList<ScOption> e)
    {
        _prefixes.setValue(e);
    }

    public void addPrefix(Object value, String label)
    {
        _prefixes.add(value, label);
    }

    public void addPrefix(ScOption e)
    {
        _prefixes.add(e);
    }

    public void addNullPrefix()
    {
        addNullPrefix("");
    }

    public void addNullPrefix(String label)
    {
        addPrefix(null, label);
    }

    public void addNullNonePrefix()
    {
        addPrefix(null, "<none>");
    }

    public void addNullDefaultPrefix()
    {
        addPrefix(null, "<default>");
    }

    public void addNullAnyPrefix()
    {
        addPrefix(null, "<any>");
    }

    public void addNullSelectPrefix()
    {
        addPrefix(null, "<select>");
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
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        checkOptionFilter();

        out.open("select");
        renderAttributesOn(out);
        out.close();

        renderOptions(out, getPrefixes());
        renderOptions(out, getOptions());

        out.end("select");

        if ( usesChosen() )
            out.getPostRender().run(formatChosenScript());
    }

    /**
     * (aaron) CHOSEN - the chosen script, there are several options
     * that can be passed in, examples are commented out below.
     * 
     * review_aaron (wyatt) discuss comments
     */
    private String formatChosenScript()
    {
        /**
         * review_aaron: options:
         *      disable_search_threshold - don't show search if below this many options 
         *      no_results_text - text to show when nothing is found in search
         */
        KmJsonObject options;
        options = new KmJsonObject();
        //        options.setInteger("disable_search_threshold", 10);
        //        options.setString("no_results_text", "No results found");

        return Kmu.format("%s.chosen(%s);", formatJqueryReference(), options);
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("size", 1);
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.printAttribute("onchange", formatOnChange());

        if ( isDisabled() )
            out.printAttribute("disabled");
    }

    protected KmCssBuilder formatCss()
    {
        return css().dropdown();
    }

    protected KmStyleBuilder formatStyle()
    {
        return style();
    }

    private void renderOptions(KmHtmlBuilder out, KmList<ScOption> v)
    {
        if ( v == null )
            return;

        Object selection = getValue();

        for ( ScOption e : v )
        {
            String value = encode(e.getValue());

            out.open("option");
            out.printAttribute("value", value);

            if ( e.hasValue(selection) )
                out.printAttribute("selected");

            out.close();
            out.print(e.getText());
            out.end("option");
        }
    }

    //##################################################
    //# action
    //##################################################

    public ScActionIF getAction()
    {
        return _action;
    }

    public void setAction(ScActionIF e)
    {
        _action = e;
    }

    public boolean hasAction()
    {
        return _action != null;
    }

    //##################################################
    //# option filter
    //##################################################

    public KmFilter<ScOption> getOptionFilter()
    {
        return _optionFilter;
    }

    public void setOptionFilter(KmFilter<ScOption> e)
    {
        _optionFilter = e;
    }

    public boolean hasOptionFilter()
    {
        return getOptionFilter() != null;
    }

    private void checkOptionFilter()
    {
        if ( !hasOptionFilter() )
            return;

        clearOptions();

        KmList<ScOption> v = getOptionFilter().findAll();
        for ( ScOption e : v )
            addOption(e);
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

        KmList<KmErrorIF> errors = new KmList<KmErrorIF>();
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

    @SuppressWarnings("rawtypes")
    public void setOptionLabelAdaptor(KmAdaptorIF e)
    {
        _optionLabelAdaptor.setValue(e);
    }

    public void setOptionLabelAdaptor(KmMetaAttribute<?,?> attr)
    {
        setOptionLabelAdaptor(attr.getAdaptor());
    }

    @SuppressWarnings("rawtypes")
    public void setOptionValueAdaptor(KmAdaptorIF e)
    {
        _optionValueAdaptor.setValue(e);
    }

    public void setOptionValueAdaptor(KmMetaAttribute<?,?> attr)
    {
        setOptionValueAdaptor(attr.getAdaptor());
    }

    public void setOptions(List<?> v)
    {
        _options.set(v, _optionValueAdaptor.getValue(), _optionLabelAdaptor.getValue());
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

    protected String formatOnChange()
    {
        if ( !hasAction() )
            return null;

        ScForm form = findFormWrapper();
        ScHtmlIdIF block = findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getAction());
        s.setForm(form);
        s.setModel(getModel());
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
        ajax().setValue(encode(e));
    }

    /**
     * Each option must have a "text" and "value".
     */
    public void ajaxSetOptions(KmJsonList options)
    {
        ajax().run("Kmu.setSelectOptions(%s,%s);", json(formatJquerySelector()), options);
    }

    public void ajaxAddOption(String text, Object value)
    {
        String encoded = encode(value);
        ajax().run(
            "Kmu.addSelectOptionTextValue(%s,%s,%s);",
            json(formatJquerySelector()),
            json(text),
            json(encoded));
    }

    public void ajaxClearOptions()
    {
        ajax().run("Kmu.clearSelectOptions(%s);", json(formatJquerySelector()));
    }

}
