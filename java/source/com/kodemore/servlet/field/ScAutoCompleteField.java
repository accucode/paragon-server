/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

import com.app.ui.servlet.ScServletCallback;
import com.app.ui.servlet.ScServletCallbackRegistry;

/**
 * I am based on...
 * http://jqueryui.com/demos/autocomplete/
 */
public class ScAutoCompleteField
    extends ScField<String>
{
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

        String ref = formatJqueryReference();
        KmJsonObject settings = formatSettings();
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

    private KmJsonObject formatSettings()
    {
        KmJsonObject map;
        map = new KmJsonObject();
        map.setInteger("minLength", getTriggerLength());

        if ( hasCallback() )
            map.setString("source", getSourceCallback());
        else
            map.setList("source", getSourceOptions());

        return map;
    }

    private String getSourceCallback()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getAutoCompleteCallback();

        return c.getPath(getKey());
    }

    private KmJsonList getSourceOptions()
    {
        KmList<String> v;
        v = getOptionsCopy();
        v.sort();

        KmJsonList json;
        json = new KmJsonList();
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
        ScAutoCompleteCallbackIF c = getCallback();
        KmList<String> v = c.getOptionsFor(term);

        KmJsonList json;
        json = new KmJsonList();
        json.addStrings(v);

        data.setJsonResult(json);
    }

}
