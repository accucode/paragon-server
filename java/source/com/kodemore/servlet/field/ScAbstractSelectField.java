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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public abstract class ScAbstractSelectField<T>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocal<T>           _value;

    private ScLocalOptionList<T> _options;
    private ScLocalString        _nullPrefix;

    private ScLocalBoolean       _disabled;
    private ScAction             _onChangeAction;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractSelectField()
    {
        _value = new ScLocal<>();
        _options = new ScLocalOptionList<>();
        _disabled = new ScLocalBoolean(false);
        _nullPrefix = new ScLocalString();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    //==================================================
    //= list
    //==================================================

    private String getListHtmlId()
    {
        return getHtmlId() + "-list";
    }

    private String getListHtmlName()
    {
        return getListHtmlId();
    }

    private String getListSelector()
    {
        return ScJquery.formatIdSelector(getListHtmlId());
    }

    private ScHtmlIdAjax getListAjax()
    {
        return newHtmlIdAjaxOn(getListHtmlId());
    }

    //##################################################
    //# options
    //##################################################

    public KmList<ScOption<T>> getOptions()
    {
        return _options.getValue();
    }

    public void addOption(T value, String label)
    {
        _options.add(value, label);
    }

    public void addOption(T value)
    {
        String label = Kmu.toDisplayString(value);
        addOption(value, label);
    }

    public void clearOptions()
    {
        _options.clear();
    }

    public void setOptions(KmList<T> v)
    {
        clearOptions();
        addOptions(v);
    }

    public void addOptions(KmList<T> v)
    {
        if ( v == null )
            return;

        for ( T e : v )
            addOption(e);
    }

    //##################################################
    //# prefixes
    //##################################################

    public void setNullPrefix(String label)
    {
        _nullPrefix.setValue(label);
    }

    public void setNullAllPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_ALL);
    }

    public void setNullAnyPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_ANY);
    }

    public void setNullDefaultPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_DEFAULT);
    }

    public void setNullNonePrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_NONE);
    }

    public void setNullUnknownPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_UNKNOWN);
    }

    public void setNullSelectPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_SELECT);
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

    //==================================================
    //= value :: convenience
    //==================================================

    /**
     * Ensure value matches one of the options.
     * If not, set it to null.
     */
    public void ensureValidValue()
    {
        if ( isValueValid() )
            return;

        resetValue();
    }

    public boolean isValueValid()
    {
        T value = getValue();

        for ( ScOption<T> e : _options )
            if ( e.hasValue(value) )
                return true;

        return false;
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

    //==================================================
    //= editable
    //==================================================

    @Override
    public boolean isEditable()
    {
        return true;
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
        KmCssDefaultBuilder css = newCssBuilder();
        KmStyleBuilder style = newStyleBuilder();

        if ( !getVisible() )
            style.hide();

        applyLayoutTo(css, style);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        renderHelpOn(out);
        renderSelectOn(out);

        out.endDiv();
    }

    protected abstract void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style);

    private void renderHelpOn(KmHtmlBuilder out)
    {
        out.printHelpImage(getHelp());
    }

    private void renderSelectOn(KmHtmlBuilder out)
    {
        out.open("select");
        out.printAttribute("id", getListHtmlId());
        out.printAttribute("name", getListHtmlName());
        out.printAttribute("size", getSelectSize());
        out.printAttribute("onchange", formatOnChange());

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, encode(getValue()));

        out.close();
        renderOptionsOn(out);
        out.end("select");
    }

    private void renderOptionsOn(KmHtmlBuilder out)
    {
        boolean alreadySelected = false;

        if ( _nullPrefix.isNotNull() )
        {
            boolean selected = renderOptionOn(out, null, _nullPrefix.getValue(), alreadySelected);
            alreadySelected = alreadySelected || selected;
        }

        for ( ScOption<T> e : _options )
        {
            boolean selected = renderOptionOn(out, e.getValue(), e.getText(), alreadySelected);
            alreadySelected = alreadySelected || selected;
        }
    }

    private boolean renderOptionOn(
        KmHtmlBuilder out,
        Object value,
        String text,
        boolean alreadySelected)
    {
        boolean selected = false;
        if ( !alreadySelected )
            if ( Kmu.isEqual(value, getValue()) )
                selected = true;

        out.open("option");
        out.printAttribute("value", encode(value));

        if ( selected )
            out.printAttribute("selected", "selected");

        out.close();
        out.print(text);
        out.end("option");

        return selected;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String s = data.getParameter(getListHtmlName());
        T e = Kmu.hasValue(s)
            ? decodeUnchecked(s)
            : null;
        _value.setValue(e);
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
        String htmlValue = encode(e);

        ScHtmlIdAjax ajax;
        ajax = getListAjax();
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }

    /**
     * Each option must have a "text" and "value".
     */
    public void ajaxSetOptions(KmJsonArray options)
    {
        getRootScript().run("Kmu.setSelectOptions(%s,%s);", json(getListSelector()), options);
    }

    public void ajaxSetOptions(KmList<ScOption<T>> options)
    {
        ajaxSetOptions(getJsonListFrom(options));
    }

    public void ajaxUpdateOptions()
    {
        KmList<ScOption<T>> v;
        v = new KmList<>();
        v.addAll(getOptions());

        ajaxUpdateOptions(v);
    }

    public void ajaxUpdateOptions(KmList<ScOption<T>> v)
    {
        ajaxSetOptions(v);
    }

    public void ajaxAddOption(T value)
    {
        String label = Kmu.toDisplayString(value);
        ajaxAddOption(value, label);
    }

    public void ajaxAddOption(ScOption<T> e)
    {
        ajaxAddOption(e.getValue(), e.getText());
    }

    public void ajaxAddOption(T value, String text)
    {
        getRootScript().run(
            "Kmu.addSelectOptionTextValue(%s,%s,%s);",
            json(getListSelector()),
            json(text),
            json(encode(value)));
    }

    public void ajaxClearOptions()
    {
        getRootScript().run("Kmu.clearSelectOptions(%s);", json(getListSelector()));
    }

    //##################################################
    //# support
    //##################################################

    private KmJsonArray getJsonListFrom(KmList<ScOption<T>> v)
    {
        KmJsonArray e;
        e = new KmJsonArray();

        for ( ScOption<T> option : v )
            e.addMap(getJsonObjectFrom(option));

        return e;
    }

    private KmJsonMap getJsonObjectFrom(ScOption<T> e)
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setString("text", e.getText());
        json.setString("value", encode(e.getValue()));
        return json;
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract int getSelectSize();

}
