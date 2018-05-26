/*
  Copyright (c) 2005-2018 www.kodemore.com

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

/**
 * A client-side script used to execute some action AFTER the user
 * stops typing in a text field.
 *
 * This relies on the TypeWatch script published under the MIT license
 * by dennyferra on github: https://github.com/dennyferra/TypeWatch.
 */
public class ScTypeWatchScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The html selector that identifies the elements that this script
     * is applied to. This typically identifies a specific element by
     * its id, e.g.: '#elementId'.
     */
    private String _selector;

    /**
     * The script to run after the user stops typing.
     * The current text is available to this script as the variable 'value'.
     */
    private String _callback;

    /**
     * The length of time to wait for additional keystrokes.
     * Defaults to 500.
     */
    private int _delayMs;

    /**
     * The minimum number of characters required to fire the callback.
     * Defaults to 1.
     */
    private int _captureLength;

    /**
     * Highlights the element when it receives focus.
     * Defaults to false.
     */
    private boolean _highlight;

    /**
     * Allows a single-line element to be submitted (enter key) regardless of captureLength.
     * Defaults to true.
     */
    private boolean _allowSubmit;

    //##################################################
    //# constructor
    //##################################################

    public ScTypeWatchScript()
    {
        _delayMs = 500;
        _captureLength = 1;
        _highlight = false;
        _allowSubmit = true;
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

    //##################################################
    //# script
    //##################################################

    public String getCallback()
    {
        return _callback;
    }

    public void setCallback(String e)
    {
        _callback = e;
    }

    //##################################################
    //# capture length
    //##################################################

    public int getCaptureLength()
    {
        return _captureLength;
    }

    public void setCaptureLength(int i)
    {
        _captureLength = i;
    }

    //##################################################
    //# delay
    //##################################################

    public int getDelayMs()
    {
        return _delayMs;
    }

    public void setDelayMs(int ms)
    {
        _delayMs = ms;
    }

    //##################################################
    //# highlight
    //##################################################

    public boolean getHighlight()
    {
        return _highlight;
    }

    public void setHighlight(boolean e)
    {
        _highlight = e;
    }

    //##################################################
    //# allow submit
    //##################################################

    public boolean getAllowSubmit()
    {
        return _allowSubmit;
    }

    public void setAllowSubmit(boolean e)
    {
        _allowSubmit = e;
    }

    //##################################################
    //# format (custom)
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        String callback = Kmu.format("function(value){%s}", getCallback());

        KmJsonMap json;
        json = new KmJsonMap();
        json.setLiteral("callback", callback);
        json.setInteger("wait", getDelayMs());
        json.setInteger("captureLength", getCaptureLength());
        json.setBoolean("highlight", getHighlight());
        json.setBoolean("allowSubmit", getAllowSubmit());

        out.printf("$('%s').typeWatch(%s);", getSelector(), json);
    }
}
