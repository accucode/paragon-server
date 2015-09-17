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

public class ScToastScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * This determines the general appearance; color, icon, etc.
     * The default is the 'notice' flavor.
     */
    private String _flavor;

    /**
     * This is the message to be displayed.  The toast allows html
     * formatting, so content such as <b> has special meaning.
     * See setText, setHtml.
     */
    private String _html;

    /**
     * If true, the message will remain on screen until the user
     * (or application) explicitly closes it.  Otherwise, the
     * message will automatically disappear after the durationMs.
     * The default is NOT sticky.
     */
    private boolean _sticky;

    /**
     * The speed of the animation used to show new messages.
     * Clients will generally not override this.
     */
    private int _effectMs;

    /**
     * This determines how long the message is displayed before
     * automatically disappearing.  This value is ignored for
     * sticky messages.
     */
    private int _durationMs;

    //##################################################
    //# constructor
    //##################################################

    public ScToastScript()
    {
        setText("");
        setFlavorNotice();
        setSticky(false);
        setEffectMs(600);
        setDurationMs(3000);
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor;
    }

    private void setFlavor(String e)
    {
        _flavor = e;
    }

    public void setFlavorNotice()
    {
        setFlavor("notice");
    }

    public void setFlavorSuccess()
    {
        setFlavor("success");
    }

    public void setFlavorWarn()
    {
        setFlavor("warning");
    }

    public void setFlavorError()
    {
        setFlavor("error");
    }

    //##################################################
    //# sticky
    //##################################################

    public boolean getSticky()
    {
        return _sticky;
    }

    public void setSticky(boolean e)
    {
        _sticky = e;
    }

    //##################################################
    //# text
    //##################################################

    public String getHtml()
    {
        return _html;
    }

    /**
     * Escape the parameter so that it can be "safely" displayed
     * without formatting.  See also, setHtml.
     */
    public void setText(String e)
    {
        boolean useBreaks = true;
        _html = Kmu.escapeHtml(e, useBreaks);
    }

    public void setText(String e, Object... args)
    {
        String s = Kmu.format(e, args);
        setText(s);
    }

    /**
     * Set the html message to the exact value of the parameter.
     * Any html formatting characters are preserved and passed
     * to the browser.  Extra care needs to be used with this
     * method to avoid accidentally corrupting the web page.
     */
    public void setHtml(String e)
    {
        _html = e;
    }

    //##################################################
    //# chaining
    //##################################################

    public ScToastScript notice()
    {
        setFlavorNotice();
        return this;
    }

    public ScToastScript success()
    {
        setFlavorSuccess();
        return this;
    }

    public ScToastScript warn()
    {
        setFlavorWarn();
        return this;
    }

    public ScToastScript error()
    {
        setFlavorError();
        return this;
    }

    public ScToastScript sticky()
    {
        setSticky(true);
        return this;
    }

    public ScToastScript text(String e)
    {
        setText(e);
        return this;
    }

    public ScToastScript html(String e)
    {
        setHtml(e);
        return this;
    }

    //##################################################
    //# effect ms
    //##################################################

    public int getEffectMs()
    {
        return _effectMs;
    }

    public void setEffectMs(int e)
    {
        _effectMs = e;
    }

    //##################################################
    //# duration ms
    //##################################################

    public int getDurationMs()
    {
        return _durationMs;
    }

    public void setDurationMs(int e)
    {
        _durationMs = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap params;
        params = new KmJsonMap();
        params.setString("text", getHtml());
        params.setBoolean("sticky", getSticky());
        params.setString("type", getFlavor());
        params.setInteger("inEffectDuration", getEffectMs());
        params.setInteger("stayTime", getDurationMs());

        out.printf("$().toastmessage('showToast',%s);", params);
    }
}
