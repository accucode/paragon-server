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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * Replace the target element with some other html.
 *
 * This should only be used when both the target and the
 * replacement are visible, and you want to use a fade
 * animation to effect the change.
 */
public class ScReplaceFadeScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The jquery selector used to identify the element
     * being replaced.
     */
    private String _targetSelector;

    /**
     * The html that will be used to replace the target.
     */
    private String _replacementHtml;

    /**
     * The script to run after the target has been replaced,
     * but before the replacement is visible.
     */
    private ScBlockScript _postDomScript;

    /**
     * The script to run after the replacement is visible
     * and its animation effect is complete.
     */
    private ScBlockScript _postRenderScript;

    /**
     * The speed of the transition.
     */
    private Integer _speed;

    //##################################################
    //# constructor
    //##################################################

    public ScReplaceFadeScript()
    {
        _postDomScript = ScBlockScript.create();
        _postRenderScript = ScBlockScript.create();
    }

    //##################################################
    //# target
    //##################################################

    public String getTargetSelector()
    {
        return _targetSelector;
    }

    public void setTargetSelector(String e)
    {
        _targetSelector = e;
    }

    public void setTarget(ScHtmlIdIF e)
    {
        String sel = e.getJquerySelector();
        setTargetSelector(sel);
    }

    //##################################################
    //# html
    //##################################################

    public String getReplacementHtml()
    {
        return _replacementHtml;
    }

    public void setReplacementHtml(String e)
    {
        _replacementHtml = e;
    }

    public void clearReplacementHtml()
    {
        setReplacementHtml(null);
    }

    public void setReplacement(ScControlIF e)
    {
        if ( e == null )
            clearReplacementHtml();
        else
            setReplacement(e.render());
    }

    public void setReplacement(KmHtmlBuilder out)
    {
        if ( out == null )
        {
            clearReplacementHtml();
            clearPostDomScript();
            clearPostRenderScript();
            return;
        }

        setReplacementHtml(out.formatHtml());
        _setPostDomScript(out.getPostDom());
        _setPostRenderScript(out.getPostRender());
    }

    //##################################################
    //# post dom script
    //##################################################

    public ScBlockScript getPostDomScript()
    {
        return _postDomScript;
    }

    public void _setPostDomScript(ScScriptIF e)
    {
        ScBlockScript post;
        post = getPostDomScript();
        post.clearScript();
        post.run(e);
    }

    public boolean hasPostDomScript()
    {
        return _postDomScript.isNotEmpty();
    }

    public void clearPostDomScript()
    {
        _postDomScript.clearScript();
    }

    //##################################################
    //# post render script
    //##################################################

    public ScBlockScript getPostRenderScript()
    {
        return _postRenderScript;
    }

    public void _setPostRenderScript(ScScriptIF e)
    {
        ScBlockScript post;
        post = getPostRenderScript();
        post.clearScript();
        post.run(e);
    }

    public boolean hasPostRenderScript()
    {
        return _postRenderScript.isNotEmpty();
    }

    public void clearPostRenderScript()
    {
        _postRenderScript.clearScript();
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
        return _speed != null && _speed > 0;
    }

    //##################################################
    //# scriptIF
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        ScBlockScript s;
        s = ScBlockScript.create();
        s.run("Kmu.jsonReplaceFade(%s);", composeOptions());
        s.formatScriptOn(out);
    }

    private KmJsonMap composeOptions()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("target", getTargetSelector());
        e.setString("replacement", getReplacementHtml());

        if ( hasSpeed() )
            e.setInteger("speed", getSpeed());

        if ( hasPostDomScript() )
        {
            String s = getPostDomScript().formatScript();
            if ( Kmu.hasValue(s) )
                e.setString("postDomScript", s);
        }

        if ( hasPostRenderScript() )
        {
            String s = getPostRenderScript().formatScript();
            if ( Kmu.hasValue(s) )
                e.setString("postRenderScript", s);
        }

        return e;
    }
}
