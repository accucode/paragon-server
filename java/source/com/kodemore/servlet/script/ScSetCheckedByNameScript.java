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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.string.KmStringBuilder;

/**
 * Un/check one or more checkboxes based on their name and value,
 * rather than based on their html id.
 */
public class ScSetCheckedByNameScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The REQUIRED html name of the checkbox.
     * If multiple checkboxes has the same name, they will all be updated.
     */
    private String  _name;

    /**
     * The OPTIONAL checkbox value.
     * If specified, only checkboxes that have this value will be updated.
     * This value must be an 'encodable' value that is compatible
     * with ScEncoder.
     */
    private Object  _value;

    /**
     * Determine if the value should be used.
     * This allows clients to set the value to null.
     */
    private boolean _usesValue;

    /**
     * If true, the default, then the checkboxes 'old' data attribute
     * is updated to coordinate client side change tracking.
     */
    private boolean _changeTracking;

    /**
     * The state to set for the identified checkboxes.
     */
    private boolean _checked;

    //##################################################
    //# constructor
    //##################################################

    public ScSetCheckedByNameScript()
    {
        _changeTracking = true;
        _checked = false;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# value
    //##################################################

    public Object getValue()
    {
        return _value;
    }

    public void setValue(Object e)
    {
        _value = e;
        _usesValue = true;
    }

    public boolean usesValue()
    {
        return _usesValue;
    }

    //##################################################
    //# change tracking
    //##################################################

    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# checked
    //##################################################

    public boolean getChecked()
    {
        return _checked;
    }

    public void setChecked(boolean e)
    {
        _checked = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setString("name", getName());

        if ( usesValue() )
            json.setString("value", ScEncoder.staticEncode(getValue()));

        json.setBoolean("changeTracking", getChangeTracking());
        json.setBoolean("checked", getChecked());

        out.printf("Kmu.setCheckedByName(%s);", json);
    }

}
