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

package com.kodemore.servlet.control;

import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.script.ScSimpleScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.utility.Kmu;

/**
 * A button that allows you to specify an arbitrary onClick client script.
 */
public class ScScriptButton
    extends ScButton
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The client side javascript to be run when the button is clicked.
     */
    private ScLocal<ScScriptIF> _script;

    //##################################################
    //# constructor
    //##################################################

    public ScScriptButton()
    {
        _script = new ScLocal<>();
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getButtonType()
    {
        return "button";
    }

    //##################################################
    //# script
    //##################################################

    public ScScriptIF getScript()
    {
        return _script.getValue();
    }

    public void setScript(ScScriptIF e)
    {
        _script.setValue(e);
    }

    public void clearScript()
    {
        _script.clearValue();
    }

    //##################################################
    //# convenience
    //##################################################

    public void setScript(String e)
    {
        if ( e == null )
            clearScript();
        else
            setScript(new ScSimpleScript(e));
    }

    public void setScriptHref(String href)
    {
        String s = Kmu.format("window.location='%s';", href);
        setScript(s);
    }

    public void setHrefHash(String hash)
    {
        String s = Kmu.format("window.location.hash='%s';", hash);
        setScript(s);
    }

    //##################################################
    //# on click
    //##################################################

    @Override
    protected String formatOnClick()
    {
        return _script.hasValue()
            ? _script.getValue().formatScript()
            : null;
    }

}
