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
import com.kodemore.html.KmCssMarginBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSetCheckedByNameScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.utility.Kmu;

/**
 * I edit a LIST of values using a collection of checkboxes.
 */
public class ScCheckboxList<T>
    extends ScField<KmList<T>>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Each field must manage a 'single' value, e.g.: getValue, setValue().
     * In this case, the value is a single LIST.  Only values that correspond
     * to the option values will be checked.
     */
    private ScLocalList<T>       _list;

    /**
     * The options define the display labels and values for the list of
     * checkboxes.  Each option should have a distinct value.
     */
    private ScLocalOptionList<T> _options;

    /**
     * The options define the help messages for the options.  The value corresponds
     * to the value in the _options list, and the text is the help message that should
     * be displayed.
     */
    private ScLocalOptionList<T> _helpOptions;

    /**
     * The height of the field in pixels.
     * The checkboxes are organized in a series of columns.
     * The height determines how many options can be listed in each column.
     * If null, the height is not constrained.
     */
    private Integer              _height;

    /**
     * If true, the checkbox button is disabled.
     * Bear in mind that disabled fields are NOT submitted with the form.
     * False by default.
     */
    private ScLocalBoolean       _disabled;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss           _cssMargin;

    private ScAction             _onChangeAction;

    //##################################################
    //# constructor
    //##################################################

    public ScCheckboxList()
    {
        _list = new ScLocalList<>();
        _options = new ScLocalOptionList<>();
        _helpOptions = new ScLocalOptionList<>();
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
        addOption(value, label, null);
    }

    public void addOption(T value, String label, String help)
    {
        _options.add(value, label);

        if ( Kmu.hasValue(help) )
            _helpOptions.add(value, help);
    }

    public void addOption(ScOption<T> e)
    {
        _options.add(e);
    }

    //##################################################
    //# help options
    //##################################################

    public void setHelpOptions(KmList<ScOption<T>> v)
    {
        _helpOptions.setValue(v);
    }

    public void addHelpOption(T value, String help)
    {
        _helpOptions.add(value, help);
    }

    public void addHelpOption(ScOption<T> e)
    {
        _helpOptions.add(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmList<T> getValue()
    {
        return _list.getValue();
    }

    @Override
    public void setValue(KmList<T> v)
    {
        _list.setValue(v);
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _list.saveValue();
    }

    @Override
    public void resetValue()
    {
        _list.resetValue();
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

    public boolean hasOnChangeAction()
    {
        return _onChangeAction != null;
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
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        KmList<String> encodedValues = data.getParameters(getInputName());
        KmList<T> decodedValues = encodedValues.collect(e -> decodeUnchecked(e));
        _list.setValue(decodedValues);
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
        css.checkboxList();
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
        Object item = e.getValue();
        boolean checked = getValue().contains(item);
        String help = getHelpFor(e);

        KmCssDefaultBuilder css = new KmCssDefaultBuilder();
        css.flexRow().flexCrossAlignCenter();
        css.checkboxField().checkboxField_enabled();

        KmStyleBuilder style;
        style = new KmStyleBuilder();
        style.margin(3);

        out.openDiv();
        out.printAttribute(css);
        out.printAttribute(style);
        out.close();

        renderHelpOn(out, help);

        out.open("input");
        out.printAttribute("type", "checkbox");
        out.printAttribute("name", name);
        out.printAttribute("value", encode(item));

        if ( hasOnChangeAction() )
            out.printAttribute("onchange", formatOnChange());

        if ( getChangeTracking() )
            printOldCheckedAttributeOn(out, checked);

        if ( !isEditable() )
            out.printAttribute("disabled", "disabled");

        if ( checked )
            out.printAttribute("checked");

        out.close();
        // no end tag

        out.endDiv();
    }

    private void renderOptionTextOn(KmHtmlBuilder out, ScOption<T> e)
    {
        out.open("span");
        out.close();
        out.print(e.getText());
        out.end("span");
    }

    private void renderHelpOn(KmHtmlBuilder out, String help)
    {
        if ( Kmu.isEmpty(help) )
            return;

        out.printHelpImage(help);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(KmList<T> v)
    {
        ajaxSetFieldValue(v, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(KmList<T> v, boolean updateOldValue)
    {
        ajaxClearFieldValue(updateOldValue);

        for ( T e : v )
        {
            ScSetCheckedByNameScript s;
            s = getRootScript().setCheckedByName();
            s.setName(getInputName());
            s.setValue(e);
            s.setChangeTracking(updateOldValue);
            s.setChecked(true);
        }
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
        return getKey();
    }

    private String getHelpFor(ScOption<T> e)
    {
        T value = e.getValue();

        KmList<ScOption<T>> v = _helpOptions.getValue();
        ScOption<T> helpOption = v.detect(x -> x.hasValue(value));

        if ( helpOption != null )
            return helpOption.getText();

        return null;
    }
}
