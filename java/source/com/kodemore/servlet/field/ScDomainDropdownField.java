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

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalFunction;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEnumIF;
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
    //# constants
    //##################################################

    private static final Integer DEFAULT_INLINE_WIDTH = 200;

    //##################################################
    //# static :: layout enum
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
        implements KmEnumIF
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
    private ScLocal<K> _valueKey;

    private ScLocalFunction<T,K>      _optionKeyFunction;
    private ScLocalFunction<T,String> _optionLabelFunction;

    private ScLocalString _nullPrefix;

    private ScLocalBoolean _disabled;

    /**
     * Used to find the list of options to be displayed.
     * The list is not cached; it is refetched during preRender.
     */
    private Supplier<KmList<T>> _optionSupplier;

    /**
     * Find a model by its key.  This lookup is independent of
     * the filter.  In practice, the value returned should be
     * a value from the filter, but this is not guaranteed or validated.
     */
    private KmKeyFinderIF<T,K> _finder;

    /**
     * If set, this action will be called each time the user changes the
     * dropdown selection.
     */
    private ScAction _onChangeAction;

    /**
     * The layout is used to coordinate the styling of the outer wrapper
     * with the inner select so that the multiple parts are work together.
     */
    private Layout _layout;

    /**
     * The width of the dropdown, in pixels.
     * If null, the size of the dropdown is determined by its widest option.
     */
    private ScLocalInteger _maximumInlineWidth;

    /**
     * The 'name' used by the html 'input' element. This is
     * normally defaulted to a unique value. Clients only need
     * to set this when dynamically creating complex layouts.
     */
    private ScLocalString _htmlName;

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
        _maximumInlineWidth = new ScLocalInteger();
        _htmlName = new ScLocalString(getSelectHtmlId());

        layoutInline();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    private String getSelectHtmlId()
    {
        return getKey() + "-select";
    }

    //##################################################
    //# html name
    //##################################################

    public void setHtmlName(String e)
    {
        _htmlName.setValue(e);
    }

    private String getSelectHtmlName()
    {
        return _htmlName.getValue();
    }

    //##################################################
    //# encodable value
    //##################################################

    @Override
    public Object getEncodableValue()
    {
        return getValueKey();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setEncodableValue(Object e)
    {
        K key = (K)e;
        setValueKey(key);
    }

    //##################################################
    //# option supplier
    //##################################################

    public Supplier<KmList<T>> getOptionSupplier()
    {
        return _optionSupplier;
    }

    public void setOptionSupplier(Supplier<KmList<T>> e)
    {
        _optionSupplier = e;
    }

    //==================================================
    //= filter :: options
    //==================================================

    public KmList<T> getOptions()
    {
        return _optionSupplier == null
            ? KmList.createEmpty()
            : _optionSupplier.get();
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
    //# meta
    //##################################################

    @Override
    public void setMeta(KmMetaAssociation<?,T> x)
    {
        super.setMeta(x);

        if ( x.isRequired() )
            setNullSelectPrefix();
        else
            setNullNonePrefix();
    }

    @Override
    public void setMeta(KmMetaProperty<?,T> x)
    {
        super.setMeta(x);

        if ( x.isRequired() )
            setNullSelectPrefix();
        else
            setNullNonePrefix();
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

    public void selectFirstValue()
    {
        T value = getOptions().getFirstSafe();
        setValue(value);
    }

    public void selectSingleValue()
    {
        KmList<T> v = getOptions();
        if ( v.isSingleton() )
        {
            T value = v.getFirstSafe();
            setValue(value);
        }
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

    public final K getValueKey()
    {
        return _valueKey.getValue();
    }

    private void setValueKey(K e)
    {
        _valueKey.setValue(e);
    }

    public final boolean hasValueKey()
    {
        return getValueKey() != null;
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
        _maximumInlineWidth.setValue(DEFAULT_INLINE_WIDTH);
    }

    public void layoutInlineDefault()
    {
        _layout = Layout.inline;
        _maximumInlineWidth.clearValue();
    }

    public void layoutInline(int width)
    {
        _layout = Layout.inline;
        _maximumInlineWidth.setValue(width);
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
                css.dropdownFieldInline();
                break;

            case block:
                css.dropdownFieldBlock();
                break;

            case flexFiller:
                css.dropdownFieldFlexFiller();
                break;
        }
        return css;
    }

    private KmStyleBuilder getStyle()
    {
        return isVisible()
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

        out.printAttribute(getSelectStyle());

        out.close();

        renderNullPrefix(out);
        renderOptionsOn(out);

        out.end("select");
    }

    private KmStyleBuilder getSelectStyle()
    {
        switch ( _layout )
        {
            case block:
            case flexFiller:
                return null;

            case inline:
                if ( !_maximumInlineWidth.hasValue() )
                    return null;

                KmStyleBuilder style;
                style = new KmStyleBuilder();
                style.maxWidth(_maximumInlineWidth.getValue());
                return style;
        }
        throw Kmu.newEnumError(_layout);
    }

    private void renderNullPrefix(KmHtmlBuilder out)
    {
        if ( _nullPrefix.isNotNull() )
            renderOption(out, null, null, _nullPrefix.getValue());
    }

    private void renderOptionsOn(KmHtmlBuilder out)
    {
        renderOptionsOn(out, getOptions());
    }

    private void renderOptionsOn(KmHtmlBuilder out, List<T> v)
    {
        if ( hasValue() )
            if ( !v.contains(getValue()) )
                renderOption(out, getValue());

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
