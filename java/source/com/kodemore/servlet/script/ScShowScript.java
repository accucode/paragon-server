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
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.utility.Kmu;

public class ScShowScript
    extends ScVisibilityScript
{
    //##################################################
    //# constructor
    //##################################################

    public ScShowScript()
    {
        super();

        setEasing(ScConstantsIF.DEFAULT_SHOW_EASING);
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    protected String getInstantFunction()
    {
        return "show";
    }

    @Override
    protected String getFadeFunction()
    {
        return "fadeIn";
    }

    @Override
    protected String getSlideFunction()
    {
        return "slideDown";
    }

    @Override
    protected String getFlipFunction()
    {
        KmJsonMap options;
        options = new KmJsonMap();
        options.setString("selector", getSelector());
        options.setInteger("duration", getSpeedMs());
        options.setString("easing", getEasing().name());

        return Kmu.format("Kmu.flipShow(%s);", options);
    }

    //##################################################
    //# chaining
    //##################################################

    @Override
    public ScShowScript fade()
    {
        return (ScShowScript)super.fade();
    }

    @Override
    public ScShowScript fade(int ms)
    {
        return (ScShowScript)super.fade(ms);
    }

    @Override
    public ScShowScript slide()
    {
        return (ScShowScript)super.slide();
    }

    @Override
    public ScShowScript slide(int ms)
    {
        return (ScShowScript)super.slide(ms);
    }

    @Override
    public ScShowScript speed(int ms)
    {
        return (ScShowScript)super.speed(ms);
    }
}
