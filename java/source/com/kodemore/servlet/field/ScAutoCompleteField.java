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

import java.util.Iterator;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

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

    private static final String      PARAMETER_TRACKED_VALUES = "trackedValues";

    //##################################################
    //# variables
    //##################################################

    /**
     * The value of the text field.  This value is read
     * from the form post, and displayed in the text field.
     */
    private ScLocalString            _text;

    /**
     * The number of characters that must be entered in
     * order to trigger autocompletion.  Valid values 
     * are 1..n.  The default is 1.  
     */
    private ScLocalInteger           _triggerLength;

    /**
     * The list of options to display in the list.
     */
    private ScLocalStringList        _options;

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
     * be rebound to their respective ScValue's prior to execute 
     * the filter.
     */
    private KmList<ScEncodedValueIF> _trackedValues;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _text = new ScLocalString();
        _triggerLength = new ScLocalInteger(1);
        _options = new ScLocalStringList();
        _callback = null;
        _trackedValues = new KmList<ScEncodedValueIF>();
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text.getValue();
    }

    public void setText(String e)
    {
        _text.setValue(e);
    }

    public boolean hasText()
    {
        return Kmu.hasValue(getText());
    }

    public boolean hasText(String e)
    {
        return _text.is(e);
    }

    public void clearText()
    {
        _text.setValue("");
    }

    public boolean isEmpty()
    {
        return !hasText();
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
        if ( c instanceof ScEncodedValueIF )
            track((ScEncodedValueIF)c);

        Iterator<ScControl> i = c.getComponents();
        while ( i.hasNext() )
        {
            ScControl e = i.next();

            if ( e instanceof ScEncodedValueIF )
                track((ScEncodedValueIF)e);

            trackAll(e);
        }
    }

    private KmList<?> getTrackedValues()
    {
        KmList<Object> v = new KmList<Object>();

        for ( ScEncodedValueIF value : _trackedValues )
            v.add(value.getEncodedValue());

        return v;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        if ( _text.isEmpty() )
            return null;

        return _text.getValue();
    }

    @Override
    public void setValue(String e)
    {
        _text.setValue(e);
    }

    //##################################################
    //# page session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
        _text.saveValue();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        resetValue();
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        return true;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String name = getHtmlName();
        String text = data.getParameter(name);

        setText(text);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("input");
        renderAttributesOn(out);
        out.close();

        String ref = getJqueryReference();
        KmJsonMap settings = formatSettings();
        out.getPostDom().run("%s.autocomplete(%s);", ref, settings);

        // no end tag
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("type", "text");
        out.printAttribute("value", getText());
        out.printAttribute(formatCss());
    }

    private KmCssDefaultBuilder formatCss()
    {
        return newCssBuilder().textField();
    }

    private KmJsonMap formatSettings()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setInteger("minLength", getTriggerLength());

        if ( hasCallback() )
            map.setString("source", getSourceCallback());
        else
            map.setArray("source", getSourceOptions());

        return map;
    }

    private String getSourceCallback()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getAutoCompleteCallback();

        String path = c.getPath(getKey());
        String addedValues = getFormattedTrackedValues();

        return path + addedValues;
    }

    private String getFormattedTrackedValues()
    {
        KmList<?> trackedValues = getTrackedValues();

        String encodedValues;
        encodedValues = ScEncoder.staticEncode(trackedValues);

        String result;
        result = "?" + PARAMETER_TRACKED_VALUES + "=" + encodedValues;

        return result;
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
     */
    public static void handleServletCallback(String pathSuffix)
    {
        /*
         * We assume the pathSuffix is the control's key since that is 
         * what we provided when composing the url.  See getSourceCallback().
         */
        String key = pathSuffix;

        ScControlRegistry r = ScControlRegistry.getInstance();
        ScControl c = r.getControl(key);

        ScAutoCompleteField f;
        f = (ScAutoCompleteField)c;
        f._handleServletCallback();
    }

    private void _handleServletCallback()
    {
        ScServletData data = getData();
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
            nextValue.setEncodedValue(nextDecode);
        }
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajax().setValue(getText());
    }

}
