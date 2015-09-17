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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class ScGlowScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The jquery selector for the element(s) to glow. 
     * This is required.
     */
    private String _target;

    /**
     * The css attribute to be modified.  This should be a single attribute,
     * compatible with the jquery methods .css and .animate.
     * This is optional.  If not specified, the default is determined by javascript.
     */
    private String _attribute;

    /**
     * The value to which the attribute will be temporarily changed.
     * This is optional.  If not specified, the default is determined by javascript.
     * However, if you specify the attribute, then you should probably also set the value.
     */
    private String _value;

    /**
     * The speed of the animation.  This is the total animation speed.
     * This is optional.  If not specified, the default is determined by javascript.
     */
    private Integer _speed;

    //##################################################
    //# constructor
    //##################################################

    public ScGlowScript()
    {
        // none
    }

    //##################################################
    //# selector
    //##################################################

    public String getTarget()
    {
        return _target;
    }

    public void setTarget(String e)
    {
        _target = e;
    }

    //##################################################
    //# attribute
    //##################################################

    public String getAttribute()
    {
        return _attribute;
    }

    public void setAttribute(String e)
    {
        _attribute = e;
    }

    public boolean hasAttribute()
    {
        return Kmu.hasValue(getAttribute());
    }

    //##################################################
    //# value
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(_value);
    }

    //##################################################
    //# speed
    //##################################################

    public Integer getSpeed()
    {
        return _speed;
    }

    public void setSpeed(Integer e)
    {
        _speed = e;
    }

    public boolean hasSpeed()
    {
        return _speed != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("target", getTarget());

        if ( hasAttribute() )
            e.setString("attribute", getAttribute());

        if ( hasValue() )
            e.setString("value", getValue());

        if ( hasSpeed() )
            e.setInteger("speed", getSpeed());

        out.printf("Kmu.glow(%s);", e);
    }
}
