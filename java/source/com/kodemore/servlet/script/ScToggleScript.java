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
import com.kodemore.utility.Kmu;

public class ScToggleScript
    extends ScAbstractVisibilityScript
{
    //##################################################
    //# constructor
    //##################################################

    public ScToggleScript(ScRootScript e)
    {
        super(e);
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    protected String getInstantFunction()
    {
        return "toggle";
    }

    @Override
    protected String getFadeFunction()
    {
        return "fadeToggle";
    }

    @Override
    protected String getSlideFunction()
    {
        return "slideToggle";
    }

    @Override
    protected String getFlipFunction()
    {
        KmJsonObject options;
        options = new KmJsonObject();
        options.setInteger("rotateY", 180);
        options.setInteger("duration", getSpeedMs());
        options.setString("easing", getEasing().name());

        return Kmu.format("transition(%s);", options);
    }

    //##################################################
    //# chaining
    //##################################################

    @Override
    public ScToggleScript fade()
    {
        return (ScToggleScript)super.fade();
    }

    @Override
    public ScToggleScript fade(int ms)
    {
        return (ScToggleScript)super.fade(ms);
    }

    @Override
    public ScToggleScript slide()
    {
        return (ScToggleScript)super.slide();
    }

    @Override
    public ScToggleScript slide(int ms)
    {
        return (ScToggleScript)super.slide(ms);
    }

    @Override
    public ScToggleScript speed(int ms)
    {
        return (ScToggleScript)super.speed(ms);
    }

    @Override
    public ScToggleScript defer()
    {
        return (ScToggleScript)super.defer();
    }

}
