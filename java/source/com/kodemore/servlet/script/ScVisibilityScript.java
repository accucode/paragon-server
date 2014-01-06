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

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScEasing;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I implement common functional to show, hide, or toggle
 * the visibility of elements.  I can operate on any valid
 * jquery selector, and provide various transition effects.
 */
public abstract class ScVisibilityScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * A reference to the root script.   This is primarily used to implement
     * convenient access to the defer() method.
     */
    private ScRootScript _root;

    /**
     * The target selector.  This can be any valid jquery
     * selector, and may match zero, one, or many elements. 
     */
    private String       _selector;

    /**
     * The optional animation effect to use.  By default,
     * the target is shown instantly.  This attribute allows
     * effects such as fade and slide.
     */
    private ScEffect     _effect;

    /**
     * The optional easing to control the animation effect.
     * 
     * We have a wide library of functions available due
     * to the use of the jquery ui effects library.  See...
     *      http://jqueryui.com/resources/demos/effect/easing.html
     */
    private ScEasing     _easing;

    /**
     * The speed to be used if an easing function is specified.
     * This is ignored if no easing method is used.
     */
    private Integer      _speedMs;

    //##################################################
    //# constructor
    //##################################################

    public ScVisibilityScript(ScRootScript root)
    {
        _root = root;

        _selector = null;
        _effect = ScConstantsIF.DEFAULT_EFFECT;
        _easing = ScConstantsIF.DEFAULT_EASING;
        _speedMs = ScConstantsIF.DEFAULT_SPEED_MS;
    }

    //##################################################
    //# hierarchy
    //##################################################

    protected ScRootScript getRoot()
    {
        return _root;
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

    public String getSelector()
    {
        return _selector;
    }

    public void setSelector(String e)
    {
        _selector = e;
    }

    public void setTarget(ScHtmlIdIF e)
    {
        setSelector(e.getJquerySelector());
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
        String sel = json(getSelector());
        String fn = getInstantFunction();

        return Kmu.format("$(%s).%s();", sel, fn);
    }

    private String formatEffect()
    {
        ScEffect e = getEffect();

        if ( e == null )
            return formatNormalEffect(getInstantFunction());

        switch ( e )
        {
            case fade:
                return formatNormalEffect(getFadeFunction());

            case slide:
                return formatNormalEffect(getSlideFunction());

            case flip:
                return formatFlipEffect();
        }

        return null;
    }

    private String formatNormalEffect(String function)
    {
        String sel = json(getSelector());
        Integer ms = getSpeedMs();
        String ease = json(getEasing().name());

        return Kmu.format("$(%s).%s(%s,%s);", sel, function, ms, ease);
    }

    private String formatFlipEffect()
    {
        return getFlipFunction();
    }

    protected abstract String getInstantFunction();

    protected abstract String getFadeFunction();

    protected abstract String getSlideFunction();

    protected abstract String getFlipFunction();

    //##################################################
    //# chaining
    //##################################################

    protected ScVisibilityScript fade()
    {
        setEffect(ScEffect.fade);
        return this;
    }

    protected ScVisibilityScript fade(int ms)
    {
        return fade().speed(ms);
    }

    protected ScVisibilityScript slide()
    {
        setEffect(ScEffect.slide);
        return this;
    }

    protected ScVisibilityScript slide(int ms)
    {
        return slide().speed(ms);
    }

    protected ScVisibilityScript speed(int ms)
    {
        setSpeedMs(ms);
        return this;
    }

    public ScVisibilityScript defer()
    {
        getRoot().deferUntil(getSelector());
        return this;
    }
}
