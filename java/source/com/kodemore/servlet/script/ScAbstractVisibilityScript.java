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

package com.kodemore.servlet.script;

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScEasing;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public abstract class ScAbstractVisibilityScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The target selector.  This can be any valid jquery
     * selector, and may match zero, one, or many elements. 
     */
    private String   _target;

    /**
     * The optional animation effect to use.  By default,
     * the target is shown instantly.  This attribute allows
     * effects such as fade and slide.
     */
    private ScEffect _effect;

    /**
     * The optional easing to control the animation effect.
     * 
     * We have a wide library of functions available due
     * to the use of the jquery ui effects library.  See...
     *      http://jqueryui.com/demos/effect/easing.html
     */
    private ScEasing _easing;

    /**
     * The speed to be used if an easing function is specified.
     * This is ignored if no easing method is used.
     */
    private Integer  _speedMs;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractVisibilityScript()
    {
        _target = null;
        _effect = ScConstantsIF.DEFAULT_EFFECT;
        _easing = ScConstantsIF.DEFAULT_EASING;
        _speedMs = ScConstantsIF.DEFAULT_SPEED_MS;
    }

    //##################################################
    //# effects
    //##################################################

    public ScEffect getEffect()
    {
        return _effect;
    }

    public void setEffect(ScEffect e)
    {
        _effect = e;
    }

    public boolean hasEffect()
    {
        return _effect != null;
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

    public void setSelector(ScHtmlIdIF e)
    {
        setTarget(e.formatJquerySelector());
    }

    //##################################################
    //# easing
    //##################################################

    public ScEasing getEasing()
    {
        return _easing;
    }

    public void setEasing(ScEasing e)
    {
        _easing = e;
    }

    public boolean hasEasing()
    {
        return _easing != null;
    }

    public boolean hasEasing(ScEasing e)
    {
        return Kmu.isEqual(getEasing(), e);
    }

    //##################################################
    //# speed
    //##################################################

    public Integer getSpeedMs()
    {
        return _speedMs;
    }

    public void setSpeedMs(Integer e)
    {
        _speedMs = e;
    }

    public boolean hasSpeed()
    {
        return _speedMs != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        if ( hasEffect() )
            out.print(formatEffect());
        else
            out.print(formatNoEffect());
    }

    private String formatNoEffect()
    {
        String sel = json(getTarget());
        String fn = getInstantFunction();

        return Kmu.format("$(%s).%s();", sel, fn);
    }

    private String formatEffect()
    {
        String sel = json(getTarget());
        String fn = getFunction();
        Integer ms = getSpeedMs();
        String ease = json(getEasing().name());

        return Kmu.format("$(%s).%s(%s,%s);", sel, fn, ms, ease);
    }

    private String getFunction()
    {
        ScEffect e = getEffect();

        if ( e == null )
            return getInstantFunction();

        switch ( e )
        {
            case fade:
                return getFadeFunction();

            case slide:
                return getSlideFunction();
        }

        return null;
    }

    protected abstract String getInstantFunction();

    protected abstract String getFadeFunction();

    protected abstract String getSlideFunction();

    //##################################################
    //# chaining
    //##################################################

    protected ScAbstractVisibilityScript fade()
    {
        setEffect(ScEffect.fade);
        return this;
    }

    protected ScAbstractVisibilityScript fade(int ms)
    {
        return fade().speed(ms);
    }

    protected ScAbstractVisibilityScript slide()
    {
        setEffect(ScEffect.slide);
        return this;
    }

    protected ScAbstractVisibilityScript slide(int ms)
    {
        return slide().speed(ms);
    }

    protected ScAbstractVisibilityScript speed(int ms)
    {
        setSpeedMs(ms);
        return this;
    }

    public ScAbstractVisibilityScript defer()
    {
        ajax().deferUntil(getTarget());
        return this;
    }

    //##################################################
    //# support
    //##################################################

    private ScScript ajax()
    {
        return getData().ajax();
    }

}
