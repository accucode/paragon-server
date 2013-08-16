/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.utility.Kmu;

public class ScHideScript
    extends ScAbstractVisibilityScript
{
    //##################################################
    //# constructor
    //##################################################

    public ScHideScript()
    {
        super();

        setEasing(ScConstantsIF.DEFAULT_HIDE_EASING);
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    protected String getInstantFunction()
    {
        return "hide";
    }

    @Override
    protected String getFadeFunction()
    {
        return "fadeOut";
    }

    @Override
    protected String getSlideFunction()
    {
        return "slideUp";
    }

    @Override
    protected String getFlipFunction()
    {
        KmJsonObject options;
        options = new KmJsonObject();
        options.setInteger("rotateY", 90);
        options.setInteger("duration", getSpeedMs());
        options.setString("easing", getEasing().name());

        return Kmu.format("transition(%s);", options);
    }

    //##################################################
    //# chaining
    //##################################################

    @Override
    public ScHideScript fade()
    {
        return (ScHideScript)super.fade();
    }

    @Override
    public ScHideScript fade(int ms)
    {
        return (ScHideScript)super.fade(ms);
    }

    @Override
    public ScHideScript slide()
    {
        return (ScHideScript)super.slide();
    }

    @Override
    public ScHideScript slide(int ms)
    {
        return (ScHideScript)super.slide(ms);
    }

    @Override
    public ScHideScript speed(int ms)
    {
        return (ScHideScript)super.speed(ms);
    }

    @Override
    public ScHideScript defer()
    {
        return (ScHideScript)super.defer();
    }
}
