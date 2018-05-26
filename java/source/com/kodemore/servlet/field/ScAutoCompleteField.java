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

import java.util.Iterator;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmCssMarginBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScTypeWatchScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

import com.app.utility.MyConstantsIF;

/**
 * I am based on...
 * http://jqueryui.com/demos/autocomplete/
 */
public class ScAutoCompleteField
    extends ScField<String>
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAMETER_TRACKED_VALUES = "trackedValues";

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
        flexFiller
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The html name for the input element.
     */
    private ScLocalString _htmlName;

    /**
     * The value of the text field.  This value is read
     * from the form post, and displayed in the text field.
     */
    private ScLocalString _text;

    /**
     * The number of characters that must be entered in
     * order to trigger autocompletion.  Valid values
     * are 1..n.  The default is 1.
     */
    private ScLocalInteger _triggerLength;

    /**
     * The list of options to display in the list.
     */
    private ScLocalStringList _options;

    /**
     * Used to dynamically fill the options as the
     * user types.  If set, this takes precedence
     * over the static options.
     */
    private ScAutoCompleteCallbackIF _callback;

    /**
     * Used to bind extra data for filtering and sorting.
     * The values in this list will be encoded into the Auto
     * complete field's callback request url.  The values will
     * be rebound to their respective ScValue's before running
     * the filter.
     *
     * PAGE SESSION: any values tracked in the client-side page session
     * are automatically submitted and should not be tracked directly.
     */
    private KmList<ScEncodedValueIF> _trackedValues;

    private ScLocalBoolean _readOnly;

    /**
     * The type of layout to apply. Because this is a composite with multiple
     * pieces (wrapper, input, image) it is not safe for clients to directly
     * set the layout via css.  Instead, clients use one of the layout*() methods
     * that ensure the different elements are coordinated correctly.
     */
    private Layout _layout;

    /**
     * Used in conjuction with the layoutFixed.
     */
    private int _layoutWidth;

    /**
     * Clients are not allowed directly access to the css since that will likely
     * cause problems.  However, clients are allowed to directly adjust the margin
     * for minor layout adjustments.
     */
    private ScLocalCss _cssMargin;

    /**
     * If set, this action is run when a user selects a value from the list,
     * and BEFORE that value is copied into the text field.
     * data.getExtra is populated with the selected value.
     */
    private ScAction _selectAction;

    /**
     * The prompt to display INSIDE the text field when no value is entered.
     */
    private ScLocalString _placeholder;

    /**
     * If set, install the typeWatch script to notify the server when
     * the user stops typing.
     */
    private ScAction _typeWatchAction;

    private int _typeWatchDelay;

    //##################################################
    //# constructor
    //##################################################

    public ScAutoCompleteField()
    {
        _htmlName = new ScLocalString(getKeyToken());
        _text = new ScLocalString();
        _triggerLength = new ScLocalInteger(1);
        _options = new ScLocalStringList();
        _callback = null;
        _trackedValues = new KmList<>();
        _readOnly = new ScLocalBoolean(false);
        _cssMargin = new ScLocalCss();
        _placeholder = new ScLocalString();
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

    public String getInputHtmlId()
    {
        return getHtmlId() + "-input";
    }

    private ScHtmlIdAjax inputAjax()
    {
        return new ScHtmlId(getInputHtmlId(), getRootScript())._htmlIdAjax();
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
    public String getValue()
    {
        return _text.hasValue()
            ? _text.getValue()
            : null;
    }

    @Override
    public void setValue(String e)
    {
        if ( Kmu.hasValue(e) )
            _text.setValue(e);
        else
            _text.clearValue();
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _text.saveValue();
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    //##################################################
    //# read only
    //##################################################

    public boolean getReadOnly()
    {
        return _readOnly.isTrue();
    }

    public void setReadOnly(boolean e)
    {
        _readOnly.setValue(e);
    }

    public boolean isEnabled()
    {
        return !getReadOnly();
    }

    //##################################################
    //# trigger
    //##################################################

    public int getTriggerLength()
    {
        return _triggerLength.getValue();
    }

    public void setTriggerLength(int e)
    {
        _triggerLength.setValue(e);
    }

    //##################################################
    //# options
    //##################################################

    public KmList<String> getOptionsCopy()
    {
        return _options.getValue();
    }

    public void addOption(String e)
    {
        _options.add(e);
    }

    public void addOptions(List<String> v)
    {
        _options.addAll(v);
    }

    public void removeOption(String e)
    {
        _options.remove(e);
    }

    public void clearOptions()
    {
        _options.clear();
    }

    //##################################################
    //# callback
    //##################################################

    public ScAutoCompleteCallbackIF getCallback()
    {
        return _callback;
    }

    public void setCallback(ScAutoCompleteCallbackIF e)
    {
        _callback = e;
    }

    public boolean hasCallback()
    {
        return _callback != null;
    }

    //##################################################
    //# tracking
    //##################################################

    public void track(ScEncodedValueIF e)
    {
        _trackedValues.add(e);
    }

    public void trackAll(ScControl c)
    {
        c.visitAllEncodedValues(e -> track(e));
    }

    private KmList<?> getTrackedValues()
    {
        return _trackedValues.collect(e -> e.getEncodableValue());
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        layoutInline(200);
    }

    public void layoutInline(int widthPx)
    {
        _layout = Layout.inline;
        _layoutWidth = widthPx;
    }

    public void layoutBlock()
    {
        _layout = Layout.block;
    }

    public void layoutFlexFiller()
    {
        _layout = Layout.flexFiller;
    }

    public void setWidthFull()
    {
        layoutBlock();
    }

    //##################################################
    //# on select
    //##################################################

    public void onSelect(ScAction e)
    {
        _selectAction = e;
    }

    public ScAction getSelectAction()
    {
        return _selectAction;
    }

    public boolean hasSelectAction()
    {
        return _selectAction != null;
    }

    //##################################################
    //# on type watch
    //##################################################

    public void onTypeWatch(ScAction e)
    {
        onTypeWatch(e, 500);
    }

    public void onTypeWatch(ScAction action, int delayMs)
    {
        _typeWatchAction = action;
        _typeWatchDelay = delayMs;
    }

    public ScAction getTypeWatchAction()
    {
        return _typeWatchAction;
    }

    public boolean hasTypeWatchAction()
    {
        return _typeWatchAction != null;
    }

    public int getTypeWatchDelayMs()
    {
        return _typeWatchDelay;
    }

    //##################################################
    //# placeholder
    //##################################################

    public void setPlaceholder(String e)
    {
        _placeholder.setValue(e);
    }

    public String getPlaceholder()
    {
        return _placeholder.getValue();
    }

    public void clearPlaceHolder()
    {
        setPlaceholder(null);
    }

    public boolean hasPlaceholder()
    {
        return _placeholder.hasValue();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getHtmlName();
        String text = data.getParameter(name);
        setValue(text);
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
        out.printAttribute("type", "text");
        out.printAttribute("value", getValue());
        out.printAttribute("placeholder", getPlaceholder());

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, getValue());

        out.close();

        String ref = ScJquery.formatIdReference(getInputHtmlId());
        KmJsonMap options = formatOptions();
        out.getPostDom().run("%s.autocomplete(%s);", ref, options);

        if ( hasTypeWatchAction() )
        {
            ScActionScript action;
            action = new ScActionScript();
            action.setAction(getTypeWatchAction());
            action.setForm(findFormWrapper());
            action.setBlockTarget(findBlockWrapper());

            ScTypeWatchScript watch;
            watch = new ScTypeWatchScript();
            watch.setSelector(ScJquery.formatIdSelector(getInputHtmlId()));
            watch.setCallback(action.formatScript());
            watch.setDelayMs(getTypeWatchDelayMs());

            out.getPostDom().run(watch);
        }

        // no end tag
    }

    //==================================================
    //= render :: supuport
    //==================================================

    private KmCssDefaultBuilder getCss()
    {
        KmCssDefaultBuilder css;
        css = new KmCssDefaultBuilder();
        css.autoCompleteField();
        css.addAll(cssMargin().getSelectors());

        if ( isEditable() )
            css.autoCompleteField_editable();
        else
            css.autoCompleteField_readonly();

        return css;
    }

    private void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        switch ( _layout )
        {
            case inline:
                css.inlineBlock();
                style.width(_layoutWidth);
                break;

            case block:
                css.block();
                break;

            case flexFiller:
                css.flexChildFiller();
                break;
        }
    }

    private KmJsonMap formatOptions()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setInteger("minLength", getTriggerLength());

        if ( hasCallback() )
            map.setLiteral("source", getSourceCallback());
        else
            map.setArray("source", getSourceOptions());

        if ( hasSelectAction() )
            map.setLiteral("select", formatSelectFunction());

        addAppendOption(map);

        return map;
    }

    /**
     * According to the jquery-ui documentation, c. Oct 2017:
     * https://api.jqueryui.com/autocomplete/#option-appendTo
     *      when the [appendTo] value is null, the parents of the input field will be
     *      checked for a class of ui-front
     *
     * This approach DOES work for other widgets such as jquery-ui datePicker.
     * But it does NOT work for the auto-complete field.
     * The common workaround on the web appears to be manually setting the appendTo
     * rather than relying on jquery to handle it automatically.
     *
     * We tested this in both jquery 1.11 and 1.12 (the current version).
     * Both have the same issue, so we're manually setting the append to as a workaround.
     */
    private void addAppendOption(KmJsonMap map)
    {
        ScForm form = findFormWrapper();
        if ( form != null )
            map.setString("appendTo", form.getJquerySelector());
    }

    private String formatSelectFunction()
    {
        ScActionScript script;
        script = new ScActionScript();
        script.setAction(getSelectAction());
        script.setForm(findFormWrapper());
        script.setExtraLiteral("ui.item.label");

        return Kmu.format("function(ev,ui){%s}", script);
    }

    /**
     * The path suffix defined here is subsequently parsed in handleServletCallback.
     *
     * @see #handleServletCallback
     */
    private String getSourceCallback()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getAutoCompleteCallback();

        String path = c.getPath(getKeyToken());
        String trackedValues = ScEncoder.staticEncode(getTrackedValues());

        KmJsonMap options;
        options = new KmJsonMap();
        options.setString("path", path);
        options.setString("trackedValues", trackedValues);

        return Kmu.format("Kmu.createAutoCompleteCallback(%s)", options);
    }

    private KmJsonArray getSourceOptions()
    {
        KmList<String> v;
        v = getOptionsCopy();
        v.sort();

        KmJsonArray json;
        json = new KmJsonArray();
        json.addStrings(v);
        return json;
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# servlet callback
    //##################################################

    /**
     * Handle servlet callback requests to fill the dropdown dynamically.
     * Callback handlers are registered in the ScServletCallbackRegistry.
     *
     * The path suffix here is defined in getSourceCallback.
     * @see #getSourceCallback
     */
    public static void handleServletCallback(String pathSuffix)
    {
        String token = pathSuffix;
        ScControl c = getRegistry().findToken(token);

        ScAutoCompleteField f;
        f = (ScAutoCompleteField)c;
        f._handleServletCallback();
    }

    private void _handleServletCallback()
    {
        ScServletData data = getData();

        String requestVersion = data.getApplicationVersion();
        String currentVersion = MyConstantsIF.APPLICATION_VERSION;
        if ( !Kmu.isEqual(currentVersion, requestVersion) )
        {
            data.setJsonResult(new KmJsonArray());
            return;
        }

        String term = data.getParameter("term");
        applyTrackedValuesFor(data);

        ScAutoCompleteCallbackIF c = getCallback();
        KmList<String> v = c.getOptionsFor(term);

        KmJsonArray json;
        json = new KmJsonArray();
        json.addStrings(v);

        data.setJsonResult(json);
    }

    private void applyTrackedValuesFor(ScServletData data)
    {
        String encodedValues = data.getParameter(PARAMETER_TRACKED_VALUES);

        if ( Kmu.isEmpty(encodedValues) )
            return;

        KmList<?> decodedValues = (KmList<?>)ScDecoder.staticDecode(encodedValues);
        Iterator<?> decodedIterator = decodedValues.iterator();
        Iterator<ScEncodedValueIF> trackedIterator = _trackedValues.iterator();

        while ( decodedIterator.hasNext() )
        {
            Object nextDecode = decodedIterator.next();

            ScEncodedValueIF nextValue;
            nextValue = trackedIterator.next();
            nextValue.setEncodableValue(nextDecode);
        }
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(String e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(String e, boolean updateOldValue)
    {
        String htmlValue = hasValue()
            ? getValue()
            : "";

        ScHtmlIdAjax ajax;
        ajax = inputAjax();
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }
}
