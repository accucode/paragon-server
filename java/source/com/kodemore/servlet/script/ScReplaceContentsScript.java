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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScTransition;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class ScReplaceContentsScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The selector used for the transition animation.
     * 
     * E.g.: When replacing this contents of a TD you may
     * need to set the outer selector to the enclosing TABLE
     * for the animation to work correctly.
     */
    private String       _outerSelector;

    /**
     * The selector whose contents will be replaced.
     * 
     * See outerSelector.
     */
    private String       _innerSelector;

    /**
     * The html to put into the innerSelector.
     */
    private String       _contents;

    /**
     * The script to run after the dom has been replaced.
     */
    private String       _postDomScript;

    /**
     * The script to run after the html has been rendered.
     * This is run AFTER any transition effects.
     */
    private String       _postRenderScript;

    /**
     * The transition to use.
     */
    private ScTransition _transition;

    /**
     * The speed of the transition.  Ignored if the transition
     * does not support it.  
     */
    private Integer      _speed;

    //##################################################
    //# constructor
    //##################################################

    public ScReplaceContentsScript()
    {
        // none
    }

    //##################################################
    //# selector
    //##################################################

    public String getOuterSelector()
    {
        return _outerSelector;
    }

    public void setOuterSelector(String e)
    {
        _outerSelector = e;
    }

    public boolean hasOuterSelector()
    {
        return Kmu.hasValue(getOuterSelector());
    }

    public boolean hasDistinctOuterSelector()
    {
        return hasOuterSelector() && !getOuterSelector().equals(getInnerSelector());
    }

    public String getInnerSelector()
    {
        return _innerSelector;
    }

    public void setInnerSelector(String e)
    {
        _innerSelector = e;
    }

    public void setSelector(String e)
    {
        setOuterSelector(e);
        setInnerSelector(e);
    }

    public void setSelector(ScHtmlIdIF e)
    {
        String sel = e.getJquerySelector();
        setSelector(sel);
    }

    //##################################################
    //# html
    //##################################################

    public String getContents()
    {
        return _contents;
    }

    public boolean hasContents()
    {
        return Kmu.hasValue(getContents());
    }

    public void setContents(String e)
    {
        _contents = e;
    }

    public void setContents(ScControl e)
    {
        if ( e == null )
            _contents = null;
        else
            setContents(e.render());
    }

    public void setContents(KmHtmlBuilder out)
    {
        if ( out == null )
        {
            setContents((String)null);
            setPostDomScript(null);
            setPostRenderScript(null);
            return;
        }

        setContents(out.formatHtml());
        setPostDomScript(out.getPostDom().formatScript());
        setPostRenderScript(out.getPostRender().formatScript());
    }

    //##################################################
    //# post dom script
    //##################################################

    public String getPostDomScript()
    {
        return _postDomScript;
    }

    public void setPostDomScript(String e)
    {
        _postDomScript = e;
    }

    public boolean hasPostDomScript()
    {
        return Kmu.hasValue(getPostDomScript());
    }

    //##################################################
    //# post render script
    //##################################################

    public String getPostRenderScript()
    {
        return _postRenderScript;
    }

    public void setPostRenderScript(String e)
    {
        _postRenderScript = e;
    }

    public boolean hasPostRenderScript()
    {
        return Kmu.hasValue(getPostRenderScript());
    }

    //##################################################
    //# transitions
    //##################################################

    public ScTransition getTransition()
    {
        return _transition;
    }

    public void setTransition(ScTransition e)
    {
        setTransition(e, 150);
    }

    public void setTransition(ScTransition e, Integer ms)
    {
        _transition = e;
        _speed = ms;
    }

    public boolean hasTransition()
    {
        return _transition != null;
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
        if ( !usesTransition() )
        {
            formatSimpleOn(out);
            return;
        }

        ScTransition e = getTransition();
        switch ( e )
        {
            case Fade:
                formatFadeOn(out);
                return;

            case SlideLeft:
                formatLeftOn(out);
                return;

            case SlideRight:
                formatRightOn(out);
                return;
        }

        formatSimpleOn(out);
    }

    private void formatSimpleOn(KmStringBuilder out)
    {
        formatCallOn(out, "Kmu.jsonReplaceSimple");
    }

    private void formatFadeOn(KmStringBuilder out)
    {
        formatCallOn(out, "Kmu.jsonReplaceFade");
    }

    private void formatLeftOn(KmStringBuilder out)
    {
        formatCallOn(out, "Kmu.jsonReplaceLeft");
    }

    private void formatRightOn(KmStringBuilder out)
    {
        formatCallOn(out, "Kmu.jsonReplaceRight");
    }

    private void formatCallOn(KmStringBuilder out, String fn)
    {
        ScRootScript s;
        s = new ScRootScript();
        s.run("%s(%s);", fn, composeJson());
        s.formatScriptOn(out);
    }

    private KmJsonMap composeJson()
    {
        KmJsonMap e;
        e = new KmJsonMap();

        e.setString("html", getContents());
        e.setString("inner", getInnerSelector());

        if ( hasDistinctOuterSelector() )
            e.setString("outer", getOuterSelector());

        if ( hasSpeed() )
            e.setInteger("speed", getSpeed());

        if ( hasPostDomScript() )
            e.setString("postDomScript", getPostDomScript());

        if ( hasPostRenderScript() )
            e.setString("postRenderScript", getPostRenderScript());

        return e;
    }

    //##################################################
    //# support
    //##################################################

    private boolean usesTransition()
    {
        if ( !hasTransition() )
            return false;

        if ( !hasSpeed() )
            return false;

        return true;
    }

}
