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

import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class ScDelayedScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    private ScRootScript _script;

    private boolean      _onReady;
    private int          _delayMs;

    //##################################################
    //# constructor
    //##################################################

    public ScDelayedScript()
    {
        _script = new ScRootScript();
        _onReady = false;
        _delayMs = 0;
    }

    //##################################################
    //# accessing
    //##################################################

    public ScRootScript getScript()
    {
        return _script;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getOnReady()
    {
        return _onReady;
    }

    public void setOnReady(boolean e)
    {
        _onReady = e;
    }

    public void setOnReady()
    {
        setOnReady(true);
    }

    public int getDelayMs()
    {
        return _delayMs;
    }

    public void setDelayMs(int e)
    {
        _delayMs = e;
    }

    public boolean hasDelay()
    {
        return _delayMs > 0;
    }

    //##################################################
    //# format (custom)
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        String s = getScript().formatScript();

        if ( hasDelay() )
        {
            s = Kmu.escapeJavascriptStringLiteral(s);
            s = Kmu.format("setTimeout(\"%s\", %s);", s, getDelayMs());
        }

        if ( getOnReady() )
            s = Kmu.format("$(function(){%s});", s);

        out.print(s);
    }
}
