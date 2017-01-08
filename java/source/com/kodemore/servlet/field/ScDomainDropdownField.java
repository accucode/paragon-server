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

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalFunction;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmKeyFinderIF;
import com.kodemore.utility.Kmu;

/**
 * I display a dropdown to select a single domain value.
 *
 * Unlike the ScDropdown or ScListField, I am specialized to
 * coordinate a list of domain objects rather than a list of
 * simple value such as string, integer, or date.
 *
 * Since domain models are not directly renderable or encodable
 * clients must configure adapters for the key and label.
 *
 * Clients cannot set the options directly.  Instead clients
 * specify a filter (or filter factory) that automatically
 * fetches the pertinent options when needed.
 */
public class ScDomainDropdownField<T, K>
    extends ScField<T>
{
    //##################################################
    //# static :: layout enum
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
    {
        /**
         * Treat the control as an inline element, with a fixed width.
         * This is similar to the way a standalone input element works.
         * This is the default.
         */
        inline,

        /**
         * Treat the control as a block element (not inline).
         * The control will generally span an entire row, much like a div.
         */
        block,

        /**
         * For use inside a flexbox (row), the child will fill the available space.
         */
        flexFiller;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The key of the currently selected value.
     * Note that the dropdown's value is typically a domain model, e.g.: Customer.
     * But the key is typically a string such as the Customer's uid.
     */
    private ScLocal<K>                _valueKey;

    private ScLocalFunction<T,K>      _optionKeyFunction;
    private ScLocalFunction<T,String> _optionLabelFunction;

    private ScLocalString             _nullPrefix;

    private ScLocalBoolean            _disabled;

    /**
     * Used to find the list of options to be displayed.
     * The list is not cached; it is refetched during preRender.
     * Clients should set either the filter or filterFactory; NOT both.
     *
     * @see #_filterFactory
     */
    private KmFilterIF<T>             _filter;

    /**
     * Used to specify a dynamic filter.
     * This could be configured to incorporate the current time, or the currently
     * selected user, or other factors that may be different eacy time we fill
     * the options.
     * Clients should set either the filter or filterFactory; NOT both.
     * @see #_filter
     */
    private KmFilterFactoryIF<T>      _filterFactory;

    /**
     * Find a model by its key.  This lookup is independent of
     * the filter.  In practice, the value returned should be
     * a value from the filter, but this is not guaranteed or validated.
     */
    private KmKeyFinderIF<T,K>        _finder;

    /**
     * If set, this action will be called each time the user changes the
     * dropdown selection.
     */
    private ScAction                  _onChangeAction;

    private Layout                    _layout;

    //##################################################
    //# constructor
    //##################################################

    public ScDomainDropdownField()
    {
        _valueKey = new ScLocal<>();

        _optionKeyFunction = new ScLocalFunction<>();
        _optionLabelFunction = new ScLocalFunction<>();

        _disabled = new ScLocalBoolean(false);

        _nullPrefix = new ScLocalString();
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

    private String getSelectHtmlId()
    {
        return getKey() + "-select";
    }

    private String getSelectHtmlName()
    {
        return getSelectHtmlId();
    }

    //##################################################
    //# encodable value
    //##################################################

    @Override
    public Object getEncodableValue()
    {
        return getKeyFor(getValue());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setEncodableValue(Object e)
    {
        K key = (K)e;
        setValue(findValue(key));
    }

    //##################################################
    //# filter
    //##################################################

    public KmFilterIF<T> getFilter()
    {
        return _filter;
    }

    public void setFilter(KmFilterIF<T> e)
    {
        _filter = e;
        _filterFactory = null;
    }

    //==================================================
    //= filter factory
    //==================================================

    public KmFilterFactoryIF<T> getFilterFactory()
    {
        return _filterFactory;
    }

    public void setFilterFactory(KmFilterFactoryIF<T> e)
    {
        _filter = null;
        _filterFactory = e;
    }

    public void setFilterFactoryWith(Supplier<KmFilterIF<T>> sup)
    {
        KmFilterFactoryIF<T> ff = new KmFilterFactoryIF<T>()
        {
            @Override
            public KmFilterIF<T> createFilter()
            {
                return sup.get();
            }
        };
        setFilterFactory(ff);
    }

    //==================================================
    //= filter :: options
    //==================================================

    private KmList<T> getOptions()
    {
        if ( _filter != null )
            return _filter.findAll();

        if ( _filterFactory != null )
            return _filterFactory.createFilter().findAll();

        return new KmList<>();
    }

    //##################################################
    //# finder
    //##################################################

    public KmKeyFinderIF<T,K> getFinder()
    {
        return _finder;
    }

    public void setFinder(KmKeyFinderIF<T,K> e)
    {
        _finder = e;
    }

    private T findValue(K key)
    {
        if ( _finder == null )
            return null;

        return _finder.find(key);
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

    public void setNullSelectPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_SELECT);
    }

    public void setNullUnknownPrefix()
    {
        setNullPrefix(ScConstantsIF.NULL_PREFIX_UNKNOWN);
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
    //# options :: keys
    //##################################################

    public Function<T,K> getOptionKeyFunction()
    {
        return _optionKeyFunction.getValue();
    }

    public void setOptionKeyFunction(Function<T,K> e)
    {
        _optionKeyFunction.setValue(e);
    }

    private K getKeyFor(T value)
    {
        return Kmu.applySafe(getOptionKeyFunction(), value);
    }

    //==================================================
    //= options :: labels
    //==================================================

    public Function<T,String> getOptionLabelFunction()
    {
        return _optionLabelFunction.getValue();
    }

    public void setOptionLabelFunction(Function<T,String> e)
    {
        _optionLabelFunction.setValue(e);
    }

    private String getLabelFor(T value)
    {
        return Kmu.applySafe(getOptionLabelFunction(), value);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        if ( _valueKey.isNull() )
            return null;

        K key = _valueKey.getValue();
        return findValue(key);
    }

    @Override
    public void setValue(T e)
    {
        _valueKey.setValue(getKeyFor(e));
    }

    /**
     * Ensure that the value is valid (or null).
     * Clear the value if it is not included the list of options.
     * Return true if the value is modified.
     */
    public boolean ensureValidValue()
    {
        if ( !hasValue() )
            return false;

        if ( getOptions().contains(getValue()) )
            return false;

        clearValue();
        return true;
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _valueKey.saveValue();
    }

    @Override
    public void resetValue()
    {
        _valueKey.resetValue();
    }

    //==================================================
    //= value :: key
    //==================================================

    private K getValueKey()
    {
        return _valueKey.getValue();
    }

    //##################################################
    //# enabled
    //##################################################

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

    @Override
    public boolean isEditable()
    {
        return !isDisabled();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        _layout = Layout.inline;
    }

    public void layoutBlock()
    {
        _layout = Layout.block;
    }

    public void layoutFlexFiller()
    {
        _layout = Layout.flexFiller;
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
        out.printAttribute(getStyle());
        out.close();

        renderHelpOn(out);
        renderSelectOn(out);

        out.endDiv();
    }

    private KmCssDefaultBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = newCssBuilder();
        css.dropdownField();

        switch ( _layout )
        {
            case inline:
                css.flexInlineRow();
                break;

            case block:
                css.flexRow();
                break;

            case flexFiller:
                css.flexInlineRow();
                css.flexChildFiller();
                break;
        }
        return css;
    }

    private KmStyleBuilder getStyle()
    {
        return getVisible()
            ? null
            : newStyleBuilder().hide();
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        out.printHelpImage(getHelp());
    }

    public void renderSelectOn(KmHtmlBuilder out)
    {
        out.open("select");
        out.printAttribute("id", getSelectHtmlId());
        out.printAttribute("name", getSelectHtmlName());
        out.printAttribute("size", 1);
        out.printAttribute("onchange", formatOnChange());

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, encode(getValueKey()));

        out.close();

        renderNullPrefix(out);
        renderOptions(out, getOptions());

        out.end("select");
    }

    private void renderNullPrefix(KmHtmlBuilder out)
    {
        if ( _nullPrefix.isNotNull() )
            renderOption(out, null, null, _nullPrefix.getValue());
    }

    private void renderOptions(KmHtmlBuilder out, List<T> v)
    {
        if ( v != null )
            for ( T e : v )
                renderOption(out, e);
    }

    private void renderOption(KmHtmlBuilder out, T value)
    {
        K key = getKeyFor(value);
        String label = getLabelFor(value);
        renderOption(out, value, key, label);
    }

    private void renderOption(KmHtmlBuilder out, T value, K key, String label)
    {
        String encodedKey = encode(key);
        boolean isSelected = Kmu.isEqual(getValue(), value);

        out.open("option");
        out.printAttribute("value", encodedKey);

        if ( isSelected )
            out.printAttribute("selected");

        out.close();
        out.print(label);
        out.end("option");
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        String htmlName = getSelectHtmlName();

        if ( !data.hasParameter(htmlName) )
            return;

        K key = decodeUnchecked(data.getParameter(htmlName));
        _valueKey.setValue(key);
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
        String htmlValue = encode(getKeyFor(e));

        ScHtmlIdAjax ajax;
        ajax = newHtmlIdAjaxOn(getSelectHtmlId());
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }

}
