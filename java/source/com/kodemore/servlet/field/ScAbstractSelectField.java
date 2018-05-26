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
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public abstract class ScAbstractSelectField<T>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The ID of the outer html element.
     */
    private ScLocalString _htmlId;

    private ScLocal<T> _value;

    private ScLocalString _nullPrefix;

    /**
     * If disabled, the field will not be editable.
     * However, a disabled <select> is generally NOT
     * included in a form post. So, when disabled,
     * we render and additional hidden field so that
     * the value will be included in the post.
     */
    private ScLocalBoolean _disabled;

    private ScAction _onChangeAction;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractSelectField()
    {
        _htmlId = new ScLocalString(getKeyToken());
        _value = new ScLocal<>();
        _disabled = new ScLocalBoolean(false);
        _nullPrefix = new ScLocalString();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public final void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    //==================================================
    //= input
    //==================================================

    protected String getListHtmlId()
    {
        return getHtmlId() + "-list";
    }

    protected String getListHtmlName()
    {
        return getListHtmlId();
    }

    protected String getListSelector()
    {
        return ScJquery.formatIdSelector(getListHtmlId());
    }

    protected String getListReference()
    {
        return ScJquery.formatIdReference(getListHtmlId());
    }

    private ScHtmlIdAjax getListAjax()
    {
        return newHtmlIdAjaxOn(getListHtmlId());
    }

    //##################################################
    //# options
    //##################################################

    /**
     * Return the options to select from.
     *
     * Note that the prefix option is NOT included in this list
     * and is managed separately.
     */
    public abstract KmList<ScOption<T>> getOptions();

    //##################################################
    //# prefixes
    //##################################################

    public String getNullPrefix()
    {
        return _nullPrefix.getValue();
    }

    public boolean hasNullPrefix()
    {
        return _nullPrefix.hasValue();
    }

    public void setNullPrefix(String label)
    {
        _nullPrefix.setValue(label);
    }

    public void setNullBlankPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_BLANK);
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

        for ( ScOption<T> e : getOptions() )
            if ( e.hasValue(value) )
                return true;

        return false;
    }

    public void selectFirstOption()
    {
        ScOption<T> e = getOptions().getFirstSafe();
        if ( e == null )
            clearValue();
        else
            setValue(e.getValue());
    }

    public void selectSingleOption()
    {
        KmList<ScOption<T>> v = getOptions();
        if ( v.isSingleton() )
            setValue(v.getFirst().getValue());
        else
            clearValue();
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

        if ( !isVisible() )
            style.hide();

        applyWrapperLayoutTo(css, style);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        renderHelpOn(out);
        renderSelectOn(out);
        renderHiddenFieldOn(out);

        out.endDiv();
    }

    protected abstract void applyWrapperLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style);

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
        out.printAttribute(formatSelectStyle());

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, encode(getValue()));

        out.close();
        renderOptionsOn(out);
        out.end("select");
    }

    protected KmStyleBuilder formatSelectStyle()
    {
        return null;
    }

    private void renderOptionsOn(KmHtmlBuilder out)
    {
        boolean alreadySelected = false;

        if ( _nullPrefix.isNotNull() )
        {
            boolean selected = renderOptionOn(out, null, _nullPrefix.getValue(), alreadySelected);
            alreadySelected = alreadySelected || selected;
        }

        for ( ScOption<T> e : getOptions() )
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

    /**
     * If disabled, we render the hidden field so that the
     * value is included in the form post.
     */
    private void renderHiddenFieldOn(KmHtmlBuilder out)
    {
        if ( isEnabled() )
            return;

        String name = getListHtmlName();
        String value = encode(getValue());

        out.printHiddenField(name, value);
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
    public final void ajaxSetFieldValue(T e)
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

        _postAjaxUpdate();
    }

    /**
     * Each option must have a "text" and "value".
     */
    public void ajaxSetOptions(KmJsonArray options)
    {
        getRootScript().run("Kmu.setSelectOptions(%s,%s);", json(getListSelector()), options);

        _postAjaxUpdate();
    }

    public final void ajaxSetOptions(KmList<ScOption<T>> options)
    {
        ajaxSetOptions(getJsonListFrom(options));
    }

    public final void ajaxUpdateOptions()
    {
        KmList<ScOption<T>> v;
        v = new KmList<>();
        v.addAll(getOptions());

        ajaxUpdateOptions(v);
    }

    public final void ajaxUpdateOptions(KmList<ScOption<T>> v)
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

        _postAjaxUpdate();
    }

    protected void _postAjaxUpdate()
    {
        // subclass
    }

    public final void ajaxClearOptions()
    {
        getRootScript().run("Kmu.clearSelectOptions(%s);", json(getListSelector()));

        _postAjaxUpdate();
    }

    public void ajaxFireChanged()
    {
        getListAjax().fireChanged();
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
